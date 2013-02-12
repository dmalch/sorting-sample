package com.dmalch.priority;

public interface PriorityQueue<E extends Comparable<E>> {
    Object[] addAllAndDeleteMax(E[] unsortedEvenArray);

    void insert(E element);

    void deleteMax();
}
