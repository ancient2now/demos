package com.akikun.demo;

/**
 * @author 李俊秋(龙泽)
 */
public class RandomDemo {


    public static void main(String[] args) {
        for (int i = 0; i < 100; ++i) {
            System.out.println(random(50, 100));
        }
    }

    static int random(int min, int max) {
        return (int) (Math.random() * (max - min + 1) + min);
    }
}
