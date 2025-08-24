package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BinarySearchTest {

    int[] sortedArray = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};
    int[] unsortedArray = {15, 1, 14, 2, 13, 3, 12, 4, 11, 5, 10, 6, 9, 7, 8};

    @Test
    void testIsSorted() {

        assertTrue(BinarySearch.isSorted(sortedArray, sortedArray.length));
        assertFalse(BinarySearch.isSorted(unsortedArray, unsortedArray.length));
    }

    @Test
    void testBinarySearch() {

        assertEquals(9, BinarySearch.binarySearch(sortedArray, sortedArray.length, 10));
    }
}
