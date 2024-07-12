package com.cluster.node.replicator;

import com.cluster.node.status.Status;

/**
 * @author: yp
 * @date: 2024/7/9 16:41
 * @description:内部类对象封装着要回调的方法，当jraft内部的客户端发送的请求收到响应后，这些方法就会被回调
 */
public interface Closure {
    void run(final Status status);
}

