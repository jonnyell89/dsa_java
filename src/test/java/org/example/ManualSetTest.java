package org.example;

import org.junit.jupiter.api.Test;

import static org.example.Config.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ManualSetTest {

    int[] array = new int[]{3, 17, 75, 80, 202};

    @Test
    void testManualSetDefault() {

        ManualSet manualSet = new ManualSet();

        assertEquals(MIN_CAPACITY, manualSet.getSet().length);
        assertEquals(DEFAULT_SIZE, manualSet.getSize());

        for (int i = 0; i < manualSet.getSet().length; i++) {

            assertEquals(DEFAULT_ELEMENT, manualSet.getSet()[i]);
        }
    }
}
