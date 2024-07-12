package com.cluster.node;

import com.cluster.node.ballot.Ballot;
import com.cluster.node.config.Configuration;
import com.cluster.node.error.RaftError;
import com.cluster.node.factory.timer.RaftTimerFactory;
import com.cluster.node.model.NettyPacket;
import com.cluster.node.node.PeerId;
import com.cluster.node.node.State;
import com.cluster.node.parse.ParseConfig;
import com.cluster.node.peer.ControllerManager;
import com.cluster.node.peer.PeerNameNode;
import com.cluster.node.peer.PeerNameNodes;
import com.cluster.node.replicator.ReplicatorGroup;
import com.cluster.node.replicator.ReplicatorGroupImpl;
import com.cluster.node.server.DefaultScheduler;
import com.cluster.node.server.NameNodeApis;
import com.cluster.node.server.NameNodeServer;
import com.cluster.node.status.Status;
import com.cluster.node.timer.RepeatedTimer;
import com.cluster.node.timer.Scheduler;
import com.cluster.node.utils.JRaftUtils;
import com.cluster.node.utils.Requires;
import com.cluster.node.utils.Utils;
import com.cluster.node.wrapper.RequestWrapper;

import com.dfs.common.enums.PacketType;
import com.dfs.common.model.namenode.Rpc;
import com.google.protobuf.InvalidProtocolBufferException;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.nio.file.Paths;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

import static com.dfs.common.enums.PacketType.*;


/**
 * @author: yp
 * @date: 2024/7/5 14:07
 * @description:
 */
@Slf4j
public class NameNode {

    private static final Logger LOG = LoggerFactory.getLogger(NameNode.class);


    private final AtomicBoolean started = new AtomicBoolean(false);

    private NameNodeServer nameNodeServer;

    private NameNodeApis nameNodeApis;

    /**
     * 当前节点状态
     */
    private volatile State state;

    /**
     * 节点的任期
     */
    private volatile long currTerm;

    private AtomicBoolean heartbeatTimeoutIsRunning = new AtomicBoolean(false);

    //计算正式选票结果的计数器
    private final Ballot voteCtx = new Ballot();
    //计算预投票结果的计数器
    private final Ballot prevVoteCtx = new Ballot();

    // 全局定时任务调度器
    private Scheduler timerManager;

    // 选举超时定时器
    private RepeatedTimer electionTimer;

    // 心跳检测定时器
    private RepeatedTimer heartTimer;

    // 投票超时处理定时器
    private RepeatedTimer voteTimer;

    // 上一次收到领导者心跳的时间
    private volatile long lastLeaderTimestamp;

    private ControllerManager controllerManager;

    private PeerNameNodes peerNameNodes;

    private ReplicatorGroup replicatorGroup;

    // 领导者Id
    private PeerId leaderId = PeerId.emptyPeer();

    private PeerId serverId = PeerId.emptyPeer();

    //这个成员变量是用来计算当前服务器上启动了几个raft节点，每启动一个，就自增1
    public static final AtomicInteger GLOBAL_NUM_NODES = new AtomicInteger(0);

    // 集群当前生效的配置信息，包括旧的配置信息
    private Configuration configuration;

    private DefaultScheduler defaultScheduler;

    //得到定时器工厂，框架中的各种定时任务几乎都是这个定时器工厂提供的
    public final static RaftTimerFactory TIMER_FACTORY = JRaftUtils.raftTimerFactory();

    //提供读写锁功能的成员变量，这个读写锁虽然是jraft框架自己定义的，但本质是继承了jdk中的ReentrantReadWriteLock类
    // TODO 需要重构，实现加锁超时功能
    private final ReadWriteLock readWriteLock = new ReentrantReadWriteLock();
    //写锁
    protected final Lock writeLock = this.readWriteLock.writeLock();
    //读锁
    protected final Lock readLock = this.readWriteLock.readLock();

    //当前节点投过票的节点的PeerId，这个成员变量可以记录下来，当前节点为哪个节点投过票
    private PeerId votedId;

    // node重连定时器
    private RepeatedTimer failPeerNodeTimer;

    //构造方法
    public NameNode(Configuration configuration) {
        //节点刚刚创建的时候，是未初始化状态
        this.state = State.STATE_UNINITIALIZED;

        this.configuration = configuration;

        final int num = GLOBAL_NUM_NODES.incrementAndGet();
        LOG.info("The number of active nodes increment to {}.", num);

        this.defaultScheduler = new DefaultScheduler("NameNode-Scheduler-");

        PeerNameNodes peerNameNodes = new PeerNameNodes(configuration, this.nameNodeApis, defaultScheduler);

        this.controllerManager = new ControllerManager(configuration, peerNameNodes);
        controllerManager.setNameNode(this);
        this.nameNodeApis = new NameNodeApis(peerNameNodes, configuration, defaultScheduler, controllerManager);
        this.nameNodeServer = new NameNodeServer(new DefaultScheduler("cluster-node-"), this.nameNodeApis);
        this.nameNodeServer.setConfiguration(configuration);

        peerNameNodes.setControllerManager(controllerManager);
        peerNameNodes.setNameNodeApis(nameNodeApis);

        this.peerNameNodes = peerNameNodes;

        updateLastLeaderTimestamp(Utils.monotonicMs());

    }

