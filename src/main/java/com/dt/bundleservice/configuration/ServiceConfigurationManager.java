package com.dt.bundleservice.configuration;

import com.dt.bundleservice.dao.ServiceConfigurationRepository;
import com.dt.bundleservice.entity.ServiceConfiguration;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.TimerTask;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@Component
@Data
public class ServiceConfigurationManager {

    private final Map<String, String> configMap = new ConcurrentHashMap<>();
    private final TimerTask tt;
    private final ScheduledExecutorService executorService = Executors.newSingleThreadScheduledExecutor();
    private long interval = 5;
    @Autowired
    private ServiceConfigurationRepository serviceConfigurationRepository;

    @Autowired
    public ServiceConfigurationManager() {
        tt = new ServiceConfigurationLoader();
        loadConfigFromDB();
        executorService.scheduleAtFixedRate(tt, interval, interval, TimeUnit.MINUTES);
    }

    private class ServiceConfigurationLoader extends TimerTask {

        @Override
        public void run() {
            loadConfigFromDB();
        }
    }

    private void loadConfigFromDB() {
        Iterable<ServiceConfiguration> serviceConfigurations = serviceConfigurationRepository.findAll();
        for (ServiceConfiguration serviceConfiguration :
                serviceConfigurations) {
            configMap.put(serviceConfiguration.getKey(), serviceConfiguration.getValue());
        }
    }
}