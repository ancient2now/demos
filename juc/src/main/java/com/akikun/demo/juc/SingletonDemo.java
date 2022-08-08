package com.akikun.demo.juc;

public class SingletonDemo {

    private static volatile SingletonDemo instance = null;

    private SingletonDemo() {
        System.out.println(Thread.currentThread().getName() + "\tConstructor SingletonDemo");
    }

    public static SingletonDemo getInstance() {
        if (instance == null) {
            synchronized (SingletonDemo.class) {
                if (instance == null) {
                    instance = new SingletonDemo();
                }
            }
        }
        return instance;
    }


    public static void main(String[] args) {

        Runnable testSinglelon = SingletonDemo::getInstance;

        for (int i = 0; i < 10; i++) {
            new Thread(testSinglelon, String.valueOf(i)).start();
        }

    }

}
