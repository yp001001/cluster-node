package com.cluster.node.server;

import com.cluster.node.config.Configuration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Collections;

/**
 * @author: yp
 * @date: 2024/7/5 14:37
 * @description:对外提供服务接口
 */
public class NameNodeServer {

    private static final Logger log = LoggerFactory.getLogger(NameNodeServer.class);

    private NameNodeApis nameNodeApis;
    private NetServer netServer;
    private Configuration configuration;

    public NameNodeServer(DefaultScheduler defaultScheduler, NameNodeApis nameNodeApis){
        this.nameNodeApis = nameNodeApis;
        this.netServer = new NetServer("NameNode-Server", defaultScheduler);
    }

    /**
     * 启动一个Socket Server，监听指定的端口号
     * @throws InterruptedException
     */
    public void start() throws InterruptedException{
        this.netServer.addHandlers(Collections.singletonList(nameNodeApis));
        netServer.bind(configuration.getPort());
    }

    public void setConfiguration(Configuration configuration) {
        this.configuration = configuration;
    }

    /**
     * 停止服务
     */
    public void shutdown() {
        log.info("Shutdown NameNodeServer.");
        netServer.shutdown();
    }

}
