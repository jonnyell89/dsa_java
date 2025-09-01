package org.example.collections;

import org.example.interfaces.IntBinaryOperator;
import org.example.interfaces.IntConsumer;
import org.example.interfaces.IntPredicate;
import org.example.interfaces.IntUnaryOperator;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;

import java.util.jar.Manifest;

import static org.junit.jupiter.api.Assertions.*;

public class ManualArrayTest {

    private static final int DEFAULT_CAPACITY = 10;
    public final int[] array = new int[]{3, 17, 75, 80, 202};

    // INSTANTIATION
    @Test
    void testManualArrayWithDefaultConstructor() {
        ManualArray manualArray = new ManualArray();
        assertEquals(DEFAULT_CAPACITY, manualArray.getData().length, String.format("ManualArray length should be %d.", DEFAULT_CAPACITY));
        assertEquals(0, manualArray.getSize(), String.format("ManualArray size should be %d", 0));
        int[] defaultArray = new int[DEFAULT_CAPACITY];
        assertArrayEquals(defaultArray, manualArray.getData(), String.format("ManualArray should contain %d zeros.", DEFAULT_CAPACITY));
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
        assertEquals(DEFAULT_CAPACITY, manualArray.getData().length, String.format("ManualArray length should be %d.", DEFAULT_CAPACITY));
        assertEquals(0, manualArray.getSize(), String.format("ManualArray size should be %d.", 0));
        int[] defaultArray = new int[DEFAULT_CAPACITY];
        assertArrayEquals(defaultArray, manualArray.getData(), String.format("ManualArray should contain %d zeros.", DEFAULT_CAPACITY));
    }

    @Test
    void testManualArrayWithLengthLessThanDefault() {
        int lengthLessThanDefault = 5;
        ManualArray manualArray = new ManualArray(lengthLessThanDefault);
        assertEquals(DEFAULT_CAPACITY, manualArray.getData().length, String.format("ManualArray length should be %d.", DEFAULT_CAPACITY));
        assertEquals(0, manualArray.getSize(), String.format("ManualArray size should be %d.", 0));
        int[] defaultArray = new int[DEFAULT_CAPACITY];
        assertArrayEquals(defaultArray, manualArray.getData(), String.format("ManualArray should contain %d zeros.", DEFAULT_CAPACITY));
    }

    @Test
    void testManualArrayWithLengthGreaterThanDefault() {
        int lengthGreaterThanDefault = 15;
        ManualArray manualArray = new ManualArray(lengthGreaterThanDefault);
        assertEquals(DEFAULT_CAPACITY * 2, manualArray.getData().length, String.format("ManualArray length should be %d.", DEFAULT_CAPACITY * 2));
        assertEquals(0, manualArray.getSize(), String.format("ManualArray size should be %d.", 0));
        int[] defaultArray = new int[DEFAULT_CAPACITY * 2];
        assertArrayEquals(defaultArray, manualArray.getData(), String.format("ManualArray should contain %d zeros.", DEFAULT_CAPACITY * 2));
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
        assertEquals(DEFAULT_CAPACITY, manualArray.getData().length, String.format("ManualArray length should be %d.", DEFAULT_CAPACITY));
        assertEquals(0, manualArray.getSize(), String.format("ManualArray size should be %d.", 0));
        int[] defaultArray = new int[DEFAULT_CAPACITY];
        assertArrayEquals(defaultArray, manualArray.getData(), String.format("ManualArray should contain %d zeros.", DEFAULT_CAPACITY));
    }

    @Test
    void testManualArrayWithArrayLengthLessThanDefault() {
        int lengthLessThanDefault = 5;
        int[] inputArray = new int[lengthLessThanDefault];
        ManualArray manualArray = new ManualArray(inputArray);
        assertEquals(DEFAULT_CAPACITY, manualArray.getData().length, String.format("ManualArray length should be %d.", DEFAULT_CAPACITY));
        assertEquals(inputArray.length, manualArray.getSize(), String.format("ManualArray size should be %d.", inputArray.length));
        assertArrayEquals(inputArray, manualArray.toArray(), String.format("ManualArray should contain %d zeros.", lengthLessThanDefault));
    }

