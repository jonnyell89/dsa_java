package org.example.collections.my_set;

import org.example.collections.MySet;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class MySetRemoveTest {

    private final List<Integer> inputList = Arrays.asList(1, 2, 3, 4, 5);

    // REMOVE
    @Test
    void testMySetRemoveElementFromEmptySet() {
        int elementToRemove = 0;
        MySet<Integer> mySet = new MySet<>();
        boolean remove = mySet.remove(elementToRemove);
        assertFalse(remove, "MySet does not contain elementToRemove.");
    }

    @Test
    void testMySetRemoveElementNotPresentInSet() {
        int elementNotPresentInSet = 0;
        MySet<Integer> mySet = new MySet<>(inputList);
        boolean remove = mySet.remove(elementNotPresentInSet);
        assertFalse(remove, "MySet does not contain elementNotPresentInSet.");
        Integer[] result = new Integer[]{1, 2, 3, 4, 5};
        assertArrayEquals(result, mySet.toArray(), "MySet should be equal to result.");
    }

    @Test
    void testMySetRemoveElement() {
        int elementToRemove = 5;
        MySet<Integer> mySet = new MySet<>(inputList);
        boolean remove = mySet.remove(elementToRemove);
        assertTrue(remove, "MySet should remove elementToRemove.");
        Integer[] result = new Integer[]{1, 2, 3, 4};
        assertArrayEquals(result, mySet.toArray(), "MySet should be equal to result.");
    }

    @Test
    void testMySetRemoveAllElementsFromEmptySet() {
        List<Integer> elementsToRemove = Arrays.asList(1, 2, 3, 4, 5);
        MySet<Integer> mySet = new MySet<>();
        boolean removeAll = mySet.removeAll(elementsToRemove);
        assertFalse(removeAll, "MySet does not contain elementsToRemove.");
    }

    @Test
    void testMySetRemoveAllElementsNotPresentInSet() {
        List<Integer> elementsNotPresentInSet = Arrays.asList(6, 7, 8, 9, 10);
        MySet<Integer> mySet = new MySet<>(inputList);
        boolean removeAll = mySet.removeAll(elementsNotPresentInSet);
        assertFalse(removeAll, "MySet does not contain elementsNotPresentInSet.");
        Integer[] result = new Integer[]{1, 2, 3, 4, 5};
        assertArrayEquals(result, mySet.toArray(), "MySet should be equal to result.");
    }

    @Test
    void testMySetRemoveAllElements() {
        List<Integer> elementsToRemove = Arrays.asList(1, 2, 3, 4, 5);
        MySet<Integer> mySet = new MySet<>(inputList);
        boolean removeAll = mySet.removeAll(elementsToRemove);
        assertTrue(removeAll, "MySet should remove elementsToRemove.");
        Integer[] result = new Integer[]{};
        assertArrayEquals(result, mySet.toArray(), "MySet should be equal to result.");
    }
}
