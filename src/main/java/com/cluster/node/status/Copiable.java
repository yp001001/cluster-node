package com.cluster.node.status;

/**
 * @author: yp
 * @date: 2024/7/8 16:50
 * @description:提供了深拷贝方法的接口
 */
public interface Copiable<T> {

    T copy();
}
