package com.mmall.concurrency.example.singleton;

import com.mmall.concurrency.annotations.NotThreadSafe;
import com.mmall.concurrency.annotations.ThreadSafe;
import lombok.extern.slf4j.Slf4j;

/**
 * 懒汉模式
 * 单例实例在第一次使用时进行创建
 */
@Slf4j
@ThreadSafe
public class SingletonExample5 {
    // 私有的构造函数，保证不能其他地方创建对象
    private SingletonExample5(){}

    // 单例对象 volatile + 双重检测机制 -->限制指令重排，保证线程安全
    private volatile static SingletonExample5 instance = null;

    // 线程不安全的原因是：38行执行实例化一个对象的时候，需要有三个步骤
    // 1、memory = allocate() 分配对象内存空间
    // 2、ctorInstance 初始化对象
    // 3、instance = memory 设置instance指向刚分配的内存空间
    // 这三个步骤在单线程的情况下CPU指令重排是不会有问题，但是多线程的情况下就会导致混乱

    //这种情况由于会发生指令重排而导致线程不安全，那么我们需要限制指令重排

    // 静态的工厂方法
    public static SingletonExample5 getInstance(){
        if(instance == null){  //双重检测机制  B-->执行到此，发现A已经在执行了，由于加了同步锁，B线程不能执行下面操作而直接返回一个还未初始化的对象，从而导致错误。
            synchronized (SingletonExample5.class){//同步锁
                if(instance == null){
                    instance = new SingletonExample5(); // A-->执行了实例化操作，执行到了内存分配操作，但还未初始化一个对象。
                }
            }
        }
        return instance;

    }

    public static void main(String[] args) {

    }
}
