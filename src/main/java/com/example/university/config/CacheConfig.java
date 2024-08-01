package com.example.university.config;

import com.github.benmanes.caffeine.cache.Caffeine;
import com.github.benmanes.caffeine.cache.RemovalCause;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.caffeine.CaffeineCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.TimeUnit;

@Slf4j
@Configuration
@EnableCaching
public class CacheConfig {

    @Bean
    public CacheManager cacheManager() {
        CaffeineCacheManager cacheManager = new CaffeineCacheManager();
        cacheManager.setCaffeine(
                Caffeine
                        .newBuilder()
                        .initialCapacity(100)
                        .maximumSize(500)
                        .expireAfterAccess(10, TimeUnit.MINUTES)
                        .evictionListener((Object key, Object value,
                                           RemovalCause cause) ->
                                log.info(String.format(
                                        "Key %s was evicted (%s)%n", key, cause)))
                        .removalListener((Object key, Object value,
                                          RemovalCause cause) ->
                                log.info(String.format(
                                        "Key %s was removed (%s)%n", key, cause)))
        );
        return cacheManager;
    }

}
