package com.dmalch;

public class HeapSortTest extends AbstractSortTest {

    @Override
    protected Sort sort() {
        return new HeapSort();
    }

}
