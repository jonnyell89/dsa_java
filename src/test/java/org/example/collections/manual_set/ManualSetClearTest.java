package org.example.collections.manual_set;

import org.example.collections.ManualSet;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class ManualSetClearTest {

    private static final int DEFAULT_CAPACITY = 10;

    // CLEAR
    @Test
    void testManualSetClearEmptyArray() {
        int[] emptyArray = new int[]{};
        ManualSet manualSet = new ManualSet();
        manualSet.clear();
        assertArrayEquals(emptyArray, manualSet.toArray(), "ManualSet should be equal to emptyArray.");
    }

    @Test
    void testManualSetClear() {
        int[] array = new int[]{1, 2, 3, 4, 5};
        ManualSet manualSet = new ManualSet(array);
        manualSet.clear();
        int[] emptyArray = new int[]{};
        assertArrayEquals(emptyArray, manualSet.toArray(), "ManualSet should be equal to emptyArray.");
    }
}
