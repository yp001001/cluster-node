package com.dfs.common.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author: yp
 * @date: 2024/7/8 10:38
 * @description:
 */
@Getter
@AllArgsConstructor
public enum PacketType {

    /**
     * 请求类型
     */
    UNKNOWN(0, "未知的包类型"),
    NAME_NODE_CONTROLLER_PREV_VOTE_REQUEST(1, "NameNode预投票选举的票据"),
    // NAME_NODE_CONTROLLER_VOTE(2, "NameNode投票选举的票据"),
    NAME_NODE_PEER_AWARE(3, "NameNode相互之间发起连接时的感知请求"),
    NAME_NODE_CONTROLLER_PREV_VOTE_RESPONSE(4, "NameNode预投票选举的票据响应"),
    NAME_NODE_FORMAL_VOTE_RESPONSE(5, "正式投票选举响应"),
    NAME_NODE_FORMAL_VOTE_REQUEST(6,"正式投票选举请求"),
    NAME_NODE_MSATER_REQUEST(7, "master请求"),
    LEADER_HEARTBEAT(8, "Leader心跳")
    ;

    public int value;
    private String description;

    public static PacketType getEnum(int value) {
        for (PacketType packetType : values()) {
            if (packetType.getValue() == value) {
                return packetType;
            }
        }
        return UNKNOWN;
    }
}
