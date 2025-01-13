package com.dbs.springsandbox.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.Map;

import static com.dbs.springsandbox.config.CacheConfig.PILOT_CACHE;

@Service
@Slf4j
public class PilotingService {
    public static final String ENABLED_PILOT_KEY = "enabled_pilot";
    public static final String ENABLED_PILOT_KEY_WITH_CONTEXT = "enabled_pilot_with_context";

    @Cacheable(PILOT_CACHE)
    public boolean isEnabled(String pilotKey) {
        try {
            log.info("Fetching pilot key named: {}", pilotKey);
            Thread.sleep(5000);
            return pilotKey.equals(ENABLED_PILOT_KEY);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            return false;
        }
    }

    @Cacheable(PILOT_CACHE)
    public boolean isEnabled(String pilotKey, Map<String, String> context) {
        try {
            log.info("Fetching pilot key named: {} with context: {}", pilotKey, context);
            Thread.sleep(5000);
            return pilotKey.equals(ENABLED_PILOT_KEY_WITH_CONTEXT);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            return false;
        }
    }
}
