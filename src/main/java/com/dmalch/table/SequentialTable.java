package com.dmalch.table;

public class SequentialTable<K extends Comparable<K>, V> implements Table<K, V> {

    private Node root = null;

    @Override
    public void put(final K key, final V value) {
        final Node node = new Node(key, value);

        node.next = root;

        root = node;
    }

    @Override
    public V get(final K key) {

        Node current = root;

        while (current != null) {
            if (current.key.compareTo(key) == 0) {
                return current.value;
            }

            current = current.next;
        }

        return null;
    }

    @Override
    public void remove(final K key) {
        if (root == null) {
            return;
        }

        if (root.key.compareTo(key) == 0) {
            root = root.next;
            return;
        }

        Node current = root;

        while (current.next != null) {
            if (current.next.key.compareTo(key) == 0) {
                current.next = current.next.next;
                break;
            }

            current = current.next;
        }
    }

    private class Node {
        private final K key;
        private final V value;
        public Node next;

        public Node(final K key, final V value) {
            this.key = key;
            this.value = value;
        }
    }
}
