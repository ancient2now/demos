package com.akikun.demo.number;

/**
 * @author 李俊秋(龙泽)
 */
public class Number2StringDemo {

    public static void main(String[] args) {
//        System.out.println(Integer.toBinaryString(10));

        for (int i = 0; i < 150; ++i) {
            System.out.println("压测" + (String.format("%03d", i)));
        }
    }
}
