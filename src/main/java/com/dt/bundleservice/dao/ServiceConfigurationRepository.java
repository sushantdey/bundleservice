package com.dt.bundleservice.dao;

import com.dt.bundleservice.entity.ServiceConfiguration;
import org.springframework.data.repository.CrudRepository;

public interface ServiceConfigurationRepository extends CrudRepository<ServiceConfiguration, String> {
}
