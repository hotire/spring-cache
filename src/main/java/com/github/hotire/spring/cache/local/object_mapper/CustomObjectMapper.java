package com.github.hotire.spring.cache.local.object_mapper;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.deser.BeanDeserializer;
import com.fasterxml.jackson.module.paramnames.ParameterNamesModule;

/**
 * @see com.fasterxml.jackson.databind.ObjectMapper
 */
public class CustomObjectMapper extends ObjectMapper {

    /**
     * @see com.fasterxml.jackson.databind.deser.BeanDeserializer#deserializeFromObjectUsingNonDefault(JsonParser, DeserializationContext)
     * @see BeanDeserializer#creatorProperties()
     */
    void addConstructorModule() {
        registerModule(new ParameterNamesModule());
    }
}
