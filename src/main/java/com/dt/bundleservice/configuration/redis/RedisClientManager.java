package com.dt.bundleservice.configuration.redis;

import com.dt.bundleservice.configuration.ServiceConfigurationManager;
import com.dt.bundleservice.exception.RedisNodesNotFoundException;
import io.lettuce.core.resource.ClientResources;
import io.micrometer.observation.ObservationRegistry;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisClusterConfiguration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.lettuce.LettuceClientConfiguration;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.connection.lettuce.observability.MicrometerTracingAdapter;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static io.lettuce.core.ReadFrom.REPLICA_PREFERRED;

//@Configuration
//@Slf4j
public class RedisClientManager {
/*
    @Autowired
    ServiceConfigurationManager serviceConfigurationManager;

    @Bean
    public ClientResources clientResources(ObservationRegistry observationRegistry) {

        return ClientResources.builder()
                .tracing(new MicrometerTracingAdapter(observationRegistry, "bundle-service-redis-cache"))
                .build();
    }

    @Bean
    public RedisConnectionFactory connectionFactory(ClientResources clientResources) throws RedisNodesNotFoundException {

        String bundleServiceRedisNodes = serviceConfigurationManager.getConfigMap() != null
                ? serviceConfigurationManager.getConfigMap().get("bundle_service_redis_nodes")
                : null;
        if (bundleServiceRedisNodes == null || bundleServiceRedisNodes.isBlank())
            throw new RedisNodesNotFoundException("Unable to fetch bundle service redis node IPs from Configuration Map");
        List<String> redisNodesList = Arrays.stream(bundleServiceRedisNodes.split(","))
                .map(ip -> ip + ":6379")
                .collect(Collectors.toList());
        LettuceClientConfiguration clientConfig = LettuceClientConfiguration.builder()
                .clientResources(clientResources)
                .readFrom(REPLICA_PREFERRED)
                .build();
        return new LettuceConnectionFactory(
                new RedisClusterConfiguration(redisNodesList), clientConfig);
    }*/
}