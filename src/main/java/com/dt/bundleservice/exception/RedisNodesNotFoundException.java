package com.dt.bundleservice.exception;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class RedisNodesNotFoundException extends Exception {
    public RedisNodesNotFoundException(String message) {
        super(message);
    }
}
