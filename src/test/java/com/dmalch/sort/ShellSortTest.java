package com.dmalch.sort;

public class ShellSortTest extends AbstractSortTest {

    @Override
    protected Sort sort() {
        return new ShellSort();
    }

}
