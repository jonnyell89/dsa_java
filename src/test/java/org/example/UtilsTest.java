package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class UtilsTest {

    int[] sortedArray = {1, 2, 3, 4, 7};
    int[] unsortedArray = {4, 2, 7, 1, 3};

    @Test
    void testIsSorted() {

        assertTrue(Utils.isSorted(sortedArray, sortedArray.length));
        assertFalse(Utils.isSorted(unsortedArray, unsortedArray.length));
    }
}
