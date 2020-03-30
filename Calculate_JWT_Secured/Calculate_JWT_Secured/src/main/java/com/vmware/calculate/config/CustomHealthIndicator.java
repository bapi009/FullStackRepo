package com.vmware.calculate.config;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

@Component
public class CustomHealthIndicator  implements HealthIndicator {

    @Override
    public Health health() {
        Health health = Health.up().withDetail("Details","Server is up").build();
        return health;
    }
}
