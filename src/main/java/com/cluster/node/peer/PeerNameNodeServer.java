package com.cluster.node.peer;

import com.cluster.node.constant.Constants;
import com.cluster.node.model.NettyPacket;
import com.cluster.node.server.DefaultScheduler;
import io.netty.channel.socket.SocketChannel;
import lombok.extern.slf4j.Slf4j;


/**
 * @author: yp
 * @date: 2024/7/8 11:18
 * @description: 表示和PeerDataNode的连接，当前NameNode作为服务端
 */
@Slf4j
public class PeerNameNodeServer extends AbstractPeerNameNode {

    private final String name;
    private volatile SocketChannel socketChannel;

    public PeerNameNodeServer(SocketChannel socketChannel, int currentNodeId, int targetNodeId,
                              String server, DefaultScheduler defaultScheduler) {
        super(currentNodeId, targetNodeId, server);
        this.name = "NameNode-PeerNode-" + currentNodeId + "-" + targetNodeId;
        this.setSocketChannel(socketChannel);
    }

    public void setSocketChannel(SocketChannel socketChannel) {
        this.socketChannel = socketChannel;
    }

    @Override
    public void send(NettyPacket nettyPacket) throws InterruptedException {
        synchronized (this){
            while(!isConnected()){
                try{
                    wait(10);
                }catch (InterruptedException e){
                    log.error("PeerDataNodeServer#send has Interrupted !!");
                }
            }
        }
        nettyPacket.setSequence(name + "-" + Constants.REQUEST_COUNTER.getAndIncrement());
        socketChannel.writeAndFlush(nettyPacket);
    }

    @Override
    public boolean isConnected() {
        return socketChannel != null && socketChannel.isActive();
    }

    @Override
    public void close() {
        socketChannel.close();
    }
}
