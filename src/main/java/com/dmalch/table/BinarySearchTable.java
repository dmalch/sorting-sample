package com.dmalch.table;

import static java.lang.System.arraycopy;

public class BinarySearchTable<K extends Comparable<K>, V> implements Table<K, V> {

    private K[] keys;
    private V[] values;
    private int actualSize = 0;

    public BinarySearchTable(final int size) {
        keys = (K[]) new Comparable[size];
        values = (V[]) new Object[size];
    }

    @Override
    public void put(final K key, final V value) {
        final int index = find(key);

        if (keys[index] != null && keys[index].compareTo(key) != 0) {
            shiftArraysAfter(index, 1);
            actualSize++;
        }

        if (keys[index] == null) {
            actualSize++;
        }

        keys[index] = key;
        values[index] = value;
    }

    private void shiftArraysAfter(final int index, final int delta) {
        arraycopy(keys, index, keys, index + delta, actualSize - index);
        arraycopy(values, index, values, index + delta, actualSize - index);
    }

    private int find(final K key) {
        int start = 0;
        int end = actualSize;

        while (start < end) {
            final int mid = start + (end - start - 1) / 2;

            if (keys[mid].compareTo(key) == 0) {
                return mid;
            } else if (keys[mid].compareTo(key) > 0) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return start;
    }

    @Override
    public V get(final K key) {
        return values[find(key)];
    }

    @Override
    public void remove(final K key) {
        final int index = find(key);

        keys[index] = null;
        values[index] = null;

        shiftArraysAfter(index + 1, -1);

        actualSize--;
    }
}
