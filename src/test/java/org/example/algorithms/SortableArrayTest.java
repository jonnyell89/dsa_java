package org.example.algorithms;

import org.example.collections.MyArray;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class SortableArrayTest {

    @Test
    void testPartition() {
        int[] array = new int[]{0, 5, 2, 1, 6, 3};
        MyArray myArray = new MyArray(array);
        SortableArray sortableArray = new SortableArray(myArray);
        int leftPointer = sortableArray.partition(0, myArray.getSize() - 1);
        int[] result = new int[]{0, 1, 2, 3, 6, 5};
        assertArrayEquals(result, myArray.toArray(), "LeftPointer should be equal to result.");
    }

    @Test
    void testQuicksort() {
        int[] array = new int[]{0, 5, 2, 1, 6, 3};
        MyArray myArray = new MyArray(array);
        SortableArray sortableArray = new SortableArray(myArray);
        sortableArray.quicksort(0, myArray.getSize() - 1);
        int[] result = new int[]{0, 1, 2, 3, 5, 6};
        assertArrayEquals(result, myArray.toArray(), "ManualArray should be equal to result.");
    }

    @Test
    void testQuickselect() {
        int[] array = new int[]{0, 50, 20, 10, 60, 30};
        MyArray myArray = new MyArray(array);
        SortableArray sortableArray = new SortableArray(myArray);
        int secondLowestValue = sortableArray.quickselect(1, 0, myArray.getSize() - 1);
        int result = 10;
        assertEquals(result, secondLowestValue, "SecondLowestValue should be equal to result.");
    }

    @Test
    void testMergeSort() {
        int[] array = new int[]{0, 5, 2, 1, 6, 3};
        MyArray myArray = new MyArray(array);
        SortableArray sortableArray = new SortableArray(myArray);
        sortableArray.mergeSort(0, myArray.getSize() - 1);
        int[] result = new int[]{0, 1, 2, 3, 5, 6};
        assertArrayEquals(result, myArray.toArray(), "ManualArray should be equal to result.");
    }

    @Test
    void testHasDuplicate() {
        int[] array = new int[]{5, 9, 3, 2, 4, 5, 6};
        MyArray myArray = new MyArray(array);
        SortableArray sortableArray = new SortableArray(myArray);
        boolean hasDuplicate = sortableArray.hasDuplicate();
        boolean result = true;
        assertEquals(result, hasDuplicate, "HasDuplicate should be equal to result.");
    }

    @Test
    void testGreatestProduct() {
        int[] array = new int[]{5, 9, 3, 2, 4, 5, 6};
        MyArray myArray = new MyArray(array);
        SortableArray sortableArray = new SortableArray(myArray);
        int greatestProduct = sortableArray.greatestProduct();
        int result = 270;
        assertEquals(result, greatestProduct, "GreatestProduct should be equal to result.");
    }

    @Test
    void testFindMissingNumber() {
        int[] array = new int[]{0, 5, 2, 1, 6, 3};
        MyArray myArray = new MyArray(array);
        SortableArray sortableArray = new SortableArray(myArray);
        int missingNumber = sortableArray.findMissingNumber();
        int result = 4;
        assertEquals(result, missingNumber, "MissingNumber should be equal to result.");
    }

    @Test
    void testGreatestNumberSlow() {
        int[] array = new int[]{5, 9, 3, 2, 4, 5, 6};
        MyArray myArray = new MyArray(array);
        SortableArray sortableArray = new SortableArray(myArray);
        int greatestNumber = sortableArray.greatestNumberSlow();
        int result = 9;
        assertEquals(result, greatestNumber, "GreatestNumber should be equal to result.");
    }

    @Test
    void testGreatestNumberMedium() {
        int[] array = new int[]{5, 9, 3, 2, 4, 5, 6};
        MyArray myArray = new MyArray(array);
        SortableArray sortableArray = new SortableArray(myArray);
        int greatestNumber = sortableArray.greatestNumberMedium();
        int result = 9;
        assertEquals(result, greatestNumber, "GreatestNumber should be equal to result.");
    }

    @Test
    void testGreatestNumberFast() {
        int[] array = new int[]{5, 9, 3, 2, 4, 5, 6};
        MyArray myArray = new MyArray(array);
        SortableArray sortableArray = new SortableArray(myArray);
        int greatestNumber = sortableArray.greatestNumberFast();
        int result = 9;
        assertEquals(result, greatestNumber, "GreatestNumber should be equal to result.");
    }
}
