package com.cluster.node.node;

/**
 * @author: yp
 * @date: 2024/7/5 14:28
 * @description:
 */
public enum State {

    //当前节点为领导者
    STATE_LEADER,
    //当前状态表示正在移交领导权
    STATE_TRANSFERRING,
    //候选者
    STATE_CANDIDATE,
    //跟随者
    STATE_FOLLOWER,
    //当前状态表示节点出现了错误
    STATE_ERROR,
    //表示节点还未初始化
    STATE_UNINITIALIZED,
    //表示节点正在停止工作
    STATE_SHUTTING,
    //已经停止工作
    STATE_SHUTDOWN,
    //代表状态转换已经结束了吧，这个枚举对象在源码中没有被用到
    STATE_END;

    //该方法判断当前节点是否处于活跃状态
    public boolean isActive() {
        //原理很简单，就是判断当前状态的枚举对象是否小于STATE_ERROR的值
        //ordinal方法用于返回一个int，排在前面的枚举对象的这个int值小于排在后面的
        //只要是小于STATE_ERROR，就意味着当前节点还在正常工作，大于STATE_ERROR，当前节点不是出错，就是要关闭了
        return this.ordinal() < STATE_ERROR.ordinal();
    }

}
