package com.iub.summitpower.core;

import java.util.Map;

public interface BaseRepository<K, V> {

    V getById(String username);
    Map<K, V> getAllData();
    boolean add(V user);
    int countAll();
}
