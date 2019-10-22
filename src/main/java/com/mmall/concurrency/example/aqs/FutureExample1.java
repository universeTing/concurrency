package com.mmall.concurrency.example.aqs;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.*;

@Slf4j
public class FutureExample1 {
    static class MyCallable implements Callable<String>{

        @Override
        public String call() throws Exception {
            log.info("do something in callable");
            Thread.sleep(1000);
            return "done";
        }
    }


    public static void main(String[] args) throws InterruptedException, ExecutionException {
        ExecutorService executorService = Executors.newCachedThreadPool();
        Future<String> future = executorService.submit(new MyCallable());
        log.info("do something in main");
        Thread.sleep(1000);
        String result = future.get();
        log.info("result: {}",result);
    }


}
