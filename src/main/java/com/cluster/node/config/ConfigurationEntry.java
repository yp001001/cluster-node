package com.cluster.node.config;

import com.cluster.node.node.PeerId;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashSet;
import java.util.Set;

/**
 * @author: yp
 * @date: 2024/7/5 14:22
 * @description:封装当前配置信息，分为新配置与旧配置
 */
public class ConfigurationEntry {

    private static final Logger LOG = LoggerFactory.getLogger(ConfigurationEntry.class);

    //当前生效的配置
    private Configuration conf = new Configuration();
    //旧的配置
    private Configuration oldConf = new Configuration();

    //构造方法
    public ConfigurationEntry() {
        super();
    }

    public Configuration getConf() {
        return this.conf;
    }


    public void setConf(final Configuration conf) {
        this.conf = conf;
    }


    public Configuration getOldConf() {
        return this.oldConf;
    }


    public void setOldConf(final Configuration oldConf) {
        this.oldConf = oldConf;
    }


    //判断旧的配置是否为空，如果旧配置为空，说明当前集群的配置没有进行过变更，也就代表当前集群是很稳定的
    public boolean isStable() {
        return this.oldConf.isEmpty();
    }

    //判断当前配置是否为空
    public boolean isEmpty() {
        return this.conf.isEmpty();
    }

    //把当前配置和就配置中的所有PeerId以集合的形式返回
    public Set<PeerId> listPeers() {
        final Set<PeerId> ret = new HashSet<>(this.conf.listPeers());
        ret.addAll(this.oldConf.listPeers());
        return ret;
    }


    //判断某个PeerId是否存在于当前配置或旧配置中
    public boolean contains(final PeerId peer) {
        return this.conf.contains(peer) || this.oldConf.contains(peer);
    }
}
