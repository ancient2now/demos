package com.akikun.demo.number;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

/**
 * @author 李俊秋(龙泽)
 */
public class NumberDemo {


    public static void main(String[] args) {
        test2();
    }

    private static void testHalfEven() {
        BigDecimal a = new BigDecimal("49103.691");
        BigDecimal b = a.setScale(2, RoundingMode.HALF_EVEN);
        System.out.println(b);
    }


    private static void test2() {
        BigDecimal a = new BigDecimal("431.691");
        BigDecimal b = a.divide(BigDecimal.ONE, new MathContext(2, RoundingMode.HALF_UP));
        BigDecimal c = a.divide(BigDecimal.ONE, 2, RoundingMode.HALF_UP);
        System.out.println(b);
        System.out.println(c);
    }
}
