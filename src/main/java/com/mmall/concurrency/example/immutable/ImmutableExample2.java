package com.mmall.concurrency.example.immutable;

import com.google.common.collect.Maps;
import com.mmall.concurrency.annotations.ThreadSafe;
import lombok.extern.slf4j.Slf4j;

import java.util.Collections;
import java.util.Map;

/**
 * final修饰不可变变量,被修饰的变量不能被修改的
 * 对于final修饰的变量，不可以再去修改他的值
 * 对于final修饰的引用，一旦初始化后就不能再重新构造对象。但是可以修改值，是线程不安全的
 * 对于Collections.unmodifiableMap这个类处理过后的map也是不可以修改的，在运行时抛异常
 */
@Slf4j
@ThreadSafe
public class ImmutableExample2 {

    private static Map<Integer,Integer> map = Maps.newHashMap();

    static {
        map.put(1,2);
        map.put(3,4);
        map.put(5,6);
        map = Collections.unmodifiableMap(map);//证明Collections.unmodifiableMap这个类处理过后的map也是不可以修改的，再运行时抛异常
    }

    public static void main(String[] args) {
        map.put(1,3);//不可以修改，运行时报错
        log.info("{}: ", map.get(1));
    }
}
