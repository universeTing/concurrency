package com.mmall.concurrency.example.singleton;

import com.mmall.concurrency.annotations.ThreadSafe;
import lombok.extern.slf4j.Slf4j;

/**
 * 饿汉模式
 * 单例实例在类装载时进行创建
 */
@Slf4j
@ThreadSafe
public class SingletonExample6 {
    // 私有的构造函数，保证不能其他地方创建对象
    private SingletonExample6(){}

    // 单例对象
    private static SingletonExample6 instance = null;

    //通过静态代码块来进行初始化对象，静态域和静态代码块的顺序不能调换，否则值会被覆盖，导致结果错误。
    static {
        instance = new SingletonExample6();
    }

    // 静态的工厂方法
    // 这事线程安全的，但是这种模式，构造函数不易过于复杂，会导致性能变慢。
    public static SingletonExample6 getInstance(){
        return instance;

    }

    public static void main(String[] args) {
        System.out.println(getInstance());
        System.out.println(getInstance());

    }
}
