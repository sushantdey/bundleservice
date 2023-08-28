package com.dt.bundleservice.service;

import java.util.concurrent.TimeUnit;

public interface RedisService {
    void save(String key, String value);
    void save(String key, String value, long ttl, TimeUnit ttlTimeUnit);
    String getByKey(String key);
}
