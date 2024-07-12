package com.cluster.node.handler;

import com.cluster.node.constant.Constants;
import com.cluster.node.listener.ConnectListener;
import com.cluster.node.listener.NettyPacketListener;
import com.cluster.node.model.NettyPacket;
import com.cluster.node.server.DefaultScheduler;
import com.cluster.node.utils.NetUtils;
import com.cluster.node.wrapper.RequestWrapper;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.socket.SocketChannel;
import lombok.extern.slf4j.Slf4j;

import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @author: yp
 * @date: 2024/7/8 11:24
 * @description:默认消息处理器
 */
@Slf4j
public class DefaultChannelHandler extends AbstractChannelHandler {

    private String name;
    private volatile SocketChannel socketChannel;
    private volatile boolean hasOtherHandlers = false;
    private List<NettyPacketListener> nettyPacketListeners = new CopyOnWriteArrayList<>();
    private List<ConnectListener> connectListeners = new CopyOnWriteArrayList<>();

    public DefaultChannelHandler(String name, DefaultScheduler defaultScheduler, long requestTimeout) {
        this.name = name;
    }


    @Override
    protected boolean handlePackage(ChannelHandlerContext ctx, NettyPacket nettyPacket) throws Exception {
        synchronized (this){
            RequestWrapper requestWrapper = new RequestWrapper(ctx, nettyPacket);
            invokeListeners(requestWrapper);
            return !hasOtherHandlers;
        }
    }

    @Override
    protected Set<Integer> interestPackageTypes() {
        return Collections.emptySet();
    }


    /**
     * 是否建立了连接
     *
     * @return 是否连接
     */
    public boolean isConnected() {
        return socketChannel != null && socketChannel.isActive();
    }

    /**
     * 获取SocketChannel
     *
     * @return SocketChannel
     */
    public SocketChannel socketChannel() {
        return socketChannel;
    }

    /**
     * 发送消息，不需要同步获取响应
     * <p>
     * 可以通过 {@link #addNettyPackageListener(NettyPacketListener)} 方法获取返回的数据包
     *
     * @param nettyPacket 网络包
     * @throws IllegalStateException 网络异常
     */
    public void send(NettyPacket nettyPacket) throws InterruptedException {
        setSequence(nettyPacket);
        socketChannel.writeAndFlush(nettyPacket);
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) {
        socketChannel = (SocketChannel) ctx.channel();
        invokeConnectListener(true);
        log.debug("Socket channel is connected. {}", NetUtils.getChannelId(ctx.channel()));
        ctx.fireChannelActive();
    }

    /**
     * 回调连接监听器
     *
     * @param isConnected 是否连接上
     */
    private void invokeConnectListener(boolean isConnected) {
        for (ConnectListener listener : connectListeners) {
            try {
                listener.onConnectStatusChanged(isConnected);
            } catch (Exception e) {
                log.error("Exception occur on invoke listener :", e);
            }
        }
    }


    /**
     * 添加消息监听器
     *
     * @param listener 监听器
     */
    public void addNettyPackageListener(NettyPacketListener listener) {
        nettyPacketListeners.add(listener);
    }


    public void addConnectListener(ConnectListener listener) {
        connectListeners.add(listener);
    }

    public void clearConnectListener() {
        connectListeners.clear();
    }

    public void clearNettyPackageListener() {
        nettyPacketListeners.clear();
    }

    private void setSequence(NettyPacket nettyPacket) {
        if (socketChannel == null) {
            throw new IllegalStateException("Socket channel is disconnect.");
        }
        nettyPacket.setSequence(name + "-" + Constants.REQUEST_COUNTER.getAndIncrement());
    }

    /**
     * 回调消息监听器
     *
     * @param requestWrapper 网络包
     */
    private void invokeListeners(RequestWrapper requestWrapper) {
        for (NettyPacketListener listener : nettyPacketListeners) {
            try {
                listener.onMessage(requestWrapper);
            } catch (Exception e) {
                log.error("Exception occur on invoke listener :", e);
            }
        }
    }

    public void setHasOtherHandlers(boolean isHasOtherHandlers) {
        this.hasOtherHandlers = isHasOtherHandlers;
    }
}
