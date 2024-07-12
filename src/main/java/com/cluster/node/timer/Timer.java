package com.cluster.node.timer;

import java.util.Set;
import java.util.concurrent.TimeUnit;


/**
 * @author: yp
 * @date: 2024/7/8 16:02
 * @description:
 */
public interface Timer {

    Timeout newTimeout(final TimerTask task, final long delay, final TimeUnit unit);

    Set<Timeout> stop();

}
