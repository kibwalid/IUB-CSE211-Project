package com.iub.summitpower.core.repositories;

import java.util.Map;

public interface BaseRepository<K, V> {

    V getById(K key);
    Map<K, V> getAllData();
    boolean add(V user);
    int countAll();
}
