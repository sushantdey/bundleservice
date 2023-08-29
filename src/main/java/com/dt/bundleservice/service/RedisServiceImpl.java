package com.dt.bundleservice.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
@Slf4j
public class RedisServiceImpl implements RedisService {
    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    @Override
    public void save(String key, String value) {
        log.info("[RedisServiceImpl] [save] : Called with arguments, key: {}, value: {}", key, value);
        redisTemplate.opsForValue().set(key, value);
    }

    @Override
    public void save(String key, String value, long ttl, TimeUnit ttlTimeUnit) {
        log.info("[RedisServiceImpl] [save] : Called with arguments, key: {}, value: {}, ttl: {}, ttlTimeUnit: {}", key, value, ttl, ttlTimeUnit);
        redisTemplate.opsForValue().set(key, value, ttl, ttlTimeUnit);
    }

    @Override
    public String getByKey(String key) {
        log.info("[RedisServiceImpl] [getByKey] : Called with arguments, key: {}", key);
        return redisTemplate.opsForValue().get(key);
    }
}
