package com.cool.meta.fault.retry.impl;

import com.cool.meta.fault.retry.RetryStrategy;
import com.cool.meta.model.RpcResponse;
import com.google.common.util.concurrent.Uninterruptibles;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/**
 * 指数退避 - 重试策略
 */
@Slf4j
public class ExponentialBackoffRetryStrategy implements RetryStrategy {

    /**
     * 重试
     *
     * @param callable
     * @return
     * @throws ExecutionException
     * @throws InterruptedException
     */
    public RpcResponse doRetry(Callable<RpcResponse> callable) throws Exception {
        int retries = 0;
        while (true) {
            try {
                return callable.call();
            } catch (Exception e) {
                retries++;
                if (retries > 3) { // 设置最大重试次数为3次
                    throw e;
                }
                // 指数退避算法：等待时间为当前重试次数的2的幂次方乘以初始等待时间
                long waitTime = (long) (Math.pow(2, retries - 1) * 100);
                Uninterruptibles.sleepUninterruptibly(waitTime, TimeUnit.MILLISECONDS);
                log.info("Retrying... attempt: {}, waitTime: {} ms", retries, waitTime);
            }
        }
    }
}