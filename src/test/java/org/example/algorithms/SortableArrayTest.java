package org.example.algorithms;

import org.example.collections.ManualArray;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class SortableArrayTest {

    @Test
    void testQuicksort() {
        int[] array = new int[]{0, 5, 2, 1, 6, 3};
        ManualArray manualArray = new ManualArray(array);
        SortableArray sortableArray = new SortableArray(manualArray);
        sortableArray.quicksort(0, manualArray.getSize() - 1);
        int[] result = new int[]{0, 1, 2, 3, 5, 6};
        assertArrayEquals(result, manualArray.toArray(), "ManualArray should be equal to result.");
    }

    @Test
    void testQuickselect() {
        int[] array = new int[]{0, 50, 20, 10, 60, 30};
        ManualArray manualArray = new ManualArray(array);
        SortableArray sortableArray = new SortableArray(manualArray);
        int secondLowestValue = sortableArray.quickselect(1, 0, manualArray.getSize() - 1);
        int result = 10;
        assertEquals(result, secondLowestValue, "SecondLowestValue should be equal to result.");
    }
}
