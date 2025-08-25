package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class UtilsTest {

    int[] sortedArray = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};
    int[] unsortedArray = {15, 1, 14, 2, 13, 3, 12, 4, 11, 5, 10, 6, 9, 7, 8};

    @Test
    void testIsSorted() {

        assertTrue(Utils.isSorted(sortedArray, sortedArray.length));
        assertFalse(Utils.isSorted(unsortedArray, unsortedArray.length));
    }
}
