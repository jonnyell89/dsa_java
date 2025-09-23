package org.example.collections.my_array;

import org.example.collections.MyArray;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MyArraySearchTest {

    private final List<Integer> inputList = Arrays.asList(3, 17, 75, 80, 202);

    // SEARCH
    @Test
    void testMyArraySearchWithInvalidElement() {
        int elementNotPresentInArray = 10;
        MyArray<Integer> myArray = new MyArray<>(inputList);
        assertEquals(-1, myArray.search(elementNotPresentInArray), "Element should not be present in MyArray.");
    }

    @Test
    void testMyArraySearchWithValidElement() {
        MyArray<Integer> myArray = new MyArray<>(inputList);
        for (int i = 0; i < myArray.getSize(); i++) {
            int element = inputList.get(i);
            assertEquals(i, myArray.search(element), String.format("Element %d should return index %d.", element, i));
        }
    }
}
