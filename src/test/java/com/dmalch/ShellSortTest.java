package com.dmalch;

public class ShellSortTest extends AbstractSortTest {

    @Override
    protected Sort sort() {
        return new ShellSort();
    }

}
