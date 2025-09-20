package org.example.collections.my_set;

import org.example.collections.MySet;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MySetTest {

    private static final int DEFAULT_CAPACITY = 10;

    // INSTANTIATION
    @Test
    void testMySetWithDefaultConstructor() {
        MySet mySet = new MySet();
        assertEquals(DEFAULT_CAPACITY, mySet.getCapacity(), String.format("MySet capacity should be %d.", DEFAULT_CAPACITY));
        assertEquals(0, mySet.getSize(), String.format("MySet size should be %d", 0));
        int[] defaultArray = new int[DEFAULT_CAPACITY];
        assertArrayEquals(defaultArray, mySet.getData(), String.format("MySet should contain %d zeros.", DEFAULT_CAPACITY));
    }

    @Test
    void testMySetWithCapacityLessThanZero() {
        int capacityLessThanZero = -5;
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> new MySet(capacityLessThanZero),
                "MySet capacity should not be negative."
        );
    }

    @Test
    void testMySetWithCapacityZero() {
        int capacityZero = 0;
        MySet mySet = new MySet(capacityZero);
        assertEquals(DEFAULT_CAPACITY, mySet.getCapacity(), String.format("MySet capacity should be %d.", DEFAULT_CAPACITY));
        assertEquals(0, mySet.getSize(), String.format("MySet size should be %d.", 0));
        int[] defaultArray = new int[DEFAULT_CAPACITY];
        assertArrayEquals(defaultArray, mySet.getData(), String.format("MySet should contain %d zeros.", DEFAULT_CAPACITY));
    }

    @Test
    void testMySetWithCapacityLessThanDefault() {
        int capacityLessThanDefault = 5;
        MySet mySet = new MySet(capacityLessThanDefault);
        assertEquals(DEFAULT_CAPACITY, mySet.getCapacity(), String.format("MySet capacity should be %d.", DEFAULT_CAPACITY));
        assertEquals(0, mySet.getSize(), String.format("MySet size should be %d.", 0));
        int[] defaultArray = new int[DEFAULT_CAPACITY];
        assertArrayEquals(defaultArray, mySet.getData(), String.format("MySet should contain %d zeros.", DEFAULT_CAPACITY));
    }

    @Test
    void testMySetWithCapacityGreaterThanDefault() {
        int capacityGreaterThanDefault = 15;
        MySet mySet = new MySet(capacityGreaterThanDefault);
        assertEquals(DEFAULT_CAPACITY * 2, mySet.getCapacity(), String.format("MySet capacity should be %d.", DEFAULT_CAPACITY * 2));
        assertEquals(0, mySet.getSize(), String.format("MySet size should be %d.", 0));
        int[] defaultArray = new int[DEFAULT_CAPACITY * 2];
        assertArrayEquals(defaultArray, mySet.getData(), String.format("MySet should contain %d zeros.", DEFAULT_CAPACITY * 2));
    }

    @Test
    void testMySetWithNullArray() {
        NullPointerException exception = assertThrows(
                NullPointerException.class,
                () -> new MySet(null),
                "MySet should not be null."
        );
    }

    @Test
    void testMySetWithEmptyArray() {
        int[] emptyArray = new int[]{};
        MySet mySet = new MySet(emptyArray);
        assertEquals(DEFAULT_CAPACITY, mySet.getCapacity(), String.format("MySet capacity should be %d.", DEFAULT_CAPACITY));
        assertEquals(0, mySet.getSize(), String.format("MySet size should be %d.", 0));
        int[] defaultArray = new int[DEFAULT_CAPACITY];
        assertArrayEquals(defaultArray, mySet.getData(), String.format("MySet should contain %d zeros.", DEFAULT_CAPACITY));
    }

    @Test
    void testMySetWithSetCapacityLessThanDefault() {
        int[] setWithCapacityLessThanDefault = new int[]{1, 2, 3, 4, 5};
        MySet mySet = new MySet(setWithCapacityLessThanDefault);
        assertEquals(DEFAULT_CAPACITY, mySet.getCapacity(), String.format("MySet capacity should be %d.", DEFAULT_CAPACITY));
        assertEquals(setWithCapacityLessThanDefault.length, mySet.getSize(), String.format("MySet size should be %d.", setWithCapacityLessThanDefault.length));
        assertArrayEquals(setWithCapacityLessThanDefault, mySet.toArray(), "MySet should be equal to setWithCapacityLessThanDefault.");
    }

    @Test
    void testMySetWithSetCapacityGreaterThanDefault() {
        int[] setWithCapacityGreaterThanDefault = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};
        MySet mySet = new MySet(setWithCapacityGreaterThanDefault);
        assertEquals(DEFAULT_CAPACITY * 2, mySet.getCapacity(), String.format("MySet capacity should be %d.", DEFAULT_CAPACITY * 2));
        assertEquals(setWithCapacityGreaterThanDefault.length, mySet.getSize(), String.format("MySet size should be %d.", setWithCapacityGreaterThanDefault.length));
        assertArrayEquals(setWithCapacityGreaterThanDefault, mySet.toArray(), "MySet should be equal to setWithCapacityGreaterThanDefault.");
    }

    @Test
    void testMySetWithArrayWithDuplicates() {
        int[] arrayWithDuplicates = new int[]{1, 1, 2, 2, 3, 3, 4, 4, 5, 5};
        MySet mySet = new MySet(arrayWithDuplicates);
        assertEquals(DEFAULT_CAPACITY, mySet.getCapacity(), String.format("MySet capacity should be %d.", DEFAULT_CAPACITY));
        int[] arrayWithoutDuplicates = new int[]{1, 2, 3, 4, 5};
        assertEquals(arrayWithoutDuplicates.length, mySet.getSize(), String.format("MySet size should be %d.", arrayWithoutDuplicates.length));
        assertArrayEquals(arrayWithoutDuplicates, mySet.toArray(), "MySet should be equal to arrayWithoutDuplicates.");
    }
}
