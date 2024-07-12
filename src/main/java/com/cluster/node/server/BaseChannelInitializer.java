package com.cluster.node.server;

/**
 * @author: yp
 * @date: 2024/7/8 10:41
 * @description:
 */

import com.cluster.node.handler.AbstractChannelHandler;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.LengthFieldPrepender;

import java.util.LinkedList;
import java.util.List;

/**
 * 基础的消息处理器
 *
 * */
public class BaseChannelInitializer extends ChannelInitializer<SocketChannel> {

    public static final int MAX_BYTES = 10 * 1024 * 1024;

    private final List<AbstractChannelHandler> handlers = new LinkedList<>();

    /**
     * @param ch            the {@link Channel} which was registered.
     */
    @Override
    protected void initChannel(SocketChannel ch) {
        // 3个字节表示长度，最长支持16MB
        // OutboundHandler是按照Pipeline的加载顺序，逆序执行，所以LengthFieldPrepender需要在前面
        ch.pipeline().addLast(
                new NettyPacketDecoder(MAX_BYTES),
                new LengthFieldPrepender(3),
                new NettyPacketEncoder()
        );
        for (AbstractChannelHandler handler : handlers) {
            ch.pipeline().addLast(handler);
        }
    }


    /**
     * 添加自定义的handler
     */
    public void addHandler(AbstractChannelHandler handler) {
        this.handlers.add(handler);
    }

    /**
     * 添加自定义的handler
     *
     * @param handlers 处理器
     */
    public void addHandlers(List<AbstractChannelHandler> handlers) {
        if (null == handlers || handlers.size() == 0) {
            return;
        }
        this.handlers.addAll(handlers);
    }

}
