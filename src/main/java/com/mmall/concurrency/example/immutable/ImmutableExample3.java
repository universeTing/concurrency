package com.mmall.concurrency.example.immutable;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.mmall.concurrency.annotations.ThreadSafe;
import lombok.extern.slf4j.Slf4j;

/**
 * final修饰不可变变量,被修饰的变量不能被修改的
 * 对于final修饰的变量，不可以再去修改他的值
 * 对于final修饰的引用，一旦初始化后就不能再重新构造对象。但是可以修改值，是线程不安全的
 * 对于Collections.unmodifiableMap这个类处理过后的map也是不可以修改的，在运行时抛异常
 * ImmutableList、ImmutableSet都是不可以修改的
 */
@Slf4j
@ThreadSafe
public class ImmutableExample3 {
    private final static ImmutableList list = ImmutableList.of(1,2,3);

    private final static ImmutableSet set = ImmutableSet.copyOf(list);

    private final static ImmutableMap<Integer,Integer> map = ImmutableMap.of(1,2,3,4);
    private final static ImmutableMap<Integer,Integer> map2 = ImmutableMap.<Integer,Integer>builder().put(1,2).put(3,4).build();

    public static void main(String[] args) {
        //list.add(4);//不可以修改，、
        //map.put(1,4);
        //map2.put(1,4);

        System.out.println(map2.get(1));
    }
}
