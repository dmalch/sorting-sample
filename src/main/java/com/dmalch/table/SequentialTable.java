package com.dmalch.table;

import java.util.LinkedList;

public class SequentialTable<K extends Comparable<K>, V> implements Table<K, V> {

    private final LinkedList<Entry<K, V>> storage = new LinkedList<Entry<K, V>>();

    @Override
    public void put(final K key, final V value) {
        storage.addFirst(new Entry<K, V>(key, value));
    }

    @Override
    public V get(final K key) {
        for (final Entry<K, V> entry : storage) {
            if (entry.key.compareTo(key) == 0) {
                return entry.value;
            }
        }
        return null;
    }

    @Override
    public void remove(final K key) {
        for (final Entry<K, V> entry : storage) {
            if (entry.key.compareTo(key) == 0) {
                storage.remove(entry);
            }
        }
    }

    private class Entry<K, V> {
        private final K key;
        private final V value;

        public Entry(final K key, final V value) {

            this.key = key;
            this.value = value;
        }
    }
}
