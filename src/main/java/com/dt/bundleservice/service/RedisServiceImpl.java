package com.dt.bundleservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.concurrent.TimeUnit;

public class RedisServiceImpl implements RedisService {
    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    @Override
    public void save(String key, String value) {
        redisTemplate.opsForValue().set(key, value);
    }

    @Override
    public void save(String key, String value, long ttl, TimeUnit ttlTimeUnit) {
        redisTemplate.opsForValue().set(key, value, ttl, ttlTimeUnit);
    }

    @Override
    public String getByKey(String key) {
        return null;
    }
}
