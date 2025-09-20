package org.example.collections.my_array;

import org.example.collections.MyArray;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MyArrayInsertTest {

    private static final int DEFAULT_CAPACITY = 10;
    public final int[] array = new int[]{3, 17, 75, 80, 202};

    // INSERT
    @Test
    void testMyArrayInsertAtStart() {
        int elementToInsert = 10;
        MyArray myArray = new MyArray(array);
        boolean result = myArray.insertAtStart(elementToInsert);
        assertTrue(result);
        int[] arrayWithElementInserted = new int[]{10, 3, 17, 75, 80, 202};
        assertArrayEquals(arrayWithElementInserted, myArray.toArray(), "MyArray should be equal to arrayWithElementInserted.");
    }

    @Test
    void testMyArrayInsertAtEnd() {
        int elementToInsert = 10;
        MyArray myArray = new MyArray(array);
        boolean result = myArray.insertAtEnd(elementToInsert);
        assertTrue(result);
        int[] arrayWithElementInserted = new int[]{3, 17, 75, 80, 202, 10};
        assertArrayEquals(arrayWithElementInserted, myArray.toArray(), "MyArray should be equal to arrayWithElementInserted.");
    }

    @Test
    void testMyArrayInsertAtIndexWithIndexLessThanZero() {
        int indexLessThanZero = -5;
        int elementToInsert = 10;
        MyArray myArray = new MyArray(array);
        ArrayIndexOutOfBoundsException exception = assertThrows(
                ArrayIndexOutOfBoundsException.class,
                () -> myArray.insertAtIndex(indexLessThanZero, elementToInsert),
                "MyArray index should not be less than zero."
        );
    }

    @Test
    void testMyArrayInsertAtIndexWithIndexGreaterThanSize() {
        int indexGreaterThanZero = 15;
        int elementToInsert = 10;
        MyArray myArray = new MyArray(array);
        ArrayIndexOutOfBoundsException exception = assertThrows(
                ArrayIndexOutOfBoundsException.class,
                () -> myArray.insertAtIndex(indexGreaterThanZero, elementToInsert),
                "MyArray index should not be greater than size."
        );
    }

    @Test
    void testMyArrayInsertAtIndex() {
        int index = array.length / 2;
        int elementToInsert = 10;
        MyArray myArray = new MyArray(array);
        boolean result = myArray.insertAtIndex(index, elementToInsert);
        assertTrue(result);
        int[] arrayWithElementInserted = new int[]{3, 17, 10, 75, 80, 202};
        assertArrayEquals(arrayWithElementInserted, myArray.toArray(), "MyArray should be equal to arrayWithElementInserted.");
    }
}
