package com.cluster.node.peer;

import com.cluster.node.config.Configuration;
import com.cluster.node.model.NettyPacket;
import com.cluster.node.node.PeerId;
import com.cluster.node.node.State;
import com.cluster.node.replicator.ReplicatorGroup;
import com.cluster.node.server.DefaultScheduler;
import com.cluster.node.server.NameNodeApis;
import com.cluster.node.server.NetClient;
import com.cluster.node.timer.RepeatedTimer;
import io.netty.channel.socket.SocketChannel;
import lombok.extern.slf4j.Slf4j;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author: yp
 * @date: 2024/7/8 11:12
 * @description:负责维护所有NameNode节点之间的组件
 */
@Slf4j
public class PeerNameNodes {

    private Map<Integer, PeerNameNode> peerNameNodeMap = new ConcurrentHashMap<>();
    private NameNodeApis nameNodeApis;
    private DefaultScheduler defaultScheduler;
    private Configuration configuration;
    private ControllerManager controllerManager;
    private Map<Integer, PeerNameNode> failPeerNameNodeMap = new ConcurrentHashMap<>();
    private ReplicatorGroup replicatorGroup;

    public PeerNameNodes(Configuration configuration, NameNodeApis nameNodeApis, DefaultScheduler defaultScheduler) {
        this.nameNodeApis = nameNodeApis;
        this.defaultScheduler = defaultScheduler;
        this.configuration = configuration;
    }

    public void setControllerManager(ControllerManager controllerManager) {
        this.controllerManager = controllerManager;
    }

    public void setReplicatorGroup(ReplicatorGroup replicatorGroup) {
        this.replicatorGroup = replicatorGroup;
    }

    public void setNameNodeApis(NameNodeApis nameNodeApis) {
        this.nameNodeApis = nameNodeApis;
    }

    /**
     * 作为客户端添加PeerNode主动连接NameNode节点
     *
     * @param server
     */
    public void connect(String server) {
        connect(server, false);
    }


    public void connect(String server, boolean force) {
        // 获取目标服务的namenodeId，服务地址
        String[] info = server.split(":");
        String hostname = info[0];
        int port = Integer.parseInt(info[1]);
        int targetNodeId = Integer.parseInt(info[2]);
        if (hostname.equals(configuration.getHost()) && port == configuration.getPort()) {
            return;
        }

        // 只往比nodeId大于自己的服务发送连接
        if (configuration.getNodeId() > targetNodeId) {
            return;
        }

        synchronized (this) {
            String peerDataNode = hostname + ":" + port + ":" + targetNodeId;
            PeerNameNode peer = peerNameNodeMap.get(targetNodeId);
            if (force || peer == null) {
                if (peer != null) {
                    peer.close();
                }
                NetClient netClient = new NetClient("NameNode-PeerNode-" + targetNodeId, defaultScheduler);
                netClient.addHandlers(Collections.singletonList(nameNodeApis));
                PeerNameNode newPeer = new PeerNameNodeClient(netClient, configuration.getNodeId(), targetNodeId, peerDataNode);
                peerNameNodeMap.put(targetNodeId, newPeer);
                netClient.addConnectListener(connected -> {
                    if (connected) {
                        // 连接成功后进行服务间的发现
                        controllerManager.reportSelfInfoToPeer(newPeer, true);
                        log.info("连接成功，sourceNameNode：{} targetNameNode：{}", configuration.getNodeId(), targetNodeId);
                    }
                });
                netClient.connect(hostname, port);
                log.info("新建PeerNameNode的链接：[hostname={}, port={}, nameNodeId={}]", hostname, port, targetNodeId);
            }
        }
    }

    /**
     * 广播
     *
     * @param nettyPacket
     * @return
     */
    public List<Integer> broadcast(NettyPacket nettyPacket) {
        return broadcast(nettyPacket, -1);
    }

    public List<Integer> broadcast(NettyPacket nettyPacket, int excludeNodeId) {
        return broadcast(nettyPacket, new HashSet<>(Collections.singletonList(excludeNodeId)));
    }

    public List<Integer> broadcast(NettyPacket nettyPacket, Set<Integer> excludeNodeIds) {
        try {
            List<Integer> result = new ArrayList<>();
            for (Integer key : peerNameNodeMap.keySet()) {
                PeerNameNode peerNameNode = peerNameNodeMap.get(key);
                if (excludeNodeIds.contains(peerNameNode.getTargetNodeId())) {
                    continue;
                }
                if (!peerNameNode.isConnected()) {
                    synchronized (this) {
                        failPeerNameNodeMap.put(key, peerNameNode);
                        peerNameNodeMap.remove(key);
                        peerNameNode.close();
                    }
                    continue;
                }
                peerNameNode.send(nettyPacket);
                result.add(peerNameNode.getTargetNodeId());
            }
            return result;
        } catch (Exception e) {
            log.error("PeerNameNodes#boardcast has interrupted. ", e);
            return new ArrayList<>();
        }
    }

    /**
     * 优雅停止
     */
    public void shutdown() {
        log.info("Shutdown PeerNameNodes");
        for (PeerNameNode peerNameNode : peerNameNodeMap.values()) {
            peerNameNode.close();
        }
    }

