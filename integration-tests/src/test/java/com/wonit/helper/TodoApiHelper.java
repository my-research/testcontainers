package com.wonit.helper;

import org.springframework.web.client.RestTemplate;

public class TodoApiHelper {

    public static final String TODO_API_BASE_URL = "http://localhost:8080/todos";
    private final RestTemplate template = new RestTemplate();

    public void postTodo() {
        template.postForEntity(TODO_API_BASE_URL, )
    }
}
