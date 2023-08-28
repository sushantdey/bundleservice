package com.dt.bundleservice.service;

import com.dt.bundleservice.entity.Bundle;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.stereotype.Service;

@Service
public class BundleService {

    @Autowired
    RedisService redisService;
    @Autowired
    RedisConnectionFactory connectionFactory;

    public Bundle getBundleInfo(String id) {
        String jsonString = redisService.getByKey(id);
        Gson gson = new GsonBuilder().create();
        Bundle bundle = gson.fromJson(jsonString, Bundle.class);
        return bundle;
    }
}
