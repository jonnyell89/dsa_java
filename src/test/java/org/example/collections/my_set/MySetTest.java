package org.example.collections.my_set;

import org.example.collections.MySet;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class MySetTest {

    private static final int DEFAULT_CAPACITY = 10;

    // INSTANTIATION
    @Test
    void testMySetWithDefaultConstructor() {
        MySet<Integer> mySet = new MySet<>();
        assertEquals(DEFAULT_CAPACITY, mySet.getCapacity(), String.format("MySet capacity should be %d.", DEFAULT_CAPACITY));
        assertEquals(0, mySet.getSize(), String.format("MySet size should be %d", 0));
        Integer[] defaultArray = new Integer[DEFAULT_CAPACITY];
        assertArrayEquals(defaultArray, mySet.getData(), String.format("MySet should contain %d zeros.", DEFAULT_CAPACITY));
    }

    @Test
    void testMySetWithCapacityLessThanZero() {
        int capacityLessThanZero = -5;
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> new MySet<>(capacityLessThanZero),
                "MySet capacity should not be negative."
        );
    }

    @Test
    void testMySetWithCapacityZero() {
        int capacityZero = 0;
        MySet<Integer> mySet = new MySet<>(capacityZero);
        assertEquals(DEFAULT_CAPACITY, mySet.getCapacity(), String.format("MySet capacity should be %d.", DEFAULT_CAPACITY));
        assertEquals(0, mySet.getSize(), String.format("MySet size should be %d.", 0));
        Integer[] defaultArray = new Integer[DEFAULT_CAPACITY];
        assertArrayEquals(defaultArray, mySet.getData(), String.format("MySet should contain %d zeros.", DEFAULT_CAPACITY));
    }

    @Test
    void testMySetWithCapacityLessThanDefault() {
        int capacityLessThanDefault = 5;
        MySet<Integer> mySet = new MySet<>(capacityLessThanDefault);
        assertEquals(DEFAULT_CAPACITY, mySet.getCapacity(), String.format("MySet capacity should be %d.", DEFAULT_CAPACITY));
        assertEquals(0, mySet.getSize(), String.format("MySet size should be %d.", 0));
        Integer[] defaultArray = new Integer[DEFAULT_CAPACITY];
        assertArrayEquals(defaultArray, mySet.getData(), String.format("MySet should contain %d zeros.", DEFAULT_CAPACITY));
    }

    @Test
    void testMySetWithCapacityGreaterThanDefault() {
        int capacityGreaterThanDefault = 15;
        MySet<Integer> mySet = new MySet<>(capacityGreaterThanDefault);
        assertEquals(DEFAULT_CAPACITY * 2, mySet.getCapacity(), String.format("MySet capacity should be %d.", DEFAULT_CAPACITY * 2));
        assertEquals(0, mySet.getSize(), String.format("MySet size should be %d.", 0));
        Integer[] defaultArray = new Integer[DEFAULT_CAPACITY * 2];
        assertArrayEquals(defaultArray, mySet.getData(), String.format("MySet should contain %d zeros.", DEFAULT_CAPACITY * 2));
    }

    @Test
    void testMySetWithNullCollection() {
        NullPointerException exception = assertThrows(
                NullPointerException.class,
                () -> new MySet<>(null),
                "MySet should not be null."
        );
    }

    @Test
    void testMySetWithEmptyCollection() {
        List<Integer> emptyList = Collections.emptyList();
        MySet<Integer> mySet = new MySet<>(emptyList);
        assertEquals(DEFAULT_CAPACITY, mySet.getCapacity(), String.format("MySet capacity should be %d.", DEFAULT_CAPACITY));
        assertEquals(0, mySet.getSize(), String.format("MySet size should be %d.", 0));
        Integer[] defaultArray = new Integer[DEFAULT_CAPACITY];
        assertArrayEquals(defaultArray, mySet.getData(), String.format("MySet should contain %d zeros.", DEFAULT_CAPACITY));
    }

    @Test
    void testMySetWithCollectionCapacityLessThanDefault() {
        List<Integer> listWithCapacityLessThanDefault = Arrays.asList(1, 2, 3, 4, 5);
        MySet<Integer> mySet = new MySet<>(listWithCapacityLessThanDefault);
        assertEquals(DEFAULT_CAPACITY, mySet.getCapacity(), String.format("MySet capacity should be %d.", DEFAULT_CAPACITY));
        assertEquals(listWithCapacityLessThanDefault.size(), mySet.getSize(), String.format("MySet size should be %d.", listWithCapacityLessThanDefault.size()));
        Integer[] result = new Integer[]{1, 2, 3, 4, 5};
        assertArrayEquals(result, mySet.toArray(), "MySet should be equal to result.");
    }

    @Test
    void testMySetWithCollectionCapacityGreaterThanDefault() {
        List<Integer> listWithCapacityGreaterThanDefault = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15);
        MySet<Integer> mySet = new MySet<>(listWithCapacityGreaterThanDefault);
        assertEquals(DEFAULT_CAPACITY * 2, mySet.getCapacity(), String.format("MySet capacity should be %d.", DEFAULT_CAPACITY * 2));
        assertEquals(listWithCapacityGreaterThanDefault.size(), mySet.getSize(), String.format("MySet size should be %d.", listWithCapacityGreaterThanDefault.size()));
        Integer[] result = new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};
        assertArrayEquals(result, mySet.toArray(), "MySet should be equal to result.");
    }

    @Test
    void testMySetWithCollectionWithDuplicates() {
        List<Integer> listWithDuplicates = Arrays.asList(1, 1, 2, 2, 3, 3, 4, 4, 5, 5);
        MySet<Integer> mySet = new MySet<>(listWithDuplicates);
        assertEquals(DEFAULT_CAPACITY, mySet.getCapacity(), String.format("MySet capacity should be %d.", DEFAULT_CAPACITY));
        Integer[] result = new Integer[]{1, 2, 3, 4, 5};
        assertEquals(result.length, mySet.getSize(), String.format("MySet size should be %d.", result.length));
        assertArrayEquals(result, mySet.toArray(), "MySet should be equal to result.");
    }
}