    public static void main(String[] args) {
        // 1. 解析配置文件
        Configuration configuration = new Configuration();

        ParseConfig.ParseConfig(Paths.get(args[0]), configuration);

        try {
            NameNode namenode = new NameNode(configuration);
            Runtime.getRuntime().addShutdownHook(new Thread(namenode::shutdown));
            namenode.start();
        } catch (Exception e) {
            log.error("启动NameNode失败：", e);
            System.exit(1);
        }
    }


    public void init() {

        this.nameNodeApis.setNameNode(this);

        this.serverId = new PeerId(configuration.getHost(), configuration.getPort(), configuration.getNodeId());

        this.replicatorGroup = new ReplicatorGroupImpl();

        //创建一个全局的定时任务管理器，这个定时任务管理器只负责启动领导者向跟随者发送心跳消息的任务
        this.timerManager = TIMER_FACTORY.getRaftScheduler(false, 1, "Raft-Node-ScheduleThreadPool");

        this.peerNameNodes.setReplicatorGroup(replicatorGroup);

        String name = "JRaft-VoteTimer-" + getNodeId();
        // 创建投票超时定时器
        this.voteTimer = new RepeatedTimer(name, configuration.getElectionTimeoutMs()) {
            @Override
            protected void onTrigger() throws InterruptedException {
                // 处理投票超时的方法
                handleVoteTimeout();
            }

            @Override
            protected int adjustTimeout(int timeoutMs) {
                return randomTimeout(timeoutMs);
            }
        };

        name = "JRaft-ElectionTimer-" + getNodeId();

        // 创建超时选举定时器
        this.electionTimer = new RepeatedTimer(name, configuration.getElectionTimeoutMs(),
                TIMER_FACTORY.getElectionTimer(false, name)) {
            @Override
            protected void onTrigger() throws InterruptedException {
                // 超时选举核心方法
                handleElectionTimeout();
            }

            @Override
            protected int adjustTimeout(int timeoutMs) {
                // 在一定范围内返回一个随机的时间，意味着每个节点的超时选举时间是不同的
                // 否则多个节点同时成为候选者，很有可能选举失败
                return randomTimeout(timeoutMs);
            }
        };

        name = "JRaft-FailNodeConnect-" + getNodeId();

        // 创建node重连定时器
        this.failPeerNodeTimer = new RepeatedTimer(name, configuration.getElectionTimeoutMs()) {
            @Override
            protected void onTrigger() throws InterruptedException {
                // 处理投票超时的方法
                peerNameNodes.handleNodeConnectFail(state);
            }

            @Override
            protected int adjustTimeout(int timeoutMs) {
                return randomTimeout(timeoutMs);
            }
        };

        failPeerNodeTimer.start();

        name = "JRaft-Heartbeat-" + getNodeId();

        // 创建超时选举定时器
        this.heartTimer = new RepeatedTimer(name, configuration.getElectionTimeoutMs(),
                TIMER_FACTORY.getElectionTimer(false, name)) {
            @Override
            protected void onTrigger() throws InterruptedException {
                // 心跳超时处理器
                handleHeartbeatTimeout();
            }

            @Override
            protected int adjustTimeout(int timeoutMs) {
                // 在一定范围内返回一个随机的时间，意味着每个节点的超时选举时间是不同的
                // 否则多个节点同时成为候选者，很有可能选举失败
                return randomTimeout(timeoutMs);
            }
        };

        // 初始化投票箱
        // this.ballotBox = new BallotBox();
        this.state = State.STATE_FOLLOWER;
        if (!this.configuration.getPeers().isEmpty()) {
            // 新启动的节点在这里进行选举，启动刚才创建好的超时选举定时器，在定时器任务中执行选举操作
            stepDown(this.currTerm, false, new Status());
        }
    }

    private void handleHeartbeatTimeout() {
        try {
            writeLock.lock();
            if (!isCurrentLeaderValid()) {
                log.info("心跳超时，开始超时选举任务");
                stepDown(this.currTerm, false, new Status(RaftError.ETIMEDOUT,
                        "heartbeat timeout."));
            }
        } finally {
            writeLock.unlock();
        }
    }

