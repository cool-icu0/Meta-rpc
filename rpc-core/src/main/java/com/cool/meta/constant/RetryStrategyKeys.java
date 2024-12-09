package com.cool.meta.constant;

/**
 * @Author Cool
 * @Date 2024/12/9 上午10:27
 * 重试策略键名常量
 */
public interface RetryStrategyKeys {

    /**
     * 不重试
     */
    String NO = "no";

    /**
     * 固定时间间隔
     */
    String FIXED_INTERVAL = "fixedInterval";

    /**
     * 指数退避
     */
    String EXPONENTIAL_BACKOFF = "exponentialBackoff";

}