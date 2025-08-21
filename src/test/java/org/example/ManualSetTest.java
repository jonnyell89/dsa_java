package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ManualSetTest {

    int[] array = new int[]{3, 17, 75, 80, 202};

    @Test
    void testManualSet() {

        ManualSet manualSet = new ManualSet();

        assertEquals(10, manualSet.getSet().length);
        assertEquals(0, manualSet.getSize());

        for (int i = 0; i < manualSet.getSet().length; i++) {

            assertEquals(0, manualSet.getSet()[i]);
        }
    }
}
