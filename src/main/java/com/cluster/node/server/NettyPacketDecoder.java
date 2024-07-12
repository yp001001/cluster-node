package com.cluster.node.server;

import com.cluster.node.model.NettyPacket;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.LengthFieldBasedFrameDecoder;
import io.netty.util.ReferenceCountUtil;

/**
 * @author: yp
 * @date: 2024/7/8 10:42
 * @description:网络包解码器
 */
public class NettyPacketDecoder extends LengthFieldBasedFrameDecoder {


    public NettyPacketDecoder(int maxFrameLength) {
        // 最大帧长度，长度字段偏移量，长度字段长度，长度调整量，跳过的初始字节数
        super(maxFrameLength, 0,
                3, 0, 3);
    }

    @Override
    protected Object decode(ChannelHandlerContext ctx, ByteBuf buffer) throws Exception {
        ByteBuf byteBuf = (ByteBuf) super.decode(ctx, buffer);
        if (byteBuf != null) {
            try {
                return NettyPacket.parsePacket(byteBuf);
            } finally {
                ReferenceCountUtil.release(byteBuf);
            }
        }
        return null;
    }
}
