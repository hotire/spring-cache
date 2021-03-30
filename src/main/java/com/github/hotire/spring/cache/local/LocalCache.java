package com.github.hotire.spring.cache.local;

import java.util.concurrent.TimeUnit;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Getter
@RequiredArgsConstructor
public class LocalCache {
    private final StringClient stringClient;
    private final LoadingCache<String, String> cache = CacheBuilder.newBuilder()
                                                                   .expireAfterWrite(1, TimeUnit.SECONDS)
                                                                   .build(new CacheLoader<>() {
                                                                        @Override
                                                                        public String load(String key) throws Exception {
                                                                            try {
                                                                                log.info("load cache");
                                                                                cache.putAll(stringClient.getAll());
                                                                                return cache.getUnchecked(key);
                                                                            } catch (Exception e) {
                                                                                log.error(e.getMessage(), e);
                                                                            }
                                                                            return "empty";
                                                                        }
                                                                    });
}
