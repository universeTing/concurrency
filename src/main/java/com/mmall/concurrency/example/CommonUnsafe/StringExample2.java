package com.mmall.concurrency.example.CommonUnsafe;

import com.mmall.concurrency.annotations.ThreadSafe;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@ThreadSafe
public class StringExample2 {
    //请求总数
    public static int clientTotal = 1000;

    //同时并发执行的线程数
    public static int threadTotal = 50;

    //计数值
    public static int count = 0;

    public static StringBuffer stringBuffer = new StringBuffer();

    public static void add(){
        stringBuffer.append("1");
    }

    /*public static void main(String []args) throws InterruptedException {
        ExecutorService executorService = Executors.newCachedThreadPool();
        final Semaphore semaphore = new java.util.concurrent.Semaphore(threadTotal);
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
        log.info("size:{}",stringBuilder.length());

    }*/

}
