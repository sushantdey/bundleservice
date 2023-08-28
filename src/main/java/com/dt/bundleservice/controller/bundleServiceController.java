package com.dt.bundleservice.controller;

import com.dt.bundleservice.entity.Bundle;
import com.dt.bundleservice.entity.Developer;
import com.dt.bundleservice.service.BundleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;

@Controller
public class bundleServiceController {

    @Autowired
    BundleService bundleService;

    @QueryMapping
    public Bundle bundleById(@Argument String id) {
        return bundleService.getBundleInfo(id);
    }

    @SchemaMapping
    public Developer developer(Bundle bundle) {
        return bundle.getDeveloper();
    }
}
