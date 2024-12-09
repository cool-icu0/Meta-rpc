package com.cool.meta.fault.retry;

import com.cool.meta.fault.retry.impl.FixedIntervalRetryStrategy;
import com.cool.meta.fault.retry.impl.NoRetryStrategy;
import com.cool.meta.model.RpcResponse;
import org.junit.Test;

/**
 * @Author Cool
 * @Date 2024/12/9 上午10:24
 * 重试策略测试
 */
public class RetryStrategyTest {

    RetryStrategy retryStrategy = new FixedIntervalRetryStrategy();

    @Test
    public void doRetry() {
        try {
            RpcResponse rpcResponse = retryStrategy.doRetry(() -> {
                System.out.println("测试重试");
                throw new RuntimeException("模拟重试失败");
            });
            System.out.println(rpcResponse);
        } catch (Exception e) {
            System.out.println("重试多次失败");
            e.printStackTrace();
        }
    }
}