package com.dmalch.sort;

public class HeapSortTest extends AbstractSortTest {

    @Override
    protected Sort sort() {
        return new HeapSort();
    }

}
