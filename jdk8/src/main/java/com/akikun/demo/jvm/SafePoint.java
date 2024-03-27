package com.akikun.demo.jvm;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author 李俊秋(龙泽)
 */
public class SafePoint {

    public static AtomicInteger num = new AtomicInteger(0);

    public static void main(String[] args) throws InterruptedException {

        Runnable runnable =()->{
            for (int i = 0; i < 10_0000_0000; ++i) {
                num.addAndGet(1);

                // prevent long time gc
//                if (i % 1000 == 0) {
//                    try {
//                        Thread.sleep(0);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                }
            }
            System.out.println(Thread.currentThread().getName() + "执行结束!");

        };


        Thread t1 = new Thread(runnable);
        Thread t2 = new Thread(runnable);
        t1.start();
        t2.start();

        Thread.sleep(1000);
        System.out.println("num=" + num);

    }

    // 在JDK8中打印现象会是： 主线程打印会等待子线程打印结束再打印。 与预期不符合。
}
