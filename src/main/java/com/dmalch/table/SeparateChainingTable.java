package com.dmalch.table;

public class SeparateChainingTable<K extends Comparable<K>, V> implements Table<K, V> {

    private final SequentialTable<K, V>[] sequentialTables;
    private final int capacity;

    public SeparateChainingTable(final int capacity) {
        this.capacity = capacity;
        sequentialTables = new SequentialTable[capacity];
        for (int i = 0; i < capacity; i++) {
            sequentialTables[i] = new SequentialTable<K, V>();
        }
    }

    @Override
    public void put(final K key, final V value) {
        sequentialTables[indexFor(key)].put(key, value);
    }

    private int indexFor(final K key) {
        return key.hashCode() % capacity;
    }

    @Override
    public V get(final K key) {
        return sequentialTables[indexFor(key)].get(key);
    }

    @Override
    public void remove(final K key) {
        sequentialTables[indexFor(key)].remove(key);
    }
}
