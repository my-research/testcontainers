package com.wonit.domain;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Todo {

    private final Long id;
    private final String name;
    private Status status;

    public static Todo newTodo(String name) {
        return new Todo(System.currentTimeMillis(), name, Status.TODO);
    }

    public static Todo loadFromDB(Long id, String name, Status status) {
        return new Todo(id, name, status);
    }
}
