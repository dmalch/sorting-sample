package com.dmalch.priority;

public interface PriorityQueue {
    Integer[] addAllAndDeleteMax(Integer[] unsortedEvenArray);

    void insert(Integer element);

    void deleteMax();
}
