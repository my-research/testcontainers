package com.wonit.domain;

import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class TodoRepositoryInMemoryImpl implements TodoRepository {
    private final Map<Long, Todo> storage = new HashMap<>();

    @Override
    public List<Todo> findAll() {
        return new ArrayList<>(storage.values());
    }

    @Override
    public Optional<Todo> findBy(Long id) {
        return Optional.ofNullable(storage.get(id));
    }

    @Override
    public void save(Todo todo) {
        storage.put(todo.getId(), todo);
    }
}
