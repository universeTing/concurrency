/*
package com.mmall.concurrency.example.lock;


import EDU.oswego.cs.dl.util.concurrent.ReentrantLock;
import EDU.oswego.cs.dl.util.concurrent.Semaphore;
import com.mmall.concurrency.annotations.ThreadSafe;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;



@Slf4j
@ThreadSafe
public class LockExample2 {
    //请求总数
    public static int clientTotal = 1000;

    //同时并发执行的线程数
    public static int threadTotal = 50;

    //计数值
    public static int count = 0;

    private static Lock lock = new ReentrantLock();
    public static void add(){
        lock.lock();
        try{
            count++;
        }finally {
            lock.unlock();
        }

    }

    public static void main(String []args) throws InterruptedException {
        ExecutorService executorService = Executors.newCachedThreadPool();
        final Semaphore semaphore = new Semaphore(threadTotal);
        final CountDownLatch countDownLatch = new CountDownLatch(clientTotal);
        for (int i = 0; i < clientTotal; i++) {
            executorService.execute(()-> {
                try{
                    semaphore.acquire(); //当前线程是否允许被执行，当不被执行时，add是被阻塞的
                    add();
                    semaphore.release(); //释放资源
                }catch (Exception e){
                    log.error("exception", e);
                }
                countDownLatch.countDown();
            });
        }
        countDownLatch.await();
        executorService.shutdown();
        log.info("count:{}",count);

    }

}
*/
