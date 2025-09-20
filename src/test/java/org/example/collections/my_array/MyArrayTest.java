package org.example.collections.my_array;

import org.example.collections.MyArray;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MyArrayTest {

    private static final int DEFAULT_CAPACITY = 10;
    public final int[] array = new int[]{3, 17, 75, 80, 202};

    // INSTANTIATION
    @Test
    void testMyArrayWithDefaultConstructor() {
        MyArray myArray = new MyArray();
        assertEquals(DEFAULT_CAPACITY, myArray.getCapacity(), String.format("MyArray capacity should be %d.", DEFAULT_CAPACITY));
        assertEquals(0, myArray.getSize(), String.format("MyArray size should be %d", 0));
        int[] defaultArray = new int[DEFAULT_CAPACITY];
        assertArrayEquals(defaultArray, myArray.getData(), String.format("MyArray should contain %d zeros.", DEFAULT_CAPACITY));
    }

    @Test
    void testMyArrayWithCapacityLessThanZero() {
        int capacityLessThanZero = -5;
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> new MyArray(capacityLessThanZero),
                "MyArray capacity should not be negative."
        );
    }

    @Test
    void testMyArrayWithCapacityZero() {
        int capacityZero = 0;
        MyArray myArray = new MyArray(capacityZero);
        assertEquals(DEFAULT_CAPACITY, myArray.getCapacity(), String.format("MyArray capacity should be %d.", DEFAULT_CAPACITY));
        assertEquals(0, myArray.getSize(), String.format("MyArray size should be %d.", 0));
        int[] defaultArray = new int[DEFAULT_CAPACITY];
        assertArrayEquals(defaultArray, myArray.getData(), String.format("MyArray should contain %d zeros.", DEFAULT_CAPACITY));
    }

    @Test
    void testMyArrayWithCapacityLessThanDefault() {
        int capacityLessThanDefault = 5;
        MyArray myArray = new MyArray(capacityLessThanDefault);
        assertEquals(DEFAULT_CAPACITY, myArray.getCapacity(), String.format("MyArray capacity should be %d.", DEFAULT_CAPACITY));
        assertEquals(0, myArray.getSize(), String.format("MyArray size should be %d.", 0));
        int[] defaultArray = new int[DEFAULT_CAPACITY];
        assertArrayEquals(defaultArray, myArray.getData(), String.format("MyArray should contain %d zeros.", DEFAULT_CAPACITY));
    }

    @Test
    void testMyArrayWithCapacityGreaterThanDefault() {
        int capacityGreaterThanDefault = 15;
        MyArray myArray = new MyArray(capacityGreaterThanDefault);
        assertEquals(DEFAULT_CAPACITY * 2, myArray.getCapacity(), String.format("MyArray capacity should be %d.", DEFAULT_CAPACITY * 2));
        assertEquals(0, myArray.getSize(), String.format("MyArray size should be %d.", 0));
        int[] defaultArray = new int[DEFAULT_CAPACITY * 2];
        assertArrayEquals(defaultArray, myArray.getData(), String.format("MyArray should contain %d zeros.", DEFAULT_CAPACITY * 2));
    }

    @Test
    void testMyArrayWithNullArray() {
        NullPointerException exception = assertThrows(
                NullPointerException.class,
                () -> new MyArray(null),
                "MyArray should not be null."
        );
    }

    @Test
    void testMyArrayWithEmptyArray() {
        int[] emptyArray = new int[]{};
        MyArray myArray = new MyArray(emptyArray);
        assertEquals(DEFAULT_CAPACITY, myArray.getCapacity(), String.format("MyArray capacity should be %d.", DEFAULT_CAPACITY));
        assertEquals(0, myArray.getSize(), String.format("MyArray size should be %d.", 0));
        int[] defaultArray = new int[DEFAULT_CAPACITY];
        assertArrayEquals(defaultArray, myArray.getData(), String.format("MyArray should contain %d zeros.", DEFAULT_CAPACITY));
    }

    @Test
    void testMyArrayWithArrayCapacityLessThanDefault() {
        int capacityLessThanDefault = 5;
        int[] inputArray = new int[capacityLessThanDefault];
        MyArray myArray = new MyArray(inputArray);
        assertEquals(DEFAULT_CAPACITY, myArray.getCapacity(), String.format("MyArray capacity should be %d.", DEFAULT_CAPACITY));
        assertEquals(inputArray.length, myArray.getSize(), String.format("MyArray size should be %d.", inputArray.length));
        assertArrayEquals(inputArray, myArray.toArray(), String.format("MyArray should contain %d zeros.", capacityLessThanDefault));
    }

    @Test
    void testMyArrayWithArrayCapacityGreaterThanDefault() {
        int capacityGreaterThanDefault = 15;
        int[] inputArray = new int[capacityGreaterThanDefault];
        MyArray myArray = new MyArray(inputArray);
        assertEquals(DEFAULT_CAPACITY * 2, myArray.getCapacity(), String.format("MyArray capacity should be %d.", DEFAULT_CAPACITY * 2));
        assertEquals(inputArray.length, myArray.getSize(), String.format("MyArray size should be %d.", inputArray.length));
        assertArrayEquals(inputArray, myArray.toArray(), String.format("MyArray should contain %d zeros.", capacityGreaterThanDefault));
    }
}
