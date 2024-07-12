package com.cluster.node.timer;

import com.cluster.node.server.NamedThreadFactory;
import com.cluster.node.utils.ThreadPoolUtil;

import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/**
 * @author: yp
 * @date: 2024/7/9 13:53
 * @description:
 */
public class TimerManager implements Scheduler {

    private final ScheduledExecutorService executor;

    public TimerManager(int workerNum) {
        this(workerNum, "JRaft-Node-ScheduleThreadPool");
    }

    public TimerManager(int workerNum, String name) {
        //通过线程池工具类创建了一个定时任务调度器
        this.executor = ThreadPoolUtil.newScheduledBuilder()
                .poolName(name)
                .coreThreads(workerNum)
                //默认开启性能监控
                .enableMetric(true)
                .threadFactory(new NamedThreadFactory(name, true))
                .build();
    }

    //下面几个都是提交定时任务的方法
    @Override
    public ScheduledFuture<?> schedule(final Runnable command, final long delay, final TimeUnit unit) {
        return this.executor.schedule(command, delay, unit);
    }

    @Override
    public ScheduledFuture<?> scheduleAtFixedRate(final Runnable command, final long initialDelay, final long period,
                                                  final TimeUnit unit) {
        return this.executor.scheduleAtFixedRate(command, initialDelay, period, unit);
    }

    @Override
    public ScheduledFuture<?> scheduleWithFixedDelay(final Runnable command, final long initialDelay, final long delay,
                                                     final TimeUnit unit) {
        return this.executor.scheduleWithFixedDelay(command, initialDelay, delay, unit);
    }

    @Override
    public void shutdown() {
        this.executor.shutdownNow();
    }
}

