package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class UtilsTest {

    int[] sortedArray = {1, 2, 3, 4, 7};
    int[] unsortedArray = {4, 2, 7, 1, 3};
    int[] duplicateArray = {3, 3, 1, 7, 9};

    @Test
    void testIsSorted() {

        assertTrue(Utils.isSorted(sortedArray, sortedArray.length), "Array should be sorted.");
        assertFalse(Utils.isSorted(unsortedArray, unsortedArray.length), "Array should not be sorted.");
    }

    @Test
    void testGetLargestElement() {

        int largestElementInArray = 7;

        assertEquals(largestElementInArray, Utils.getLargestElement(sortedArray), String.format("Array should contain %d as the largest element.", largestElementInArray));
        assertEquals(largestElementInArray, Utils.getLargestElement(unsortedArray), String.format("Array should contain %d as the largest element.", largestElementInArray));
    }

    @Test
    void testIsDuplicate() {

        int elementPresentInArray = 7;
        int elementNotPresentInArray = 5;

        assertTrue(Utils.isDuplicate(sortedArray, elementPresentInArray), String.format("Array should contain %d.", elementPresentInArray));
        assertFalse(Utils.isDuplicate(unsortedArray, elementNotPresentInArray), String.format("Array should not contain %d.", elementNotPresentInArray));
    }

    @Test
    void testHasDuplicateQuadraticTime() {

        assertTrue(Utils.hasDuplicate(duplicateArray), "Array should contain duplicate elements.");
        assertFalse(Utils.hasDuplicate(sortedArray), "Array should not contain duplicate elements.");
        assertFalse(Utils.hasDuplicate(unsortedArray), "Array should not contain duplicate elements.");
    }

    @Test
    void testHasDuplicateLinearTime() {

        assertTrue(Utils.hasDuplicate(duplicateArray, Utils.getLargestElement(duplicateArray)), "Array should contain duplicate elements.");
        assertFalse(Utils.hasDuplicate(sortedArray, Utils.getLargestElement(sortedArray)), "Array should not contain duplicate elements.");
        assertFalse(Utils.hasDuplicate(unsortedArray, Utils.getLargestElement(unsortedArray)), "Array should not contain duplicate elements.");
    }
}