    /**
     * 处理选举超时方法
     */
    private void handleVoteTimeout() throws InterruptedException {
        this.writeLock.lock();
        if (this.state != State.STATE_CANDIDATE) {
            this.writeLock.unlock();
            return;
        }
        //进行身份降级，把当前节点降级为跟随者，然后重新开始预投票操作
        stepDown(this.currTerm, false, new Status(RaftError.ETIMEDOUT,
                "Vote timeout: fail to get quorum vote-granted."));
        //进行预投票操作
        preVote();
    }


    private void updateLastLeaderTimestamp(final long lastLeaderTimestamp) {
        this.lastLeaderTimestamp = lastLeaderTimestamp;
    }

    // 返回一个超时选举时间的方法，超时选举定时器会调用该方法，在raft协议中，为了避免多个节点同时成为选举这
    // 所以会让超时选举时间错开
    private int randomTimeout(final int timeoutMs) {
        return ThreadLocalRandom.current().nextInt(timeoutMs, timeoutMs + configuration.getElectionTimeoutMs());
    }

    /**
     * 检测当前节点是否需要进行身份降级
     *
     * @param term
     * @param wakeupCandidate
     * @param status
     */
    private void stepDown(final long term, final boolean wakeupCandidate, final Status status) {
        LOG.debug("Node {} stepDown, term={}, newTerm={}, wakeupCandidate={}.", configuration.getNodeId(), this.currTerm, term,
                wakeupCandidate);
        //检查当前节点的状态是否活跃。其实就是看看是否正在关闭或者有没有异常
        if (!this.state.isActive()) {
            return;
        }
        resetLeaderId(PeerId.emptyPeer(), status);
        // 将当前节点状态更新为跟随者
        this.state = State.STATE_FOLLOWER;
        // 更新最后一次收到领导者信息的时间，这里更新这个时间主要是因为stepDown方法在
        // 多个和投票选举的方法中被调用，既然正在投票选举，肯定不能让超时选举定时器工作
        // 所以每次都要更新这个时间
        updateLastLeaderTimestamp(Utils.monotonicMs());

        replicatorGroup.stopAllReplicator();

        // 如果方法参数中的任期比当前节点的任期大，这时候就意味着当前节点正在进行选举工作
        // 这个stepDown可能正在被handleRequestVoteRequest方法调用
        if (term > this.currTerm) {
            // 修改当前节点任期
            this.currTerm = term;
            // 这里先把当前节点的投票记录设置为空，因为接受到了一个新的任期，一个任期只能投一票
            this.votedId = PeerId.emptyPeer();
            // 持久化元数据信息
        }
        // 如果当前节点不是学习者么就启动当前节点的超时选举定时器
        if (!isLearner()) {
            this.electionTimer.restart();
        } else {
            log.info("Node {} is a learner, election timer is not started.", configuration.getNodeId());
        }
    }

    private boolean isLearner() {
        return false;
    }

    /**
     * 超市选举处理方法，这个方法就是超时选举定时器要调用的方法
     */
    private void handleElectionTimeout() throws InterruptedException {
        boolean doUnlock = true;
        try {
            this.writeLock.lock();
            // 判断当前节点的状态，如果当前节点不是跟随者的状态，就不能进行投票选举
            // 因为候选者是从跟随者转换过去的，连跟随者都不是，不能转换成候选者
            if (this.state != State.STATE_FOLLOWER) {
                return;
            }
            // 超时选举定时器启动之后，只要节点状态是跟随者，就会一直工作
            // 每过一段时间就会触发一次，但是触发了并不意味着就要真的去进行选举，会从这里进行判断
            // 看看距离当前节点最后一次收到领导者信息过去的多少时间，如果这个时间超过了超时选举时间，才会进入投票节点
            if (isCurrentLeaderValid()) {
                return;
            }
            // 既然是要超时选举了，就说明领导者已经没有了，在这里对当前节点存放的领导者信息进行充值
            resetLeaderId(PeerId.emptyPeer(), new Status(RaftError.ERAFTTIMEDOUT, "Lost connection from leader %s.",
                    this.leaderId));
            // 设置释放锁标识为false，这里设置为false是为了不在finally块中释放写锁
            doUnlock = false;
            // 开始预投票，还持有写锁
            log.info("开始预投票");
            preVote();
        } finally {
            if (doUnlock) {
                this.writeLock.unlock();
            }
        }
    }


