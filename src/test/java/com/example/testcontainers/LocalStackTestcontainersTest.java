package com.example.testcontainers;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.testcontainers.containers.localstack.LocalStackContainer.Service.S3;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.S3Object;
import java.io.IOException;
import java.nio.charset.Charset;
import lombok.extern.slf4j.Slf4j;
import org.junit.Rule;
import org.junit.jupiter.api.Test;
import org.testcontainers.containers.localstack.LocalStackContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;
import org.testcontainers.shaded.org.apache.commons.io.IOUtils;
import org.testcontainers.utility.DockerImageName;

@Slf4j
@Testcontainers
public class LocalStackTestcontainersTest {
    @Container
    private static final DockerImageName LOCALSTACK_NAME = DockerImageName.parse("localstack/localstack");

    @Rule
    public LocalStackContainer localStackContainer = new LocalStackContainer(LOCALSTACK_NAME).withServices(S3);

    @Test
    void name() throws IOException {
        AmazonS3 amazonS3 = AmazonS3ClientBuilder.standard()
                .withEndpointConfiguration(localStackContainer.getEndpointConfiguration(S3))
                .withCredentials(localStackContainer.getDefaultCredentialsProvider())
                .build();

        String bucketName = "woo";
        amazonS3.createBucket(bucketName);
        System.out.println("버킷 생성");

        String key = "aaaa";
        String content = "bbbbb";
        amazonS3.putObject(bucketName, key, content);
        System.out.println("파일 업로드");

        S3Object object = amazonS3.getObject(bucketName, key);
        System.out.println("object.getKey() = " + object.getKey());
        String key2 = object.getKey();
        String content2 = IOUtils.toString(object.getObjectContent(), Charset.forName("UTF-8"));

        assertAll(
                () -> assertEquals(content, content2),
                () -> assertEquals(key, key2)
        );
    }
}
