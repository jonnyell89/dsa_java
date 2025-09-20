package org.example.collections.my_array;

import org.example.collections.MyArray;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class MyArrayReadTest {

    private static final int DEFAULT_CAPACITY = 10;
    public final int[] array = new int[]{3, 17, 75, 80, 202};

    // READ
    @Test
    void testMyArrayReadWithIndexLessThanZero() {
        int indexLessThanZero = -5;
        MyArray myArray = new MyArray(array);
        ArrayIndexOutOfBoundsException exception = assertThrows(
                ArrayIndexOutOfBoundsException.class,
                () -> myArray.read(indexLessThanZero),
                "MyArray index should not be less than zero."
        );
    }

    @Test
    void testMyArrayReadWithIndexGreaterThanSize() {
        int indexGreaterThanSize = 15;
        MyArray myArray = new MyArray(array);
        ArrayIndexOutOfBoundsException exception = assertThrows(
                ArrayIndexOutOfBoundsException.class,
                () -> myArray.read(indexGreaterThanSize),
                "MyArray index should not be greater than size."
        );
    }

    @Test
    void testMyArrayReadWithValidIndex() {
        MyArray myArray = new MyArray(array);
        for (int i = 0; i < myArray.getSize(); i++) {
            int element = array[i];
            assertEquals(element, myArray.read(i), String.format("Element at myArray[%d] should be %d.", i, element));
        }
    }
}
