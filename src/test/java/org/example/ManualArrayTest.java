package org.example;

import org.junit.jupiter.api.Test;

import static org.example.Config.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ManualArrayTest {

    int[] array = new int[]{3, 17, 75, 80, 202};

    @Test
    void testManualArrayDefault() {

        ManualArray manualArray = new ManualArray();

        assertEquals(MIN_CAPACITY, manualArray.getArray().length, String.format("Array should have length: %d", MIN_CAPACITY));
        assertEquals(0, manualArray.getSize(), String.format("Array should have size: %d", 0));

        for (int i = 0; i < manualArray.getArray().length; i++) {

            assertEquals(0, manualArray.getArray()[i], String.format("Element at array[%d] should be: %d", i, 0));
        }
    }

    @Test
    void testManualArrayLengthParameterLessThanZero() {

        int lengthLessThanZero = -5;

        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class, // Type of exception.
                () -> new ManualArray(lengthLessThanZero),  // Operation that throws exception.
                "Array with negative length should throw IllegalArgumentException.");
    }

    @Test
    void testManualArrayLengthParameterZero() {

        int lengthZero = 0;

        ManualArray manualArray = new ManualArray(lengthZero);

        assertEquals(MIN_CAPACITY, manualArray.getArray().length, String.format("Array should have length: %d", MIN_CAPACITY));
        assertEquals(0, manualArray.getSize(), String.format("Array should have size: %d", 0));

        for (int i = 0; i < manualArray.getArray().length; i++) {

            assertEquals(0, manualArray.getArray()[i], String.format("Element at array[%d] should be: %d", i, 0));
        }
    }

    @Test
    void testManualArrayLengthParameterLessThanDefault() {

        int lengthLessThanDefault = 5;

        ManualArray manualArray = new ManualArray(lengthLessThanDefault);

        assertEquals(MIN_CAPACITY, manualArray.getArray().length, String.format("Array should have length: %d", MIN_CAPACITY));
        assertEquals(0, manualArray.getSize(), String.format("Array should have size: %d", 0));

        for (int i = 0; i < manualArray.getArray().length; i++) {

            assertEquals(0, manualArray.getArray()[i], String.format("Element at array[%d] should be: %d", i, 0));
        }
    }

    @Test
    void testManualArrayLengthParameterGreaterThanDefault() {

        int lengthGreaterThanDefault = 15;

        ManualArray manualArray = new ManualArray(lengthGreaterThanDefault);

        assertEquals(MIN_CAPACITY * 2, manualArray.getArray().length, String.format("Array should have length: %d", MIN_CAPACITY * 2));
        assertEquals(0, manualArray.getSize(), String.format("Array should have size: %d", 0));

        for (int i = 0; i < manualArray.getArray().length; i++) {

            assertEquals(0, manualArray.getArray()[i], String.format("Element at array[%d] should be: %d", i, 0));
        }
    }

    @Test
    void testManualArrayNullArrayParameter() {

        NullPointerException exception = assertThrows(
                NullPointerException.class, // Type of exception.
                () -> new ManualArray(null),  // Operation that throws exception.
                "Null should throw NullPointerException.");
    }

    @Test
    void testManualArrayEmptyArrayParameter() {

        int[] emptyArray = new int[]{};

        ManualArray manualArray = new ManualArray(emptyArray);

        assertEquals(MIN_CAPACITY, manualArray.getArray().length, String.format("Array should have length: %d", MIN_CAPACITY));
        assertEquals(0, manualArray.getSize(), String.format("Array should have size: %d", 0));

        for (int i = 0; i < manualArray.getArray().length; i++) {

            assertEquals(0, manualArray.getArray()[i], String.format("Element at array[%d] should be: %d", i, 0));
        }
    }

    @Test
    void testManualArrayArrayParameterLengthLessThanDefault() {

        int[] lessThanDefault = new int[]{3, 17, 75, 80, 202};

        ManualArray manualArray = new ManualArray(lessThanDefault);

        assertEquals(MIN_CAPACITY, manualArray.getArray().length, String.format("Array should have length: %d", MIN_CAPACITY));
        assertEquals(lessThanDefault.length, manualArray.getSize(), String.format("Array should have size: %d", lessThanDefault.length));
    }

    @Test
    void testManualArrayArrayParameterLengthGreaterThanDefault() {

        int[] greaterThanDefault = new int[]{3, 17, 75, 80, 202, 2, 16, 74, 79, 201, 1, 15, 73, 78, 200};

        ManualArray manualArray = new ManualArray(greaterThanDefault);

        assertEquals(MIN_CAPACITY * 2, manualArray.getArray().length, String.format("Array should have length: %d", MIN_CAPACITY * 2));
        assertEquals(greaterThanDefault.length, manualArray.getSize(), String.format("Array should have size: %d", greaterThanDefault.length));
    }
}
