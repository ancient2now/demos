package com.akikun.demo.juc;

/**
 * @author 李俊秋(龙泽)
 */
public class D05_ThreadLocal {

    public static void main(String[] args) {
        ThreadLocal tl = new ThreadLocal();

        tl.set("hello");
        tl.remove();
    }
}
