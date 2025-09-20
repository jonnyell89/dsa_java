package org.example.collections.manual_array;

import org.example.collections.MyArray;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ManualArrayEditTest {

    private static final int DEFAULT_CAPACITY = 10;
    public final int[] array = new int[]{3, 17, 75, 80, 202};

    @Test
    void testManualArraySwapByIndexWithIndexLessThanZero() {
        int indexLessThanZero = -5;
        int index = 0;
        MyArray manualArray = new MyArray(array);
        ArrayIndexOutOfBoundsException exception = assertThrows(
                ArrayIndexOutOfBoundsException.class,
                () -> manualArray.swapByIndex(indexLessThanZero, index),
                "ManualArray index should not be less than zero."
        );
    }

    @Test
    void testManualArraySwapByIndexWithIndexGreaterThanSize() {
        int index = 0;
        int indexGreaterThanSize = 15;
        MyArray manualArray = new MyArray(array);
        ArrayIndexOutOfBoundsException exception = assertThrows(
                ArrayIndexOutOfBoundsException.class,
                () -> manualArray.swapByIndex(index, indexGreaterThanSize),
                "ManualArray index should not be greater than size."
        );
    }

    @Test
    void testManualArraySwapByIndex() {
        int i = 0;
        int j = array.length / 2;
        MyArray manualArray = new MyArray(array);
        manualArray.swapByIndex(i, j);
        int[] arrayWithElementsSwapped = new int[]{75, 17, 3, 80, 202};
        assertArrayEquals(arrayWithElementsSwapped, manualArray.toArray(), "ManualArray should be equal to arrayWithElementsSwapped.");
    }

    @Test
    void testManualArrayReplaceByIndexWithIndexLessThanZero() {
        int indexLessThanZero = -5;
        int index = 0;
        MyArray manualArray = new MyArray(array);
        ArrayIndexOutOfBoundsException exception = assertThrows(
                ArrayIndexOutOfBoundsException.class,
                () -> manualArray.replaceByIndex(indexLessThanZero, index),
                "ManualArray index should not be less than zero."
        );
    }

    @Test
    void testManualArrayReplaceByIndexWithIndexGreaterThanSize() {
        int index = 0;
        int indexGreaterThanSize = 15;
        MyArray manualArray = new MyArray(array);
        ArrayIndexOutOfBoundsException exception = assertThrows(
                ArrayIndexOutOfBoundsException.class,
                () -> manualArray.replaceByIndex(index, indexGreaterThanSize),
                "ManualArray index should not be greater than size."
        );
    }

    @Test
    void testManualArrayReplaceByIndex() {
        int i = 0;
        int j = array.length / 2;
        MyArray manualArray = new MyArray(array);
        manualArray.replaceByIndex(i, j);
        int[] arrayWithElementReplaced = new int[]{75, 17, 75, 80, 202};
        assertArrayEquals(arrayWithElementReplaced, manualArray.toArray(), "ManualArray should be equal to arrayWithElementReplaced.");
    }

    @Test
    void testManualArraySetByIndexWithIndexLessThanZero() {
        int indexLessThanZero = -5;
        int element = 0;
        MyArray manualArray = new MyArray(array);
        ArrayIndexOutOfBoundsException exception = assertThrows(
                ArrayIndexOutOfBoundsException.class,
                () -> manualArray.setByIndex(indexLessThanZero, element),
                "ManualArray index should not be less than zero."
        );
    }

    @Test
    void testManualArraySetByIndexWithIndexGreaterThanSize() {
        int indexGreaterThanSize = 15;
        int element = 0;
        MyArray manualArray = new MyArray(array);
        ArrayIndexOutOfBoundsException exception = assertThrows(
                ArrayIndexOutOfBoundsException.class,
                () -> manualArray.setByIndex(indexGreaterThanSize, element),
                "ManualArray index should not be greater than size."
        );
    }

    @Test
    void testManualArraySetByIndex() {
        int index = array.length / 2;
        int element = 0;
        MyArray manualArray = new MyArray(array);
        manualArray.setByIndex(index, element);
        int[] arrayWithElementSet = new int[]{3, 17, 0, 80, 202};
        assertArrayEquals(arrayWithElementSet, manualArray.toArray(), "ManualArray should be equal to arrayWithElementSet.");
    }
}
