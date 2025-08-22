package org.example;

import org.junit.jupiter.api.Test;

import static org.example.Config.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ManualSetTest {

    int[] array = new int[]{3, 17, 75, 80, 202};

    @Test
    void testManualSetWithDefaultConstructor() {

        ManualSet manualSet = new ManualSet();

        assertEquals(MIN_CAPACITY, manualSet.getSet().length, String.format("Set length should be %d.", MIN_CAPACITY));
        assertEquals(0, manualSet.getSize(), String.format("Set size should be %d.", 0));

        for (int i = 0; i < manualSet.getSet().length; i++) {

            assertEquals(0, manualSet.getSet()[i], String.format("Element at set[%d] should be %d.", i, 0));
        }
    }

    @Test
    void testManualSetWithLengthLessThanZero() {

        int lengthLessThanZero = -5;

        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> new ManualSet(lengthLessThanZero),
                "Set length should not be negative.");
    }

    @Test
    void testManualSetWithLengthZero() {

        int lengthZero = 0;

        ManualSet manualSet = new ManualSet(lengthZero);

        assertEquals(MIN_CAPACITY, manualSet.getSet().length, String.format("Set length should be %d.", MIN_CAPACITY));
        assertEquals(0, manualSet.getSize(), String.format("Set size should be %d.", 0));

        for (int i = 0; i < manualSet.getSet().length; i++) {

            assertEquals(0, manualSet.getSet()[i], String.format("Element at set[%d] should be %d.", i, 0));
        }
    }

    @Test
    void testManualSetWithLengthLessThanDefault() {

        int lengthLessThanDefault = 5;

        ManualSet manualSet = new ManualSet(lengthLessThanDefault);

        assertEquals(MIN_CAPACITY, manualSet.getSet().length, String.format("Set length should be %d.", MIN_CAPACITY));
        assertEquals(0, manualSet.getSize(), String.format("Set size should be %d.", 0));

        for (int i = 0; i < manualSet.getSet().length; i++) {

            assertEquals(0, manualSet.getSet()[i], String.format("Element at set[%d] should be %d.", i, 0));
        }
    }

    @Test
    void testManualSetWithLengthGreaterThanDefault() {

        int lengthGreaterThanDefault = 15;

        ManualSet manualSet = new ManualSet(lengthGreaterThanDefault);

        assertEquals(MIN_CAPACITY * 2, manualSet.getSet().length, String.format("Set length should be %d.", MIN_CAPACITY * 2));
        assertEquals(0, manualSet.getSize(), String.format("Set size should be %d.", 0));

        for (int i = 0; i < manualSet.getSet().length; i++) {

            assertEquals(0, manualSet.getSet()[i], String.format("Element at set[%d] should be %d.", i, 0));
        }
    }
}