    public List<String> getAllServers() {
        List<String> result = new ArrayList<>(peerNameNodeMap.size());
        for (PeerNameNode peerNameNode : peerNameNodeMap.values()) {
            result.add(peerNameNode.getServer());
        }
        return result;
    }

    public List<Integer> getAllNodeId() {
        return new ArrayList<>(peerNameNodeMap.keySet());
    }

    /**
     * 获取所有已经建立连接的节点数量
     *
     * @return 建立连接的节点数量
     */
    public int getConnectedCount() {
        synchronized (this) {
            int count = 0;
            for (PeerNameNode peerNameNode : peerNameNodeMap.values()) {
                if (peerNameNode.isConnected()) {
                    count++;
                }
            }
            return count;
        }
    }

    public PeerNameNode addPeerNode(int nodeId, SocketChannel socketChannel, String server, int selfNodeId,
                                    DefaultScheduler defaultScheduler) {
        synchronized (this) {
            PeerNameNode oldPeer = peerNameNodeMap.get(nodeId);
            PeerNameNode newPeer = new PeerNameNodeServer(socketChannel, configuration.getNodeId(), nodeId, server, defaultScheduler);
            if (oldPeer == null) {
                log.info("收到新的PeerNameNode的通知网络包, 保存连接以便下一次使用: [nodeId={}]", nodeId);
                peerNameNodeMap.put(nodeId, newPeer);
                return newPeer;
            } else {
                if (oldPeer instanceof PeerNameNodeServer && newPeer.getTargetNodeId() == oldPeer.getTargetNodeId()) {
                    // 表示断线重连，重新更新channel
                    PeerNameNodeServer peerNameNodeServer = (PeerNameNodeServer) oldPeer;
                    peerNameNodeServer.setSocketChannel(socketChannel);
                    log.info("PeerNameNode断线重连，更新channel: [nodeId={}]", oldPeer.getTargetNodeId());
                    return oldPeer;
                } else {
                    if (selfNodeId > nodeId) {
                        newPeer.close();
                        connect(server, true);
                        log.info("新的连接NameNodeId比较小，关闭新的连接, 并主动往小id的节点发起连接: [nodeId={}]", newPeer.getTargetNodeId());
                        return null;
                    }
                }
            }
        }
        return null;
    }

    public PeerNameNode getPeerNameNode(Integer nodeId) {
        return peerNameNodeMap.get(nodeId);
    }

    public void handleNodeConnectFail(State state) {
        synchronized (this) {
            for (Integer key : peerNameNodeMap.keySet()) {
                PeerNameNode peerNameNode = peerNameNodeMap.get(key);
                if (!peerNameNode.isConnected()) {
                    failPeerNameNodeMap.put(key, peerNameNode);
                    peerNameNodeMap.remove(key);
                    peerNameNode.close();
                }
            }
            if (!failPeerNameNodeMap.isEmpty()) {
                log.info("存在断连node，开启重连");
                for (Integer key : failPeerNameNodeMap.keySet()) {
                    PeerNameNode peerNameNode = failPeerNameNodeMap.get(key);

                    int targetNodeId = peerNameNode.getTargetNodeId();

                    if (targetNodeId <= configuration.getNodeId()) {
                        log.info("nodeId 小于本 nodeId  不进行主动连接");
                        continue;
                    }

                    log.warn("断连node {}  本node {} 主动连接...", targetNodeId, configuration.getNodeId());


                    NetClient netClient = new NetClient("NameNode-PeerNode-" + targetNodeId, defaultScheduler);
                    netClient.addHandlers(Collections.singletonList(nameNodeApis));
                    String peerDataNode = peerNameNode.getServer();
                    String hostname = peerNameNode.getServer().split(":")[0];
                    int port = Integer.parseInt(peerNameNode.getServer().split(":")[1]);
                    PeerNameNode newPeer = new PeerNameNodeClient(netClient, configuration.getNodeId(), targetNodeId, peerDataNode);
                    peerNameNodeMap.put(targetNodeId, newPeer);
                    failPeerNameNodeMap.remove(key);

                    netClient.addConnectListener(connected -> {
                        if (connected) {
                            // 连接成功后进行服务间的发现
                            controllerManager.reportSelfInfoToPeer(newPeer, true);
                            log.info("重新连接成功，sourceNameNode：{} targetNameNode：{}", configuration.getNodeId(), targetNodeId);
                            PeerId peerId = parsePeerId(peerNameNode.getServer());
                            if (state == State.STATE_LEADER) {
                                replicatorGroup.addReplicator(peerId, newPeer, state);
                            }
                        }
                    });
                    netClient.connect(hostname, port);
                    log.info("重新建立PeerNameNode的链接：[hostname={}, port={}, nameNodeId={}]", hostname, port, targetNodeId);
                }
            }
        }
    }

    private PeerId parsePeerId(String peerStr) {
        String[] split = peerStr.split(":");
        return new PeerId(split[0], Integer.parseInt(split[1]), Integer.parseInt(split[2]));
    }
}
