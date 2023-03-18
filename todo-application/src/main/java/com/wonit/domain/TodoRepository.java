package com.wonit.domain;

import java.util.List;
import java.util.Optional;

public interface TodoRepository {
    List<Todo> findAll();

    Optional<Todo> findBy(Long id);

    void save(Todo todo);
}
