package org.example.collections.manual_array;

import org.example.collections.MyArray;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ManualArrayReadTest {

    private static final int DEFAULT_CAPACITY = 10;
    public final int[] array = new int[]{3, 17, 75, 80, 202};

    // READ
    @Test
    void testManualArrayReadWithIndexLessThanZero() {
        int indexLessThanZero = -5;
        MyArray manualArray = new MyArray(array);
        ArrayIndexOutOfBoundsException exception = assertThrows(
                ArrayIndexOutOfBoundsException.class,
                () -> manualArray.read(indexLessThanZero),
                "ManualArray index should not be less than zero."
        );
    }

    @Test
    void testManualArrayReadWithIndexGreaterThanSize() {
        int indexGreaterThanSize = 15;
        MyArray manualArray = new MyArray(array);
        ArrayIndexOutOfBoundsException exception = assertThrows(
                ArrayIndexOutOfBoundsException.class,
                () -> manualArray.read(indexGreaterThanSize),
                "ManualArray index should not be greater than size."
        );
    }

    @Test
    void testManualArrayReadWithValidIndex() {
        MyArray manualArray = new MyArray(array);
        for (int i = 0; i < manualArray.getSize(); i++) {
            int element = array[i];
            assertEquals(element, manualArray.read(i), String.format("Element at manualArray[%d] should be %d.", i, element));
        }
    }
}
