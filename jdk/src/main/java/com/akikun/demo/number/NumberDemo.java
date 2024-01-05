package com.akikun.demo.number;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * @author 李俊秋(龙泽)
 */
public class NumberDemo {


    public static void main(String[] args) {

    }

    private static void testHalfEven() {
        BigDecimal a = new BigDecimal("49103.691");
        BigDecimal b = a.setScale(2, RoundingMode.HALF_EVEN);
        System.out.println(b);
    }
}
