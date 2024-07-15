package com.akikun.demo;

import java.math.BigDecimal;

/**
 * @author 李俊秋(龙泽)
 */
public class Playground {

    public static void main(String[] args) {
        BigDecimal a = new BigDecimal(1);
        BigDecimal b = new BigDecimal(1.0);
        BigDecimal c = new BigDecimal("1.0");

        boolean r1 = a.equals(b);
        System.out.println(r1);

        boolean r2 = a.equals(c);
        System.out.println(r2);


    }
}
