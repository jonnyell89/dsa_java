package org.example.collections.manual_array;

import org.example.collections.ManualArray;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ManualArraySearchTest {

    private static final int DEFAULT_CAPACITY = 10;
    public final int[] array = new int[]{3, 17, 75, 80, 202};

    // SEARCH
    @Test
    void testManualArraySearchWithInvalidElement() {
        int elementNotPresentInArray = 10;
        ManualArray manualArray = new ManualArray(array);
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> manualArray.search(elementNotPresentInArray),
                "Element should not be present in ManualArray."
        );
    }

    @Test
    void testManualArraySearchWithValidElement() {
        ManualArray manualArray = new ManualArray(array);
        for (int i = 0; i < manualArray.getSize(); i++) {
            int element = array[i];
            assertEquals(i, manualArray.search(element), String.format("Element at manualArray[%d] should return the index %d.", i, i));
        }
    }
}
