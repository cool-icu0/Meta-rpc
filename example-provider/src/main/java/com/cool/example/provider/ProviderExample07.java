package com.cool.example.provider;


import com.cool.example.service.UserService;
import com.cool.meta.RpcApplication;
import com.cool.meta.config.RegistryConfig;
import com.cool.meta.config.RpcConfig;
import com.cool.meta.model.ServiceMetaInfo;
import com.cool.meta.registry.LocalRegistry;
import com.cool.meta.registry.RegistryFactory;
import com.cool.meta.registry.service.Registry;
import com.cool.meta.server.tcp.VertxTcpServer;

/**
 * 服务提供者示例
 */
public class ProviderExample07 {

    public static void main(String[] args) {
        // RPC 框架初始化
        RpcApplication.init();

        // 注册服务
        String serviceName = UserService.class.getName();
        LocalRegistry.register(serviceName, UserServiceImpl.class);

        // 注册服务到注册中心
        RpcConfig rpcConfig = RpcApplication.getRpcConfig();
        RegistryConfig registryConfig = rpcConfig.getRegistryConfig();
        Registry registry = RegistryFactory.getInstance(registryConfig.getRegistry());
        ServiceMetaInfo serviceMetaInfo = new ServiceMetaInfo();
        serviceMetaInfo.setServiceName(serviceName);
        serviceMetaInfo.setServiceHost(rpcConfig.getServerHost());
        serviceMetaInfo.setServicePort(rpcConfig.getServerPort());
        try {
            registry.register(serviceMetaInfo);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        // 启动 TCP 服务
        VertxTcpServer vertxTcpServer = new VertxTcpServer();
        vertxTcpServer.doStart(8080);
    }
}