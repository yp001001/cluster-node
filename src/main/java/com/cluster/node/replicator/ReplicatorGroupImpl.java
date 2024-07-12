package com.cluster.node.replicator;

import com.cluster.node.config.Configuration;
import com.cluster.node.error.RaftError;
import com.cluster.node.node.PeerId;
import com.cluster.node.node.State;
import com.cluster.node.peer.PeerNameNode;
import com.cluster.node.status.Status;
import com.cluster.node.timer.Scheduler;
import lombok.extern.slf4j.Slf4j;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author: yp
 * @date: 2024/7/9 16:33
 * @description:
 */
@Slf4j
public class ReplicatorGroupImpl implements ReplicatorGroup {

    private final ConcurrentHashMap<PeerId, ThreadId> replicatorMap = new ConcurrentHashMap<>();
    // 选举超时时间
    private int electionTimeoutMs = -1;
    // 表示每一个节点身份的Map，相对于领导者而言，其他节点可能是跟随者，也可能是一个学习者，存放着映射关系，这个是节点出现异常的Map映射
    private final Map<PeerId, ReplicatorType> failureReplicators = new ConcurrentHashMap<>();
    private ReplicatorOption option;


    @Override
    public boolean init(PeerId leaderId, Configuration configuration, long term, Scheduler scheduler) {
        this.electionTimeoutMs = configuration.getElectionTimeoutMs();
        option = new ReplicatorOption();
        option.setLeader(leaderId);
        option.setTerm(term);
        option.setTimerManager(scheduler);
        option.setDynamicTimeoutMs(configuration.getDynamicTimeoutMs());
        return true;
    }

    @Override
    public ThreadId getReplicator(final PeerId peer) {
        return this.replicatorMap.get(peer);
    }

    @Override
    public void checkReplicator(PeerId peer, boolean lockNode) {
    }

    @Override
    public boolean resetTerm(long newTerm) {
        return false;
    }

    @Override
    public boolean contains(PeerId peer) {
        return false;
    }

    //停止复制器对象工作的方法
    @Override
    public boolean stopReplicator(final PeerId peer) {
        log.info("Stop replicator to {}.", peer);
        this.failureReplicators.remove(peer);
        final ThreadId rid = this.replicatorMap.remove(peer);
        if (rid == null) {
            return false;
        }
        return rid.stop();
    }


    /**
     * 当一个节点当选为领导者后，就会把集群中其他节点包装成一个个复制器对象
     *
     * @param peer
     * @param replicatorType
     * @param sync
     * @return
     */
    @Override
    public boolean addReplicator(final PeerId peer, final ReplicatorType replicatorType, final boolean sync, PeerNameNode peerNameNode, State state) {
        this.failureReplicators.remove(peer);
        //判断复制器对象是否已经添加过了
        if (this.replicatorMap.containsKey(peer)) {
            log.warn("重复保存Replicator peerId：{} 关闭原先Replicator", peer);
            ThreadId threadId = replicatorMap.get(peer);
            threadId.stop();
        }

        //在这里真正创建了一个复制器对象，虽然返回了一个ThreadId对象，但是该对象内部持有者复制器对象
        final ThreadId rid = Replicator.start(option, peer, peerNameNode);
        //如果复制器对象创建失败则返回false
        if (rid == null) {
            log.error("Fail to start replicator to peer={}, replicatorType={}.", peer, replicatorType);
            //记录失败节点到Map中
            this.failureReplicators.put(peer, replicatorType);
            return false;
        }
        //到这里就一切顺利，把包装着复制器对象的ThreadId对象添加到replicatorMap这个Map中
        return this.replicatorMap.put(peer, rid) == null;
    }


    //得到领导者最后一次跟peer对应的跟随者节点发送消息的时间
    @Override
    public long getLastRpcSendTimestamp(final PeerId peer) {
        final ThreadId rid = this.replicatorMap.get(peer);
        if (rid == null) {
            return 0L;
        }
        return Replicator.getLastRpcSendTimestamp(rid);
    }

    @Override
    public void stopAllReplicator() {
        for (ThreadId threadId : replicatorMap.values()) {
            threadId.stop();
        }
        replicatorMap.clear();
        failureReplicators.clear();
    }

    @Override
    public void describe(Printer out) {

    }
}
