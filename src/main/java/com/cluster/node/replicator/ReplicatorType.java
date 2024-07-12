package com.cluster.node.replicator;

/**
 * @author: yp
 * @date: 2024/7/9 16:28
 * @description:当一个节点成为领导者后，其他节点信息都被封装成一个个复制器对象
 * 领导者向每一个跟随者同步数据的时候，都是通过每一个复制器对象来进行的
 */
public enum ReplicatorType {

    Follower, Learner;

    public final boolean isFollower() {
        return this == Follower;
    }

    public final boolean isLearner() {
        return this == Learner;
    }

}
