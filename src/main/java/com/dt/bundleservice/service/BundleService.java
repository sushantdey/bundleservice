package com.dt.bundleservice.service;

import com.dt.bundleservice.dao.RedisRepository;
import com.dt.bundleservice.entity.Bundle;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import io.micrometer.observation.annotation.Observed;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@Observed(name = "BundleService")
public class BundleService {

    @Autowired
    RedisRepository redisRepository;
    @Autowired
    RedisConnectionFactory connectionFactory;

    public Bundle getBundleInfo(String id) {
        log.info("[BundleService] [getBundleInfo] : Called with argument {}", id);
        String jsonString = redisRepository.getByKey(id);
        log.info("[BundleServiceController] [bundleById] : Redis lookup with key: {}, returned value: {}", id, jsonString);
        Gson gson = new GsonBuilder().create();
        Bundle bundle = gson.fromJson(jsonString, Bundle.class);
        return bundle;
    }
}
