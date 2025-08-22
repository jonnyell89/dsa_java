package org.example;

import org.junit.jupiter.api.Test;

import static org.example.Config.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ManualArrayTest {

    int[] array = new int[]{3, 17, 75, 80, 202};

    @Test
    void testManualArrayDefault() {

        ManualArray manualArray = new ManualArray();

        assertEquals(MIN_CAPACITY, manualArray.getArray().length);
        assertEquals(DEFAULT_SIZE, manualArray.getSize());

        for (int i = 0; i < manualArray.getArray().length; i++) {

            assertEquals(DEFAULT_ELEMENT, manualArray.getArray()[i]);
        }
    }
}
