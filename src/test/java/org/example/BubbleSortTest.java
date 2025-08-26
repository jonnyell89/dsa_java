package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class BubbleSortTest {

    @Test
    void testBubbleSort() {

        int[] unsortedArray = {4, 2, 7, 1, 3};

        BubbleSort.bubbleSort(unsortedArray, unsortedArray.length);

        assertTrue(Utils.isSorted(unsortedArray, unsortedArray.length));

        int[] sortedArray = {1, 2, 3, 4, 7};

        assertArrayEquals(sortedArray, unsortedArray);
    }
}
