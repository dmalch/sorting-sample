package com.dmalch.table;

public class BinarySearchTreeTable<K extends Comparable<K>, V> implements Table<K, V> {

    private Node root;

    @Override
    public void put(final K key, final V value) {
        root = createNodeIfNull(root, key);
        put(root, key, value);
    }

    private void put(final Node root, final K key, final V value) {
        final int cmp = root.key.compareTo(key);
        if (cmp == 0) {
            root.value = value;
        } else if (cmp > 0) {
            root.left = createNodeIfNull(root.left, key);
            put(root.left, key, value);
        } else {
            root.right = createNodeIfNull(root.right, key);
            put(root.right, key, value);
        }
    }

    private Node createNodeIfNull(final Node original, final K key) {
        if (original == null) {
            final Node node = new Node();
            node.key = key;
            return node;
        }
        return original;
    }

    @Override
    public V get(final K key) {
        return get(root, key);
    }

    private V get(final Node root, final K key) {

        if (root == null) {
            return null;
        }

        final int cmp = root.key.compareTo(key);

        if (cmp == 0) {
            return root.value;
        } else if (cmp > 0) {
            return get(root.left, key);
        } else if (cmp < 0) {
            return get(root.right, key);
        }
        return null;
    }

    @Override
    public void remove(final K key) {
        root = remove(root, key);
    }

    private Node remove(final Node root, final K key) {
        final int cmp = root.key.compareTo(key);
        if (cmp == 0) {
            if (root.right == null) {

                if (root.left == null) {
                    return null;
                }

                return root.left;
            }

            final Node replacement = min(root.right);
            final Node right = deleteMin(root.right);

            replacement.left = root.left;
            replacement.right = right;
            return replacement;
        } else if (cmp > 0) {
            root.left = remove(root.left, key);
        } else {
            root.right = remove(root.right, key);
        }
        return root;
    }

    private Node deleteMin(final Node node) {
        if (node.left == null) {
            return node.right;
        }
        node.left = deleteMin(node.left);
        return node;
    }

    private Node min(final Node node) {
        if (node.left == null) {
            return node;
        }
        return min(node.left);
    }

    private class Node {
        public K key;
        public V value;
        public Node left;
        public Node right;

        @Override
        public String toString() {
            return "Node{" +
                    "key=" + key +
                    ", value=" + value +
                    '}';
        }
    }
}
