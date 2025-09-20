package org.example.collections.my_set;

import org.example.collections.MySet;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MySetRemoveTest {

    private static final int DEFAULT_CAPACITY = 10;

    // REMOVE
    @Test
    void testMySetRemoveElementFromEmptyArray() {
        int elementToRemove = 0;
        MySet mySet = new MySet();
        assertFalse(mySet.remove(elementToRemove), "MySet does not contain elementToRemove.");
    }

    @Test
    void testMySetRemoveElementNotPresentInArray() {
        int elementNotPresentInArray = 0;
        int[] array = new int[]{1, 2, 3, 4, 5};
        MySet mySet = new MySet(array);
        assertFalse(mySet.remove(elementNotPresentInArray), "MySet does not contain elementNotPresentInSet.");
        assertArrayEquals(array, mySet.toArray(), "MySet should be equal to array.");
    }

    @Test
    void testMySetRemoveElement() {
        int elementToRemove = 5;
        int[] array = new int[]{1, 2, 3, 4, 5};
        MySet mySet = new MySet(array);
        assertTrue(mySet.remove(elementToRemove), "MySet should remove elementToRemove.");
        int[] arrayWithElementRemoved = new int[]{1, 2, 3, 4};
        assertArrayEquals(arrayWithElementRemoved, mySet.toArray(), "MySet should be equal to arrayWithElementRemoved.");
    }

    @Test
    void testMySetRemoveAllElementsFromEmptyArray() {
        int[] elementsToRemove = new int[]{1, 2, 3, 4, 5};
        MySet mySet = new MySet();
        assertFalse(mySet.removeAll(elementsToRemove), "MySet does not contain elementsToRemove.");
    }

    @Test
    void testMySetRemoveAllElementsNotPresentInArray() {
        int[] elementsNotPresentInArray = new int[]{6, 7, 8, 9, 10};
        int[] array = new int[]{1, 2, 3, 4, 5};
        MySet mySet = new MySet(array);
        assertFalse(mySet.removeAll(elementsNotPresentInArray), "MySet does not contain elementsNotPresentInSet.");
        assertArrayEquals(array, mySet.toArray(), "MySet should be equal to array.");
    }

    @Test
    void testMySetRemoveAllElements() {
        int[] elementsToRemove = new int[]{1, 2, 3, 4, 5};
        int[] array = new int[]{1, 2, 3, 4, 5};
        MySet mySet = new MySet(array);
        assertTrue(mySet.removeAll(elementsToRemove), "MySet should remove elementsToRemove.");
        int[] arrayWithElementsRemoved = new int[]{};
        assertArrayEquals(arrayWithElementsRemoved, mySet.toArray(), "MySet should be equal to arrayWithElementsRemoved.");
    }
}
