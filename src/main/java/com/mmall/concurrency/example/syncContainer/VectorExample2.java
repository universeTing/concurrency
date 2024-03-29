package com.mmall.concurrency.example.syncContainer;

import com.mmall.concurrency.annotations.NotThreadSafe;

import java.util.Vector;

/**
 * 线程安全的容器，一定要注意其同步方法的调用顺序，否则也会引起线程不安全
 */
@NotThreadSafe
public class VectorExample2 {

    private static Vector<Integer> vector = new Vector<>();

    public static void main(String[] args) {
       while(true){
           for (int i = 0; i < 10; i++) {
               vector.add(i);
           }

           Thread thread1 = new Thread(){
               public void run(){
                   for (int i = 0; i < vector.size(); i++) {
                       vector.remove(i);
                   }
               }
           };

           Thread thread2 = new Thread(){
               public void run(){
                   for (int i = 0; i < vector.size(); i++) {
                       vector.get(i);
                   }
               }
           };

           thread1.start();
           thread2.start();
       }

    }

}
