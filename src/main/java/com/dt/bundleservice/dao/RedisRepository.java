package com.dt.bundleservice.dao;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.concurrent.TimeUnit;

public interface RedisRepository {
    void save(String key, String value);
    void save(String key, String value, long ttl, TimeUnit ttlTimeUnit);
    String getByKey(String key);
}
