package com.cluster.node.timer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.*;

/**
 * @author: yp
 * @date: 2024/7/9 13:56
 * @description:
 */
public class LogScheduledThreadPoolExecutor extends ScheduledThreadPoolExecutor {

    private static final Logger LOG = LoggerFactory.getLogger(LogScheduledThreadPoolExecutor.class);

    private final String        name;

    public LogScheduledThreadPoolExecutor(int corePoolSize, String name) {
        super(corePoolSize);
        this.name = name;
    }

    public LogScheduledThreadPoolExecutor(int corePoolSize, ThreadFactory threadFactory, String name) {
        super(corePoolSize, threadFactory);
        this.name = name;
    }

    public LogScheduledThreadPoolExecutor(int corePoolSize, RejectedExecutionHandler handler, String name) {
        super(corePoolSize, handler);
        this.name = name;
    }

    public LogScheduledThreadPoolExecutor(int corePoolSize, ThreadFactory threadFactory,
                                          RejectedExecutionHandler handler, String name) {
        super(corePoolSize, threadFactory, handler);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    protected void afterExecute(Runnable r, Throwable t) {
        super.afterExecute(r, t);
        if (t == null && r instanceof Future<?>) {
            try {
                final Future<?> f = (Future<?>) r;
                if (f.isDone()) {
                    f.get();
                }
            } catch (final CancellationException ce) {
                // ignored
            } catch (final ExecutionException ee) {
                t = ee.getCause();
            } catch (final InterruptedException ie) {
                Thread.currentThread().interrupt();
            }
        }
        if (t != null) {
            LOG.error("Uncaught exception in pool: {}, {}.", this.name, super.toString(), t);
        }
    }

    @Override
    protected void terminated() {
        super.terminated();
        LOG.info("ThreadPool is terminated: {}, {}.", this.name, super.toString());
    }
}

