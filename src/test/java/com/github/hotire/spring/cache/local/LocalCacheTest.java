package com.github.hotire.spring.cache.local;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import lombok.extern.slf4j.Slf4j;

@Slf4j
class LocalCacheTest {

    @DisplayName("development")
    @Test
    void getCache() throws InterruptedException {
        // given
        final StringClient client = new StringClient();
        final LocalCache cache = new LocalCache(client);

        // no assert
        log.info("cache : {}", cache);
    }
}