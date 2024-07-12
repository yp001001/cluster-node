package com.cluster.node.config;

import com.cluster.node.node.PeerId;
import com.cluster.node.utils.Requires;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;

/**
 * @author: yp
 * @date: 2024/7/5 14:18
 * @description:
 */
public class Configuration {

    private static final Logger LOG = LoggerFactory.getLogger(Configuration.class);

    //该成员变量在该类的parse方法中被用到了，用来判断新添加进来的节点是否为一个学习者
    //学习者是raft协议中的一个角色，新添加到集群中的节点只需要从领导者那里同步数据即可，投票和决策都不参与
    private static final String LEARNER_POSTFIX = "/learner";
    //存放PeerId的集合
    private List<PeerId> peers = new ArrayList<>();

    //这些节点的信息都是用PeerID对象封装的，只不过用不同的集合把它们的身份区分开了
    private LinkedHashSet<PeerId> learners = new LinkedHashSet<>();

    // 服务端端口
    private Integer port;

    private String host;

    private Integer nodeId;

    // 通过namendoe.properties可以进行配置
    private Integer nameNodeApiCoreSize = 6;
    private Integer nameNodeApiMaximumPoolSize = 10;
    private Integer nameNodeApiQueueSize = 10000;
    private int electionTimeoutMs = 10000;
    private int dynamicTimeoutMs = 2000;

    //下面都是几个简单的构造方法
    public Configuration() {
        super();
    }


    public Configuration(final Iterable<PeerId> conf) {
        this(conf, null);
    }


    public Configuration(final Configuration conf) {
        this(conf.getPeers(), conf.getLearners());
    }

    public LinkedHashSet<PeerId> getLearners() {
        return this.learners;
    }

    public Configuration(final Iterable<PeerId> conf, final Iterable<PeerId> learners) {
        Requires.requireNonNull(conf, "conf");
        for (final PeerId peer : conf) {
            this.peers.add(peer.copy());
        }
        addLearners(learners);
    }

    public boolean addLearner(final PeerId learner) {
        return this.learners.add(learner);
    }

    public int addLearners(final Iterable<PeerId> learners) {
        int ret = 0;
        if (learners != null) {
            for (final PeerId peer : learners) {
                if (this.learners.add(peer.copy())) {
                    ret++;
                }
            }
        }
        return ret;
    }


    public Configuration copy() {
        return new Configuration(this.peers, this.learners);
    }


    //重制配置信息的方法
    public void reset() {
        this.peers.clear();
    }

    public List<PeerId> listPeers() {
        return new ArrayList<>(this.peers);
    }

    public List<PeerId> getPeers() {
        return this.peers;
    }

    public void setPeers(final List<PeerId> peers) {
        this.peers.clear();
        for (final PeerId peer : peers) {
            this.peers.add(peer.copy());
        }
    }

    public boolean addPeer(final PeerId peer) {
        return this.peers.add(peer);
    }

    public boolean isEmpty() {
        return this.peers.isEmpty();
    }

    public boolean contains(final PeerId peer) {
        return this.peers.contains(peer);
    }

    public Integer getPort() {
        return port;
    }

    public void setPort(Integer port) {
        this.port = port;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public void setNodeId(Integer nodeId) {
        this.nodeId = nodeId;
    }

    public String getHost() {
        return host;
    }

    public Integer getNodeId() {
        return nodeId;
    }

    public int getNameNodeApiCoreSize() {
        return this.nameNodeApiCoreSize;
    }

    public int getNameNodeApiMaximumPoolSize() {
        return this.nameNodeApiMaximumPoolSize;
    }

    public int getNameNodeApiQueueSize() {
        return this.nameNodeApiQueueSize;
    }

    public void setNameNodeApiCoreSize(Integer nameNodeApiCoreSize) {
        this.nameNodeApiCoreSize = nameNodeApiCoreSize;
    }

    public void setNameNodeApiMaximumPoolSize(Integer nameNodeApiMaximumPoolSize) {
        this.nameNodeApiMaximumPoolSize = nameNodeApiMaximumPoolSize;
    }

    public void setNameNodeApiQueueSize(Integer nameNodeApiQueueSize) {
        this.nameNodeApiQueueSize = nameNodeApiQueueSize;
    }

    public int getElectionTimeoutMs() {
        return this.electionTimeoutMs;
    }

    public int getDynamicTimeoutMs() {
        return this.dynamicTimeoutMs;
    }
}
