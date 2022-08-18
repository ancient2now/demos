package com.akikun.demo.juc;

public class D02_Singleton {

    private static volatile D02_Singleton instance = null;

    private D02_Singleton() {
        System.out.println(Thread.currentThread().getName() + "\tConstructor SingletonDemo");
    }

    public static D02_Singleton getInstance() {
        if (instance == null) {
            synchronized (D02_Singleton.class) {
                if (instance == null) {
                    instance = new D02_Singleton();
                }
            }
        }
        return instance;
    }


    public static void main(String[] args) {

        Runnable testSinglelon = D02_Singleton::getInstance;

        for (int i = 0; i < 10; i++) {
            new Thread(testSinglelon, String.valueOf(i)).start();
        }

    }

}