    @Test
    void testManualArrayWithArrayLengthGreaterThanDefault() {
        int lengthGreaterThanDefault = 15;
        int[] inputArray = new int[lengthGreaterThanDefault];
        ManualArray manualArray = new ManualArray(inputArray);
        assertEquals(DEFAULT_CAPACITY * 2, manualArray.getData().length, String.format("ManualArray length should be %d.", DEFAULT_CAPACITY * 2));
        assertEquals(inputArray.length, manualArray.getSize(), String.format("ManualArray size should be %d.", inputArray.length));
        assertArrayEquals(inputArray, manualArray.toArray(), String.format("ManualArray should contain %d zeros.", lengthGreaterThanDefault));
    }

    // READ
    @Test
    void testManualArrayReadWithIndexLessThanZero() {
        int indexLessThanZero = -5;
        ManualArray manualArray = new ManualArray(array);
        ArrayIndexOutOfBoundsException exception = assertThrows(
                ArrayIndexOutOfBoundsException.class,
                () -> manualArray.read(indexLessThanZero),
                "ManualArray index should not be less than zero."
        );
    }

    @Test
    void testManualArrayReadWithIndexGreaterThanSize() {
        int indexGreaterThanSize = 15;
        ManualArray manualArray = new ManualArray(array);
        ArrayIndexOutOfBoundsException exception = assertThrows(
                ArrayIndexOutOfBoundsException.class,
                () -> manualArray.read(indexGreaterThanSize),
                "ManualArray index should not be greater than size."
        );
    }

    @Test
    void testManualArrayReadWithValidIndex() {
        ManualArray manualArray = new ManualArray(array);
        for (int i = 0; i < manualArray.getSize(); i++) {
            assertEquals(array[i], manualArray.read(i), String.format("Element at manualArray[%d] should be %d.", i, array[i]));
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
                "Element should not be present in ManualArray."
        );
    }

    @Test
    void testManualArraySearchWithValidElement() {
        ManualArray manualArray = new ManualArray(array);
        for (int i = 0; i < manualArray.getSize(); i++) {
            assertEquals(i, manualArray.search(array[i]), String.format("Element at manualArray[%d] should return the index %d.", i, i));
        }
    }

    // INSERT
    @Test
    void testManualArrayInsertAtStart() {
        int elementToInsert = 10;
        ManualArray manualArray = new ManualArray(array);
        manualArray.insertAtStart(elementToInsert);
        int[] arrayWithElementInserted = new int[]{10, 3, 17, 75, 80, 202};
        assertArrayEquals(arrayWithElementInserted, manualArray.toArray(), "ManualArray should be equal to arrayWithElementInserted.");
    }

    @Test
    void testManualArrayInsertAtEnd() {
        int elementToInsert = 10;
        ManualArray manualArray = new ManualArray(array);
        manualArray.insertAtEnd(elementToInsert);
        int[] arrayWithElementInserted = new int[]{3, 17, 75, 80, 202, 10};
        assertArrayEquals(arrayWithElementInserted, manualArray.toArray(), "ManualArray should be equal to arrayWithElementInserted.");
    }

    @Test
    void testManualArrayInsertAtIndexWithIndexLessThanZero() {
        int indexLessThanZero = -5;
        int elementToInsert = 10;
        ManualArray manualArray = new ManualArray(array);
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
        ManualArray manualArray = new ManualArray(array);
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
        ManualArray manualArray = new ManualArray(array);
        manualArray.insertAtIndex(index, elementToInsert);
        int[] arrayWithElementInserted = new int[]{3, 17, 10, 75, 80, 202};
        assertArrayEquals(arrayWithElementInserted, manualArray.toArray(), "ManualArray should be equal to arrayWithElementInserted.");
    }

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

