package com.wonit.helper;

import org.testcontainers.containers.GenericContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.utility.DockerImageName;

public class TestcontainersHelper {
    @Container
    private final GenericContainer todoApplication = new GenericContainer(DockerImageName.parse("wonit:0.0.1"))
            .withExposedPorts(8080);

    public void start() {
        todoApplication.start();
    }

}
