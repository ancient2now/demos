package com.akikun.cache;


/**
 *
 * 本地缓存，同时保证一致性
 *
 * @author 李俊秋(龙泽)
 */
public interface AkiCache<K, V> {
//    String getKey();
//
//    String getName();

    /**
     * 通过 key 获取 value
     */
    V get(K key);

    /**
     * 添加 value
     */
    void put(K key, V value);

    /**
     * 是否包含这个 key
     */
    boolean contains(K key);

    /**
     * 删除这个 key 的缓存
     */
    void invalidate(K key);

    /**
     * 清空所有缓存
     */
    void clear();
}
