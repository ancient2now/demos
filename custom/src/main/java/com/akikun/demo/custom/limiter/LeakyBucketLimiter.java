package com.akikun.demo.custom.limiter;

import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author 李俊秋(龙泽)
 */
public class LeakyBucketLimiter<T> implements Limiter {

    /**
     * 桶容量
     */
    private final long capacity;

    /**
     * 漏桶流出的速率 每rate毫秒放出一个请求
     */
    private final long rate;

    /**
     * 当前水量
     */
    private AtomicInteger currentWater = new AtomicInteger(0);

    /**
     * 存放请求的请求队列
     */
    private final BlockingDeque<T> queue;

    /**
     * 定时任务线程池
     */
    private final ScheduledExecutorService executorService = new ScheduledThreadPoolExecutor(1);

    public LeakyBucketLimiter(long rate, int capacity, BlockingDeque<T> queue) {
        this.rate = rate;
        this.capacity = capacity;
        this.queue = new LinkedBlockingDeque<>();

        executorService.schedule(new Runnable() {
            @Override
            public void run() {
                //队列中没有请求的时候阻塞等待，防止空转消费资源
                try {
                    //如果是比较耗时间的任务可以定义额外的线程池来处理，将分发任务和执行任务分隔开
                    System.out.println("处理请求：" + queue.take());
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                currentWater.addAndGet(-1);
                executorService.schedule(this, rate, TimeUnit.MILLISECONDS);
            }
        }, rate, TimeUnit.MILLISECONDS);
    }

    @Override
    public synchronized boolean tryAcquire() {
        //成功增加水池水量，失败则回滚
        if (currentWater.addAndGet(1) <= capacity) {
            return true;
        } else {
            currentWater.addAndGet(-1);
            return false;
        }
    }
}
