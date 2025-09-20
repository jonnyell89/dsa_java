package org.example.collections.my_set;

import org.example.collections.MySet;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MySetAddTest {

    private static final int DEFAULT_CAPACITY = 10;

    // ADD
    @Test
    void testMySetAddDuplicateElement() {
        int[] array = new int[]{1, 2, 3, 4, 5};
        int elementToAdd = 5;
        MySet mySet = new MySet(array);
        assertFalse(mySet.add(elementToAdd), "MySet should not add a duplicate element.");
        assertArrayEquals(array, mySet.toArray(), "MySet should be equal to array.");
    }

    @Test
    void testMySetAddNonDuplicateElement() {
        int[] array = new int[]{1, 2, 3, 4, 5};
        int elementToAdd = 7;
        MySet mySet = new MySet(array);
        assertTrue(mySet.add(elementToAdd), "MySet should add a non-duplicate element.");
        int[] arrayWithElementAdded = new int[]{1, 2, 3, 4, 5, 7};
        assertArrayEquals(arrayWithElementAdded, mySet.toArray(), "MySet should be equal to arrayWithElementAdded.");
    }

    @Test
    void testMySetAddAllToEmptyArray() {
        MySet mySet = new MySet();
        int[] array = new int[]{1, 2, 3, 4, 5};
        assertTrue(mySet.addAll(array), "MySet should add all elements.");
        assertArrayEquals(array, mySet.toArray(), "MySet should be equal to array.");
    }

    @Test
    void testMySetAddAllWithDuplicateElements() {
        int[] array = new int[]{1, 2, 3, 4, 5};
        MySet mySet = new MySet(array);
        int[] arrayWithDuplicateElements = new int[] {1, 2, 3, 4, 5};
        assertFalse(mySet.addAll(arrayWithDuplicateElements), "MySet should not add duplicate elements.");
        assertArrayEquals(array, mySet.toArray(), "MySet should be equal to array.");
    }

    @Test
    void testMySetAddAllWithSomeDuplicateElements() {
        int[] array = new int[]{1, 2, 3, 4, 5};
        MySet mySet = new MySet(array);
        int[] arrayWithSomeDuplicateElements = new int[]{1, 2, 3, 4, 5, 7, 7};
        assertTrue(mySet.addAll(arrayWithSomeDuplicateElements), "MySet should add all non-duplicate elements.");
        int[] arrayWithElementsAdded = new int[]{1, 2, 3, 4, 5, 7};
        assertArrayEquals(arrayWithElementsAdded, mySet.toArray(), "MySet should be equal to arrayWithElementsAdded.");
    }

    @Test
    void testMySetAddAllWithNonDuplicateElements() {
        int[] array = new int[]{1, 2, 3, 4, 5};
        MySet mySet = new MySet(array);
        int[] arrayWithNonDuplicateElements = new int[]{6, 7, 8, 9, 10};
        assertTrue(mySet.addAll(arrayWithNonDuplicateElements), "MySet should add all elements.");
        int[] arrayWithElementsAdded = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        assertArrayEquals(arrayWithElementsAdded, mySet.toArray(), "MySet should be equal to arrayWithElementsAdded.");
    }
}
