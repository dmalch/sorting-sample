package com.dmalch.table;

public interface Table<K extends Comparable<K>, V> {
    void put(K key, V value);

    V get(K key);

    void remove(K key);
}
