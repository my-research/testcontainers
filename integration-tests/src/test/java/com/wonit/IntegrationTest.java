package com.wonit;

import com.wonit.helper.TestcontainersHelper;
import org.junit.jupiter.api.Test;
import org.testcontainers.containers.GenericContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.utility.DockerImageName;

public class IntegrationTest {

    TestcontainersHelper container = new TestcontainersHelper();

    @Test
    void name() {
        container.start();
    }
}
