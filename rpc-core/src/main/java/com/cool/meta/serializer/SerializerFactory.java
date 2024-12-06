package com.cool.meta.serializer;

import com.cool.meta.serializer.service.Serializer;
import com.cool.meta.serializer.service.impl.JdkSerializer;
import com.cool.meta.spi.SpiLoader;

import java.util.HashMap;
import java.util.Map;

/**
 * 序列化器工厂（用于获取序列化器对象）
 */
public class SerializerFactory {

    static {
        SpiLoader.load(Serializer.class);
    }

    /**
     * 默认序列化器
     */
    private static final Serializer DEFAULT_SERIALIZER = new JdkSerializer();


    private static volatile Map<String, Serializer> serializerMap;

    /**
     * 获取实例(双检锁)
     *
     * @param key
     * @return
     */
    public static Serializer getInstance(String key) {
        return SpiLoader.getInstance(Serializer.class, key);
    }

}