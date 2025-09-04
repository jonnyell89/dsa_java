package org.example.collections.manual_set;

import org.example.collections.ManualSet;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ManualSetRemoveTest {

    private static final int DEFAULT_CAPACITY = 10;

    // REMOVE
    @Test
    void testManualSetRemoveElementFromEmptyArray() {
        int elementToRemove = 0;
        ManualSet manualSet = new ManualSet();
        assertFalse(manualSet.remove(elementToRemove), "ManualSet does not contain elementToRemove.");
    }

    @Test
    void testManualSetRemoveElementNotPresentInArray() {
        int elementNotPresentInArray = 0;
        int[] array = new int[]{1, 2, 3, 4, 5};
        ManualSet manualSet = new ManualSet(array);
        assertFalse(manualSet.remove(elementNotPresentInArray), "ManualSet does not contain elementNotPresentInSet.");
        assertArrayEquals(array, manualSet.toArray(), "ManualSet should be equal to array.");
    }

    @Test
    void testManualSetRemoveElement() {
        int elementToRemove = 5;
        int[] array = new int[]{1, 2, 3, 4, 5};
        ManualSet manualSet = new ManualSet(array);
        assertTrue(manualSet.remove(elementToRemove), "ManualSet should remove elementToRemove.");
        int[] arrayWithElementRemoved = new int[]{1, 2, 3, 4};
        assertArrayEquals(arrayWithElementRemoved, manualSet.toArray(), "ManualSet should be equal to arrayWithElementRemoved.");
    }

    @Test
    void testManualSetRemoveAllElementsFromEmptyArray() {
        int[] elementsToRemove = new int[]{1, 2, 3, 4, 5};
        ManualSet manualSet = new ManualSet();
        assertFalse(manualSet.removeAll(elementsToRemove), "ManualSet does not contain elementsToRemove.");
    }

    @Test
    void testManualSetRemoveAllElementsNotPresentInArray() {
        int[] elementsNotPresentInArray = new int[]{6, 7, 8, 9, 10};
        int[] array = new int[]{1, 2, 3, 4, 5};
        ManualSet manualSet = new ManualSet(array);
        assertFalse(manualSet.removeAll(elementsNotPresentInArray), "ManualSet does not contain elementsNotPresentInSet.");
        assertArrayEquals(array, manualSet.toArray(), "ManualSet should be equal to array.");
    }

    @Test
    void testManualSetRemoveAllElements() {
        int[] elementsToRemove = new int[]{1, 2, 3, 4, 5};
        int[] array = new int[]{1, 2, 3, 4, 5};
        ManualSet manualSet = new ManualSet(array);
        assertTrue(manualSet.removeAll(elementsToRemove), "ManualSet should remove elementsToRemove.");
        int[] arrayWithElementsRemoved = new int[]{};
        assertArrayEquals(arrayWithElementsRemoved, manualSet.toArray(), "ManualSet should be equal to arrayWithElementsRemoved.");
    }
}
