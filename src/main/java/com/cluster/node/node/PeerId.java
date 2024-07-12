package com.cluster.node.node;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Serializable;
import java.util.Objects;

import static com.cluster.node.utils.Utils.IP_ANY;

/**
 * @author: yp
 * @date: 2024/7/5 14:08
 * @description:集群节点信息类
 */
public class PeerId implements Serializable {

    private String host;
    private Integer port;
    private Integer nodeId;

    public PeerId() {
    }

    public PeerId(String host, Integer port, Integer nodeId) {
        this.host = host;
        this.port = port;
        this.nodeId = nodeId;
    }

    public void setNodeId(Integer nodeId) {
        this.nodeId = nodeId;
    }

    public Integer getNodeId() {
        return nodeId;
    }

    public Integer getPort() {
        return port;
    }

    public void setPort(Integer port) {
        this.port = port;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    //    private static final long serialVersionUID = 8083529734784884641L;
//
//    private static final Logger LOG = LoggerFactory.getLogger(PeerId.class);
//
//    //当前节点的IP地址和端口号就封装在这个成员变量对象中
//    private Endpoint endpoint = new Endpoint(IP_ANY, 0);
//    //该类对象的toString结果的缓存
//    private String str;
//    //节点初始化的时候，默认选举优先级功能是禁止的
//    private int priority = ElectionPriority.Disabled;
//
//    //这个成员变量起到一个标识符的作用，具体使用的时候我会为大家讲解的
//    public static final PeerId ANY_PEER = new PeerId();
//
//    //这个是在同样的IP地址下，用来区分集群中不同节点的
//    //比如在某个特定环境下，三个节点使用的IP地址是相同的，这时候就可以通过这个idx来区分这三个节点了
//    //比如IP地址和端口号都是localhost:8080
//    //idx分别为1，2，3这样就区分开了
//    //在我们的课程中不会讨论这种情况，实际上，我们应该不会这样来部署自己的程序
//    private int idx;
//
//    public PeerId() {
//        super();
//    }

    //创建一个空节点对象
    public static PeerId emptyPeer() {
        return new PeerId();
    }

    //深拷贝方法
    public PeerId copy() {
        return new PeerId(this.host, port, nodeId);
    }

    public boolean isEmpty() {
        return host == null && port == null && nodeId == null;
    }

//
//    //下面都是一些构造方法
//    public PeerId(final Endpoint endpoint, final int idx) {
//        super();
//        this.endpoint = endpoint;
//        this.idx = idx;
//    }
//
//    public PeerId(final String ip, final int port) {
//        this(ip, port, 0);
//    }
//
//    public PeerId(final String ip, final int port, final int idx) {
//        super();
//        this.endpoint = new Endpoint(ip, port);
//        this.idx = idx;
//    }
//
//    public PeerId(final Endpoint endpoint, final int idx, final int priority) {
//        super();
//        this.endpoint = endpoint;
//        this.idx = idx;
//        this.priority = priority;
//    }
//
//    public PeerId(final String ip, final int port, final int idx, final int priority) {
//        super();
//        this.endpoint = new Endpoint(ip, port);
//        this.idx = idx;
//        this.priority = priority;
//    }


    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        PeerId peerId = (PeerId) object;
        return Objects.equals(host, peerId.host) && Objects.equals(port, peerId.port) && Objects.equals(nodeId, peerId.nodeId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(host, port, nodeId);
    }

    @Override
    public String toString() {
        return host + ":" + port + ":" + nodeId;
    }
}