    /**
     * 所谓预投票机制就是在集群中的节点正式投票选主之前，先进行一次预投票，这个预投票和正式投票的逻辑没什么区别
     * 也是将当前节点的任期自增1，获取当前节点的最后一条日志的信息，然后根据这两条信息去和其他节点的信息做对比，只有任期比其他节点大，日志比其他节点新，其他节点才会给当前节点投票
     * 唯一的区别就是在预投票过程中没有限制一个节点只能投一票，最后只有当这个节点预投票通过了，也就是获得了整个集群中超过一半节点的投票
     * 这个节点才能正式开始向其他节点发起所要投票的请求。这么做是考虑到在一个集群中出现网络分区后，有些节点的任期无限制增大，等分区故障处理之后
     * 影响整个集群的工作。比如一个只有5个节点的集群，出现网络分区了，1个节点不能和其他四个节点通信了，而领导者在那4个节点之中，这样，其他4个节点还可以正常工作
     * 但是单独的1个节点因为无法接收到领导者的心跳，很快就会触发超时选举任务，如果没有预投票机制，那这个节点就会直接给自己的任期自增1，然后发起投票，但是它根本没办法和其他节点通信
     * 所以仍然会触发超时选举，于是任期就会无限自增，直到故障恢复，但是很可能故障恢复之后，这个节点的任期比集群中领导者的节点大的多，恢复通信后，根据任期大小显然就会让领导者下台了
     * 但是这个节点根本就没有日志数据，为了防止这种情况出现，所以搞了一个预投票机制，假如这个故障节点预投票失败了，就不会再进入正式选举，这里我要再强调一下，在进行预投票的时候
     * 会讲当前节点的任期自增1，这个其实并没有真的给当前节点的任期赋值，只是在传输消息中使用了自增的任期，这样就保证了，如果预投票失败，当前节点的任期并不会有任何变化
     * 只有正式投票，才会改变当前节点的任期
     */
    private void preVote() throws InterruptedException {
        // 定义一个变量记录当前节点任期
        long oldTerm;
        try {
            // 开始记录预投票的日志
            log.info("Node {} term {} start preVote.", getNodeId(), this.currTerm);
            // todo:判断是否是集群中的节点
            oldTerm = this.currTerm;
        } finally {
            //这里有一个finally块主要是因为上面大代码中有一个if判断，如果判断成立就直接退出方法了，退出之前需要把写锁释放了，因为在上层方法的最后并没有释放写锁
            //注意，如果上面的if分之没有被执行，走到这里仍然会执行释放写锁的方法，这就意味着下面我们好要重新获得写锁
            //但是在释放写锁的这段时间中会发生什么事呢？假如集群中已经选举出了新的节点，并且已经把当前节点的任期值改变了怎么办呢？
            this.writeLock.unlock();
        }
        boolean doUnlock = true;
        // 重新获取写锁
        this.writeLock.lock();
        try {
            // 再次判断任期是否改变，如果改变，就不再预投票了
            if (oldTerm != currTerm) {
                LOG.warn("Node {} raise term {} when get lastLogId.", getNodeId(), this.currTerm);
                return;
            }
            // 初始化预投票计算器，当前节点收到的头皮安排结果都会被prevVoteCtx这个成员变量收集，在该成员变量中计算
            // 如果收到的预投票的票数大于一半，就会进入正式投票状态
            // 这里初始化预投票计算器其实就是把配置类中的节点信息交给prevVoteCtx对象
            // 这样这个prevVoteCtx预投票计算器就知道集群中有多少节点了，也知道得到的预投票的票数超过多少就可以进入正式投票状态了
            this.prevVoteCtx.init(configuration);
            // 创建预投票请求
            Rpc.RequestVoteRequest request = Rpc.RequestVoteRequest.newBuilder()
                    //设置为true意味着是预投票请求
                    .setPreVote(true)
                    //在发送请求时发送的任期值为当前节点的任期值加1
                    .setTerm(this.currTerm + 1)
                    .setPeerId(this.serverId.toString())
                    .build();
            peerNameNodes.broadcast(NettyPacket.buildPacket(request.toByteArray(), NAME_NODE_CONTROLLER_PREV_VOTE_REQUEST));
            // 给自己投一票
            this.prevVoteCtx.grant(this.serverId);
            //这里判断了一下，看是否得到了超过集群中半数节点的投票
            if (this.prevVoteCtx.isGranted()) {
                //超过了则不在本方法中释放写锁，而是直接开始进行正式投票
                doUnlock = false;
                //开始正式进行投票
                electSelf();
            }
        } finally {
            //这里根据是否释放写锁标志来判断是不是要释放写锁
            if (doUnlock) {
                this.writeLock.unlock();
            }
        }
    }

    // 判断是否触发超时选举机制
    private boolean isCurrentLeaderValid() {
        return Utils.monotonicMs() - this.lastLeaderTimestamp < configuration.getElectionTimeoutMs();
    }


    /**
     * 将当前节点记录的领导者信息充值
     *
     * @param newLeaderId
     * @param status
     */
    private void resetLeaderId(final PeerId newLeaderId, final Status status) {
        // 判断当前传进来的节点是否为空
        if (newLeaderId.isEmpty()) {
            // 如果为空，可能意味着正在进行选举操作，将选举者置为空
            this.leaderId = PeerId.emptyPeer();
        } else {
            this.leaderId = newLeaderId.copy();
        }
    }

