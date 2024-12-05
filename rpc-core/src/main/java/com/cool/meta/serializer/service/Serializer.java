package com.cool.meta.serializer.service;


import java.io.IOException;

/**
 * 序列化器接口
 */
public interface Serializer {

    /**
     * 序列化
     *
     * @param object  待序列化对象
     * @param <T>  泛型
     * @return 字节数组
     * @throws IOException 异常
     */
    <T> byte[] serialize(T object) throws IOException;

    /**
     * 反序列化
     *
     * @param bytes  字节数组
     * @param type  类型
     * @param <T>  泛型
     * @return 对象
     * @throws IOException 异常
     */
    <T> T deserialize(byte[] bytes, Class<T> type) throws IOException;
}