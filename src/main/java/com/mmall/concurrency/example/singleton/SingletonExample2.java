package com.mmall.concurrency.example.singleton;

import com.mmall.concurrency.annotations.NotThreadSafe;
import com.mmall.concurrency.annotations.ThreadSafe;
import lombok.extern.slf4j.Slf4j;

/**
 * 饿汉模式
 * 单例实例在类装载时进行创建
 */
@Slf4j
@ThreadSafe
public class SingletonExample2 {
    // 私有的构造函数，保证不能其他地方创建对象
    private SingletonExample2(){}

    // 单例对象
    private static SingletonExample2 instance = new SingletonExample2();

    // 静态的工厂方法
    // 这事线程安全的，但是这种模式，构造函数不易过于复杂，会导致性能变慢。
    public static SingletonExample2 getInstance(){
        return instance;

    }

    public static void main(String[] args) {

    }
}
