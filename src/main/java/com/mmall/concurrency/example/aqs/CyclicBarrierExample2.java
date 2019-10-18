package com.mmall.concurrency.example.aqs;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.*;

@Slf4j
public class CyclicBarrierExample2 {

    private static CyclicBarrier barrier = new CyclicBarrier(5);

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newCachedThreadPool();

        for (int i = 0; i < 10; i++) {

            final int threadNum = i;
            Thread.sleep(1000);
            executorService.execute(() ->{
                try{
                    race(threadNum);
                }catch (BrokenBarrierException e) {
                    e.printStackTrace();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (TimeoutException e) {
                    e.printStackTrace();
                }
            });
        }

        executorService.shutdown();
    }

    private static void race(int threadNum) throws BrokenBarrierException, InterruptedException, TimeoutException {
        Thread.sleep(1000);
        log.info("{} is ready", threadNum);
        barrier.await(2000, TimeUnit.MILLISECONDS);
        log.info("{} continue", threadNum);
    }
}
