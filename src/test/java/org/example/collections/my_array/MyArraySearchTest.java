package org.example.collections.my_array;

import org.example.collections.MyArray;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MyArraySearchTest {

    private static final int DEFAULT_CAPACITY = 10;
    public final int[] array = new int[]{3, 17, 75, 80, 202};

    // SEARCH
    @Test
    void testMyArraySearchWithInvalidElement() {
        int elementNotPresentInArray = 10;
        MyArray myArray = new MyArray(array);
        assertEquals(-1, myArray.search(elementNotPresentInArray), "Element should not be present in MyArray.");
    }

    @Test
    void testMyArraySearchWithValidElement() {
        MyArray myArray = new MyArray(array);
        for (int i = 0; i < myArray.getSize(); i++) {
            int element = array[i];
            assertEquals(i, myArray.search(element), String.format("Element at myArray[%d] should return the index %d.", i, i));
        }
    }
}
