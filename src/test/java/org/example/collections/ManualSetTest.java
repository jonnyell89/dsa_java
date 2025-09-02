package org.example.collections;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ManualSetTest {

    private static final int DEFAULT_CAPACITY = 10;

    // INSTANTIATION
    @Test
    void testManualSetWithDefaultConstructor() {
        ManualSet manualSet = new ManualSet();
        assertEquals(DEFAULT_CAPACITY, manualSet.getData().getCapacity(), String.format("ManualSet capacity should be %d.", DEFAULT_CAPACITY));
        assertEquals(0, manualSet.getData().getSize(), String.format("ManualSet size should be %d", 0));
        int[] defaultArray = new int[DEFAULT_CAPACITY];
        assertArrayEquals(defaultArray, manualSet.getData().getData(), String.format("ManualSet should contain %d zeros.", DEFAULT_CAPACITY));
    }

    @Test
    void testManualSetWithCapacityLessThanZero() {
        int capacityLessThanZero = -5;
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> new ManualSet(capacityLessThanZero),
                "ManualSet capacity should not be negative."
        );
    }

    @Test
    void testManualSetWithCapacityZero() {
        int capacityZero = 0;
        ManualSet manualSet = new ManualSet(capacityZero);
        assertEquals(DEFAULT_CAPACITY, manualSet.getData().getCapacity(), String.format("ManualSet capacity should be %d.", DEFAULT_CAPACITY));
        assertEquals(0, manualSet.getData().getSize(), String.format("ManualSet size should be %d.", 0));
        int[] defaultArray = new int[DEFAULT_CAPACITY];
        assertArrayEquals(defaultArray, manualSet.getData().getData(), String.format("ManualSet should contain %d zeros.", DEFAULT_CAPACITY));
    }

    @Test
    void testManualSetWithCapacityLessThanDefault() {
        int capacityLessThanDefault = 5;
        ManualSet manualSet = new ManualSet(capacityLessThanDefault);
        assertEquals(DEFAULT_CAPACITY, manualSet.getData().getCapacity(), String.format("ManualSet capacity should be %d.", DEFAULT_CAPACITY));
        assertEquals(0, manualSet.getData().getSize(), String.format("ManualSet size should be %d.", 0));
        int[] defaultArray = new int[DEFAULT_CAPACITY];
        assertArrayEquals(defaultArray, manualSet.getData().getData(), String.format("ManualSet should contain %d zeros.", DEFAULT_CAPACITY));
    }

    @Test
    void testManualSetWithCapacityGreaterThanDefault() {
        int capacityGreaterThanDefault = 15;
        ManualSet manualSet = new ManualSet(capacityGreaterThanDefault);
        assertEquals(DEFAULT_CAPACITY * 2, manualSet.getData().getCapacity(), String.format("ManualSet capacity should be %d.", DEFAULT_CAPACITY * 2));
        assertEquals(0, manualSet.getData().getSize(), String.format("ManualSet size should be %d.", 0));
        int[] defaultArray = new int[DEFAULT_CAPACITY * 2];
        assertArrayEquals(defaultArray, manualSet.getData().getData(), String.format("ManualSet should contain %d zeros.", DEFAULT_CAPACITY * 2));
    }

    @Test
    void testManualSetWithNullArray() {
        NullPointerException exception = assertThrows(
                NullPointerException.class,
                () -> new ManualSet(null),
                "ManualSet should not be null."
        );
    }

    @Test
    void testManualSetWithEmptyArray() {
        int[] emptyArray = new int[]{};
        ManualSet manualSet = new ManualSet(emptyArray);
        assertEquals(DEFAULT_CAPACITY, manualSet.getData().getCapacity(), String.format("ManualSet capacity should be %d.", DEFAULT_CAPACITY));
        assertEquals(0, manualSet.getData().getSize(), String.format("ManualSet size should be %d.", 0));
        int[] defaultArray = new int[DEFAULT_CAPACITY];
        assertArrayEquals(defaultArray, manualSet.getData().getData(), String.format("ManualSet should contain %d zeros.", DEFAULT_CAPACITY));
    }

    @Test
    void testManualSetWithSetCapacityLessThanDefault() {
        int[] setWithCapacityLessThanDefault = new int[]{1, 2, 3, 4, 5};
        ManualSet manualSet = new ManualSet(setWithCapacityLessThanDefault);
        assertEquals(DEFAULT_CAPACITY, manualSet.getData().getCapacity(), String.format("ManualSet capacity should be %d.", DEFAULT_CAPACITY));
        assertEquals(setWithCapacityLessThanDefault.length, manualSet.getData().getSize(), String.format("ManualSet size should be %d.", setWithCapacityLessThanDefault.length));
        assertArrayEquals(setWithCapacityLessThanDefault, manualSet.getData().toArray(), "ManualSet should be equal to setWithCapacityLessThanDefault.");
    }

    @Test
    void testManualSetWithSetCapacityGreaterThanDefault() {
        int[] setWithCapacityGreaterThanDefault = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};
        ManualSet manualSet = new ManualSet(setWithCapacityGreaterThanDefault);
        assertEquals(DEFAULT_CAPACITY * 2, manualSet.getData().getCapacity(), String.format("ManualSet capacity should be %d.", DEFAULT_CAPACITY * 2));
        assertEquals(setWithCapacityGreaterThanDefault.length, manualSet.getData().getSize(), String.format("ManualSet size should be %d.", setWithCapacityGreaterThanDefault.length));
        assertArrayEquals(setWithCapacityGreaterThanDefault, manualSet.getData().toArray(), "ManualSet should be equal to setWithCapacityGreaterThanDefault.");
    }

    @Test
    void testManualSetWithArrayWithDuplicates() {
        int[] arrayWithDuplicates = new int[]{1, 1, 2, 2, 3, 3, 4, 4, 5, 5};
        int[] arrayWithoutDuplicates = new int[]{1, 2, 3, 4, 5};
        ManualSet manualSet = new ManualSet(arrayWithDuplicates);
        assertEquals(DEFAULT_CAPACITY, manualSet.getData().getCapacity(), String.format("ManualSet capacity should be %d.", DEFAULT_CAPACITY));
        assertEquals(arrayWithoutDuplicates.length, manualSet.getData().getSize(), String.format("ManualSet size should be %d.", arrayWithoutDuplicates.length));
        assertArrayEquals(arrayWithoutDuplicates, manualSet.getData().toArray(), "ManualSet should be equal to arrayWithoutDuplicates.");
    }

    @Test
    void testManualSetAddDuplicateElement() {
        int[] array = new int[]{1, 2, 3, 4, 5};
        int elementToAdd = 5;
        ManualSet manualSet = new ManualSet(array);
        assertFalse(manualSet.add(elementToAdd));
        assertArrayEquals(array, manualSet.getData().toArray());
    }

    @Test
    void testManualSetAddElement() {
        int[] array = new int[]{1, 2, 3, 4, 5};
        int elementToAdd = 7;
        int[] arrayWithElementAdded = new int[]{1, 2, 3, 4, 5, 7};
        ManualSet manualSet = new ManualSet(array);
        assertTrue(manualSet.add(elementToAdd));
        assertArrayEquals(arrayWithElementAdded, manualSet.getData().toArray());
    }
}
