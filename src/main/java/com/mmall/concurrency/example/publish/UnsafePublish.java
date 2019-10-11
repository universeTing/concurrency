package com.mmall.concurrency.example.publish;

import com.mmall.concurrency.annotations.NotThreadSafe;
import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

@Slf4j
@NotThreadSafe
public class UnsafePublish {

    private String[] states = {"a","b","c"};

    public String[] getStates() {
        return states;
    }

    public static void main(String[] args) {
        // 通过创建一个实例来发布对象，通过这个对象来访问他的私有域的值。
        // 也可以通过这个对象来修改其中的值。当其他的线程想访问对象的域里面的值的时候，不知道该值已被修改了，所以是线程不安全的。
        // 因为我们无法判断其他线程是否已修改了其中的域，从而做出错误的判断。所以是线程不安全的
        UnsafePublish unsafePublish = new UnsafePublish();
        log.info("{}", Arrays.toString(unsafePublish.getStates()));

        //修改值
        unsafePublish.getStates()[0] = "d";
        log.info("{}",Arrays.toString(unsafePublish.getStates()));
    }
}
