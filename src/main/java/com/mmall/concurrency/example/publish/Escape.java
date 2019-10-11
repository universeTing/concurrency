package com.mmall.concurrency.example.publish;

import com.mmall.concurrency.annotations.NotRecommend;
import com.mmall.concurrency.annotations.NotThreadSafe;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@NotThreadSafe
@NotRecommend
public class Escape {

    private int thisCanBeEscape = 0;

    public Escape(){
        new InnerClass();
    }

    private class InnerClass{

        public InnerClass(){
            log.info("/// {}", Escape.this.thisCanBeEscape);
        }
    }

    // this 是在对象还未构造完成之时就可以看得见，所以构造函数的时候再去创建一个其他的类，
    // 导致this这个对象的语义不一致，所以是线程不安全的。
    public static void main(String[] args) {
        new Escape();
    }
}
