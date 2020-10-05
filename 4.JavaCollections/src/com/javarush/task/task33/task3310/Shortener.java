package com.javarush.task.task33.task3310;

import com.javarush.task.task33.task3310.strategy.StorageStrategy;

public class Shortener {
    private Long lastId = 0L;
    private StorageStrategy storageStrategy;

    public Shortener(StorageStrategy storageStrategy) {
        this.storageStrategy = storageStrategy;
    }

    public synchronized Long getId(String string) {
        Long id;
        if (storageStrategy.containsValue(string)) {
            id = storageStrategy.getKey(string);
        } else {
            id = ++lastId;
            storageStrategy.put(lastId, string);
        }
        return id;
    }

    public synchronized String getString(Long id) {
        return storageStrategy.getValue(id);
    }
}
