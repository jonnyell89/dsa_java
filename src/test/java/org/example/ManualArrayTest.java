package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ManualArrayTest {

    private static final int DEFAULT_CAPACITY = 10;
    public final int[] array = new int[]{3, 17, 75, 80, 202};

    // INSTANTIATION
    @Test
    void testManualArrayWithDefaultConstructor() {

        ManualArray manualArray = new ManualArray();

        assertEquals(DEFAULT_CAPACITY, manualArray.getArray().length, String.format("Array length should be %d.", DEFAULT_CAPACITY));
        assertEquals(0, manualArray.getSize(), String.format("Array size should be %d", 0));

        int[] defaultArray = new int[DEFAULT_CAPACITY];

        assertArrayEquals(defaultArray, manualArray.getArray(), String.format("Array should contain %d zeros.", DEFAULT_CAPACITY));
    }

    @Test
    void testManualArrayWithLengthLessThanZero() {

        int lengthLessThanZero = -5;

        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> new ManualArray(lengthLessThanZero),
                "Array length should not be negative."
        );
    }

    @Test
    void testManualArrayWithLengthZero() {

        int lengthZero = 0;

        ManualArray manualArray = new ManualArray(lengthZero);

        assertEquals(DEFAULT_CAPACITY, manualArray.getArray().length, String.format("Array length should be %d.", DEFAULT_CAPACITY));
        assertEquals(0, manualArray.getSize(), String.format("Array size should be %d.", 0));

        int[] defaultArray = new int[DEFAULT_CAPACITY];

        assertArrayEquals(defaultArray, manualArray.getArray(), String.format("Array should contain %d zeros.", DEFAULT_CAPACITY));
    }

    @Test
    void testManualArrayWithLengthLessThanDefault() {

        int lengthLessThanDefault = 5;

        ManualArray manualArray = new ManualArray(lengthLessThanDefault);

        assertEquals(DEFAULT_CAPACITY, manualArray.getArray().length, String.format("Array length should be %d.", DEFAULT_CAPACITY));
        assertEquals(0, manualArray.getSize(), String.format("Array size should be %d.", 0));

        int[] defaultArray = new int[DEFAULT_CAPACITY];

        assertArrayEquals(defaultArray, manualArray.getArray(), String.format("Array should contain %d zeros.", DEFAULT_CAPACITY));
    }

    @Test
    void testManualArrayWithLengthGreaterThanDefault() {

        int lengthGreaterThanDefault = 15;

        ManualArray manualArray = new ManualArray(lengthGreaterThanDefault);

        assertEquals(DEFAULT_CAPACITY * 2, manualArray.getArray().length, String.format("Array length should be %d.", DEFAULT_CAPACITY * 2));
        assertEquals(0, manualArray.getSize(), String.format("Array size should be %d.", 0));

        int[] defaultArray = new int[DEFAULT_CAPACITY * 2];

        assertArrayEquals(defaultArray, manualArray.getArray(), String.format("Array should contain %d zeros.", DEFAULT_CAPACITY * 2));
    }

    @Test
    void testManualArrayWithNullArray() {

        NullPointerException exception = assertThrows(
                NullPointerException.class,
                () -> new ManualArray(null),
                "Array should not be null."
        );
    }

    @Test
    void testManualArrayWithEmptyArray() {

        int[] emptyArray = new int[]{};

        ManualArray manualArray = new ManualArray(emptyArray);

        assertEquals(DEFAULT_CAPACITY, manualArray.getArray().length, String.format("Array length should be %d.", DEFAULT_CAPACITY));
        assertEquals(0, manualArray.getSize(), String.format("Array size should be %d.", 0));

        int[] defaultArray = new int[DEFAULT_CAPACITY];

        assertArrayEquals(defaultArray, manualArray.getArray(), String.format("Array should contain %d zeros.", DEFAULT_CAPACITY));
    }

    @Test
    void testManualArrayWithArrayLengthLessThanDefault() {

        int lengthLessThanDefault = 5;

        int[] inputArray = new int[lengthLessThanDefault];

        ManualArray manualArray = new ManualArray(inputArray);

        assertEquals(DEFAULT_CAPACITY, manualArray.getArray().length, String.format("Array length should be %d.", DEFAULT_CAPACITY));
        assertEquals(inputArray.length, manualArray.getSize(), String.format("Array size should be %d.", inputArray.length));

        assertArrayEquals(inputArray, manualArray.toArray(), String.format("Array should contain %d zeros.", lengthLessThanDefault));
    }

    @Test
    void testManualArrayWithArrayLengthGreaterThanDefault() {

        int lengthGreaterThanDefault = 15;

        int[] inputArray = new int[lengthGreaterThanDefault];

        ManualArray manualArray = new ManualArray(inputArray);

        assertEquals(DEFAULT_CAPACITY * 2, manualArray.getArray().length, String.format("Array length should be %d.", DEFAULT_CAPACITY * 2));
        assertEquals(inputArray.length, manualArray.getSize(), String.format("Array size should be %d.", inputArray.length));

        assertArrayEquals(inputArray, manualArray.toArray(), String.format("Array should contain %d zeros.", lengthGreaterThanDefault));
    }

    // READ
    @Test
    void testManualArrayReadWithIndexLessThanZero() {

        int indexLessThanZero = -5;

        ManualArray manualArray = new ManualArray(array);

        ArrayIndexOutOfBoundsException exception = assertThrows(
                ArrayIndexOutOfBoundsException.class,
                () -> manualArray.read(indexLessThanZero),
                "Array index should not be less than zero."
        );
    }

    @Test
    void testManualArrayReadWithIndexGreaterThanSize() {

        int indexGreaterThanSize = 15;

        ManualArray manualArray = new ManualArray(array);

        ArrayIndexOutOfBoundsException exception = assertThrows(
                ArrayIndexOutOfBoundsException.class,
                () -> manualArray.read(indexGreaterThanSize),
                "Array index should not be greater than size."
        );
    }

    @Test
    void testManualArrayReadWithValidIndex() {

        ManualArray manualArray = new ManualArray(array);

        for (int i = 0; i < manualArray.getSize(); i++) {

            assertEquals(array[i], manualArray.read(i), String.format("Element at array[%d] should be %d.", i, array[i]));
        }
    }

    // SEARCH
    @Test
    void testManualArraySearchWithInvalidElement() {

        int elementNotPresentInArray = 10;

        ManualArray manualArray = new ManualArray(array);

        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> manualArray.search(elementNotPresentInArray),
                "Element should be present in array."
        );
    }

    @Test
    void testManualArraySearchWithValidElement() {

        ManualArray manualArray = new ManualArray(array);

        for (int i = 0; i < manualArray.getSize(); i++) {

            assertEquals(i, manualArray.search(array[i]), String.format("Element at array[%d] should return the index %d.", i, i));
        }
    }

    // INSERT
    @Test
    void testManualArrayInsertAtStart() {

        int elementToInsert = 10;

        ManualArray manualArray = new ManualArray(array);

        manualArray.insertAtStart(elementToInsert);

        int[] arrayWithElementInserted = new int[]{10, 3, 17, 75, 80, 202};

        assertArrayEquals(arrayWithElementInserted, manualArray.toArray(), "Array should be equal to arrayWithElementInserted.");
    }

    @Test
    void testManualArrayInsertAtEnd() {

        int elementToInsert = 10;

        ManualArray manualArray = new ManualArray(array);

        manualArray.insertAtEnd(elementToInsert);

        int[] arrayWithElementInserted = new int[]{3, 17, 75, 80, 202, 10};

        assertArrayEquals(arrayWithElementInserted, manualArray.toArray(), "Array should be equal to arrayWithElementInserted.");
    }

    @Test
    void testManualArrayInsertAtIndexWithIndexLessThanZero() {

        int indexLessThanZero = -5;
        int elementToInsert = 10;

        ManualArray manualArray = new ManualArray(array);

        ArrayIndexOutOfBoundsException exception = assertThrows(
                ArrayIndexOutOfBoundsException.class,
                () -> manualArray.insertAtIndex(indexLessThanZero, elementToInsert),
                "Array index should not be less than zero."
        );
    }

    @Test
    void testManualArrayInsertAtIndexWithIndexGreaterThanSize() {

        int indexGreaterThanZero = 15;
        int elementToInsert = 10;

        ManualArray manualArray = new ManualArray(array);

        ArrayIndexOutOfBoundsException exception = assertThrows(
                ArrayIndexOutOfBoundsException.class,
                () -> manualArray.insertAtIndex(indexGreaterThanZero, elementToInsert),
                "Array index should not be greater than size."
        );
    }

    @Test
    void testManualArrayInsertAtIndex() {

        int index = 2;
        int elementToInsert = 10;

        ManualArray manualArray = new ManualArray(array);

        manualArray.insertAtIndex(index, elementToInsert);

        int[] arrayWithElementInserted = new int[]{3, 17, 10, 75, 80, 202};

        assertArrayEquals(arrayWithElementInserted, manualArray.toArray(), "Array should be equal to arrayWithElementInserted.");
    }

    // DELETE
    @Test
    void testManualArrayDeleteFromStartOfEmptyArray() {

        ManualArray manualArray = new ManualArray();

        IllegalStateException exception = assertThrows(
                IllegalStateException.class,
                () -> manualArray.deleteFromStart(),
                "Array should not be empty."
        );
    }

    @Test
    void testManualArrayDeleteFromStart() {

        ManualArray manualArray = new ManualArray(array);

        manualArray.deleteFromStart();

        int[] arrayWithElementDeleted = new int[]{17, 75, 80, 202};

        assertArrayEquals(arrayWithElementDeleted, manualArray.toArray(), "Array should be equal to arrayWithElementDeleted.");
    }

    @Test
    void testManualArrayDeleteFromEndOfEmptyArray() {

        ManualArray manualArray = new ManualArray();

        IllegalStateException exception = assertThrows(
                IllegalStateException.class,
                () -> manualArray.deleteFromEnd(),
                "Array should not be empty."
        );
    }

    @Test
    void testManualArrayDeleteFromEnd() {

        ManualArray manualArray = new ManualArray(array);

        manualArray.deleteFromEnd();

        int[] arrayWithElementDeleted = new int[]{3, 17, 75, 80};

        assertArrayEquals(arrayWithElementDeleted, manualArray.toArray(), "Array should be equal to arrayWithElementDeleted.");
    }

    @Test
    void testManualArrayDeleteFromIndexOfEmptyArray() {

        int index = 0;

        ManualArray manualArray = new ManualArray();

        IllegalStateException exception = assertThrows(
                IllegalStateException.class,
                () -> manualArray.deleteFromIndex(index),
                "Array should not be empty."
        );
    }

    @Test
    void testManualArrayDeleteFromIndexWithIndexLessThanZero() {

        int indexLessThanZero = -5;

        ManualArray manualArray = new ManualArray(array);

        ArrayIndexOutOfBoundsException exception = assertThrows(
                ArrayIndexOutOfBoundsException.class,
                () -> manualArray.deleteFromIndex(indexLessThanZero),
                "Array index should not be less than zero."
        );
    }

    @Test
    void testManualArrayDeleteAtIndexWithIndexGreaterThanSize() {

        int indexGreaterThanZero = 15;

        ManualArray manualArray = new ManualArray(array);

        ArrayIndexOutOfBoundsException exception = assertThrows(
                ArrayIndexOutOfBoundsException.class,
                () -> manualArray.deleteFromIndex(indexGreaterThanZero),
                "Array index should not be greater than size."
        );
    }

    @Test
    void testManualArrayDeleteAtIndex() {

        int index = 1;

        ManualArray manualArray = new ManualArray(array);

        manualArray.deleteFromIndex(index);

        int[] arrayWithElementDeleted = new int[]{3, 17, 80, 202};

        assertArrayEquals(arrayWithElementDeleted, manualArray.toArray(), "Array should be equal to arrayWithElementDeleted.");
    }
}
