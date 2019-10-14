package com.mmall.concurrency.example.CommonUnsafe;

import com.mmall.concurrency.annotations.NotThreadSafe;
import lombok.extern.slf4j.Slf4j;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

@Slf4j
@NotThreadSafe
public class DateFormatExample3 {

    //请求总数
    public static int clientTotal = 5000;
    //同时并发执行的线程数
    public static int threadTotal = 200;

    private static DateTimeFormatter dateTimeFormatter = DateTimeFormat.forPattern("yyyyMMdd");

    public static void update(){
        log.info("{},{}",DateTime.parse("20191014", dateTimeFormatter).toDate());
    }

   /* public static void main(String []args) throws InterruptedException {
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
*/

}
