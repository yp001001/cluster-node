package com.cluster.node.timer;


/**
 * @author: yp
 * @date: 2024/7/8 15:53
 * @description:
 */
public interface Timeout {

    Timer timer();

    TimerTask task();

    boolean isExpired();

    boolean isCancelled();

    boolean cancel();

}