    private int getNodeId() {
        return configuration.getNodeId();
    }

    /**
     * 处理预投票请求
     *
     * @param requestWrapper
     */
    public void handlePreVoteResponse(RequestWrapper requestWrapper) throws InvalidProtocolBufferException, InterruptedException {
        boolean doUnlock = true;
        this.writeLock.lock();
        try {
            Rpc.RequestVoteResponse response = Rpc.RequestVoteResponse.parseFrom(requestWrapper.getRequest().getBody());
            // 如果当前节点的身份不再是跟随者，直接退出方法
            if (this.state != State.STATE_FOLLOWER) {
                log.warn("Node {} received invalid PreVoteResponse from, state not in STATE_FOLLOWER but {}.",
                        getNodeId(), this.state);
                return;
            }
            // 判断当前节点的前后任期是否一致
            long selfTerm = response.getSelfTerm();
            if (selfTerm != this.currTerm + 1) {
                log.warn("节点前后任期不一致");
                return;
            }
            // 如果接收到响应发现请求中的任期，也就是回复节点的任期比自己大，也直接退出，并让自己成为跟随者，处理预请求响应
            // 正常情况下，没有发生分区故障的话，响应的节点应该应该与发起预请求的任期一样
            if (response.getTerm() > this.currTerm) {
                log.warn("{} 的任期小于响应 {} selfTerm {} responseTerm {}", getNodeId(), response.getPeerId(), selfTerm, response.getTerm());
                return;
            }
            if (response.getGrant()) {
                String peerIdStr = response.getPeerId();
                this.prevVoteCtx.grant(parsePeerId(peerIdStr));
                if (this.prevVoteCtx.isGranted()) {
                    System.out.println("预投票中 " + response.getPeerId() + " 给 " + this.serverId + " 投票");
                    doUnlock = false;
                    // 开始正式投票
                    electSelf();
                }
            }
        } finally {
            if (doUnlock) {
                this.writeLock.unlock();
            }
        }

    }


    /**
     * 处理预投票请求
     *
     * @param requestWrapper
     */
    public void handlePreVoteRequest(RequestWrapper requestWrapper) throws InvalidProtocolBufferException {
        boolean doUnlock = true;
        this.writeLock.lock();
        try {
            Rpc.RequestVoteRequest request = Rpc.RequestVoteRequest.parseFrom(requestWrapper.getRequest().getBody());
            if (!this.state.isActive()) {
                LOG.warn("Node {} is not in active state, currTerm={}.", getNodeId(), this.currTerm);
                Rpc.RequestVoteResponse response = Rpc.RequestVoteResponse.newBuilder()
                        .setStatus(false)
                        .build();
                requestWrapper.sendResponse(NettyPacket.buildPacket(response.toByteArray(), NAME_NODE_CONTROLLER_PREV_VOTE_RESPONSE));
            }
            // 解析候选者节点信息
            PeerId candidateId = parsePeerId(request.getPeerId());
            // 定义一个投票变量，false表示还没有给候选者投票
            boolean granted = false;
            do {
                if (!this.configuration.getPeers().contains(candidateId)) {
                    log.warn("配置中不存在该namenode节点信息 {}", candidateId);
                    break;
                }
                // 表示当前领导者还存在，且配有超时
                if (this.leaderId != null && !this.leaderId.isEmpty() && isCurrentLeaderValid()) {
                    log.info("节点中的领导者有效");
                    break;
                }
                // 判断候选者节点的任期是否小于当前节点任期
                if (request.getTerm() < this.currTerm) {
                    log.info("请求节点 {} 任期 {} 小于 当前任期 {}", request.getPeerId(), request.getTerm(), this.currTerm);
                    break;
                }

                //进行一次复制器检查，其实在这个方法内部会判断当前接收到预投票请求的节点是不是领导者
                //如果是领导者，并且领导者并没有出故障，所以就根据候选者节点信息去复制器组中检查一下，如果复制器组中没有与候选者节点
                //对应的复制器对象，就为这个候选者节点创建一个复制器节点，创建完毕后，也会给候选者发送心跳消息，让候选者重新成为跟随者
                // checkReplicator(candidateId);

                doUnlock = true;
                granted = true;
            } while (false);
            Rpc.RequestVoteResponse response = Rpc.RequestVoteResponse.newBuilder()
                    .setStatus(granted)
                    .setSelfTerm(request.getTerm())
                    .setTerm(this.currTerm)
                    .setPeerId(this.serverId.toString())
                    .setGrant(true)
                    .build();
            requestWrapper.sendResponse(NettyPacket.buildPacket(response.toByteArray(), NAME_NODE_CONTROLLER_PREV_VOTE_RESPONSE));
        } finally {
            if (doUnlock) {
                this.writeLock.unlock();
            }
        }
    }

