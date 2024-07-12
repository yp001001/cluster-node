package com.cluster.node.ballot;

import com.cluster.node.config.Configuration;
import com.cluster.node.node.PeerId;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: yp
 * @date: 2024/7/8 15:35
 * @description:投票箱 计算投票结果的类，做减法，得到集群中所有参与选举的节点
 * 然后计算做最少需要的票数，每得到一票就从需要得到的票数减一，就说明获取到足够的票了
 * 所需的票数必须是 n/2+1;
 */
public class Ballot {

    public static final class PosHint {
        // 这个成员变量表示节点在peers集合中的位置
        int pos0 = -1;
        // 如果一个节点是在旧配置中，那么就用下面这个成员变量代表其中在oldPeers中的位置
        int pos1 = -1;
    }


    public static class UnfoundPeerId {
        // 节点信息
        PeerId peerId;
        // 节点是否被找到，默认为false
        boolean found;
        // 节点索引
        int index;

        public UnfoundPeerId(PeerId peerId, int index, boolean found) {
            super();
            this.peerId = peerId;
            this.index = index;
            this.found = found;
        }
    }


    // 存放当前配置中的节点信息
    private final List<UnfoundPeerId> peers = new ArrayList<>();
    // 当前配置中需要收到的最小票数，才能成功当选领导者或者进入正式投票节点
    private int quorm;
    private int oldQuorm;
    // 存放旧配置中的节点信息
    private final List<UnfoundPeerId> oldPeers = new ArrayList<>();
    // 旧配置中需要收到的最小票数，才能成功当选领导者或进入到正式投票节点


    public boolean init(Configuration configuration) {
        this.peers.clear();
        this.oldPeers.clear();
        // 需要的最小票数也清零
        this.quorm = this.oldQuorm = 0;
        int index = 0;
        if (configuration != null) {
            for (PeerId peer : configuration.getPeers()) {
                this.peers.add(new UnfoundPeerId(peer, index++, false));
            }
        }
        // 计算当选票数
        this.quorm = this.peers.size() / 2 + 1;
        return true;
    }

    private UnfoundPeerId findPeer(final PeerId peerId, final List<UnfoundPeerId> peers, final int posHint) {
        // 判断是否已经更新
        if (posHint < 0 || posHint >= peers.size() || !peers.get(posHint).peerId.equals(peerId)) {
            for (UnfoundPeerId ufp : peers) {
                if (ufp.peerId.equals(peerId)) {
                    return ufp;
                }
            }
            return null;
        }
        return peers.get(posHint);
    }

    public PosHint grant(final PeerId peerId, final PosHint hint) {
        // 在peers集合中查找对应的节点
        UnfoundPeerId peer = findPeer(peerId, this.peers, hint.pos0);
        if (peer != null) {
            // 找到的话意味着方法参数中的那个peerId节点的投票是有效的
            if (!peer.found) {
                peer.found = true;
                this.quorm--;
            }
            hint.pos0 = peer.index;
        } else {
            hint.pos0 = -1;
        }

        return hint;
    }

    public void grant(final PeerId peerId) {
        grant(peerId, new PosHint());
    }

    public boolean isGranted() {
        return this.quorm <= 0;
    }


//    private Set<String> votePeerIdSet;
//    private volatile int quorum;
//
//    public Ballot() {
//        votePeerIdSet = new HashSet<>();
//    }
//
//    public void setQuorum(int quorum){
//        this.quorum = quorum;
//    }
//
//
//    public void grant(final String peerId) {
//        synchronized (this) {
//            if (!votePeerIdSet.contains(peerId)) {
//                quorum--;
//            }
//        }
//    }
//
//
//    public boolean isGranted() {
//        return this.quorum <= 0;
//    }

}
