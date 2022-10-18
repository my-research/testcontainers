package com.example.testcontainers;

import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;

@TestConfiguration
public class TestBeanSetting {
    @Bean
    public Car car() {
        return new Car();
    }
}
