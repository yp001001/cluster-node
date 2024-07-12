package com.cluster.node.node;

import com.cluster.node.utils.Copiable;
import com.cluster.node.utils.Utils;

import java.io.Serializable;

/**
 * @author: yp
 * @date: 2024/7/5 14:10
 * @description:
 */
//该类的对象会封装节点的IP地址和端口号信息
public class Endpoint implements Copiable<Endpoint>, Serializable {

    private static final long serialVersionUID = -7329681263115546100L;
    //初始化的ip地址
    private String ip = Utils.IP_ANY;
    //端口号
    private int port;
    //ip地址端口号的字符串形式
    private String str;

    public Endpoint() {
        super();
    }

    public Endpoint(String address, int port) {
        super();
        this.ip = address;
        this.port = port;
    }

    public String getIp() {
        return this.ip;
    }

    public int getPort() {
        return this.port;
    }

    @Override
    public String toString() {
        if (str == null) {
            str = this.ip + ":" + this.port;
        }
        return str;
    }

    @Override
    public Endpoint copy() {
        return new Endpoint(this.ip, this.port);
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (this.ip == null ? 0 : this.ip.hashCode());
        result = prime * result + this.port;
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
        final Endpoint other = (Endpoint) obj;
        if (this.ip == null) {
            if (other.ip != null) {
                return false;
            }
        } else if (!this.ip.equals(other.ip)) {
            return false;
        }
        return this.port == other.port;
    }
}
