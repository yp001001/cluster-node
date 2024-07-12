package com.cluster.node.timer;

import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/**
 * @author: yp
 * @date: 2024/7/8 16:24
 * @description:
 */
public interface Scheduler {


    ScheduledFuture<?> schedule(final Runnable command, final long delay, final TimeUnit unit);


    ScheduledFuture<?> scheduleAtFixedRate(final Runnable command, final long initialDelay, final long period,
                                           final TimeUnit unit);


    ScheduledFuture<?> scheduleWithFixedDelay(final Runnable command, final long initialDelay, final long delay,
                                              final TimeUnit unit);

    void shutdown();
}
