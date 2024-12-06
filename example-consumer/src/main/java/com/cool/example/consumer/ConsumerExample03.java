package com.cool.example.consumer;

import com.cool.example.model.User;
import com.cool.example.service.UserService;
import com.cool.meta.config.RpcConfig;
import com.cool.meta.proxy.ServiceProxyFactory;
import com.cool.meta.utils.ConfigUtils;

/**
 * 简易服务消费者示例
 */
public class ConsumerExample03 {

    public static void main(String[] args) {
        // 获取代理
        UserService userService = ServiceProxyFactory.getProxy(UserService.class);
        User user = new User();
        user.setName("cool");
        // 调用
        User newUser = userService.getUser(user);
        if (newUser != null) {
            System.out.println(newUser.getName());
        } else {
            System.out.println("user == null");
        }
    }
}