package com.example.university.config;

import org.jetbrains.annotations.NotNull;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Collection;
import java.util.Collections;

@Configuration
@EnableCaching
public class CacheConfig {

    @Bean
    public CacheManager cacheManager() {
        return new CacheManager() {
            private final Cache jsonCache = new JsonCache();

            @Override
            public Cache getCache(@NotNull String name) {
                if (jsonCache.getName().equals(name)) {
                    return jsonCache;
                }
                return null;
            }

            @Override
            public @NotNull Collection<String> getCacheNames() {
                return Collections.singletonList(jsonCache.getName());
            }
        };
    }
}
