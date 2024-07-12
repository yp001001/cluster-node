package com.cluster.node.replicator;

import com.cluster.node.node.PeerId;
import com.cluster.node.peer.PeerNameNode;
import com.cluster.node.timer.Scheduler;

/**
 * @author: yp
 * @date: 2024/7/9 17:21
 * @description:
 */
public class ReplicatorOption {

    private long term;
    private PeerId leader;
    // 全局定时任务管理器，这个定时任务管理器会提交发送心跳信息的定时任务
    private Scheduler timerManager;
    // 心跳间隔时间
    private int dynamicTimeoutMs;

    public int getDynamicTimeoutMs() {
        return dynamicTimeoutMs;
    }

    public void setDynamicTimeoutMs(int dynamicTimeoutMs) {
        this.dynamicTimeoutMs = dynamicTimeoutMs;
    }

    public long getTerm() {
        return term;
    }

    public void setTerm(long term) {
        this.term = term;
    }

    public PeerId getLeader() {
        return leader;
    }

    public void setLeader(PeerId leader) {
        this.leader = leader;
    }

    public Scheduler getTimerManager() {
        return timerManager;
    }

    public void setTimerManager(Scheduler timerManager) {
        this.timerManager = timerManager;
    }
}
