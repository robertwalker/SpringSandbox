package com.dbs.springsandbox.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import static com.dbs.springsandbox.config.CacheConfig.DEFAULT_CACHE;

@Service
@Slf4j
public class SlowService {
    @Cacheable(DEFAULT_CACHE)
    public String waitForMe(String name) {
        try {
            log.info("Greeting " + name);
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        return name;
    }

    @CacheEvict(cacheNames = DEFAULT_CACHE, allEntries = true)
    public void resetDefaultCache() {
        log.info("Clearing all cached values from default cache");
    }
}
