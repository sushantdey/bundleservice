package com.dt.bundleservice.controller;

import com.dt.bundleservice.entity.Bundle;
import com.dt.bundleservice.entity.Developer;
import com.dt.bundleservice.service.BundleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;

@Controller
@Slf4j
public class BundleServiceController {

    @Autowired
    BundleService bundleService;

    @QueryMapping
    public Bundle bundleById(@Argument String id) {
        log.info("[BundleServiceController] [bundleById] : Called with argument {}", id);
        return bundleService.getBundleInfo(id);
    }

    @SchemaMapping
    public Developer developer(Bundle bundle) {
        log.info("[BundleServiceController] [developer] : Called with argument {}", bundle);
        return bundle.getDeveloper();
    }
}
