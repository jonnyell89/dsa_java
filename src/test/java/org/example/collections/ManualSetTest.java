package org.example.collections;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class ManualSetTest {

    private static final int DEFAULT_CAPACITY = 10;
    public final int[] set = new int[]{3, 17, 75, 80, 202};

    // INSTANTIATION
    @Test
    void testManualSetWithDefaultConstructor() {

        ManualSet manualSet = new ManualSet();

        assertEquals(DEFAULT_CAPACITY, manualSet.getData().length, String.format("Set length should be %d.", DEFAULT_CAPACITY));
        assertEquals(0, manualSet.getSize(), String.format("Set size should be %d", 0));

        int[] defaultSet = new int[DEFAULT_CAPACITY];

        assertArrayEquals(defaultSet, manualSet.getData(), String.format("Set should contain %d zeros.", DEFAULT_CAPACITY));
    }

    @Test
    void testManualSetWithLengthLessThanZero() {

        int lengthLessThanZero = -5;

        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> new ManualSet(lengthLessThanZero),
                "Set length should not be negative."
        );
    }

    @Test
    void testManualSetWithLengthZero() {

        int lengthZero = 0;

        ManualSet manualSet = new ManualSet(lengthZero);

        assertEquals(DEFAULT_CAPACITY, manualSet.getData().length, String.format("Set length should be %d.", DEFAULT_CAPACITY));
        assertEquals(0, manualSet.getSize(), String.format("Set size should be %d.", 0));

        int[] defaultSet = new int[DEFAULT_CAPACITY];

        assertArrayEquals(defaultSet, manualSet.getData(), String.format("Set should contain %d zeros.", DEFAULT_CAPACITY));
    }

    @Test
    void testManualSetWithLengthLessThanDefault() {

        int lengthLessThanDefault = 5;

        ManualSet manualSet = new ManualSet(lengthLessThanDefault);

        assertEquals(DEFAULT_CAPACITY, manualSet.getData().length, String.format("Set length should be %d.", DEFAULT_CAPACITY));
        assertEquals(0, manualSet.getSize(), String.format("Set size should be %d.", 0));

        int[] defaultSet = new int[DEFAULT_CAPACITY];

        assertArrayEquals(defaultSet, manualSet.getData(), String.format("Set should contain %d zeros.", DEFAULT_CAPACITY));
    }

    @Test
    void testManualSetWithLengthGreaterThanDefault() {

        int lengthGreaterThanDefault = 15;

        ManualSet manualSet = new ManualSet(lengthGreaterThanDefault);

        assertEquals(DEFAULT_CAPACITY * 2, manualSet.getData().length, String.format("Set length should be %d.", DEFAULT_CAPACITY * 2));
        assertEquals(0, manualSet.getSize(), String.format("Set size should be %d.", 0));

        int[] defaultSet = new int[DEFAULT_CAPACITY * 2];

        assertArrayEquals(defaultSet, manualSet.getData(), String.format("Set should contain %d zeros.", DEFAULT_CAPACITY * 2));
    }

