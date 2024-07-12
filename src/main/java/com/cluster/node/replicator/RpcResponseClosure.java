package com.cluster.node.replicator;

import com.google.protobuf.Message;

/**
 * @author: yp
 * @date: 2024/7/9 16:41
 * @description:
 */
//接收到响应要回调的方法
public interface RpcResponseClosure<T extends Message> extends Closure {

    //把接收到的响应设置到RpcResponseClosureAdapter适配器对象中
    void setResponse(T resp);
}