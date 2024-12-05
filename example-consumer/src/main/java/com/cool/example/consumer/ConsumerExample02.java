package com.cool.example.consumer;

import com.cool.meta.config.RpcConfig;
import com.cool.meta.utils.ConfigUtils;

public class ConsumerExample02 {

    public static void main(String[] args) {
        RpcConfig rpc = ConfigUtils.loadConfig(RpcConfig.class, "rpc");
        System.out.println(rpc);
    }
}