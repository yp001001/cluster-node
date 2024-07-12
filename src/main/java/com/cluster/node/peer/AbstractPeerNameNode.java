package com.cluster.node.peer;

import com.cluster.node.model.NettyPacket;

/**
 * @author: yp
 * @date: 2024/7/8 11:15
 * @description:
 */
public abstract class AbstractPeerNameNode implements PeerNameNode {

    private String server;
    protected Integer currentNodeId;
    private Integer targetNodeId;

    public AbstractPeerNameNode(int currentNodeId, int targetNodeId, String server) {
        this.currentNodeId = currentNodeId;
        this.targetNodeId = targetNodeId;
        this.server = server;
    }

    @Override
    public int getTargetNodeId() {
        return targetNodeId;
    }

    @Override
    public String getServer() {
        return this.server;
    }

}
