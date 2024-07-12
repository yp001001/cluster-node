package com.cluster.node.server;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author: yp
 * @date: 2024/7/8 10:45
 * @description:
 */
public class NamedThreadFactory implements ThreadFactory {

    private boolean daemon;
    private String prefix;
    private AtomicInteger threadId = new AtomicInteger();

    public NamedThreadFactory(String prefix) {
        this(prefix, true);
    }

    public NamedThreadFactory(String prefix, boolean daemon) {
        this.prefix = prefix;
        this.daemon = daemon;
    }

    @Override
    public Thread newThread(Runnable r) {
        return new DefaultThread(prefix + threadId.getAndIncrement(), r, daemon);
    }
}

