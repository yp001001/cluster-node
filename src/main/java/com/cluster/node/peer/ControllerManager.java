package com.cluster.node.peer;

import com.cluster.node.NameNode;
import com.cluster.node.config.Configuration;
import com.cluster.node.constant.Constants;
import com.cluster.node.model.NettyPacket;
import com.cluster.node.node.PeerId;
import com.cluster.node.utils.NetUtils;
import com.dfs.common.enums.PacketType;
import com.dfs.common.model.namenode.NameNodeAwareRequest;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * @author: yp
 * @date: 2024/7/8 13:51
 * @description:
 */
@Slf4j
public class ControllerManager {

    private PeerNameNodes peerNameNodes;
    private Configuration configuration;
    private AtomicBoolean isInit = new AtomicBoolean(false);
    private NameNode nameNode;

    public ControllerManager(Configuration configuration, PeerNameNodes peerNameNodes) {
        this.peerNameNodes = peerNameNodes;
        this.configuration = configuration;
    }

    public void setNameNode(NameNode nameNode) {
        this.nameNode = nameNode;
    }

    public void start() throws Exception {
        log.info("NameNode当前节点为：[nodeId={}, server={}]", configuration.getNodeId(), configuration.getHost() + ":" + configuration.getPort());
//        if (nameNodeConfig.getNameNodePeerServers() == null || nameNodeConfig.getNameNodePeerServers().length() == 0
//                || nameNodeConfig.getNameNodePeerServers().split(",").length == 1) {
//            log.info("NameNode集群模式为单点模式, 自己就是Controller节点");
//            controllerManager.startControllerElection();
//        } else {
        List<PeerId> peers = configuration.getPeers();
        for (PeerId peer : peers) {
            if (configuration.getNodeId() == peer.getNodeId()) {
                continue;
            }
            String server = peer.getHost() + ":" + peer.getPort() + ":" + peer.getNodeId();
            peerNameNodes.connect(server);
        }
    }

    /**
     * 上报自身信息给其它节点PeerNameNode
     *
     * @param nameNode
     * @param isClient
     * @throws InterruptedException
     */
    public void reportSelfInfoToPeer(PeerNameNode nameNode, boolean isClient) throws InterruptedException {
        if (nameNode == null) return;
        NameNodeAwareRequest nameNodeInfo = NameNodeAwareRequest.newBuilder()
                .setNameNodeId(configuration.getNodeId())
                .setServer(configuration.getHost() + ":" + configuration.getPort() + ":" + configuration.getNodeId())
                .setIsClient(isClient)
                .addAllServers(peerNameNodes.getAllServers())
                .build();
        NettyPacket nettyPacket = NettyPacket.buildPacket(nameNodeInfo.toByteArray(), PacketType.NAME_NODE_PEER_AWARE);
        nameNode.send(nettyPacket);
        log.info("建立了PeerNameNode的连接, 发送自身信息：[currentNodeId={}, targetNodeId={}]", configuration.getNodeId(),
                nameNode.getTargetNodeId());
    }

    /**
     * 等待进行投票选举master
     *
     * @param nameNodeAwareRequest
     */
    public void onAwarePeerNameNode(NameNodeAwareRequest nameNodeAwareRequest) {
        // 确保所有服务已经连接成功
        if(configuration.getPeers().size() - 1 == peerNameNodes.getConnectedCount()){
            if(isInit.compareAndSet(false, true)){
                log.info("初始化namenode...");
                nameNode.init();
            }
        }
    }
}
