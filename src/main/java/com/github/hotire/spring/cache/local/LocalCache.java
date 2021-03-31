package com.github.hotire.spring.cache.local;

import java.util.concurrent.TimeUnit;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
public class LocalCache {
    private final StringClient stringClient;
    private final LoadingCache<String, String> cache = CacheBuilder.newBuilder()
                                                                   .expireAfterWrite(1, TimeUnit.SECONDS)
                                                                   .build(new CacheLoader<>() {
                                                                       @Override
                                                                       public String load(String key) {
                                                                           log.info("load cache");
                                                                           cache.putAll(stringClient.getAll());
                                                                           return get(key);
                                                                       }
                                                                   });

    public String get(final String key) {
        try {
            return cache.getUnchecked(key);
        } catch (Exception e) {
            return "empty";
        }
    }
}
