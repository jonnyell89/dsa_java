package org.example.collections.my_array;

import org.example.collections.MyArray;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class MyArrayEditTest {

    private static final int DEFAULT_CAPACITY = 10;
    public final int[] array = new int[]{3, 17, 75, 80, 202};

    @Test
    void testMyArraySwapByIndexWithIndexLessThanZero() {
        int indexLessThanZero = -5;
        int index = 0;
        MyArray myArray = new MyArray(array);
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
        MyArray myArray = new MyArray(array);
        ArrayIndexOutOfBoundsException exception = assertThrows(
                ArrayIndexOutOfBoundsException.class,
                () -> myArray.swapByIndex(index, indexGreaterThanSize),
                "MyArray index should not be greater than size."
        );
    }

    @Test
    void testMyArraySwapByIndex() {
        int i = 0;
        int j = array.length / 2;
        MyArray myArray = new MyArray(array);
        myArray.swapByIndex(i, j);
        int[] arrayWithElementsSwapped = new int[]{75, 17, 3, 80, 202};
        assertArrayEquals(arrayWithElementsSwapped, myArray.toArray(), "MyArray should be equal to arrayWithElementsSwapped.");
    }

    @Test
    void testMyArrayReplaceByIndexWithIndexLessThanZero() {
        int indexLessThanZero = -5;
        int index = 0;
        MyArray myArray = new MyArray(array);
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
        MyArray myArray = new MyArray(array);
        ArrayIndexOutOfBoundsException exception = assertThrows(
                ArrayIndexOutOfBoundsException.class,
                () -> myArray.replaceByIndex(index, indexGreaterThanSize),
                "MyArray index should not be greater than size."
        );
    }

    @Test
    void testMyArrayReplaceByIndex() {
        int i = 0;
        int j = array.length / 2;
        MyArray myArray = new MyArray(array);
        myArray.replaceByIndex(i, j);
        int[] arrayWithElementReplaced = new int[]{75, 17, 75, 80, 202};
        assertArrayEquals(arrayWithElementReplaced, myArray.toArray(), "MyArray should be equal to arrayWithElementReplaced.");
    }

    @Test
    void testMyArraySetByIndexWithIndexLessThanZero() {
        int indexLessThanZero = -5;
        int element = 0;
        MyArray myArray = new MyArray(array);
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
        MyArray myArray = new MyArray(array);
        ArrayIndexOutOfBoundsException exception = assertThrows(
                ArrayIndexOutOfBoundsException.class,
                () -> myArray.setByIndex(indexGreaterThanSize, element),
                "MyArray index should not be greater than size."
        );
    }

    @Test
    void testMyArraySetByIndex() {
        int index = array.length / 2;
        int element = 0;
        MyArray myArray = new MyArray(array);
        myArray.setByIndex(index, element);
        int[] arrayWithElementSet = new int[]{3, 17, 0, 80, 202};
        assertArrayEquals(arrayWithElementSet, myArray.toArray(), "MyArray should be equal to arrayWithElementSet.");
    }
}
