package org.example.collections.my_array;

import org.example.collections.MyArray;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class MyArrayReadTest {

    private final List<Integer> inputList = Arrays.asList(3, 17, 75, 80, 202);

    // READ
    @Test
    void testMyArrayReadWithIndexLessThanZero() {
        int indexLessThanZero = -5;
        MyArray<Integer> myArray = new MyArray<>(inputList);
        ArrayIndexOutOfBoundsException exception = assertThrows(
                ArrayIndexOutOfBoundsException.class,
                () -> myArray.read(indexLessThanZero),
                "MyArray index should not be less than zero."
        );
    }

    @Test
    void testMyArrayReadWithIndexGreaterThanSize() {
        int indexGreaterThanSize = 15;
        MyArray<Integer> myArray = new MyArray<>(inputList);
        ArrayIndexOutOfBoundsException exception = assertThrows(
                ArrayIndexOutOfBoundsException.class,
                () -> myArray.read(indexGreaterThanSize),
                "MyArray index should not be greater than size."
        );
    }

    @Test
    void testMyArrayReadWithValidIndex() {
        MyArray<Integer> myArray = new MyArray<>(inputList);
        for (int i = 0; i < myArray.getSize(); i++) {
            int element = inputList.get(i);
            assertEquals(element, myArray.read(i), String.format("Element at index %d should be %d.", i, element));
        }
    }
}