    /**
     * 开始正式投票，正式投票限制每一个节点只允许投一票
     */
    private void electSelf() throws InterruptedException {
        long oldTerm;
        try {
            System.out.println("进入正式投票环节");
            log.info("Node {} start vote and grant vote self, term={}.", getNodeId(), this.currTerm);
            if (!this.configuration.getPeers().contains(this.serverId)) {
                log.warn("Node {} can't do electSelf as it is not in config.", getNodeId());
                return;
            }
            // 如果当前节点目前是跟随者，停止超时选举定时器
            if (this.state == State.STATE_FOLLOWER) {
                log.debug("Node {} stop election timer, term={}.", getNodeId(), this.currTerm);
                //在这里停止超时选举定时器工作
                log.info("开启正式投票，关闭预投票定时任务...");
                this.electionTimer.stop();
            }
            resetLeaderId(PeerId.emptyPeer(), new Status(RaftError.ERAFTTIMEDOUT,
                    "A follower's leader_id is reset to NULL as it begins to request_vote."));
            // 更改节点状态为候选者
            this.state = State.STATE_CANDIDATE;
            // 递增任期
            this.currTerm++;
            this.votedId = this.serverId.copy();
            log.debug("Node {} start vote timer, term={} .", getNodeId(), this.currTerm);
            // 开启选举超时定时器
            this.voteTimer.start();
            this.voteCtx.init(configuration);
            oldTerm = this.currTerm;
        } finally {
            //释放写锁
            this.writeLock.unlock();
        }
        this.writeLock.lock();
        try {
            if (oldTerm != this.currTerm) {
                LOG.warn("Node {} raise term {} when getLastLogId.", getNodeId(), this.currTerm);
                return;
            }
            for (PeerId peer : configuration.getPeers()) {
                if (peer.equals(this.serverId)) {
                    continue;
                }
                // 遍历连接到的这个节点，看是否能够连接成功
                PeerNameNode peerNameNode = null;
                if ((peerNameNode = peerNameNodes.getPeerNameNode(peer.getNodeId())) == null
                        || !peerNameNode.isConnected()) {
                    log.warn("Node {} channel init failed, address={}.", getNodeId(), peer.toString());
                    continue;
                }
                // 创建正式投票请求
                Rpc.FormalVoteRequest request = Rpc.FormalVoteRequest.newBuilder()
                        .setTerm(this.currTerm)
                        .setPeerId(peer.toString())
                        .setServerId(this.serverId.toString())
                        .build();
                peerNameNode.send(NettyPacket.buildPacket(request.toByteArray(), NAME_NODE_FORMAL_VOTE_REQUEST));
            }
            this.voteCtx.grant(this.serverId);
            if (this.voteCtx.isGranted()) {
                becomeLeader();
            }
        } finally {
            //释放写锁
            this.writeLock.unlock();
        }
    }


