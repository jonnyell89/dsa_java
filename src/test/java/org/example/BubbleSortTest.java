package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class BubbleSortTest {

    @Test
    void testBubbleSort() {

        int[] array = {15, 1, 14, 2, 13, 3, 12, 4, 11, 5, 10, 6, 9, 7, 8};

        BubbleSort.bubbleSort(array, array.length);

        assertTrue(Utils.isSorted(array, array.length));
    }
}
