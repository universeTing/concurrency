package com.mmall.concurrency.example.immutable;

import com.google.common.collect.Maps;
import com.mmall.concurrency.annotations.NotThreadSafe;
import lombok.extern.slf4j.Slf4j;

import java.util.Map;

/**
 * final修饰不可变变量,被修饰的变量不能被修改的
 * 对于final修饰的变量，不可以再去修改他的值
 * 对于final修饰的引用，一旦初始化后就不能再重新构造对象。但是可以修改值，是线程不安全的
 */
@Slf4j
@NotThreadSafe
public class ImmutableExample1 {

    private final static Integer a = 1;
    private final static String b = "2";
    private final static Map<Integer,Integer> map = Maps.newHashMap();

    static {
        map.put(1,2);
        map.put(3,4);
        map.put(5,6);
    }

    public static void main(String[] args) {
//        a = 2;
//        b = "3";
//        map = Maps.newHashMap();
        // 对于final修饰的变量，不可以再去修改他的值
        // 对于final修饰的引用，一旦初始化后就不能再重新构造对象。但是可以修改值
        map.put(1,3);
        log.info("{}: ", map.get(1));
    }

    private void test(final int a){
//        a=1;   //传入的参数通过final修饰的，意思是不允许再方法实现的时候修改
    }
}