    /**
     * 处理正式投票请求
     *
     * @param requestWrapper
     */
    public void handleRequestVoteRequest(RequestWrapper requestWrapper) throws InvalidProtocolBufferException {
        boolean doUnlock = true;
        this.writeLock.lock();
        try {
            // 检查当前节点是否处于活跃状态
            if (!this.state.isActive()) {
                log.warn("Node {} is not in active state, currTerm={}.", getNodeId(), this.currTerm);
                Rpc.FormalVoteResponse response = Rpc.FormalVoteResponse.newBuilder()
                        .setStatus(false)
                        .setPeerId(this.serverId.toString())
                        .build();
                requestWrapper.sendResponse(NettyPacket.buildPacket(response.toByteArray(), NAME_NODE_FORMAL_VOTE_RESPONSE));
                return;
            }
            Rpc.FormalVoteRequest request = Rpc.FormalVoteRequest.parseFrom(requestWrapper.getRequest().getBody());
            PeerId candidateId = parsePeerId(request.getPeerId());
            if (!configuration.getPeers().contains(candidateId)) {
                log.warn("Node {} received RequestVoteRequest from {} serverId bad format.", getNodeId(),
                        request.getServerId());
                Rpc.FormalVoteResponse response = Rpc.FormalVoteResponse.newBuilder()
                        .setStatus(false)
                        .setPeerId(this.serverId.toString())
                        .build();
                requestWrapper.sendResponse(NettyPacket.buildPacket(response.toByteArray(), NAME_NODE_FORMAL_VOTE_RESPONSE));
                return;
            }
            do {
                if (request.getTerm() >= this.currTerm) {
                    LOG.info("Node {} received RequestVoteRequest from {}, term={}, currTerm={}.", getNodeId(),
                            request.getServerId(), request.getTerm(), this.currTerm);
                    // 如果候选者节点任期比较大，则让当前节点身份降级，成为跟随者
                    // 如果候选者节点和当前节点相等，不会让当前节点身份降级，可能出现两个候选者
                    if (request.getTerm() > this.currTerm) {
                        stepDown(request.getTerm(), false, new Status(RaftError.EHIGHERTERMRESPONSE,
                                "Raft node receives higher term RequestVoteRequest."));
                    }
                } else {
                    System.out.println("需要投票的节点的任期小于当前节点 " + request.getPeerId() + " " + getNodeId());
                    //走到这里意味着候选者任期小于当前节点，直接忽略该请求即可
                    log.info("Node {} ignore RequestVoteRequest from {}, term={}, currTerm={}.", getNodeId(),
                            request.getServerId(), request.getTerm(), this.currTerm);
                    break;
                }
                if (request.getTerm() != this.currTerm) {
                    //不一致则直接退出循环
                    log.warn("Node {} raise term {} when get lastLogId.", getNodeId(), this.currTerm);
                    break;
                }
                if (this.votedId == null || this.votedId.isEmpty()) {
                    System.out.println(("当前节点还未正式投票给其它节点，可以投票并且降级，投票给 " + request.getPeerId() + " 节点"));
                    //在这里把当前节点的状态改为跟随者
                    stepDown(request.getTerm(), false, new Status(RaftError.EVOTEFORCANDIDATE,
                            "Raft node votes for some candidate, step down to restart election_timer."));
                    this.votedId = candidateId.copy();
                }
            } while (false);

            Rpc.FormalVoteResponse response = Rpc.FormalVoteResponse.newBuilder()
                    .setStatus(true)
                    .setGranted(request.getTerm() == this.currTerm && candidateId.equals(this.votedId))
                    .setTerm(this.currTerm)
                    .setPeerId(this.serverId.toString())
                    .build();
            requestWrapper.sendResponse(NettyPacket.buildPacket(response.toByteArray(), NAME_NODE_FORMAL_VOTE_RESPONSE));
        } finally {
            //释放写锁的操作
            if (doUnlock) {
                this.writeLock.unlock();
            }
        }
    }

    /**
     * 处理正式投票的响应
     *
     * @param requestWrapper
     */
    public void handleRequestVoteResponse(RequestWrapper requestWrapper) throws InvalidProtocolBufferException {
        this.writeLock.lock();
        try {
            Rpc.FormalVoteResponse response = Rpc.FormalVoteResponse.parseFrom(requestWrapper.getRequest().getBody());

            if (!response.getStatus()) {
                log.warn("请求失败 peerId：{}", response.getPeerId());
                return;
            }
            //当前候选者节点接收到响应之后，发现自己的身份不是候选者了，就直接退出该方法
            //也许在接收到投票响应之前已经收到了集群中选举出来的领导者的信息，这样就会把自己的身份降级为跟随者了
            if (this.state != State.STATE_CANDIDATE) {
                LOG.warn("Node {} received invalid RequestVoteResponse from {}, state not in STATE_CANDIDATE but {}.",
                        getNodeId(), this.serverId, this.state);
                return;
            }
            long term = response.getTerm();
            //判断当前候选者节点的任期是否发生了变化，这里的这个term代表的是当前候选者节点发送索要投票请求之前的任期
            //而在发送索要投票请求之后，收到响应之前，很可能任期就被新的领导者改变了，如果前后任期不一致，也直接退出该方法
            if (term != this.currTerm) {
                LOG.warn("Node {} received stale RequestVoteResponse from {}, term={}, currTerm={}.", getNodeId(),
                        this.serverId, term, this.currTerm);
                return;
            }
            //如果接收到响应后发现请求中的任期，也就是回复响应的节点的任期比自己大
            //也直接退出该方法，并且让自己成为跟随者
            if (response.getTerm() > this.currTerm) {
                LOG.warn("Node {} received invalid RequestVoteResponse from {}, term={}, expect={}.", getNodeId(),
                        this.serverId, response.getTerm(), this.currTerm);
                //身份降级
                stepDown(response.getTerm(), false, new Status(RaftError.EHIGHERTERMRESPONSE,
                        "Raft node receives higher term request_vote_response."));
                return;
            }
            //从请求中判断是否收到了投票
            if (response.getGranted()) {
                //如果收到了投票就把来自peerId节点的投票收集到计票器中
                this.voteCtx.grant(parsePeerId(response.getPeerId()));
                //使用投票计算器计算当前节点收到的投票是否超过了集群中半数节点
                if (this.voteCtx.isGranted()) {
                    //超过了就让当前节点成为领导者
                    System.out.println("正式投票中 " + response.getPeerId() + " 给 " + this.serverId + " 投票  任期为 " + this.currTerm);
                    becomeLeader();
                }
            }
        } finally {
            //释放写锁
            this.writeLock.unlock();
        }
    }

