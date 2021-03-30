package com.github.hotire.spring.cache.local;

import org.junit.jupiter.api.Test;

import lombok.extern.slf4j.Slf4j;

@Slf4j
class LocalCacheTest {

    @Test
    void getCache() throws InterruptedException {
        // given
        final StringClient client = new StringClient();
        final LocalCache cache = new LocalCache(client);

        // when
        log.info(cache.getCache().getIfPresent("d"));
        try {
            log.info(cache.getCache().getUnchecked("d"));
        } catch (Exception e) {
            log.info(cache.getCache().getIfPresent("d"));
            log.info(cache.getCache().getIfPresent("d"));
            log.info(cache.getCache().getIfPresent("d"));
        }
        log.info(cache.getCache().getIfPresent("d"));
        log.info(cache.getCache().getUnchecked("d"));
        log.info(cache.getCache().getUnchecked("a"));
        log.info(cache.getCache().getUnchecked("b"));
        log.info(cache.getCache().getUnchecked("c"));

        Thread.sleep(1100);
        log.info(cache.getCache().getUnchecked("c"));
        log.info(cache.getCache().getUnchecked("d"));
        log.info(cache.getCache().getUnchecked("d"));
        Thread.sleep(1100);
        Thread.sleep(1100);
        log.info(cache.getCache().getUnchecked("d"));
        // no assert
    }
}