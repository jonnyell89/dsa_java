package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BinarySearchTest {

    @Test
    void testBinarySearch() {

        int[] sortedArray = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        for (int i = 0; i < sortedArray.length; i++) {

            assertEquals(i, BinarySearch.binarySearch(sortedArray, sortedArray.length, sortedArray[i]));
        }
    }
}
