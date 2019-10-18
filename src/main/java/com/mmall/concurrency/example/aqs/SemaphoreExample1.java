package com.mmall.concurrency.example.aqs;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.*;

/**
 * 一次性释放一个许可
 */
@Slf4j
public class SemaphoreExample1 {
    private final static int threadCount= 20;

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newCachedThreadPool();

        // 定义一个信号量，给定一次允许执行的并发数量
        final Semaphore semaphore = new Semaphore(3);

        for (int i = 0; i < threadCount; i++) {
            final int threadNum = i;
            executorService.execute(() ->{

                try {
                    /*semaphore.acquire();//获取一个许可
//                    semaphore.acquire(3);//获取三个许可
                    test(threadNum);
                    semaphore.release();//释放一个许可*/
//                    semaphore.release(3);//释放三个许可

                    //尝试获取一个许可，间隔一秒钟获取一次
                    /*if(semaphore.tryAcquire(1,TimeUnit.SECONDS)){
                        test(threadNum);
                        semaphore.release();
                    }*/

                    if(semaphore.tryAcquire(5000,TimeUnit.MILLISECONDS)){
                        test(threadNum);
                        semaphore.release();
                    }
                } catch (InterruptedException e) {
                    log.error("error {}",e);
                }
            });
        }
        // 线程池不再使用后，关闭掉, 调用这个方法并不是马上关闭掉，而是把当前正在执行的线程，执行结束后才关闭掉。
        executorService.shutdown();
    }

    private static void test(int threadNum) throws InterruptedException {
        Thread.sleep(1000);
        log.info("{}",threadNum);
    }

}
