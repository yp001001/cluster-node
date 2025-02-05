package com.cluster.node.server;

import com.cluster.node.model.NettyPacket;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;
import lombok.extern.slf4j.Slf4j;

/**
 * @author: yp
 * @date: 2024/7/8 10:42
 * @description:网络编码器
 */
@Slf4j
public class NettyPacketEncoder extends MessageToByteEncoder<NettyPacket> {

    @Override
    protected void encode(ChannelHandlerContext ctx, NettyPacket msg, ByteBuf out) throws Exception {
        msg.write(out);
    }
}
