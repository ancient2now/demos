package com.akikun.demo.performance;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

/**
 * 测试集合stream的性能
 *
 * @author 李俊秋(龙泽)
 */
public class DemoStream {


    public static void main(String[] args) {
        int mod = 1000000000 + 7;
        int size = Integer.MAX_VALUE / 1000;

        int times = 500;


        long streamCost = 0, iterationCost = 0;
        for (int i = 0; i < times; ++i) {
//            System.err.println("开始测试偶数+1..第" + (i + 1) + "次.....samples: " + size);
//            List<Integer> list = randomIntegerList(size);
//            iterationCost += iterationOuImpl(list);
//            streamCost += streamOuImpl(list);


            System.out.println("开始测试查询最小数..第" + (i + 1) + "次.....samples: " + size);
            List<Integer> list = randomIntegerList(size);
            streamCost += streamMinImpl(list);
            iterationCost += iterationMinImpl(list);
        }

        System.err.println("streamImpl: " + streamCost);
        System.err.println("iterationImpl: " + iterationCost);

    }

    public static long streamOuImpl(List<Integer> list) {
        long start = System.currentTimeMillis();
        List<Integer> ans = list.stream().filter(a -> a % 2 == 0).collect(Collectors.toList());
        long end = System.currentTimeMillis();
//        System.err.println("streamImpl: " + (end - start));
        return end - start;
    }

    public static long iterationOuImpl(List<Integer> list) {
        long start = System.currentTimeMillis();
        LinkedList<Integer> ans = new LinkedList<>();
        for (Integer i : list) {
            if (i % 2 == 0) {
                ans.add(i);
            }
        }
        long end = System.currentTimeMillis();
//        System.err.println("iterationImpl: " + (end - start));
        return end - start;
    }

    public static long streamMinImpl(List<Integer> list) {
        long start = System.currentTimeMillis();
        Integer ans = list.stream().min(Comparator.comparingInt(a -> a)).get();
        long end = System.currentTimeMillis();
        System.out.println("streamMinImpl answer: " + ans);
        return end - start;
    }

    public static long iterationMinImpl(List<Integer> list) {
        long start = System.currentTimeMillis();
        Integer ans = list.get(0);
        for (Integer i : list) {
            if (i < ans) {
                ans = i;
            }
        }
        System.out.println("iterationMinImpl answer: " + ans);
        long end = System.currentTimeMillis();
        return end - start;
    }

    public static List<Integer> randomIntegerList(int size) {
        Random random = new Random();
        List<Integer> list = new ArrayList<>(size);
        for (int i = 0; i < size; ++i) {
            list.add(random.nextInt());
        }
        return list;
    }
}
