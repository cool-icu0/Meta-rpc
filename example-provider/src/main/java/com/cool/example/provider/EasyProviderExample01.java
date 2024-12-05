package com.cool.example.provider;

import com.cool.example.service.UserService;
import com.cool.meta.registry.LocalRegistry;
import com.cool.meta.server.HttpServer;
import com.cool.meta.server.VertxHttpServer;

/**
 * 简易服务提供者示例
 */
public class EasyProviderExample01 {

    public static void main(String[] args) {
        // 提供服务
         LocalRegistry.register(UserService.class.getName(), UserServiceImpl.class);
        // 启动 web 服务
        HttpServer httpServer = new VertxHttpServer();
        httpServer.doStart(8080);
    }
}