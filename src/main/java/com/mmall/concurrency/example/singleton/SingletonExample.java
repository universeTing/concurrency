package com.mmall.concurrency.example.singleton;

import com.mmall.concurrency.annotations.NotThreadSafe;
import lombok.extern.slf4j.Slf4j;

/**
 * 懒汉模式
 * 单例实例在第一次使用时进行创建
 */
@Slf4j
@NotThreadSafe
public class SingletonExample {
    // 私有的构造函数，保证不能其他地方创建对象
    private SingletonExample(){}

    // 单例对象
    private static SingletonExample instance = null;

    // 静态的工厂方法
    // 该方法在单线程下没问题
    // 在多线程下，在21行会出问题，原因时某时刻有多个线程同时执行时，会去创建两次对象，
    // 导致状态不一样，两个线程拿到的实例是不一样的。在实际开发应用中，构造函数一般会做很多其他的操作，所以有可能会导致结果不正确。
    public static SingletonExample getInstance(){
        if(instance == null){
            instance = new SingletonExample();
        }
        return instance;

    }

    public static void main(String[] args) {

    }
}
