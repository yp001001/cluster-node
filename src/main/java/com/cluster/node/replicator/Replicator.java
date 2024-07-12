package com.cluster.node.replicator;

import com.cluster.node.model.NettyPacket;
import com.cluster.node.node.PeerId;
import com.cluster.node.peer.PeerNameNode;
import com.cluster.node.timer.Scheduler;
import com.cluster.node.utils.Utils;
import com.cluster.node.wrapper.RequestWrapper;
import com.dfs.common.model.namenode.Rpc;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

import static com.dfs.common.enums.PacketType.LEADER_HEARTBEAT;

/**
 * @author: yp
 * @date: 2024/7/9 16:39
 * @description:
 */
@Slf4j
public class Replicator implements ThreadId.OnError {

    // 领导者任期
    private final long term;
    //领导者最后一次发送信息的时间
    private volatile long lastRpcSendTimestamp;
    //心跳定时器
    private ScheduledFuture<?> heartbeatTimer;
    // 节点信息
    private PeerId peerId;
    // 心跳时间间隔
    private int dynamicTimeoutMs = -1;
    // 连接信息
    private PeerNameNode peerNameNode;
    //这个其实就可以看成一个句柄，复制器对象的引用被ThreadId对象持用
    //该对象会交给复制器组管理
    protected ThreadId id;
    // 全局定时任务管理器，这个定时任务管理器会提交发送心跳信息的定时任务
    private final Scheduler timerManager;
    // leader信息
    private PeerId leaderId;

    public Replicator(ReplicatorOption option, PeerId peerId, PeerNameNode peerNameNode) {
        this.timerManager = option.getTimerManager();
        this.leaderId = option.getLeader();
        this.term = option.getTerm();
        this.peerNameNode = peerNameNode;
        this.peerId = peerId;
        this.dynamicTimeoutMs = option.getDynamicTimeoutMs();
    }


    public static ThreadId start(ReplicatorOption option, PeerId peerId, PeerNameNode peerNameNode) {
        final Replicator r = new Replicator(option, peerId, peerNameNode);
        //在这里远程连接一下这个复制器对象对应的节点，连接失败返回null
        if (!r.peerNameNode.isConnected()) {
            log.error("Fail to init sending channel to {}.", peerId);
            return null;
        }
        //创建ThreadId句柄对象，这个对象持有了刚才创建的复制器对象
        r.id = new ThreadId(r, r);
        // 加锁
        r.id.lock();
        r.lastRpcSendTimestamp = Utils.monotonicMs();
        //启动心跳定时器，这个定时器会定时向其他节点发送心跳消息
        r.startHeartbeatTimer(Utils.nowMs());
        //返回ThreadId对象
        return r.id;
    }

    public boolean stop() {
        log.info("关闭Replicator peerId {}", peerId);
        heartbeatTimer.cancel(true);
        return true;
    }

    //得到领导者最后一次跟对应的跟随者节点发送消息的时间
    public static long getLastRpcSendTimestamp(final ThreadId id) {
        final Replicator r = (Replicator) id.getData();
        if (r == null) {
            return 0L;
        }
        return r.lastRpcSendTimestamp;
    }

    /**
     * 启动心跳定时器的方法
     *
     * @param startMs
     */
    private void startHeartbeatTimer(final long startMs) {
        final long dueTime = startMs + dynamicTimeoutMs;
        try {
            //使用全局定时任务管理器提交一个定时任务，在这个任务中执行发送心跳消息的请求
            this.heartbeatTimer = this.timerManager.scheduleAtFixedRate(() -> onTimeout(this.id), dueTime - Utils.nowMs(),
                    3000, TimeUnit.MILLISECONDS);
        } catch (final Exception e) {
            log.error("Fail to schedule heartbeat timer", e);
            onTimeout(this.id);
        }
    }

    private static void onTimeout(final ThreadId id) {
        if (id != null) {
            id.setError(1010);
        } else {
            log.warn("Replicator id is null when timeout, maybe it's destroyed.");
        }
    }


    @Override
    public void onError(ThreadId id, Object data, int errorCode) {
        //发送之前先上锁
        final Replicator r = (Replicator) id.getData();
        if (r == null) {
            return;
        }
        r.sendEmptyEntries(true);
    }

    private void sendEmptyEntries(final boolean isHeartbeat) {
        try {
            //当前发送请求的时间
            final long monotonicSendTimeMs = Utils.monotonicMs();
            //根据方法中的参数判断是否为心跳请求
            if (isHeartbeat) {
                System.out.println("LEADER发送了心跳消息 leaderId " + leaderId.toString() + " term " + term);
                //创建AppendEntriesRequest对象封装消息内容
                Rpc.HeartbeatRequest request = Rpc.HeartbeatRequest.newBuilder()
                        .setPeerId(this.leaderId.toString())
                        .setTerm(this.term)
                        .build();
                peerNameNode.send(NettyPacket.buildPacket(request.toByteArray(), LEADER_HEARTBEAT));
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    private void lockId() {
        if (this.id == null) {
            return;
        }
        this.id.lock();
    }

    //释放锁的方法
    private void unlockId() {
        if (this.id == null) {
            return;
        }
        this.id.unlock();
    }

    /**
     * 处理心跳响应
     *
     * @param requestWrapper
     */
    public void handleHeartbeat(RequestWrapper requestWrapper) {
    }
}
