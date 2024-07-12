package com.cluster.node.timer;

/**
 * @author: yp
 * @date: 2024/7/8 15:54
 * @description: 要提交到时间轮中的定时任务接口
 */
public interface TimerTask {

    void run(final Timeout timeout) throws Exception;

}
