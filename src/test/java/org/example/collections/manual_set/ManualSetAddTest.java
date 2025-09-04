package org.example.collections.manual_set;

import org.example.collections.ManualSet;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ManualSetAddTest {

    private static final int DEFAULT_CAPACITY = 10;

    // ADD
    @Test
    void testManualSetAddDuplicateElement() {
        int[] array = new int[]{1, 2, 3, 4, 5};
        int elementToAdd = 5;
        ManualSet manualSet = new ManualSet(array);
        assertFalse(manualSet.add(elementToAdd), "ManualSet should not add a duplicate element.");
        assertArrayEquals(array, manualSet.toArray(), "ManualSet should be equal to array.");
    }

    @Test
    void testManualSetAddNonDuplicateElement() {
        int[] array = new int[]{1, 2, 3, 4, 5};
        int elementToAdd = 7;
        ManualSet manualSet = new ManualSet(array);
        assertTrue(manualSet.add(elementToAdd), "ManualSet should add a non-duplicate element.");
        int[] arrayWithElementAdded = new int[]{1, 2, 3, 4, 5, 7};
        assertArrayEquals(arrayWithElementAdded, manualSet.toArray(), "ManualSet should be equal to arrayWithElementAdded.");
    }

    @Test
    void testManualSetAddAllToEmptyArray() {
        ManualSet manualSet = new ManualSet();
        int[] array = new int[]{1, 2, 3, 4, 5};
        assertTrue(manualSet.addAll(array), "ManualSet should add all elements.");
        assertArrayEquals(array, manualSet.toArray(), "ManualSet should be equal to array.");
    }

    @Test
    void testManualSetAddAllWithDuplicateElements() {
        int[] array = new int[]{1, 2, 3, 4, 5};
        ManualSet manualSet = new ManualSet(array);
        int[] arrayWithDuplicateElements = new int[] {1, 2, 3, 4, 5};
        assertFalse(manualSet.addAll(arrayWithDuplicateElements), "ManualSet should not add duplicate elements.");
        assertArrayEquals(array, manualSet.toArray(), "ManualSet should be equal to array.");
    }

    @Test
    void testManualSetAddAllWithSomeDuplicateElements() {
        int[] array = new int[]{1, 2, 3, 4, 5};
        ManualSet manualSet = new ManualSet(array);
        int[] arrayWithSomeDuplicateElements = new int[]{1, 2, 3, 4, 5, 7, 7};
        assertTrue(manualSet.addAll(arrayWithSomeDuplicateElements), "ManualSet should add all non-duplicate elements.");
        int[] arrayWithElementsAdded = new int[]{1, 2, 3, 4, 5, 7};
        assertArrayEquals(arrayWithElementsAdded, manualSet.toArray(), "ManualSet should be equal to arrayWithElementsAdded.");
    }

    @Test
    void testManualSetAddAllWithNonDuplicateElements() {
        int[] array = new int[]{1, 2, 3, 4, 5};
        ManualSet manualSet = new ManualSet(array);
        int[] arrayWithNonDuplicateElements = new int[]{6, 7, 8, 9, 10};
        assertTrue(manualSet.addAll(arrayWithNonDuplicateElements), "ManualSet should add all elements.");
        int[] arrayWithElementsAdded = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        assertArrayEquals(arrayWithElementsAdded, manualSet.toArray(), "ManualSet should be equal to arrayWithElementsAdded.");
    }
}
