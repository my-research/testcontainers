package com.example.testcontainers;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;

@SpringBootTest(classes = TestBeanSetting.class)
class TestcontainersApplicationTests {

    @Autowired
    ApplicationContext ctx;

    @Test
    void contextLoads() {
        Car car = ctx.getBean("car", Car.class);
        System.out.println("car = " + car);
    }
}
