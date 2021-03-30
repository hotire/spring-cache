package com.github.hotire.spring.cache.local;

import java.util.Map;

public class StringClient {

    public Map<String, String> getAll() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return Map.of("a", "a", "b", "b", "c", "c");
    }

    public Map<String, String> throwException() {
        throw new RuntimeException();
    }
}