    private void becomeLeader() {
        Requires.requireTrue(this.state == State.STATE_CANDIDATE, "Illegal state: " + this.state);
        //当前节点正在成为领导者，记录这条日志
        //将当前节点状态设置为领导者
        this.state = State.STATE_LEADER;
        //设置领导者ID为当前服务器ID，也就是说领导者就是自己
        this.leaderId = this.serverId.copy();
//        Rpc.MasterRequest request = Rpc.MasterRequest.newBuilder()
//                .setPeerId(this.serverId.toString())
//                .setTerm(this.currTerm)
//                .build();
//        peerNameNodes.broadcast(NettyPacket.buildPacket(request.toByteArray(), NAME_NODE_MSATER_REQUEST));
        PeerNameNode peerNameNode = null;

        replicatorGroup.init(this.leaderId.copy(), this.configuration, this.currTerm, this.timerManager);

        if (heartbeatTimeoutIsRunning.compareAndSet(true, false)) {
            heartTimer.stop();
        }


        for (PeerId peer : configuration.getPeers()) {
            if ((peerNameNode = peerNameNodes.getPeerNameNode(peer.getNodeId())) != null) {
                replicatorGroup.addReplicator(peer, peerNameNode, state);
            }
        }
    }


    public void handleHeartbeat(RequestWrapper requestWrapper) throws InvalidProtocolBufferException {
        try {
            writeLock.lock();
            Rpc.HeartbeatRequest heartbeatRequest = Rpc.HeartbeatRequest.parseFrom(requestWrapper.getRequest().getBody());
            log.info("接收到来自leader的心跳请求 leaderId {}  term {}", heartbeatRequest.getPeerId(), heartbeatRequest.getTerm());
            if (heartbeatRequest.getTerm() < this.currTerm) {
                log.info("心跳请求term小于当前node节点，可能发生了网络分区 this.term {}", this.currTerm);
                Rpc.MasterRequest request = Rpc.MasterRequest.newBuilder()
                        .setTerm(this.currTerm)
                        .setPeerId(this.leaderId.toString())
                        .build();
                log.info("可能产生网络分区，发送本node数据");
                requestWrapper.sendResponse(NettyPacket.buildPacket(request.toByteArray(), NAME_NODE_MSATER_REQUEST));
                return;
            }
            this.state = State.STATE_FOLLOWER;
            this.electionTimer.stop();
            this.currTerm = heartbeatRequest.getTerm();
            updateLastLeaderTimestamp(Utils.monotonicMs());
            this.leaderId = parsePeerId(heartbeatRequest.getPeerId());
            if (heartbeatTimeoutIsRunning.compareAndSet(false, true)) {
                heartTimer.restart();
            }
        } finally {
            writeLock.unlock();
        }
    }


    /**
     * 处理Master选举成功请求
     *
     * @param requestWrapper
     */
    public void handleMasterRequest(RequestWrapper requestWrapper) throws InvalidProtocolBufferException {
        try {
            writeLock.lock();
            Rpc.MasterRequest request = Rpc.MasterRequest.parseFrom(requestWrapper.getRequest().getBody());
            if (this.currTerm < request.getTerm()) {
                log.info("响应的节点的term比本node高 降级 selfNodeId {}  targetNodeId {}", this.currTerm, request.getTerm());
                stepDown(request.getTerm(), false, new Status(RaftError.EHIGHERTERMRESPONSE,
                        "Raft node receives higher term RequestVoteRequest."));
            }
        } finally {
            writeLock.unlock();
        }
    }

    private void checkStepDown(final long term, final PeerId peerId) {
        // 该对象用来封装当前节点身份变更的重要信息
    }


    private PeerId parsePeerId(String peerStr) {
        String[] split = peerStr.split(":");
        return new PeerId(split[0], Integer.parseInt(split[1]), Integer.parseInt(split[2]));
    }


    private void start() throws Exception {
        if (started.compareAndSet(false, true)) {
            controllerManager.start();
            nameNodeServer.start();
        }
    }

    /**
     * 优雅停机
     */
    public void shutdown() {
        if (started.compareAndSet(true, false)) {
            this.defaultScheduler.shutdown();
            this.peerNameNodes.shutdown();
            this.nameNodeServer.shutdown();
        }
    }

    public void addReplicator(String server, PeerNameNode peerNameNode) {
        PeerId peerId = parsePeerId(server);
        replicatorGroup.addReplicator(peerId, peerNameNode, state);
    }
}
