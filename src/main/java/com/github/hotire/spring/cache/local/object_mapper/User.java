package com.github.hotire.spring.cache.local.object_mapper;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class User {
    private final String name;
    private final Integer age;
}
