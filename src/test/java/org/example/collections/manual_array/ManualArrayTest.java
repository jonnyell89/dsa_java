package org.example.collections.manual_array;

import org.example.collections.MyArray;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ManualArrayTest {

    private static final int DEFAULT_CAPACITY = 10;
    public final int[] array = new int[]{3, 17, 75, 80, 202};

    // INSTANTIATION
    @Test
    void testManualArrayWithDefaultConstructor() {
        MyArray manualArray = new MyArray();
        assertEquals(DEFAULT_CAPACITY, manualArray.getCapacity(), String.format("ManualArray capacity should be %d.", DEFAULT_CAPACITY));
        assertEquals(0, manualArray.getSize(), String.format("ManualArray size should be %d", 0));
        int[] defaultArray = new int[DEFAULT_CAPACITY];
        assertArrayEquals(defaultArray, manualArray.getData(), String.format("ManualArray should contain %d zeros.", DEFAULT_CAPACITY));
    }

    @Test
    void testManualArrayWithCapacityLessThanZero() {
        int capacityLessThanZero = -5;
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> new MyArray(capacityLessThanZero),
                "ManualArray capacity should not be negative."
        );
    }

    @Test
    void testManualArrayWithCapacityZero() {
        int capacityZero = 0;
        MyArray manualArray = new MyArray(capacityZero);
        assertEquals(DEFAULT_CAPACITY, manualArray.getCapacity(), String.format("ManualArray capacity should be %d.", DEFAULT_CAPACITY));
        assertEquals(0, manualArray.getSize(), String.format("ManualArray size should be %d.", 0));
        int[] defaultArray = new int[DEFAULT_CAPACITY];
        assertArrayEquals(defaultArray, manualArray.getData(), String.format("ManualArray should contain %d zeros.", DEFAULT_CAPACITY));
    }

    @Test
    void testManualArrayWithCapacityLessThanDefault() {
        int capacityLessThanDefault = 5;
        MyArray manualArray = new MyArray(capacityLessThanDefault);
        assertEquals(DEFAULT_CAPACITY, manualArray.getCapacity(), String.format("ManualArray capacity should be %d.", DEFAULT_CAPACITY));
        assertEquals(0, manualArray.getSize(), String.format("ManualArray size should be %d.", 0));
        int[] defaultArray = new int[DEFAULT_CAPACITY];
        assertArrayEquals(defaultArray, manualArray.getData(), String.format("ManualArray should contain %d zeros.", DEFAULT_CAPACITY));
    }

    @Test
    void testManualArrayWithCapacityGreaterThanDefault() {
        int capacityGreaterThanDefault = 15;
        MyArray manualArray = new MyArray(capacityGreaterThanDefault);
        assertEquals(DEFAULT_CAPACITY * 2, manualArray.getCapacity(), String.format("ManualArray capacity should be %d.", DEFAULT_CAPACITY * 2));
        assertEquals(0, manualArray.getSize(), String.format("ManualArray size should be %d.", 0));
        int[] defaultArray = new int[DEFAULT_CAPACITY * 2];
        assertArrayEquals(defaultArray, manualArray.getData(), String.format("ManualArray should contain %d zeros.", DEFAULT_CAPACITY * 2));
    }

    @Test
    void testManualArrayWithNullArray() {
        NullPointerException exception = assertThrows(
                NullPointerException.class,
                () -> new MyArray(null),
                "ManualArray should not be null."
        );
    }

    @Test
    void testManualArrayWithEmptyArray() {
        int[] emptyArray = new int[]{};
        MyArray manualArray = new MyArray(emptyArray);
        assertEquals(DEFAULT_CAPACITY, manualArray.getCapacity(), String.format("ManualArray capacity should be %d.", DEFAULT_CAPACITY));
        assertEquals(0, manualArray.getSize(), String.format("ManualArray size should be %d.", 0));
        int[] defaultArray = new int[DEFAULT_CAPACITY];
        assertArrayEquals(defaultArray, manualArray.getData(), String.format("ManualArray should contain %d zeros.", DEFAULT_CAPACITY));
    }

    @Test
    void testManualArrayWithArrayCapacityLessThanDefault() {
        int capacityLessThanDefault = 5;
        int[] inputArray = new int[capacityLessThanDefault];
        MyArray manualArray = new MyArray(inputArray);
        assertEquals(DEFAULT_CAPACITY, manualArray.getCapacity(), String.format("ManualArray capacity should be %d.", DEFAULT_CAPACITY));
        assertEquals(inputArray.length, manualArray.getSize(), String.format("ManualArray size should be %d.", inputArray.length));
        assertArrayEquals(inputArray, manualArray.toArray(), String.format("ManualArray should contain %d zeros.", capacityLessThanDefault));
    }

    @Test
    void testManualArrayWithArrayCapacityGreaterThanDefault() {
        int capacityGreaterThanDefault = 15;
        int[] inputArray = new int[capacityGreaterThanDefault];
        MyArray manualArray = new MyArray(inputArray);
        assertEquals(DEFAULT_CAPACITY * 2, manualArray.getCapacity(), String.format("ManualArray capacity should be %d.", DEFAULT_CAPACITY * 2));
        assertEquals(inputArray.length, manualArray.getSize(), String.format("ManualArray size should be %d.", inputArray.length));
        assertArrayEquals(inputArray, manualArray.toArray(), String.format("ManualArray should contain %d zeros.", capacityGreaterThanDefault));
    }
}
