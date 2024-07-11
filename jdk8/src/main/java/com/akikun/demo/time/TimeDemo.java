package com.akikun.demo.time;

import java.util.Date;

/**
 * @author 李俊秋(龙泽)
 */
public class TimeDemo {

    public static void main(String[] args) {
        System.out.println(System.currentTimeMillis());

        Date date = new Date(1715267642000L);
        System.out.println(date);
    }
}
