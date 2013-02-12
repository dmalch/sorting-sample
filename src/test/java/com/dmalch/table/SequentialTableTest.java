package com.dmalch.table;

import org.junit.Test;

import java.util.List;

import static java.util.Arrays.asList;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.nullValue;

public class SequentialTableTest {
    @Test
    public void testAddAndGetValues() throws Exception {
        final Table<Integer, Integer> table = givenTable();

        final List<Integer> keys = asList(1, 2, 3);
        final List<Integer> values = asList(1, 2, 3);

        for (int i = 0; i < keys.size(); i++) {
            table.put(keys.get(i), values.get(i));
        }

        for (int i = 0; i < keys.size(); i++) {
            assertThat(table.get(keys.get(i)), equalTo(values.get(i)));
        }
    }

    @Test
    public void testOverwriteValues() throws Exception {
        final Table<Integer, Integer> table = givenTable();

        table.put(1, 1);
        table.put(1, 2);

        assertThat(table.get(1), equalTo(2));
    }

    @Test
    public void testRemove() throws Exception {
        final Table<Integer, Integer> table = givenTable();

        table.put(1, 1);
        table.remove(1);

        assertThat(table.get(1), nullValue());
    }

    private Table<Integer, Integer> givenTable() {
        return new SequentialTable<Integer, Integer>();
    }
}
