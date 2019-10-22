package com.mmall.concurrency.example.threadpool;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Slf4j
public class ThreadPooolExample3 {
    public static void main(String[] args){
        ExecutorService executorService = Executors.newSingleThreadExecutor();

        for (int i = 0; i < 10; i++) {
            final int index = 1;
            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    log.info("task: {}", index);
                }
            });
        }

        executorService.shutdown();
    }
}
