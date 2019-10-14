package com.mmall.concurrency.example.CommonUnsafe;

import EDU.oswego.cs.dl.util.concurrent.Semaphore;
import com.mmall.concurrency.annotations.NotThreadSafe;
import lombok.extern.slf4j.Slf4j;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Slf4j
@NotThreadSafe
public class DateFormatExample1 {

    //SimpleDateFormat不是线程安全的对象
    private static SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyMMdd");

    //请求总数
    public static int clientTotal = 5000;
    //同时并发执行的线程数
    public static int threadTotal = 200;

    public static void update(){
        try {
            simpleDateFormat.parse("20191014");
        } catch (ParseException e) {
            log.error("parse exception", e);
        }
    }

    public static void main(String []args) throws InterruptedException {
        ExecutorService executorService = Executors.newCachedThreadPool();
        final Semaphore semaphore = new java.util.concurrent.Semaphore(threadTotal);
        final CountDownLatch countDownLatch = new CountDownLatch(clientTotal);
        for (int i = 0; i < clientTotal; i++) {
            executorService.execute(()-> {
                try{
                    semaphore.acquire(); //当前线程是否允许被执行，当不被执行时，add是被阻塞的
                    update();
                    semaphore.release(); //释放资源
                }catch (Exception e){
                    log.error("exception", e);
                }
                countDownLatch.countDown();
            });
        }
        countDownLatch.await();
        executorService.shutdown();

    }


}
