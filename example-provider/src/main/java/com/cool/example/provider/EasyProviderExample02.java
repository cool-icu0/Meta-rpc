package com.cool.example.provider;

import com.cool.example.service.UserService;
import com.cool.meta.RpcApplication;
import com.cool.meta.registry.LocalRegistry;
import com.cool.meta.server.HttpServer;
import com.cool.meta.server.VertxHttpServer;

/**
 * 简易服务提供者示例
 * 默认为 8080 端口，如果rpc-core 配置文件中配置了端口，将使用配置文件中的端口
 */
public class EasyProviderExample02 {

    public static void main(String[] args) {
        // RPC 框架初始化
        RpcApplication.init();
        
        // 注册服务
        LocalRegistry.register(UserService.class.getName(), UserServiceImpl.class);

        // 启动 web 服务
        HttpServer httpServer = new VertxHttpServer();
        httpServer.doStart(RpcApplication.getRpcConfig().getServerPort());
    }
}