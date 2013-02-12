package com.dmalch.priority;

public interface PriorityQueue<E extends Comparable<E>> {
    E[] addAllAndDeleteMax(E[] unsortedEvenArray, final Class<? extends E[]> aClass);

    void insert(E element);

    void deleteMax();
}
