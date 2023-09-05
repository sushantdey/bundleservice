package com.dt.bundleservice.dao;

import io.micrometer.observation.annotation.Observed;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.repository.configuration.EnableRedisRepositories;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

@Component
@EnableRedisRepositories
@Slf4j
@Observed(name = "RedisRepositoryImpl")
public class RedisRepositoryImpl implements RedisRepository {
    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    @Override
    public void save(String key, String value) {
        log.info("[RedisRepositoryImpl] [save] : Called with arguments, key: {}, value: {}", key, value);
        redisTemplate.opsForValue().set(key, value);
    }

    @Override
    public void save(String key, String value, long ttl, TimeUnit ttlTimeUnit) {
        log.info("[RedisRepositoryImpl] [save] : Called with arguments, key: {}, value: {}, ttl: {}, ttlTimeUnit: {}", key, value, ttl, ttlTimeUnit);
        redisTemplate.opsForValue().set(key, value, ttl, ttlTimeUnit);
    }

    @Override
    public String getByKey(String key) {
        log.info("[RedisRepositoryImpl] [getByKey] : Called with arguments, key: {}", key);
        return redisTemplate.opsForValue().get(key);
    }
}
