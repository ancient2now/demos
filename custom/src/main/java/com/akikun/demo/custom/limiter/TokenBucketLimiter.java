package com.akikun.demo.custom.limiter;

/**
 * @author 李俊秋(龙泽)
 */
public class TokenBucketLimiter implements Limiter {
    /**
     * 最大容量
     */
    private final long capacity;
    /**
     * 令牌的生成速率 每rate毫秒生成一个令牌
     */
    private final long rate;
    /**
     * 下一个令牌的发放时间
     */
    long nextTokenTime = System.currentTimeMillis();
    /**
     * 当前持有的令牌总数
     */
    private long currentTokens;

    public TokenBucketLimiter(long rate, int capacity, int currentTokens) {
        this.rate = rate;
        this.capacity = capacity;
        //根据需求设置令牌桶中令牌的初始数量
        this.currentTokens = currentTokens;
    }

    @Override
    public boolean tryAcquire() {
        long nowTime = System.currentTimeMillis();
        if (nowTime - nextTokenTime > rate) {
            //计算新产生的令牌数
            long newTokens = (nowTime - nextTokenTime) / rate;
            //更新当前持有的令牌数量
            currentTokens = Math.min(currentTokens + newTokens, capacity);
            //更新可以获取令牌的时间
            nextTokenTime = nowTime;
        }
        if (currentTokens > 0) {
            currentTokens--;
            return true;
        }
        return false;
    }
}