//    @Test
//    void testManualSetWithNullSet() {
//
//        NullPointerException exception = assertThrows(
//                NullPointerException.class,
//                () -> new ManualSet(null),
//                "Set should not be null."
//        );
//    }
//
//    @Test
//    void testManualSetWithEmptySet() {
//
//        int[] emptySet = new int[]{};
//
//        ManualSet manualSet = new ManualSet(emptySet);
//
//        assertEquals(DEFAULT_CAPACITY, manualSet.getData().length, String.format("Set length should be %d.", DEFAULT_CAPACITY));
//        assertEquals(0, manualSet.getSize(), String.format("Set size should be %d.", 0));
//
//        int[] defaultSet = new int[DEFAULT_CAPACITY];
//
//        assertArrayEquals(defaultSet, manualSet.getData(), String.format("Set should contain %d zeros.", DEFAULT_CAPACITY));
//    }
//
//    @Test
//    void testManualSetWithSetLengthLessThanDefault() {
//
//        int lengthLessThanDefault = 5;
//
//        int[] inputSet = new int[lengthLessThanDefault];
//
//        ManualSet manualSet = new ManualSet(inputSet);
//
//        assertEquals(DEFAULT_CAPACITY, manualSet.getData().length, String.format("Set length should be %d.", DEFAULT_CAPACITY));
//        assertEquals(inputSet.length, manualSet.getSize(), String.format("Set size should be %d.", inputSet.length));
//
//        assertArrayEquals(inputSet, manualSet.toSet(), String.format("Set should contain %d zeros.", lengthLessThanDefault));
//    }
//
//    @Test
//    void testManualSetWithSetLengthGreaterThanDefault() {
//
//        int lengthGreaterThanDefault = 15;
//
//        int[] inputSet = new int[lengthGreaterThanDefault];
//
//        ManualSet manualSet = new ManualSet(inputSet);
//
//        assertEquals(DEFAULT_CAPACITY * 2, manualSet.getData().length, String.format("Set length should be %d.", DEFAULT_CAPACITY * 2));
//        assertEquals(inputSet.length, manualSet.getSize(), String.format("Set size should be %d.", inputSet.length));
//
//        assertArrayEquals(inputSet, manualSet.toSet(), String.format("Set should contain %d zeros.", lengthGreaterThanDefault));
//    }
//
//    // READ
//    @Test
//    void testManualSetReadWithIndexLessThanZero() {
//
//        int indexLessThanZero = -5;
//
//        ManualSet manualSet = new ManualSet(set);
//
//        IndexOutOfBoundsException exception = assertThrows(
//                IndexOutOfBoundsException.class,
//                () -> manualSet.read(indexLessThanZero),
//                "Set index should not be less than zero."
//        );
//    }
//
//    @Test
//    void testManualSetReadWithIndexGreaterThanSize() {
//
//        int indexGreaterThanSize = 15;
//
//        ManualSet manualSet = new ManualSet(set);
//
//        IndexOutOfBoundsException exception = assertThrows(
//                IndexOutOfBoundsException.class,
//                () -> manualSet.read(indexGreaterThanSize),
//                "Set index should not be greater than size."
//        );
//    }
//
//    @Test
//    void testManualSetReadWithValidIndex() {
//
//        ManualSet manualSet = new ManualSet(set);
//
//        for (int i = 0; i < manualSet.getSize(); i++) {
//
//            assertEquals(set[i], manualSet.read(i), String.format("Element at set[%d] should be %d.", i, set[i]));
//        }
//    }
//
//    // SEARCH
//    @Test
//    void testManualSetSearchWithInvalidElement() {
//
//        int elementNotPresentInSet = 10;
//
//        ManualSet manualSet = new ManualSet(set);
//
//        IllegalArgumentException exception = assertThrows(
//                IllegalArgumentException.class,
//                () -> manualSet.search(elementNotPresentInSet),
//                "Element should be present in set."
//        );
//    }
//
//    @Test
//    void testManualSetSearchWithValidElement() {
//
//        ManualSet manualSet = new ManualSet(set);
//
//        for (int i = 0; i < manualSet.getSize(); i++) {
//
//            assertEquals(i, manualSet.search(set[i]), String.format("Element at set[%d] should return the index %d.", i, i));
//        }
//    }
//
//    // INSERT
//    @Test
//    void testManualSetInsertAtStart() {
//
//        int elementToInsert = 10;
//
//        ManualSet manualSet = new ManualSet(set);
//
//        manualSet.insertAtStart(elementToInsert);
//
//        int[] setWithElementInserted = new int[]{10, 3, 17, 75, 80, 202};
//
//        assertArrayEquals(setWithElementInserted, manualSet.toSet(), "Set should be equal to setWithElementInserted.");
//    }
//
//    @Test
//    void testManualSetInsertAtEnd() {
//
//        int elementToInsert = 10;
//
//        ManualSet manualSet = new ManualSet(set);
//
//        manualSet.insertAtEnd(elementToInsert);
//
//        int[] setWithElementInserted = new int[]{3, 17, 75, 80, 202, 10};
//
//        assertArrayEquals(setWithElementInserted, manualSet.toSet(), "Set should be equal to setWithElementInserted.");
//    }
//
//    @Test
//    void testManualSetInsertAtIndexWithIndexLessThanZero() {
//
//        int indexLessThanZero = -5;
//        int elementToInsert = 10;
//
//        ManualSet manualSet = new ManualSet(set);
//
//        IndexOutOfBoundsException exception = assertThrows(
//                IndexOutOfBoundsException.class,
//                () -> manualSet.insertAtIndex(indexLessThanZero, elementToInsert),
//                "Set index should not be less than zero."
//        );
//    }
//
//    @Test
//    void testManualSetInsertAtIndexWithIndexGreaterThanSize() {
//
//        int indexGreaterThanZero = 15;
//        int elementToInsert = 10;
//
//        ManualSet manualSet = new ManualSet(set);
//
//        IndexOutOfBoundsException exception = assertThrows(
//                IndexOutOfBoundsException.class,
//                () -> manualSet.insertAtIndex(indexGreaterThanZero, elementToInsert),
//                "Set index should not be greater than size."
//        );
//    }
//
//    @Test
//    void testManualSetInsertAtIndex() {
//
//        int insertAtIndex = 2;
//        int elementToInsert = 10;
//
//        ManualSet manualSet = new ManualSet(set);
//
//        manualSet.insertAtIndex(insertAtIndex, elementToInsert);
//
//        int[] setWithElementInserted = new int[]{3, 17, 10, 75, 80, 202};
//
//        assertArrayEquals(setWithElementInserted, manualSet.toSet(), "Set should be equal to setWithElementInserted.");
//    }
//
//    // DELETE
//    @Test
//    void testManualSetDeleteFromStartOfEmptySet() {
//
//        ManualSet manualSet = new ManualSet();
//
//        IllegalStateException exception = assertThrows(
//                IllegalStateException.class,
//                () -> manualSet.deleteFromStart(),
//                "Set should not be empty."
//        );
//    }
//
//    @Test
//    void testManualSetDeleteFromStart() {
//
//        ManualSet manualSet = new ManualSet(set);
//
//        manualSet.deleteFromStart();
//
//        int[] setWithElementDeleted = new int[]{17, 75, 80, 202};
//
//        assertArrayEquals(setWithElementDeleted, manualSet.toSet(), "Set should be equal to setWithElementDeleted.");
//    }
//
//    @Test
//    void testManualSetDeleteFromEndOfEmptySet() {
//
//        ManualSet manualSet = new ManualSet();
//
//        IllegalStateException exception = assertThrows(
//                IllegalStateException.class,
//                () -> manualSet.deleteFromEnd(),
//                "Set should not be empty."
//        );
//    }
//
//    @Test
//    void testManualSetDeleteFromEnd() {
//
//        ManualSet manualSet = new ManualSet(set);
//
//        manualSet.deleteFromEnd();
//
//        int[] setWithElementDeleted = new int[]{3, 17, 75, 80};
//
//        assertArrayEquals(setWithElementDeleted, manualSet.toSet(), "Set should be equal to setWithElementDeleted.");
//    }
//
//    @Test
//    void testManualSetDeleteFromIndexOfEmptySet() {
//
//        int deleteFromIndex = 0;
//
//        ManualSet manualSet = new ManualSet();
//
//        IllegalStateException exception = assertThrows(
//                IllegalStateException.class,
//                () -> manualSet.deleteFromIndex(deleteFromIndex),
//                "Set should not be empty."
//        );
//    }
//
//    @Test
//    void testManualSetDeleteFromIndexWithIndexLessThanZero() {
//
//        int indexLessThanZero = -5;
//
//        ManualSet manualSet = new ManualSet(set);
//
//        IndexOutOfBoundsException exception = assertThrows(
//                IndexOutOfBoundsException.class,
//                () -> manualSet.deleteFromIndex(indexLessThanZero),
//                "Set index should not be less than zero."
//        );
//    }
//
//    @Test
//    void testManualSetDeleteFromIndexWithIndexGreaterThanSize() {
//
//        int indexGreaterThanZero = 15;
//
//        ManualSet manualSet = new ManualSet(set);
//
//        IndexOutOfBoundsException exception = assertThrows(
//                IndexOutOfBoundsException.class,
//                () -> manualSet.deleteFromIndex(indexGreaterThanZero),
//                "Set index should not be greater than size."
//        );
//    }
//
//    @Test
//    void testManualSetDeleteFromIndex() {
//
//        int deleteFromIndex = 3;
//
//        ManualSet manualSet = new ManualSet(set);
//
//        manualSet.deleteFromIndex(deleteFromIndex);
//
//        int[] setWithElementDeleted = new int[]{3, 17, 75, 202};
//
//        assertArrayEquals(setWithElementDeleted, manualSet.toSet(), "Set should be equal to setWithElementDeleted.");
//    }
}
