package com.cluster.node.factory.timer;

import com.cluster.node.server.NamedThreadFactory;
import com.cluster.node.timer.HashedWheelTimer;
import com.cluster.node.timer.Scheduler;
import com.cluster.node.timer.Timer;
import com.cluster.node.timer.TimerManager;
import com.cluster.node.utils.Utils;
import io.netty.util.internal.SystemPropertyUtil;

import java.util.concurrent.TimeUnit;

/**
 * @author: yp
 * @date: 2024/7/8 16:31
 * @description:创建定时器，超时选举投票定时器，检测是否下台定时器等
 */
public class DefaultRaftTimerFactory implements RaftTimerFactory {


    @Override
    public Timer getElectionTimer(boolean shared, String name) {
        return createTimer(name);
    }

    @Override
    public Timer getVoteTimer(boolean shared, String name) {
        return createTimer(name);
    }

    @Override
    public Timer getStepDownTimer(boolean shared, String name) {
        return null;
    }

    @Override
    public Timer getSnapshotTimer(boolean shared, String name) {
        return null;
    }

    @Override
    public Scheduler getRaftScheduler(boolean shared, int workerNum, String name) {
        return createScheduler(workerNum, name);
    }

    @Override
    public Timer createTimer(String name) {
        return new HashedWheelTimer(new NamedThreadFactory(name, true), 1, TimeUnit.MILLISECONDS, 2048);
    }

    @Override
    public Scheduler createScheduler(int workerNum, String name) {
        return new TimerManager(workerNum, name);
    }
}
