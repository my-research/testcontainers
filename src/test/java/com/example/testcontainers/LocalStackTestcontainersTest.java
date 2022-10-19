package com.example.testcontainers;

import lombok.extern.slf4j.Slf4j;
import org.testcontainers.containers.localstack.LocalStackContainer;
import org.testcontainers.containers.localstack.LocalStackContainer.Service;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;
import org.testcontainers.utility.DockerImageName;

@Slf4j
@Testcontainers
public class LocalStackTestcontainersTest {
    @Container
    LocalStackContainer container = new LocalStackContainer(DockerImageName.parse(Service.S3.getLocalStackName()));
    // LocalStackContainer container = new LocalStackContainer.Service(Service.S3.getLocalStackName(), 9121);

}
