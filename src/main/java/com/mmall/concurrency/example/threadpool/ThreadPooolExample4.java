package com.mmall.concurrency.example.threadpool;

import lombok.extern.slf4j.Slf4j;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

@Slf4j
public class ThreadPooolExample4 {
    public static void main(String[] args){

        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(10);

        /*executorService.schedule(new Runnable() {
            @Override
            public void run() {
                log.warn("scheduled run");
            }
        },3, TimeUnit.SECONDS);

        executorService.shutdown();*/


        //延迟3s执行一次
        /*executorService.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                log.warn("scheduled runing");
            }
        },1,3,TimeUnit.SECONDS);*/


        //间隔5s执行一次
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                log.warn("timer run");
            }
        },new Date(),5*1000);
    }
}
