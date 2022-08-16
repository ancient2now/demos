package com.akikun.demo.juc;

public class DemoSingleton {

    private static volatile DemoSingleton instance = null;

    private DemoSingleton() {
        System.out.println(Thread.currentThread().getName() + "\tConstructor SingletonDemo");
    }

    public static DemoSingleton getInstance() {
        if (instance == null) {
            synchronized (DemoSingleton.class) {
                if (instance == null) {
                    instance = new DemoSingleton();
                }
            }
        }
        return instance;
    }


    public static void main(String[] args) {

        Runnable testSinglelon = DemoSingleton::getInstance;

        for (int i = 0; i < 10; i++) {
            new Thread(testSinglelon, String.valueOf(i)).start();
        }

    }

}
