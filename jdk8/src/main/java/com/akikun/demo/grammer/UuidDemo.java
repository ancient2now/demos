package com.akikun.demo.grammer;

import java.util.UUID;

/**
 * @author 李俊秋(龙泽)
 */
public class UuidDemo {

    public static void main(String[] args) {
        String a =  UUID.randomUUID().toString();
        String b = UUID.randomUUID().toString().replace("-", "");

        System.out.println(a);
        System.out.println(b);


        Long BJ_ID = 10000000L;
        String token = BJ_ID.toString() + BJ_ID;
        System.out.println(token);
    }
}
