package com.dmalch.sort;

public class TopDownHeapSortTest extends AbstractSortTest {

    @Override
    protected Sort sort() {
        return new TopDownHeapSort();
    }

}
