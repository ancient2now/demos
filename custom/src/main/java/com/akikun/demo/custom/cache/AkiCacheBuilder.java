package com.akikun.demo.custom.cache;


import com.google.common.cache.CacheBuilder;

/**
 *
 * 本地缓存，同时保证一致性
 *
 * @author 李俊秋(龙泽)
 */
public final class AkiCacheBuilder<K, V> {

    private CacheBuilder<K, V> cacheBuilder;

    private String remoteVersionKey;

    private AkiCacheBuilder() {

    }

    public static <K, V> AkiCacheBuilder<K, V> from(CacheBuilder<K, V> cacheBuilder) {
        AkiCacheBuilder<K, V> akiCacheBuilder = new AkiCacheBuilder<>();
        akiCacheBuilder.cacheBuilder = cacheBuilder;
        return akiCacheBuilder;
    }

    public CacheBuilder<K, V> getCacheBuilder() {
        return this.cacheBuilder;
    }

//    public AkiCacheBuilder<K, V> expireAfterAccess(long duration, TimeUnit unit) {
//        cacheBuilder.expireAfterAccess(duration, unit);
//        return this;
//    }
//
//    public AkiCacheBuilder<K, V> maximumSize(long maximumSize) {
//        cacheBuilder.maximumSize(maximumSize);
//        return this;
//    }
//
//    public AkiCacheBuilder<K, V> remoteVersionKey(String remoteVersionKey) {
//        this.remoteVersionKey = remoteVersionKey;
//        return this;
//    }

    public String getRemoteVersionKey() {
        return this.remoteVersionKey;
    }

    public AkiCache<K, V> build() {
        return new AkiCacheBean.DemoCache(this);
    }




}
