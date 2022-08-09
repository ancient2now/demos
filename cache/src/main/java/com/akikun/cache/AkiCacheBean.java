package com.akikun.cache;


import com.google.common.cache.Cache;

import java.io.Serializable;

/**
 * @author 李俊秋(龙泽)
 */
class AkiCacheBean<K, V> {

    static class DemoCache<K, V> implements AkiCache<K, V>, Serializable {

        private Cache<K, V> cache;

        private String remoteVersionKey;

        public DemoCache(AkiCacheBuilder<K, V> akiCacheBuilder) {
            this.cache = akiCacheBuilder.getCacheBuilder().build();
            this.remoteVersionKey = akiCacheBuilder.getRemoteVersionKey();
        }

        @Override
        public V get(K key) {
            return cache.getIfPresent(key);
        }

        @Override
        public void put(K key, V value) {
            cache.put(key, value);
        }

        @Override
        public boolean contains(K key) {
            return cache.asMap().containsKey(key);
        }

        @Override
        public void invalidate(K key) {
            cache.invalidate(key);
        }

        @Override
        public void clear() {
            cache.cleanUp();
        }
    }
}
