package com.akikun.demo.custom.limiter;

import java.util.PriorityQueue;

/**
 * 滑动窗口
 * <p>
 * 用一个有序集合来存储所有请求的时间戳，以空间换时间的方式来简化计算
 *
 * @author 李俊秋(龙泽)
 */
public class CountLimiter implements Limiter {

    /**
     * 维护一个优先队列记录请求的时间戳
     * 将PriorityQueue替换为Redis的ZSet的话可以实现分布式的限流
     */
    private final PriorityQueue<Long> queue = new PriorityQueue<>();

    /**
     * 限流大小
     */
    private final int limitCount;

    /**
     * 限流时间范围
     */
    private final Long limitTime;

    public CountLimiter(int limitCount, Long limitTime) {
        this.limitCount = limitCount;
        this.limitTime = limitTime;
    }

    @Override
    public synchronized boolean tryAcquire() {
        long nowTime = System.currentTimeMillis();
        if (queue.size() < limitCount) {
            queue.add(nowTime);
            return true;
        } else {
            long preTime = nowTime - limitTime;
            //淘汰已经超过时间限制的请求
            while (!queue.isEmpty() && preTime > queue.peek()) {
                queue.poll();
            }
            if (queue.size() < limitCount) {
                queue.add(nowTime);
                return true;
            } else {
                return false;
            }
        }
    }
}

