package com.mmall.concurrency.example.singleton;

import com.mmall.concurrency.annotations.Recommend;
import com.mmall.concurrency.annotations.ThreadSafe;
import lombok.extern.slf4j.Slf4j;

/**
 * 枚举模式 ：最安全的
 * 单例实例在枚举定义中创建
 */
@Slf4j
@ThreadSafe
@Recommend
public class SingletonExample7 {
    // 私有的构造函数，保证不能其他地方创建对象
    private SingletonExample7(){}

    public static SingletonExample7 getInstance(){
        return Singleton.INSTANCE.getInstance();
    }

    private enum Singleton{
        INSTANCE;

        private SingletonExample7 singleton;

        // JVM保证这个方法绝对只调用一次
        Singleton(){
            singleton = new SingletonExample7();
        }

        public SingletonExample7 getInstance(){ return singleton;}
    }

    public static void main(String[] args) {

    }
}
