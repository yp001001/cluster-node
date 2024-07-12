package com.cluster.node.listener;

/**
 * @author: yp
 * @date: 2024/7/8 11:26
 * @description:网络连接状态监听器
 */
public interface ConnectListener {

    /**网络状态监听
     *  为了保证消息的有序性
     *
     * @param connected
     * @throws Exception
     */
    void onConnectStatusChanged(boolean connected) throws Exception;

}
