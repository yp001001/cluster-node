package com.cluster.node.error;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: yp
 * @date: 2024/7/8 16:49
 * @description:状态码枚举类
 */
public enum RaftError {

    //未知错误
    UNKNOWN(-1),

    //成功
    SUCCESS(0),

    //任务超时
    ERAFTTIMEDOUT(10001),

    //状态机异常
    ESTATEMACHINE(10002),

    //追赶数据失败
    ECATCHUP(10003),

    //当前节点身份降级
    ELEADERREMOVED(10004),


    ESETPEER(10005),


    ENODESHUTDOWN(10006),

    //发来请求消息的节点的任期高于当前节点
    EHIGHERTERMREQUEST(10007),

    //发送响应的节点的任期比当前节点高
    EHIGHERTERMRESPONSE(10008),


    EBADNODE(10009),

    //为候选者投票
    EVOTEFORCANDIDATE(10010),

    //收到新的领导者消息
    ENEWLEADER(10011),


    ELEADERCONFLICT(10012),

    ETRANSFERLEADERSHIP(10013),


    ELOGDELETED(10014),


    ENOMOREUSERLOG(10015),


    EREQUEST(1000),


    ESTOP(1001),


    EAGAIN(1002),


    EINTR(1003),


    EINTERNAL(1004),


    ECANCELED(1005),


    EHOSTDOWN(1006),


    ESHUTDOWN(1007),


    EPERM(1008),


    EBUSY(1009),


    ETIMEDOUT(1010),


    ESTALE(1011),


    ENOENT(1012),


    EEXISTS(1013),


    EIO(1014),


    EINVAL(1015),


    EACCES(1016);

    private static final Map<Integer, RaftError> RAFT_ERROR_MAP = new HashMap<>();

    static {
        for (final RaftError error : RaftError.values()) {
            RAFT_ERROR_MAP.put(error.getNumber(), error);
        }
    }

    public final int getNumber() {
        return this.value;
    }

    public static RaftError forNumber(final int value) {
        return RAFT_ERROR_MAP.getOrDefault(value, UNKNOWN);
    }

    public static String describeCode(final int code) {
        RaftError e = forNumber(code);
        return e != null ? e.name() : "<Unknown:" + code + ">";
    }

    private final int value;

    RaftError(final int value) {
        this.value = value;
    }
}