    @Test
    void testManualArraySwapByIndexWithIndexLessThanZero() {
        int indexLessThanZero = -5;
        int index = 0;
        ManualArray manualArray = new ManualArray(array);
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
        ManualArray manualArray = new ManualArray(array);
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
        ManualArray manualArray = new ManualArray(array);
        manualArray.swapByIndex(i, j);
        int[] arrayWithElementsSwapped = new int[]{75, 17, 3, 80, 202};
        assertArrayEquals(arrayWithElementsSwapped, manualArray.toArray(), "ManualArray should be equal to arrayWithElementsSwapped.");
    }

    @Test
    void testManualArrayReplaceByIndexWithIndexLessThanZero() {
        int indexLessThanZero = -5;
        int index = 0;
        ManualArray manualArray = new ManualArray(array);
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
        ManualArray manualArray = new ManualArray(array);
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
        ManualArray manualArray = new ManualArray(array);
        manualArray.replaceByIndex(i, j);
        int[] arrayWithElementReplaced = new int[]{75, 17, 75, 80, 202};
        assertArrayEquals(arrayWithElementReplaced, manualArray.toArray(), "ManualArray should be equal to arrayWithElementReplaced.");
    }

    @Test
    void testManualArraySetByIndexWithIndexLessThanZero() {
        int indexLessThanZero = -5;
        int element = 0;
        ManualArray manualArray = new ManualArray(array);
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
        ManualArray manualArray = new ManualArray(array);
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
        ManualArray manualArray = new ManualArray(array);
        manualArray.setByIndex(index, element);
        int[] arrayWithElementSet = new int[]{3, 17, 0, 80, 202};
        assertArrayEquals(arrayWithElementSet, manualArray.toArray(), "ManualArray should be equal to arrayWithElementSet.");
    }

    @Test
    void testManualArrayForEachIterator() {
        ManualArray manualArrayForInsertion = new ManualArray();
        ManualArray manualArrayForTraversal = new ManualArray(array);
        manualArrayForTraversal.forEach(new IntConsumer() {
            @Override
            public void accept(int element) {
                manualArrayForInsertion.insertAtEnd(element);
            }
        });
        assertArrayEquals(manualArrayForTraversal.toArray(), manualArrayForInsertion.toArray(), "ManualArrayForInsertion should be equal to ManualArrayForTraversal.");
    }

    @Test
    void testManualArrayFilterIterator() {
        ManualArray manualArray = new ManualArray(array);
        ManualArray result = manualArray.filter(new IntPredicate() {
            @Override
            public boolean test(int element) {
                return element % 2 == 0;
            }
        });
        int[] arrayWithEvenElements = new int[]{80, 202};
        assertArrayEquals(arrayWithEvenElements, result.toArray(), "ManualArray result should be equal to arrayWithEvenElements.");
    }

    @Test
    void testManualArrayMapIterator() {
        ManualArray manualArray = new ManualArray(array);
        ManualArray result = manualArray.map(new IntUnaryOperator() {
            @Override
            public int apply(int element) {
                return element * 2;
            }
        });
        int[] arrayWithDoubledElements = new int[]{6, 34, 150, 160, 404};
        assertArrayEquals(arrayWithDoubledElements, result.toArray(), "ManualArray result should be equal to arrayWithDoubledElements.");
    }

    @Test
    void testManualArrayReduceIterator() {
        ManualArray manualArray = new ManualArray(array);
        int result = manualArray.reduce(new IntBinaryOperator() {
            @Override
            public int apply(int left, int right) {
                return left + right;
            }
        }, 0);
        int sumOfArrayElements = 377;
        assertEquals(sumOfArrayElements, result, "ManualArray result should be equal to sumOfArrayElements.");
    }

    @Test
    void testManualArraySomeIterator() {
        ManualArray manualArray = new ManualArray(array);
        boolean result = manualArray.some(new IntPredicate() {
            @Override
            public boolean test(int element) {
                return element % 2 != 0;
            }
        });
        assertTrue(result, "ManualArray should contain one or more odd numbers.");
    }

    @Test
    void testManualArrayEveryIterator() {
        ManualArray manualArray = new ManualArray(array);
        boolean result = manualArray.every(new IntPredicate() {
            @Override
            public boolean test(int element) {
                return element >= 0;
            }
        });
        assertTrue(result, "ManualArray should contain all positive numbers.");
    }
}
