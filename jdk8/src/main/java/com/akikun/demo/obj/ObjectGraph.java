package com.akikun.demo.obj;

import org.openjdk.jol.info.ClassLayout;
import org.openjdk.jol.info.GraphLayout;

/**
 * @author 李俊秋(龙泽)
 */
public class ObjectGraph {

    public static void main(String[] args) {
        T t = new T();

        String graphLayout = GraphLayout.parseInstance(t).toPrintable();
        String claasLayout = ClassLayout.parseInstance(t).toPrintable();

        System.out.println(graphLayout);
        System.out.println(claasLayout);
    }

    public static class T {

        private int m = 8;

        private int n = 0;
    }
}
