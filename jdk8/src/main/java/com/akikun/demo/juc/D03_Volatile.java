package com.akikun.demo.juc;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 验证volatile的可见性 verifyVisibility
 * 验证volatile的原子性 verifyAtomic
 *
 */
public class D03_Volatile {

    public static void main(String[] args) {
//        VolatileDemo test = new VolatileDemo();
//        test.verifyAtomic();
//        test.verifyVisibility();


    }

    /**
     * 预期结果： AAA线程暂停3秒钟,然后将number修改,while循环就会结束
     * 不使用volatile，将会一直在while循环
     */
    public void verifyVisibility() {

        Data data = new Data();

        Runnable AAA = () -> {
            System.out.println(Thread.currentThread().getName() + "\t come in");
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            data.addTo60();
            System.out.println(Thread.currentThread().getName() + "\t updated number value: " + data.number);
        };

        new Thread(AAA, "AAA").start();

        while (data.number == 0) {

        }

        System.out.println(Thread.currentThread().getName() + "\t is over");
    }

    /**
     * 验证volatile不能保证原子性,预期结果值都是20000
     * 使用AtomicInteger保证原子性
     */
    public void verifyAtomic() {

        Data data = new Data();

        Runnable add = () -> {
            for (int i = 0; i < 1000; i++) {
                data.addPlusPlus();
                data.addAtomicNumber();
            }
        };

        for (int i = 0; i < 20; i++) {
            new Thread(add, String.valueOf(i)).start();
        }

        // 后台默认有两个线程GC线程和Main线程, 使用yield方法暂停在这儿等上面的线程执行完
        while (Thread.activeCount() > 2) {
            Thread.yield();
        }

        System.out.println(Thread.currentThread().getName() + "\t is over");
        System.out.println("finally int number value: " + data.getNumber());
        System.out.println("finally Atomic number value: " + data.getAtomicNumber());

    }

    static class Data {

    //    int number = 0;

        private volatile int number = 0;

        private AtomicInteger atoNumber = new AtomicInteger();

        public void addTo60() {
            this.number = 60;
        }

        public void addPlusPlus() {
            number++;
        }

//        public synchronized void addPlusPlus() {
//            number++;
//        }

        public void addAtomicNumber() {
            atoNumber.incrementAndGet();
        }

        public int getNumber() {
            return number;
        }

        public int getAtomicNumber() {
            return atoNumber.get();
        }
    }
}


