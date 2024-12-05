package com.cool.example.consumer;

import com.cool.example.model.User;
import com.cool.example.service.UserService;
import com.cool.meta.proxy.ServiceProxyFactory;

/**
 * 简易服务消费者示例
 */
public class EasyConsumerExample01 {

    public static void main(String[] args) {
        // 需要获取 UserService 的实现类对象
        // 静态代理实现  UserService userService = new UserServiceProxy();
        // 动态代理实现
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
