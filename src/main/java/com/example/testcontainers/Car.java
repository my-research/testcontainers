package com.example.testcontainers;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Getter
@RequiredArgsConstructor
@ToString
public class Car {
    private final String name = "hello";
    private final int wheelCount = 4;
}
