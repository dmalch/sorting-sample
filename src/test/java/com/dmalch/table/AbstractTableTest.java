package com.dmalch.table;

import org.junit.Test;

import java.util.List;

import static java.util.Arrays.asList;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.nullValue;

public abstract class AbstractTableTest {
    @Test
    public void testAddAndGetValues() throws Exception {
        final Table<Integer, Integer> table = givenTable();

        final List<Integer> keys = asList(1, 2, 3, 6, 5, 4);
        final List<Integer> values = asList(1, 2, 3, 6, 5, 4);

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
        table.put(2, 2);
        table.put(3, 3);
        table.remove(1);
        table.remove(2);
        table.remove(3);

        assertThat(table.get(1), nullValue());
        assertThat(table.get(2), nullValue());
        assertThat(table.get(3), nullValue());
    }

    protected abstract Table<Integer, Integer> givenTable();
}
