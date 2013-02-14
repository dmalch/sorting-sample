package com.dmalch.table;

public class SeparateChainingTableTest extends AbstractTableTest {

    @Override
    protected Table<Integer, Integer> givenTable() {
        return new SeparateChainingTable<Integer, Integer>(10);
    }
}
