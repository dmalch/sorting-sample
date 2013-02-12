package com.dmalch.sort;

import static com.dmalch.sort.SortUtils.less;
import static com.dmalch.sort.SortUtils.swap;

public final class HeapUtils {
    public static <T extends Comparable<T>> void siftDown(final T[] unsortedArray, final int start, final int end) {
        int root = start;

        while (root * 2 + 1 <= end) {
            final int child = root * 2 + 1;
            int swap = root;

            if (less(unsortedArray[root], unsortedArray[child])) {
                swap = child;
            }

            if (child + 1 <= end && less(unsortedArray[swap], unsortedArray[child + 1])) {
                swap = child + 1;
            }

            if (swap != root) {
                swap(unsortedArray, root, swap);
                root = swap;
            } else {
                break;
            }
        }
    }

    public static <T extends Comparable<T>> void siftUp(final T[] unsortedArray, final int start, final int end) {

        int child = end;

        while (child > start && less(unsortedArray[child / 2], unsortedArray[child])) {
            swap(unsortedArray, child / 2, child);
            child /= 2;
        }
    }
}
