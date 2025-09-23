package org.example.collections.my_set;

import org.example.collections.MySet;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class MySetAddTest {

    private final List<Integer> inputList = Arrays.asList(1, 2, 3, 4, 5);

    // ADD
    @Test
    void testMySetAddDuplicateElement() {
        int elementToAdd = 5;
        MySet<Integer> mySet = new MySet<>(inputList);
        assertFalse(mySet.add(elementToAdd), "MySet should not add a duplicate element.");
        Integer[] result = new Integer[]{1, 2, 3, 4, 5};
        assertArrayEquals(result, mySet.toArray(), "MySet should be equal to result.");
    }

    @Test
    void testMySetAddNonDuplicateElement() {
        int elementToAdd = 7;
        MySet<Integer> mySet = new MySet<>(inputList);
        assertTrue(mySet.add(elementToAdd), "MySet should add a non-duplicate element.");
        Integer[] result = new Integer[]{1, 2, 3, 4, 5, 7};
        assertArrayEquals(result, mySet.toArray(), "MySet should be equal to result.");
    }

    @Test
    void testMySetAddAllToEmptySet() {
        MySet<Integer> mySet = new MySet<>();
        List<Integer> toEmptySet = Arrays.asList(1, 2, 3, 4, 5);
        boolean addAll = mySet.addAll(toEmptySet);
        assertTrue(addAll, "MySet should add all elements.");
        Integer[] result = new Integer[]{1, 2, 3, 4, 5};
        assertArrayEquals(result, mySet.toArray(), "MySet should be equal to result.");
    }

    @Test
    void testMySetAddAllWithDuplicateElements() {
        MySet<Integer> mySet = new MySet<>(inputList);
        List<Integer> listWithDuplicateElements = Arrays.asList(1, 2, 3, 4, 5);
        boolean addAll = mySet.addAll(listWithDuplicateElements);
        assertFalse(addAll, "MySet should not add duplicate elements.");
        Integer[] result = new Integer[]{1, 2, 3, 4, 5};
        assertArrayEquals(result, mySet.toArray(), "MySet should be equal to result.");
    }

    @Test
    void testMySetAddAllWithSomeDuplicateElements() {
        MySet<Integer> mySet = new MySet<>(inputList);
        List<Integer> listWithSomeDuplicateElements = Arrays.asList(1, 2, 3, 4, 5, 7, 7);
        boolean addAll = mySet.addAll(listWithSomeDuplicateElements);
        assertTrue(addAll, "MySet should add all non-duplicate elements.");
        Integer[] result = new Integer[]{1, 2, 3, 4, 5, 7};
        assertArrayEquals(result, mySet.toArray(), "MySet should be equal to result.");
    }

    @Test
    void testMySetAddAllWithNonDuplicateElements() {
        MySet<Integer> mySet = new MySet<>(inputList);
        List<Integer> listWithNonDuplicateElements = Arrays.asList(6, 7, 8, 9, 10);
        boolean addAll = mySet.addAll(listWithNonDuplicateElements);
        assertTrue(addAll, "MySet should add all elements.");
        Integer[] result = new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        assertArrayEquals(result, mySet.toArray(), "MySet should be equal to result.");
    }
}
