package com.cluster.node.wrapper;

import com.cluster.node.constant.Constants;
import com.cluster.node.model.NettyPacket;
import com.dfs.common.enums.PacketType;
import com.google.protobuf.MessageLite;
import io.netty.channel.ChannelHandlerContext;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

/**
 * @author: yp
 * @date: 2024/7/8 11:31
 * @description:网络请求
 */
@Slf4j
public class RequestWrapper {

    private OnResponseListener listener;
    private ChannelHandlerContext ctx;
    private NettyPacket request;
    private String requestSequence;
    private int nodeId;

    public RequestWrapper(ChannelHandlerContext ctx, NettyPacket request) {
        this(ctx, request, -1, null);
    }


    public RequestWrapper(ChannelHandlerContext ctx, NettyPacket request, int nodeId, OnResponseListener listener) {
        this.ctx = ctx;
        this.request = request;
        this.requestSequence = request.getSequence();
        this.nodeId = nodeId;
        this.listener = listener;
    }

    public String getRequestSequence() {
        return requestSequence;
    }

    public ChannelHandlerContext getCtx() {
        return ctx;
    }

    public NettyPacket getRequest() {
        return request;
    }


    /**
     * 发送响应
     */
    public void sendResponse() {
        sendResponse(null);
    }


    /**
     * 发送响应
     *
     * @param response 响应
     */
    public void sendResponseNull(MessageLite response) {
        byte[] body = response == null ? new byte[0] : response.toByteArray();
        NettyPacket nettyResponse = NettyPacket.buildPacket(body, PacketType.getEnum(request.getPacketType()));
        List<NettyPacket> responses = nettyResponse.partitionChunk(request.isSupportChunked(), Constants.CHUNKED_SIZE);
        if (responses.size() > 1) {
            log.info("返回响应通过chunked方式，共拆分为{}个包", responses.size());
        }
        for (NettyPacket res : responses) {
            sendResponse(res, requestSequence);
        }
    }


    public void sendResponse(NettyPacket response){
        long l = Constants.REQUEST_COUNTER.incrementAndGet();
        response.setSequence(String.valueOf(l));
        ctx.writeAndFlush(response);
        if(listener != null){
            listener.onResponse(response.getBody().length);
        }
    }


    public void sendResponse(NettyPacket response, String sequence) {
        response.setSequence(sequence);
        response.setNodeId(nodeId);
        ctx.writeAndFlush(response);
        if (listener != null) {
            listener.onResponse(response.getBody().length);
        }
    }

    public interface OnResponseListener {
        void onResponse(int bodyLength);
    }

}
