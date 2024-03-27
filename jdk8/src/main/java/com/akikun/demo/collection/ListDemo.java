package com.akikun.demo.collection;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author 李俊秋(龙泽)
 */
public class ListDemo {


    public static void main(String[] args) {
        testList2String();
    }

    public static void testList2String() {
        List<String> list = new ArrayList<>();
        list.add("A");
        list.add("B");
        list.add("C");

        String str = String.join("/", list);
        System.out.println(str);

    }
}
