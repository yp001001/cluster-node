package com.cluster.node.peer;

import com.cluster.node.model.NettyPacket;
import com.cluster.node.server.NetClient;

/**
 * @author: yp
 * @date: 2024/7/8 11:22
 * @description:表示和PeerNameNode的连接，作为客户端
 */
public class PeerNameNodeClient extends AbstractPeerNameNode{

    private NetClient netClient;

    public PeerNameNodeClient(NetClient netClient, int currentNodeId, int targetNodeId, String server) {
        super(currentNodeId, targetNodeId, server);
        this.netClient = netClient;
    }

    @Override
    public void send(NettyPacket nettyPacket) throws InterruptedException {
        netClient.send(nettyPacket);
    }

    @Override
    public boolean isConnected() {
        return netClient.isConnected();
    }

    @Override
    public void close() {
        netClient.shutdown();
    }
}
