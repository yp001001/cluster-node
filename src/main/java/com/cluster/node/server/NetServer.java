package com.cluster.node.server;

import com.cluster.node.handler.AbstractChannelHandler;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.buffer.PooledByteBufAllocator;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.epoll.EpollServerSocketChannel;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.util.ResourceLeakDetector;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author: yp
 * @date: 2024/7/8 10:40
 * @description:网络服务端
 */
@Slf4j
public class NetServer {

    private String name;
    private DefaultScheduler defaultScheduler;
    private EventLoopGroup boss;
    private EventLoopGroup worker;
    private BaseChannelInitializer baseChannelInitializer;
    private boolean supportEpoll;

    public NetServer(String name, DefaultScheduler defaultScheduler) {
        this(name, defaultScheduler, Runtime.getRuntime().availableProcessors());
    }


    public NetServer(String name, DefaultScheduler defaultScheduler, int workerThreads) {
        this(name, defaultScheduler, workerThreads, false);
    }

    public NetServer(String name, DefaultScheduler defaultScheduler, int workerThreads, boolean supportEpoll) {
        this.name = name;
        this.defaultScheduler = defaultScheduler;
        this.boss = new NioEventLoopGroup(1, new NamedThreadFactory("NetServer-Boss-", false));
        this.worker = new NioEventLoopGroup(workerThreads, new NamedThreadFactory("NetServer-Worker-", false));
        this.supportEpoll = supportEpoll;
        this.baseChannelInitializer = new BaseChannelInitializer();
    }

    public void setChannelInitializer(BaseChannelInitializer baseChannelInitializer) {
        this.baseChannelInitializer = baseChannelInitializer;
    }

    /**
     * 添加自定义的handler
     */
    public void addHandlers(List<AbstractChannelHandler> handlers) {
        if (null == handlers || handlers.size() == 0) {
            return;
        }
        baseChannelInitializer.addHandlers(handlers);
    }


    /**
     * 绑定端口，同步等待关闭
     *
     * @throws InterruptedException interrupt异常
     */
    public void bind(int port) throws InterruptedException {
        bind(Collections.singletonList(port));
    }

    /**
     * 绑定端口，同步等待关闭
     *
     * @throws InterruptedException interrupt异常
     */
    public void bind(List<Integer> ports) throws InterruptedException {
        internalBind(ports);
    }


    /**
     * 异步绑定端口
     */
    public void bindAsync(int port) {
        defaultScheduler.scheduleOnce("绑定服务端口", () -> {
            try {
                internalBind(Collections.singletonList(port));
            } catch (InterruptedException e) {
                log.info("NetServer internalBind is Interrupted !!");
            }
        }, 0);
    }

    /**
     * 绑定端口
     *
     * @param ports 端口
     * @throws InterruptedException 异常
     */
    private void internalBind(List<Integer> ports) throws InterruptedException {
        try {
            ServerBootstrap bootstrap = new ServerBootstrap();
            bootstrap.group(boss, worker)
                    .channel(supportEpoll ? EpollServerSocketChannel.class : NioServerSocketChannel.class)
                    .option(ChannelOption.ALLOCATOR, PooledByteBufAllocator.DEFAULT)
                    .childOption(ChannelOption.ALLOCATOR, PooledByteBufAllocator.DEFAULT)
                    .childHandler(baseChannelInitializer); // 在服务端设置的客户端的handler
            ResourceLeakDetector.setLevel(ResourceLeakDetector.Level.ADVANCED);
            List<ChannelFuture> channelFeture = new ArrayList<>();
            for (int port : ports) {
                ChannelFuture future = bootstrap.bind(port).sync();
                log.info("Netty Server started on port ：{}", port);
                channelFeture.add(future);
            }
            for (ChannelFuture future : channelFeture) {
                future.channel().closeFuture().addListener((ChannelFutureListener) future1 -> future1.channel().close());
            }
            for (ChannelFuture future : channelFeture) {
                future.channel().closeFuture().sync();
            }
        } finally {
            boss.shutdownGracefully();
            worker.shutdownGracefully();
        }
    }

    /**
     * 停止
     */
    public void shutdown() {
        log.info("Shutdown NetServer : [name={}]", name);
        if (boss != null && worker != null) {
            boss.shutdownGracefully();
            worker.shutdownGracefully();
        }
    }


}
