package org.example.collections.manual_array;

import org.example.collections.MyArray;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ManualArrayInsertTest {

    private static final int DEFAULT_CAPACITY = 10;
    public final int[] array = new int[]{3, 17, 75, 80, 202};

    // INSERT
    @Test
    void testManualArrayInsertAtStart() {
        int elementToInsert = 10;
        MyArray manualArray = new MyArray(array);
        manualArray.insertAtStart(elementToInsert);
        int[] arrayWithElementInserted = new int[]{10, 3, 17, 75, 80, 202};
        assertArrayEquals(arrayWithElementInserted, manualArray.toArray(), "ManualArray should be equal to arrayWithElementInserted.");
    }

    @Test
    void testManualArrayInsertAtEnd() {
        int elementToInsert = 10;
        MyArray manualArray = new MyArray(array);
        manualArray.insertAtEnd(elementToInsert);
        int[] arrayWithElementInserted = new int[]{3, 17, 75, 80, 202, 10};
        assertArrayEquals(arrayWithElementInserted, manualArray.toArray(), "ManualArray should be equal to arrayWithElementInserted.");
    }

    @Test
    void testManualArrayInsertAtIndexWithIndexLessThanZero() {
        int indexLessThanZero = -5;
        int elementToInsert = 10;
        MyArray manualArray = new MyArray(array);
        ArrayIndexOutOfBoundsException exception = assertThrows(
                ArrayIndexOutOfBoundsException.class,
                () -> manualArray.insertAtIndex(indexLessThanZero, elementToInsert),
                "ManualArray index should not be less than zero."
        );
    }

    @Test
    void testManualArrayInsertAtIndexWithIndexGreaterThanSize() {
        int indexGreaterThanZero = 15;
        int elementToInsert = 10;
        MyArray manualArray = new MyArray(array);
        ArrayIndexOutOfBoundsException exception = assertThrows(
                ArrayIndexOutOfBoundsException.class,
                () -> manualArray.insertAtIndex(indexGreaterThanZero, elementToInsert),
                "ManualArray index should not be greater than size."
        );
    }

    @Test
    void testManualArrayInsertAtIndex() {
        int index = array.length / 2;
        int elementToInsert = 10;
        MyArray manualArray = new MyArray(array);
        manualArray.insertAtIndex(index, elementToInsert);
        int[] arrayWithElementInserted = new int[]{3, 17, 10, 75, 80, 202};
        assertArrayEquals(arrayWithElementInserted, manualArray.toArray(), "ManualArray should be equal to arrayWithElementInserted.");
    }
}
