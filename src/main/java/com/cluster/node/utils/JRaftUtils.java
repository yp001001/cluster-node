package com.cluster.node.utils;

import com.cluster.node.factory.timer.DefaultRaftTimerFactory;
import com.cluster.node.factory.timer.RaftTimerFactory;

/**
 * @author: yp
 * @date: 2024/7/8 16:27
 * @description:
 */
public class JRaftUtils {

//    扩展可使用SPI机制
//    private final static RaftTimerFactory TIMER_FACTORY = JRaftServiceLoader.load(RaftTimerFactory.class).first();
    private final static RaftTimerFactory TIMER_FACTORY = new DefaultRaftTimerFactory();

    //返回定时器工厂
    public static RaftTimerFactory raftTimerFactory() {
        return TIMER_FACTORY;
    }


}
