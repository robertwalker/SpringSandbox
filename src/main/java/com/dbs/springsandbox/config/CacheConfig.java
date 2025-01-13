package com.dbs.springsandbox.config;

import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.concurrent.ConcurrentMapCache;
import org.springframework.cache.concurrent.ConcurrentMapCacheFactoryBean;
import org.springframework.cache.support.SimpleCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Set;

@Configuration
@EnableCaching
@SuppressWarnings("unused")
public class CacheConfig {
    public static final String DEFAULT_CACHE = "default";
    public static final String PILOT_CACHE = "pilot";

    @Bean
    ConcurrentMapCacheFactoryBean defaultCache() {
        ConcurrentMapCacheFactoryBean cache = new ConcurrentMapCacheFactoryBean();
        cache.setName(DEFAULT_CACHE);
        return cache;
    }

    @Bean
    ConcurrentMapCacheFactoryBean pilotCache() {
        ConcurrentMapCacheFactoryBean cache = new ConcurrentMapCacheFactoryBean();
        cache.setName(PILOT_CACHE);
        return cache;
    }

    @Bean
    CacheManager cacheManager(ConcurrentMapCache defaultCache, ConcurrentMapCache pilotCache) {
        SimpleCacheManager cacheManager = new SimpleCacheManager();
        cacheManager.setCaches(Set.of(defaultCache, pilotCache));
        return cacheManager;
    }
}
