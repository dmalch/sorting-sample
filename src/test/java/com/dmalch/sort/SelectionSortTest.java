package com.dmalch.sort;

public class SelectionSortTest extends AbstractSortTest {

    @Override
    protected Sort sort() {
        return new SelectionSort();
    }

}
