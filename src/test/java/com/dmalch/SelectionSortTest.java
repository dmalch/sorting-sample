package com.dmalch;

public class SelectionSortTest extends AbstractSortTest {

    @Override
    protected Sort sort() {
        return new SelectionSort();
    }

}
