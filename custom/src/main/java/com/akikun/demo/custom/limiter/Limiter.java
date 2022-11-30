package com.akikun.demo.custom.limiter;

/**
 * @author 李俊秋(龙泽)
 */
public interface Limiter {

    // 实现参考来源： https://juejin.cn/post/7169631447244865544

    /**
     * 获取许可
     *
     * @return true：获取成功
     */
    boolean tryAcquire();
}

