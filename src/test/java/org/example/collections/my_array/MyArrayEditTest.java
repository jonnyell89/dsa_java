package org.example.collections.my_array;

import org.example.collections.MyArray;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class MyArrayEditTest {

    private final List<Integer> inputList = Arrays.asList(3, 17, 75, 80, 202);

    @Test
    void testMyArraySwapByIndexWithIndexLessThanZero() {
        int indexLessThanZero = -5;
        int index = 0;
        MyArray<Integer> myArray = new MyArray<>(inputList);
        ArrayIndexOutOfBoundsException exception = assertThrows(
                ArrayIndexOutOfBoundsException.class,
                () -> myArray.swapByIndex(indexLessThanZero, index),
                "MyArray index should not be less than zero."
        );
    }

    @Test
    void testMyArraySwapByIndexWithIndexGreaterThanSize() {
        int index = 0;
        int indexGreaterThanSize = 15;
        MyArray<Integer> myArray = new MyArray<>(inputList);
        ArrayIndexOutOfBoundsException exception = assertThrows(
                ArrayIndexOutOfBoundsException.class,
                () -> myArray.swapByIndex(index, indexGreaterThanSize),
                "MyArray index should not be greater than size."
        );
    }

    @Test
    void testMyArraySwapByIndex() {
        int i = 0;
        int j = inputList.size() / 2;
        MyArray<Integer> myArray = new MyArray<>(inputList);
        myArray.swapByIndex(i, j);
        Integer[] arrayWithElementsSwapped = new Integer[]{75, 17, 3, 80, 202};
        assertArrayEquals(arrayWithElementsSwapped, myArray.toArray(), "MyArray should be equal to arrayWithElementsSwapped.");
    }

    @Test
    void testMyArrayReplaceByIndexWithIndexLessThanZero() {
        int indexLessThanZero = -5;
        int index = 0;
        MyArray<Integer> myArray = new MyArray<>(inputList);
        ArrayIndexOutOfBoundsException exception = assertThrows(
                ArrayIndexOutOfBoundsException.class,
                () -> myArray.replaceByIndex(indexLessThanZero, index),
                "MyArray index should not be less than zero."
        );
    }

    @Test
    void testMyArrayReplaceByIndexWithIndexGreaterThanSize() {
        int index = 0;
        int indexGreaterThanSize = 15;
        MyArray<Integer> myArray = new MyArray<>(inputList);
        ArrayIndexOutOfBoundsException exception = assertThrows(
                ArrayIndexOutOfBoundsException.class,
                () -> myArray.replaceByIndex(index, indexGreaterThanSize),
                "MyArray index should not be greater than size."
        );
    }

    @Test
    void testMyArrayReplaceByIndex() {
        int i = 0;
        int j = inputList.size() / 2;
        MyArray<Integer> myArray = new MyArray<>(inputList);
        myArray.replaceByIndex(i, j);
        Integer[] arrayWithElementReplaced = new Integer[]{75, 17, 75, 80, 202};
        assertArrayEquals(arrayWithElementReplaced, myArray.toArray(), "MyArray should be equal to arrayWithElementReplaced.");
    }

    @Test
    void testMyArraySetByIndexWithIndexLessThanZero() {
        int indexLessThanZero = -5;
        int element = 0;
        MyArray<Integer> myArray = new MyArray<>(inputList);
        ArrayIndexOutOfBoundsException exception = assertThrows(
                ArrayIndexOutOfBoundsException.class,
                () -> myArray.setByIndex(indexLessThanZero, element),
                "MyArray index should not be less than zero."
        );
    }

    @Test
    void testMyArraySetByIndexWithIndexGreaterThanSize() {
        int indexGreaterThanSize = 15;
        int element = 0;
        MyArray<Integer> myArray = new MyArray<>(inputList);
        ArrayIndexOutOfBoundsException exception = assertThrows(
                ArrayIndexOutOfBoundsException.class,
                () -> myArray.setByIndex(indexGreaterThanSize, element),
                "MyArray index should not be greater than size."
        );
    }

    @Test
    void testMyArraySetByIndex() {
        int index = inputList.size() / 2;
        int element = 0;
        MyArray<Integer> myArray = new MyArray<>(inputList);
        myArray.setByIndex(index, element);
        Integer[] arrayWithElementSet = new Integer[]{3, 17, 0, 80, 202};
        assertArrayEquals(arrayWithElementSet, myArray.toArray(), "MyArray should be equal to arrayWithElementSet.");
    }
}
