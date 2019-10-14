package com.mmall.concurrency.example.threadLocal;

public class RequestHolder {

    private final static ThreadLocal<Long> requestHolder = new ThreadLocal<>();

    //取出线程的id添加信息
    public static void add(Long id) {
        requestHolder.set(id);
    }

    public static Long getId() {
        return requestHolder.get();
    }

    //移除当前变量的信息，如果不移除的话，会造成内存泄漏
    public static void remove() {
        requestHolder.remove();
    }
}
