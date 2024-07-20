package com.example.university.config;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.jetbrains.annotations.NotNull;
import org.springframework.cache.concurrent.ConcurrentMapCache;


public class JsonCache extends ConcurrentMapCache {

    private final ObjectMapper objectMapper;

    public JsonCache() {
        super("JsonCache");
        this.objectMapper = new ObjectMapper();
    }

    @Override
    public void put(@NotNull Object key, Object value) {
        try {
            String jsonValue = objectMapper.writeValueAsString(value);
            super.put(key, jsonValue);
        } catch (Exception e) {
            throw new RuntimeException("Could not serialize value to JSON", e);
        }
    }

    @Override
    public ValueWrapper get(@NotNull Object key) {
        ValueWrapper wrapper = super.get(key);
        if (wrapper != null && wrapper.get() instanceof String) {
            try {
                String jsonValue = (String) wrapper.get();
                return () -> {
                    try {
                        return objectMapper.readValue(jsonValue, Object.class);
                    } catch (JsonProcessingException e) {
                        throw new RuntimeException(e);
                    }
                };
            } catch (Exception e) {
                throw new RuntimeException("Could not deserialize value from JSON", e);
            }
        }
        return wrapper;
    }
}
