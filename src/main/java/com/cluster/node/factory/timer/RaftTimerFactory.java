package com.cluster.node.factory.timer;

import com.cluster.node.timer.Scheduler;
import com.cluster.node.timer.Timer;

/**
 * @author: yp
 * @date: 2024/7/8 16:29
 * @description:定时任务功能，
 */
public interface RaftTimerFactory {

    Timer getElectionTimer(final boolean shared, final String name);

    Timer getVoteTimer(final boolean shared, final String name);

    Timer getStepDownTimer(final boolean shared, final String name);

    Timer getSnapshotTimer(final boolean shared, final String name);

    Scheduler getRaftScheduler(final boolean shared, final int workerNum, final String name);

    Timer createTimer(final String name);

    Scheduler createScheduler(final int workerNum, final String name);
}
