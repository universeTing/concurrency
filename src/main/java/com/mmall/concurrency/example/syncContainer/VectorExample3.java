package com.mmall.concurrency.example.syncContainer;

import com.mmall.concurrency.annotations.NotThreadSafe;

import java.util.Iterator;
import java.util.Vector;

/**
 * vector. arrayList等再遍历的时候去修改都会报错，可以使用并发容器来代替
 */
@NotThreadSafe
public class VectorExample3 {


    //会报线程修改异常 Exception in thread "main" java.util.ConcurrentModificationException
    private static void test1(Vector<Integer> v1){//foreach
        for (Integer i: v1) {
            if(i.equals(3)){
                v1.remove(i);
            }
        }
    }

    //会报线程修改异常 Exception in thread "main" java.util.ConcurrentModificationException
    private static void test2(Vector<Integer> v1){//iterator
        Iterator<Integer> iterator = v1.iterator();
        while(iterator.hasNext()){
            Integer i = iterator.next();
            if(i.equals(3)){
                v1.remove(i);
            }
        }
    }
    // 不会报错，。 所以在使用这些集合的时候，不推荐在遍历的时候去更新集合，如果需要更新，推荐先遍历找出结果，再去更新。
    private static void test3(Vector<Integer> v1){//fori 是安全的
        for (int i = 0; i < v1.size(); i++) {
            if(v1.get(i).equals(3)){
                v1.remove(i);
            }
        }
    }


    // 再单线程下都会报错，那么再多线程下报销的机率更大
    public static void main(String[] args) {
        Vector<Integer> vector = new Vector<>();
        vector.add(1);
        vector.add(2);
        vector.add(3);
        test3(vector);

    }

}
