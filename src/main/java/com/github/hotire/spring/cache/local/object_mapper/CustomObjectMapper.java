package com.github.hotire.spring.cache.local.object_mapper;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.module.paramnames.ParameterNamesModule;

/**
 * @see com.fasterxml.jackson.databind.ObjectMapper
 */
public class CustomObjectMapper extends ObjectMapper {

    void AddConstructorModule() {
        registerModule(new ParameterNamesModule());
    }
}
