package com.wonit.app;

import com.wonit.domain.Todo;
import com.wonit.domain.TodoRepositoryInMemoryImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/todos")
@RequiredArgsConstructor
public class TodoController {
    private final TodoRepositoryInMemoryImpl repository;

    @PostMapping
    public ResponseEntity<Void> create(@RequestBody Map<String, String> createRequestBody) {
        repository.save(Todo.newTodo(createRequestBody.get("name")));
        return ResponseEntity.status(HttpStatus.ACCEPTED).build();
    }

    @GetMapping
    public ResponseEntity<List<Todo>> findAll() {
        return ResponseEntity.ok(repository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Todo> findBy(@PathVariable Long id) {
        return ResponseEntity.ok(repository.findBy(id).orElseThrow());
    }
}
