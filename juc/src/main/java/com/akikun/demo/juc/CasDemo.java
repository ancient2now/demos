package com.akikun.demo.juc;

import java.util.concurrent.atomic.AtomicInteger;

public class CasDemo {

    public static void main(String[] args) {

        AtomicInteger atomicInteger = new AtomicInteger(5);

        atomicInteger.compareAndSet(5, 2020);

    }
}
