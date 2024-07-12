package com.cluster.node.parse;

import com.cluster.node.config.Configuration;
import com.cluster.node.node.PeerId;
import lombok.extern.slf4j.Slf4j;

import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/**
 * @author: yp
 * @date: 2024/7/8 15:45
 * @description:
 */
@Slf4j
public class ParseConfig {

    public static final void ParseConfig(Path path, Configuration configuration){

        try {
            try (InputStream inputStream = Files.newInputStream(path)) {
                Properties properties = new Properties();
                properties.load(inputStream);
                parseOption(properties, configuration);
            }
            log.info("NameNode启动配置文件 : {}", path.toAbsolutePath());
        } catch (Exception e) {
            log.error("无法加载配置文件 : ", e);
            System.exit(1);
        }
    }

    private static void parseOption(Properties properties, Configuration configuration){
        int port = Integer.parseInt((String) properties.get("namenode.port"));
        log.info("namenode解析，port：{}", port);
        configuration.setPort(port);

        String host = properties.getProperty("namenode.host");
        configuration.setHost(host);

        Integer namenodeId = Integer.parseInt((String) properties.get("namenode.nodeId"));
        configuration.setNodeId(namenodeId);

        String peers = properties.getProperty("namenode.peer.servers");
        String[] split = peers.split(",");

        List<PeerId> peerIdList = new ArrayList<>();

        for (String s : split) {
            String peerHost = s.split(":")[0];
            Integer peerPort = Integer.valueOf(s.split(":")[1]);
            Integer nodeId = Integer.valueOf(s.split(":")[2]);
            peerIdList.add(new PeerId(peerHost, peerPort, nodeId));
        }
        configuration.setPeers(peerIdList);
    }

}
