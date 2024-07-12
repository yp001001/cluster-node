package com.cluster.node.listener;

/**
 * @author: yp
 * @date: 2024/7/8 11:37
 * @description:网络客户端连接失败监听器
 */
public interface NetClientFailListener {

    void onConnectFail();

}
