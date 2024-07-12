package com.cluster.node.peer;

import com.cluster.node.model.NettyPacket;

/**
 * @author: yp
 * @date: 2024/7/8 11:14
 * @description:表示一个NameNode节点的连接
 */
public interface PeerNameNode {

    /**
     * 发送网络包，同步发送
     * @param nettyPacket
     * @throws InterruptedException
     */
    void send(NettyPacket nettyPacket) throws InterruptedException;

    /**
     * 获取NameNodeId
     *
     * @return NameNode ID
     */
    int getTargetNodeId();

    /**
     * 获取服务连接的IP和端口号
     *
     * @return IP 和端口号
     */
    String getServer();

    /**
     * 是否连接上
     *
     * @return 是否连接上
     */
    boolean isConnected();

    /**
     * 关闭连接
     */
    void close();

}
