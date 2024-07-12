package com.cluster.node.constant;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicLong;

import static com.cluster.node.server.BaseChannelInitializer.MAX_BYTES;

/**
 * @author: yp
 * @date: 2024/7/8 11:21
 * @description:
 */
public class Constants {

    public static AtomicLong REQUEST_COUNTER = new AtomicLong(1);


    /**
     * 分块传输，每一块的大小
     */
    public static final int CHUNKED_SIZE = (int) (MAX_BYTES * 0.5F);

    public static CountDownLatch countDownLatch = new CountDownLatch(1);

}
