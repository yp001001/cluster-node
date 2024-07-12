package com.cluster.node.server;

import lombok.extern.slf4j.Slf4j;

/**
 * @author: yp
 * @date: 2024/7/8 10:41
 * @description:
 */
@Slf4j
public class DefaultThread extends Thread {

    public DefaultThread(final String name, boolean daemon) {
        super(name);
        configureThread(name, daemon);
    }

    public DefaultThread(final String name, Runnable runnable, boolean daemon) {
        super(runnable, name);
        configureThread(name, daemon);
    }


    private void configureThread(String name, boolean daemon) {
        setDaemon(daemon);
        setUncaughtExceptionHandler((t, e) -> log.error("Uncaught exception in thread '{}':", name, e));
    }
}

