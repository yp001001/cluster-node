package com.cluster.node.replicator;

import com.cluster.node.config.Configuration;
import com.cluster.node.node.PeerId;
import com.cluster.node.node.State;
import com.cluster.node.peer.PeerNameNode;
import com.cluster.node.timer.Describer;
import com.cluster.node.timer.Scheduler;

/**
 * @author: yp
 * @date: 2024/7/9 16:26
 * @description:复制器组的接口
 */
public interface ReplicatorGroup extends Describer {

    boolean init(PeerId leaderId, Configuration configuration, long term, Scheduler scheduler);

    default boolean addReplicator(final PeerId peer, PeerNameNode peerNameNode, State state) {
        return addReplicator(peer, ReplicatorType.Follower, true, peerNameNode, state);
    }

    default boolean addReplicator(final PeerId peer, ReplicatorType replicatorType, PeerNameNode peerNameNode, State state) {
        return addReplicator(peer, replicatorType, true, peerNameNode, state);
    }

    ThreadId getReplicator(final PeerId peer);

    boolean addReplicator(final PeerId peer, ReplicatorType replicatorType, boolean sync, PeerNameNode peerNameNode, State state);

    void checkReplicator(final PeerId peer, final boolean lockNode);

    boolean resetTerm(final long newTerm);

    boolean contains(final PeerId peer);

    boolean stopReplicator(final PeerId peer);

    long getLastRpcSendTimestamp(final PeerId peer);

    void stopAllReplicator();
}
