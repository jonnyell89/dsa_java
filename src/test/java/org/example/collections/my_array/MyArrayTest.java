package org.example.collections.my_array;

import org.example.collections.MyArray;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class MyArrayTest {

    private static final int DEFAULT_CAPACITY = 10;

    // INSTANTIATION
    @Test
    void testMyArrayWithDefaultConstructor() {
        MyArray<Integer> myArray = new MyArray<>();
        assertEquals(DEFAULT_CAPACITY, myArray.getCapacity(), String.format("MyArray capacity should be %d.", DEFAULT_CAPACITY));
        assertEquals(0, myArray.getSize(), String.format("MyArray size should be %d", 0));
        Integer[] defaultArray = new Integer[DEFAULT_CAPACITY];
        assertArrayEquals(defaultArray, myArray.getData(), String.format("MyArray should contain %d zeros.", DEFAULT_CAPACITY));
    }

    @Test
    void testMyArrayWithCapacityLessThanZero() {
        int capacityLessThanZero = -5;
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> new MyArray<Integer>(capacityLessThanZero),
                "MyArray capacity should not be negative."
        );
    }

    @Test
    void testMyArrayWithCapacityZero() {
        int capacityZero = 0;
        MyArray<Integer> myArray = new MyArray<>(capacityZero);
        assertEquals(DEFAULT_CAPACITY, myArray.getCapacity(), String.format("MyArray capacity should be %d.", DEFAULT_CAPACITY));
        assertEquals(0, myArray.getSize(), String.format("MyArray size should be %d.", 0));
        Integer[] defaultArray = new Integer[DEFAULT_CAPACITY];
        assertArrayEquals(defaultArray, myArray.getData(), String.format("MyArray should contain %d zeros.", DEFAULT_CAPACITY));
    }

    @Test
    void testMyArrayWithCapacityLessThanDefault() {
        int capacityLessThanDefault = 5;
        MyArray<Integer> myArray = new MyArray<>(capacityLessThanDefault);
        assertEquals(DEFAULT_CAPACITY, myArray.getCapacity(), String.format("MyArray capacity should be %d.", DEFAULT_CAPACITY));
        assertEquals(0, myArray.getSize(), String.format("MyArray size should be %d.", 0));
        Integer[] defaultArray = new Integer[DEFAULT_CAPACITY];
        assertArrayEquals(defaultArray, myArray.getData(), String.format("MyArray should contain %d zeros.", DEFAULT_CAPACITY));
    }

    @Test
    void testMyArrayWithCapacityGreaterThanDefault() {
        int capacityGreaterThanDefault = 15;
        MyArray<Integer> myArray = new MyArray<>(capacityGreaterThanDefault);
        assertEquals(DEFAULT_CAPACITY * 2, myArray.getCapacity(), String.format("MyArray capacity should be %d.", DEFAULT_CAPACITY * 2));
        assertEquals(0, myArray.getSize(), String.format("MyArray size should be %d.", 0));
        Integer[] defaultArray = new Integer[DEFAULT_CAPACITY * 2];
        assertArrayEquals(defaultArray, myArray.getData(), String.format("MyArray should contain %d zeros.", DEFAULT_CAPACITY * 2));
    }

    @Test
    void testMyArrayWithNullCollection() {
        NullPointerException exception = assertThrows(
                NullPointerException.class,
                () -> new MyArray<Integer>((List<Integer>) null),
                "MyArray should not be null."
        );
    }

    @Test
    void testMyArrayWithEmptyCollection() {
        List<Integer> emptyList = Collections.emptyList();
        MyArray<Integer> myArray = new MyArray<>(emptyList);
        assertEquals(DEFAULT_CAPACITY, myArray.getCapacity(), String.format("MyArray capacity should be %d.", DEFAULT_CAPACITY));
        assertEquals(0, myArray.getSize(), String.format("MyArray size should be %d.", 0));
        Integer[] defaultArray = new Integer[DEFAULT_CAPACITY];
        assertArrayEquals(defaultArray, myArray.getData(), String.format("MyArray should contain %d zeros.", DEFAULT_CAPACITY));
    }

    @Test
    void testMyArrayWithCollectionCapacityLessThanDefault() {
        List<Integer> inputList = Arrays.asList(1, 2, 3, 4, 5);
        MyArray<Integer> myArray = new MyArray<>(inputList);
        assertEquals(DEFAULT_CAPACITY, myArray.getCapacity(), String.format("MyArray capacity should be %d.", DEFAULT_CAPACITY));
        assertEquals(inputList.size(), myArray.getSize(), String.format("MyArray size should be %d.", inputList.size()));
        Integer[] result = new Integer[]{1, 2, 3, 4, 5};
        assertArrayEquals(result, myArray.toArray(), "MyArray should be equal to result.");
    }

    @Test
    void testMyArrayWithCollectionCapacityGreaterThanDefault() {
        List<Integer> inputList = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15);
        MyArray<Integer> myArray = new MyArray<>(inputList);
        assertEquals(DEFAULT_CAPACITY * 2, myArray.getCapacity(), String.format("MyArray capacity should be %d.", DEFAULT_CAPACITY * 2));
        assertEquals(inputList.size(), myArray.getSize(), String.format("MyArray size should be %d.", inputList.size()));
        Integer[] result = new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};
        assertArrayEquals(result, myArray.toArray(), "MyArray should be equal to result.");
    }
}
