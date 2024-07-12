package com.cluster.node.utils;

import java.util.Collection;

/**
 * @author: yp
 * @date: 2024/7/8 11:39
 * @description:
 */
public class CollectionUtils {

    public static boolean isEmpty(Collection collection){
        return null == collection || collection.isEmpty();
    }

}
