package com.mmall.concurrency.example.atomic;

import com.mmall.concurrency.annotations.ThreadSafe;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

@Slf4j
@ThreadSafe
public class AtomicReferenceFieldUpdater1 {

    // 声明的时候，传入的值是该类和该类的一个字段名（存在的一个字段）。
    private static AtomicIntegerFieldUpdater<AtomicReferenceFieldUpdater1> updater =
            AtomicIntegerFieldUpdater.newUpdater(AtomicReferenceFieldUpdater1.class,"count");

    // 这个字段必须是volatile修饰的，同时不能是static 声明的
    @Getter
    private volatile int count = 100;

    private static AtomicReferenceFieldUpdater1 atomicReferenceFieldUpdater1 = new AtomicReferenceFieldUpdater1();

    public static void main(String[] args){
        // 如果期望值是100，就修改为120
        if(updater.compareAndSet(atomicReferenceFieldUpdater1,100,120)){
            log.info("update success1 {}",atomicReferenceFieldUpdater1.getCount());
        }

        if(updater.compareAndSet(atomicReferenceFieldUpdater1,100,120)){
            log.info("update success2 {}",atomicReferenceFieldUpdater1.getCount());
        }else{
            log.info("update failed {}",atomicReferenceFieldUpdater1.getCount());
        }
    }

}
