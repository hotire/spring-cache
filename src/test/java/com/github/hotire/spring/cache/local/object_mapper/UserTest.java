package com.github.hotire.spring.cache.local.object_mapper;

import org.junit.jupiter.api.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.module.paramnames.ParameterNamesModule;

class UserTest {

    @Test
    void cast() throws JsonProcessingException {
        // given
        final User user = new User("hello", 10);
        final ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new ParameterNamesModule());

        // when
        final String json = objectMapper.writeValueAsString(user);
        final User result = objectMapper.readValue(json, User.class);

        // no assert
    }
}