package org.example.collections.manual_array;

import org.example.collections.ManualArray;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ManualArrayDeleteTest {

    private static final int DEFAULT_CAPACITY = 10;
    public final int[] array = new int[]{3, 17, 75, 80, 202};

    // DELETE
    @Test
    void testManualArrayDeleteFromStartOfEmptyArray() {
        ManualArray manualArray = new ManualArray();
        IllegalStateException exception = assertThrows(
                IllegalStateException.class,
                () -> manualArray.deleteFromStart(),
                "ManualArray should not be empty."
        );
    }

    @Test
    void testManualArrayDeleteFromStart() {
        ManualArray manualArray = new ManualArray(array);
        manualArray.deleteFromStart();
        int[] arrayWithElementDeleted = new int[]{17, 75, 80, 202};
        assertArrayEquals(arrayWithElementDeleted, manualArray.toArray(), "ManualArray should be equal to arrayWithElementDeleted.");
    }

    @Test
    void testManualArrayDeleteFromEndOfEmptyArray() {
        ManualArray manualArray = new ManualArray();
        IllegalStateException exception = assertThrows(
                IllegalStateException.class,
                () -> manualArray.deleteFromEnd(),
                "ManualArray should not be empty."
        );
    }

    @Test
    void testManualArrayDeleteFromEnd() {
        ManualArray manualArray = new ManualArray(array);
        manualArray.deleteFromEnd();
        int[] arrayWithElementDeleted = new int[]{3, 17, 75, 80};
        assertArrayEquals(arrayWithElementDeleted, manualArray.toArray(), "ManualArray should be equal to arrayWithElementDeleted.");
    }

    @Test
    void testManualArrayDeleteFromIndexOfEmptyArray() {
        int index = 0;
        ManualArray manualArray = new ManualArray();
        IllegalStateException exception = assertThrows(
                IllegalStateException.class,
                () -> manualArray.deleteFromIndex(index),
                "ManualArray should not be empty."
        );
    }

    @Test
    void testManualArrayDeleteFromIndexWithIndexLessThanZero() {
        int indexLessThanZero = -5;
        ManualArray manualArray = new ManualArray(array);
        ArrayIndexOutOfBoundsException exception = assertThrows(
                ArrayIndexOutOfBoundsException.class,
                () -> manualArray.deleteFromIndex(indexLessThanZero),
                "ManualArray index should not be less than zero."
        );
    }

    @Test
    void testManualArrayDeleteFromIndexWithIndexGreaterThanSize() {
        int indexGreaterThanZero = 15;
        ManualArray manualArray = new ManualArray(array);
        ArrayIndexOutOfBoundsException exception = assertThrows(
                ArrayIndexOutOfBoundsException.class,
                () -> manualArray.deleteFromIndex(indexGreaterThanZero),
                "ManualArray index should not be greater than size."
        );
    }

    @Test
    void testManualArrayDeleteFromIndex() {
        int deleteFromIndex = array.length / 2;
        ManualArray manualArray = new ManualArray(array);
        manualArray.deleteFromIndex(deleteFromIndex);
        int[] arrayWithElementDeleted = new int[]{3, 17, 80, 202};
        assertArrayEquals(arrayWithElementDeleted, manualArray.toArray(), "ManualArray should be equal to arrayWithElementDeleted.");
    }
}
