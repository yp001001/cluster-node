package com.cluster.node.node;

import java.io.Serializable;

/**
 * @author: yp
 * @date: 2024/7/5 14:35
 * @description:
 */
public final class NodeId implements Serializable {

    private static final long serialVersionUID = 4428173460056804264L;

    //当前节点所在集群的id，是个字符串，其实就是我在main函数参数中配置的那个counter
    private final String groupId;
    //当前节点的PeerId
    private final PeerId peerId;
    //缓存当前对象的toString的结果
    private String str;

    public NodeId(String groupId, PeerId peerId) {
        super();
        this.groupId = groupId;
        this.peerId = peerId;
    }

    public String getGroupId() {
        return this.groupId;
    }

    @Override
    public String toString() {
        if (str == null) {
            str = "<" + this.groupId + "/" + this.peerId + ">";
        }
        return str;
    }

    public PeerId getPeerId() {
        return this.peerId;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (this.groupId == null ? 0 : this.groupId.hashCode());
        result = prime * result + (this.peerId == null ? 0 : this.peerId.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final NodeId other = (NodeId) obj;
        if (this.groupId == null) {
            if (other.groupId != null) {
                return false;
            }
        } else if (!this.groupId.equals(other.groupId)) {
            return false;
        }
        if (this.peerId == null) {
            return other.peerId == null;
        } else {
            return this.peerId.equals(other.peerId);
        }
    }
}

