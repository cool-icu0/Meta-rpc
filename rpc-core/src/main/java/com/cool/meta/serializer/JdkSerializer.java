package com.cool.meta.serializer;

import java.io.*;

/**
 * JDK 序列化器
 */
public class JdkSerializer implements Serializer {

    /**
     * 序列化
     *
     * @param object 对象
     * @param <T>   泛型
     * @return 字节数组
     * @throws IOException 异常
     */
    @Override
    public <T> byte[] serialize(T object) throws IOException {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
        objectOutputStream.writeObject(object);
        objectOutputStream.close();
        return outputStream.toByteArray();
    }

    /**
     * 反序列化
     *
     * @param bytes 字节数组
     * @param type  类型
     * @param <T>   泛型
     * @return 对象
     * @throws IOException 异常
     */
    @Override
    public <T> T deserialize(byte[] bytes, Class<T> type) throws IOException {
        ByteArrayInputStream inputStream = new ByteArrayInputStream(bytes);
        ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
        try {
            return (T) objectInputStream.readObject();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } finally {
            objectInputStream.close();
        }
    }
}