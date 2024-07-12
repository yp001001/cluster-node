package com.cluster.node.server;

import com.cluster.node.NameNode;
import com.cluster.node.config.Configuration;
import com.cluster.node.handler.AbstractChannelHandler;
import com.cluster.node.model.NettyPacket;
import com.cluster.node.node.PeerId;
import com.cluster.node.peer.ControllerManager;
import com.cluster.node.peer.PeerNameNode;
import com.cluster.node.peer.PeerNameNodes;
import com.cluster.node.replicator.ReplicatorGroup;
import com.cluster.node.wrapper.RequestWrapper;
import com.dfs.common.enums.PacketType;
import com.dfs.common.model.namenode.NameNodeAwareRequest;
import com.google.protobuf.InvalidProtocolBufferException;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.socket.SocketChannel;
import lombok.extern.slf4j.Slf4j;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author: yp
 * @date: 2024/7/5 14:39
 * @description:NameNode网络接口处理器
 */
@Slf4j
public class NameNodeApis extends AbstractChannelHandler {

    private PeerNameNodes peerNameNodes;
    private Integer nodeId;
    private Configuration configuration;
    private final ThreadPoolExecutor executor;
    private DefaultScheduler defaultScheduler;
    private ControllerManager controllerManager;
    private NameNode nameNode;

    public NameNodeApis(PeerNameNodes peerNameNodes, Configuration configuration,
                        DefaultScheduler defaultScheduler, ControllerManager controllerManager) {
        this.peerNameNodes = peerNameNodes;
        this.configuration = configuration;
        this.nodeId = configuration.getNodeId();
        this.executor = new ThreadPoolExecutor(configuration.getNameNodeApiCoreSize(), configuration.getNameNodeApiMaximumPoolSize(),
                60L, TimeUnit.SECONDS, new LinkedBlockingQueue<>(configuration.getNameNodeApiQueueSize()));
        this.defaultScheduler = defaultScheduler;
        this.controllerManager = controllerManager;
    }

    public void setNameNode(NameNode nameNode) {
        this.nameNode = nameNode;
    }

    @Override
    public ThreadPoolExecutor getExecutor() {
        return executor;
    }

    @Override
    protected boolean handlePackage(ChannelHandlerContext ctx, NettyPacket nettyPacket) throws Exception {
        PacketType packetType = PacketType.getEnum(nettyPacket.getPacketType());
        RequestWrapper requestWrapper = new RequestWrapper(ctx, nettyPacket);

        switch (packetType) {
            case NAME_NODE_CONTROLLER_PREV_VOTE_REQUEST:
                // 处理其它namenode发送的投票请求
                nameNode.handlePreVoteRequest(requestWrapper);
                break;
            case NAME_NODE_PEER_AWARE:
                handleNameNodePeerAwareRequest(requestWrapper);
                break;
            case NAME_NODE_CONTROLLER_PREV_VOTE_RESPONSE:
                System.out.println(("接收到预投票的响应"));
                nameNode.handlePreVoteResponse(requestWrapper);
                break;
            case NAME_NODE_FORMAL_VOTE_REQUEST:
                nameNode.handleRequestVoteRequest(requestWrapper);
                break;
            case NAME_NODE_FORMAL_VOTE_RESPONSE:
                nameNode.handleRequestVoteResponse(requestWrapper);
                break;
            case NAME_NODE_MSATER_REQUEST:
                nameNode.handleMasterRequest(requestWrapper);
                break;
            case LEADER_HEARTBEAT:
                nameNode.handleHeartbeat(requestWrapper);
                break;
            default:
                break;
        }

        return false;
    }


    @Override
    protected Set<Integer> interestPackageTypes() {
        return new HashSet<>();
    }

    /**
     * 处理节点发起连接后立即发送的NameNode集群信息请求
     */
    private void handleNameNodePeerAwareRequest(RequestWrapper requestWrapper) throws InvalidProtocolBufferException, InterruptedException {
        NettyPacket request = requestWrapper.getRequest();
        ChannelHandlerContext ctx = requestWrapper.getCtx();
        NameNodeAwareRequest nameNodeAwareRequest = NameNodeAwareRequest.parseFrom(request.getBody());
        if (nameNodeAwareRequest.getIsClient()) {
            /**
             * 只有作为服务端才会保存新增的连接，客户端已经保存了连接
             */
            PeerNameNode peerNameNode = peerNameNodes.addPeerNode(nameNodeAwareRequest.getNameNodeId(), (SocketChannel) ctx.channel(),
                    nameNodeAwareRequest.getServer(), configuration.getNodeId(), defaultScheduler);
            if (peerNameNodes != null) {
                // 作为服务端接收到连接请求也同时发送自身信息给别的节点
                controllerManager.reportSelfInfoToPeer(peerNameNode, false);
            }

            if (nameNode != null && peerNameNode != null) {
                nameNode.addReplicator(nameNodeAwareRequest.getServer(), peerNameNode);
            }
        }
        // 等待所有节点连接，通过投票选择master节点
        log.info("查询得到连接数量：{}", peerNameNodes.getConnectedCount());
        controllerManager.onAwarePeerNameNode(nameNodeAwareRequest);
    }

    private PeerId parsePeerId(String peerStr) {
        String[] split = peerStr.split(":");
        return new PeerId(split[0], Integer.parseInt(split[1]), Integer.parseInt(split[2]));
    }
}
