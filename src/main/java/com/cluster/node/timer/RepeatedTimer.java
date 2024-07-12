package com.cluster.node.timer;

import com.cluster.node.server.NamedThreadFactory;
import com.cluster.node.utils.Requires;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author: yp
 * @date: 2024/7/8 15:51
 * @description:定时任务管理器
 */
@Slf4j
public abstract class RepeatedTimer implements Describer {

    private final Lock lock = new ReentrantLock();
    // 其实就是Netty内部的定时器HashedWheelTimer
    private final Timer timer;
    private Timeout timeout;
    private boolean stopped;
    private volatile boolean running;
    private volatile boolean destroyed;
    private volatile boolean invoking;
    // 超时选举时间
    private volatile int timeoutMs;
    private final String name;

    public RepeatedTimer(final String name, final int timeoutMs) {
        this(name, timeoutMs, new HashedWheelTimer(new NamedThreadFactory(name, true), 1, TimeUnit.MILLISECONDS, 2048));
    }

    public RepeatedTimer(final String name, final int timeoutMs, final Timer timer) {
        super();
        this.name = name;
        this.timeoutMs = timeoutMs;
        this.stopped = true;
        this.timer = Requires.requireNonNull(timer, "timer");
    }

    protected abstract void onTrigger() throws InterruptedException;

    /**
     * 返回一个超时选举时间
     *
     * @param timeoutMs
     * @return
     */
    protected int adjustTimeout(final int timeoutMs) {
        return timeoutMs;
    }

    public int getTimeoutMs() {
        return timeoutMs;
    }

    /**
     * 核心方法，时间轮线程中执行的实际上就是该类对象中的run方法
     */
    public void run() {
        this.invoking = true;
        try {
            // 调用该方法后，在该方法内部进一步调用handleElectionTimeout方法进行投票活动
            onTrigger();
        } catch (final Throwable t) {
            log.error("RUN timer failed.", t);
        }
        boolean invokeDestroyed = false;
        try {
            this.lock.lock();
            this.invoking = false;
            // 判断该定时器有没有终止
            if (this.stopped) {
                this.running = false;
                invokeDestroyed = this.destroyed;
            } else {
                // 表示定时器还在正常活动
                this.timeout = null;
                // 再次调用schedule方法，提交下一个选举超时任务
                schedule();
            }
        } finally {
            this.lock.unlock();
        }
        if (invokeDestroyed) {
            onDestroy();
        }
    }


    protected void onDestroy() {
        log.info("Destroy timer: {}.", this);
    }

    /**
     * 启动定时器的方法
     */
    public void start() {
        try {
            this.lock.lock();
            if (this.destroyed) {
                return;
            }
            if (!this.stopped) {
                return;
            }
            this.stopped = false;
            if (this.running) {
                return;
            }
            this.running = true;
            //开始调度定时器管理的定时任务
            schedule();
        } finally {
            this.lock.unlock();
        }
    }


    /**
     * 重新启动定时器的方法
     */
    public void restart() {
        this.lock.lock();
        try {
            if (this.destroyed) {
                return;
            }
            this.stopped = false;
            this.running = true;
            schedule();
        } finally {
            this.lock.unlock();
        }
    }

    /**
     * 设置多少时间后执行定时任务
     */
    private void schedule() {
        if (this.timeout != null) {
            this.timeout.cancel();
        }
        final TimerTask timerTask = timeout -> {
            try {
                RepeatedTimer.this.run();
            } catch (final Throwable t) {
                log.error("Run timer task failed, taskName={}", RepeatedTimer.this.name);
            }
        };
        this.timeout = this.timer.newTimeout(timerTask, adjustTimeout(this.timeoutMs), TimeUnit.MILLISECONDS);
    }

    //重置超时选举时间，然后调度超时选举任务
    public void reset(final int timeoutMs) {
        this.lock.lock();
        this.timeoutMs = timeoutMs;
        try {
            if (this.stopped) {
                return;
            }
            if (this.running) {
                schedule();
            }
        } finally {
            this.lock.unlock();
        }
    }


    public void reset() {
        this.lock.lock();
        try {
            reset(this.timeoutMs);
        } finally {
            this.lock.unlock();
        }
    }


    public void destroy() {
        boolean invokeDestroyed = false;
        this.lock.lock();
        try {
            if (this.destroyed) {
                return;
            }
            this.destroyed = true;
            if (!this.running) {
                invokeDestroyed = true;
            }
            if (this.stopped) {
                return;
            }
            this.stopped = true;
            if (this.timeout != null) {
                if (this.timeout.cancel()) {
                    invokeDestroyed = true;
                    this.running = false;
                }
                this.timeout = null;
            }
        } finally {
            this.lock.unlock();
            this.timer.stop();
            if (invokeDestroyed) {
                onDestroy();
            }
        }
    }


    public void stop() {
        this.lock.lock();
        try {
            if (this.stopped) {
                return;
            }
            this.stopped = true;
            if (this.timeout != null) {
                this.timeout.cancel();
                this.running = false;
                this.timeout = null;
            }
        } finally {
            this.lock.unlock();
        }
    }

    @Override
    public void describe(final Printer out) {
        final String _describeString;
        this.lock.lock();
        try {
            _describeString = toString();
        } finally {
            this.lock.unlock();
        }
        out.print("  ") //
                .println(_describeString);
    }

    @Override
    public String toString() {
        return "RepeatedTimer{" + "timeout=" + this.timeout + ", stopped=" + this.stopped + ", running=" + this.running
                + ", destroyed=" + this.destroyed + ", invoking=" + this.invoking + ", timeoutMs=" + this.timeoutMs
                + ", name='" + this.name + '\'' + '}';
    }
}
