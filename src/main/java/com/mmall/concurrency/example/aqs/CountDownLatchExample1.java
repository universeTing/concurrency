package com.mmall.concurrency.example.aqs;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Slf4j
public class CountDownLatchExample1 {
    private final static int threadCount= 200;

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newCachedThreadPool();

        // countDownLatch 通过计数来判断线程是否执行结束，当其中一个线程执行的时候会阻塞掉其他线程
        final CountDownLatch countDownLatch = new CountDownLatch(threadCount);

        for (int i = 0; i < threadCount; i++) {
            final int threadNum = i;
            executorService.execute(() ->{

                try {
                    test(threadNum);
                } catch (InterruptedException e) {
                    log.error("error {}",e);
                }finally {
                    // 确保每次执行结束后都减一
                    countDownLatch.countDown();
                }
            });
        }

        // 使当前线程等待，直到countDownLatch 减到0
        countDownLatch.await();
        log.info("finish");
        // 线程池不再使用后，关闭掉
        executorService.shutdown();
    }

    private static void test(int threadNum) throws InterruptedException {
        Thread.sleep(100);
        log.info("{}",threadNum);
        Thread.sleep(100);
    }

}
