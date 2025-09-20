package org.example.collections.my_array;

import org.example.collections.MyArray;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MyArrayDeleteTest {

    private static final int DEFAULT_CAPACITY = 10;
    public final int[] array = new int[]{3, 17, 75, 80, 202};

    // DELETE
    @Test
    void testMyArrayDeleteFromStartOfEmptyArray() {
        MyArray myArray = new MyArray();
        IllegalStateException exception = assertThrows(
                IllegalStateException.class,
                () -> myArray.deleteFromStart(),
                "MyArray should not be empty."
        );
    }

    @Test
    void testMyArrayDeleteFromStart() {
        MyArray myArray = new MyArray(array);
        int result = myArray.deleteFromStart();
        assertEquals(array[0], result);
        int[] arrayWithElementDeleted = new int[]{17, 75, 80, 202};
        assertArrayEquals(arrayWithElementDeleted, myArray.toArray(), "MyArray should be equal to arrayWithElementDeleted.");
    }

    @Test
    void testMyArrayDeleteFromEndOfEmptyArray() {
        MyArray myArray = new MyArray();
        IllegalStateException exception = assertThrows(
                IllegalStateException.class,
                () -> myArray.deleteFromEnd(),
                "MyArray should not be empty."
        );
    }

    @Test
    void testMyArrayDeleteFromEnd() {
        MyArray myArray = new MyArray(array);
        int result = myArray.deleteFromEnd();
        assertEquals(array[array.length - 1], result);
        int[] arrayWithElementDeleted = new int[]{3, 17, 75, 80};
        assertArrayEquals(arrayWithElementDeleted, myArray.toArray(), "MyArray should be equal to arrayWithElementDeleted.");
    }

    @Test
    void testMyArrayDeleteFromIndexOfEmptyArray() {
        int index = 0;
        MyArray myArray = new MyArray();
        IllegalStateException exception = assertThrows(
                IllegalStateException.class,
                () -> myArray.deleteFromIndex(index),
                "MyArray should not be empty."
        );
    }

    @Test
    void testMyArrayDeleteFromIndexWithIndexLessThanZero() {
        int indexLessThanZero = -5;
        MyArray myArray = new MyArray(array);
        ArrayIndexOutOfBoundsException exception = assertThrows(
                ArrayIndexOutOfBoundsException.class,
                () -> myArray.deleteFromIndex(indexLessThanZero),
                "MyArray index should not be less than zero."
        );
    }

    @Test
    void testMyArrayDeleteFromIndexWithIndexGreaterThanSize() {
        int indexGreaterThanZero = 15;
        MyArray myArray = new MyArray(array);
        ArrayIndexOutOfBoundsException exception = assertThrows(
                ArrayIndexOutOfBoundsException.class,
                () -> myArray.deleteFromIndex(indexGreaterThanZero),
                "MyArray index should not be greater than size."
        );
    }

    @Test
    void testMyArrayDeleteFromIndex() {
        int deleteFromIndex = array.length / 2;
        MyArray myArray = new MyArray(array);
        int result = myArray.deleteFromIndex(deleteFromIndex);
        assertEquals(array[deleteFromIndex], result);
        int[] arrayWithElementDeleted = new int[]{3, 17, 80, 202};
        assertArrayEquals(arrayWithElementDeleted, myArray.toArray(), "MyArray should be equal to arrayWithElementDeleted.");
    }
}
