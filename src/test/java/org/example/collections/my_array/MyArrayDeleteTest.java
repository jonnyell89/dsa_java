package org.example.collections.my_array;

import org.example.collections.MyArray;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class MyArrayDeleteTest {

    private final List<Integer> inputList = Arrays.asList(3, 17, 75, 80, 202);

    // DELETE
    @Test
    void testMyArrayDeleteFromStartOfEmptyArray() {
        MyArray<Integer> myArray = new MyArray<>();
        IllegalStateException exception = assertThrows(
                IllegalStateException.class,
                () -> myArray.deleteFromStart(),
                "MyArray should not be empty."
        );
    }

    @Test
    void testMyArrayDeleteFromStart() {
        MyArray<Integer> myArray = new MyArray<>(inputList);
        int result = myArray.deleteFromStart();
        assertEquals(inputList.get(0), result);
        Integer[] arrayWithElementDeleted = new Integer[]{17, 75, 80, 202};
        assertArrayEquals(arrayWithElementDeleted, myArray.toArray(), "MyArray should be equal to arrayWithElementDeleted.");
    }

    @Test
    void testMyArrayDeleteFromEndOfEmptyArray() {
        MyArray<Integer> myArray = new MyArray<>();
        IllegalStateException exception = assertThrows(
                IllegalStateException.class,
                () -> myArray.deleteFromEnd(),
                "MyArray should not be empty."
        );
    }

    @Test
    void testMyArrayDeleteFromEnd() {
        MyArray<Integer> myArray = new MyArray<>(inputList);
        int result = myArray.deleteFromEnd();
        assertEquals(inputList.get(inputList.size() - 1), result);
        Integer[] arrayWithElementDeleted = new Integer[]{3, 17, 75, 80};
        assertArrayEquals(arrayWithElementDeleted, myArray.toArray(), "MyArray should be equal to arrayWithElementDeleted.");
    }

    @Test
    void testMyArrayDeleteFromIndexOfEmptyArray() {
        int index = 0;
        MyArray<Integer> myArray = new MyArray<>();
        IllegalStateException exception = assertThrows(
                IllegalStateException.class,
                () -> myArray.deleteFromIndex(index),
                "MyArray should not be empty."
        );
    }

    @Test
    void testMyArrayDeleteFromIndexWithIndexLessThanZero() {
        int indexLessThanZero = -5;
        MyArray<Integer> myArray = new MyArray<>(inputList);
        ArrayIndexOutOfBoundsException exception = assertThrows(
                ArrayIndexOutOfBoundsException.class,
                () -> myArray.deleteFromIndex(indexLessThanZero),
                "MyArray index should not be less than zero."
        );
    }

    @Test
    void testMyArrayDeleteFromIndexWithIndexGreaterThanSize() {
        int indexGreaterThanZero = 15;
        MyArray<Integer> myArray = new MyArray<>(inputList);
        ArrayIndexOutOfBoundsException exception = assertThrows(
                ArrayIndexOutOfBoundsException.class,
                () -> myArray.deleteFromIndex(indexGreaterThanZero),
                "MyArray index should not be greater than size."
        );
    }

    @Test
    void testMyArrayDeleteFromIndex() {
        int deleteFromIndex = inputList.size() / 2;
        MyArray<Integer> myArray = new MyArray<>(inputList);
        int result = myArray.deleteFromIndex(deleteFromIndex);
        assertEquals(inputList.get(deleteFromIndex), result);
        Integer[] arrayWithElementDeleted = new Integer[]{3, 17, 80, 202};
        assertArrayEquals(arrayWithElementDeleted, myArray.toArray(), "MyArray should be equal to arrayWithElementDeleted.");
    }
}
