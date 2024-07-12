package com.cluster.node.utils;

import io.netty.channel.Channel;
import io.netty.channel.socket.SocketChannel;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @author: yp
 * @date: 2024/7/8 11:28
 * @description:
 */
public class NetUtils {

    /**
     * 获取channel的id
     */
    public static String getChannelId(Channel channel) {
        SocketChannel socketChannel = (SocketChannel) channel;
        return socketChannel.id().asLongText().replaceAll("-", "");
    }

    private static String HOSTNAME;

    /**
     * 获取主机名
     *
     * @return 主机名
     */
    public static String getHostName() {
        if (HOSTNAME == null) {
            try {
                HOSTNAME = (InetAddress.getLocalHost()).getHostName();
            } catch (UnknownHostException uhe) {
                // host = "hostname: hostname"
                String host = uhe.getMessage();
                if (host != null) {
                    int colon = host.indexOf(':');
                    if (colon > 0) {
                        return host.substring(0, colon);
                    }
                }
                HOSTNAME = "UnknownHost";
            }
        }
        return HOSTNAME;
    }
}

