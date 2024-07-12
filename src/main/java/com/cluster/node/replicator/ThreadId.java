package com.cluster.node.replicator;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author: yp
 * @date: 2024/7/9 16:36
 * @description:该类的对象会持有复制器对象的引用，包装复制器对象，提供了同步锁的功能
 */
@Slf4j
public class ThreadId {

    private final Object data;
    private final ReentrantLock lock = new ReentrantLock();
    private final OnError onError;
    private volatile boolean destroyed;

    public boolean stop() {
        if(data instanceof Replicator){
            Replicator replicator = (Replicator) data;
            return replicator.stop();
        }
        return false;
    }

    public interface OnError{
        void onError(final ThreadId id, final Object data, final int errorCode);
    }

    public ThreadId(final Object data, final OnError onError){
        super();
        this.data = data;
        this.onError = onError;
        this.destroyed = false;
    }

    public Object getData() {
        return data;
    }

    public Object lock() {
        if (this.destroyed) {
            return null;
        }
        this.lock.lock();
        if (this.destroyed) {
            this.lock.unlock();
            return null;
        }
        return this.data;
    }

    public void unlock() {
        if (!this.lock.isHeldByCurrentThread()) {
            log.warn("Fail to unlock with {}, the lock is not held by current thread {}.", this.data,
                    Thread.currentThread());
            return;
        }
        this.lock.unlock();
    }

    //让当前线程让出执行行权
    public void join() {
        while (!this.destroyed) {
            Thread.yield();
        }
    }

    @Override
    public String toString() {
        return this.data.toString();
    }

    /**
     * 发送心跳请求
     * @param errorCode
     */
    public void setError(final int errorCode) {
        if (this.destroyed) {
            log.warn("ThreadId: {} already destroyed, ignore error code: {}", this.data, errorCode);
            return;
        }
        try {
            if (this.destroyed) {
                log.warn("ThreadId: {} already destroyed, ignore error code: {}", this.data, errorCode);
                return;
            }
            if (this.onError != null) {
                this.onError.onError(this, this.data, errorCode);
            }
        } finally {
        }
    }

}
