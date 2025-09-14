package org.example.collections.linked_list;

import org.example.collections.LinkedList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

public class LinkedListTest {

    private LinkedList<Integer> linkedList;

    @BeforeEach
    void testInit() {
        linkedList = new LinkedList<>();
        linkedList.insertAtStart(4);
        linkedList.insertAtStart(3);
        linkedList.insertAtStart(2);
        linkedList.insertAtStart(1);
        linkedList.insertAtStart(0);
    }

    // READ
    @Test
    void testLinkedListReadWhenEmpty() {
        int index = 0;
        linkedList = new LinkedList<>();
        NoSuchElementException exception = assertThrows(
                NoSuchElementException.class,
                () -> linkedList.read(index),
                "LinkedList head is null."
        );
    }

    @Test
    void testLinkedListReadWithIndexLessThanZero() {
        int indexLessThanZero = -5;
        IndexOutOfBoundsException exception = assertThrows(
                IndexOutOfBoundsException.class,
                () -> linkedList.read(indexLessThanZero),
                "LinkedList index should not be less than zero."
        );
    }

    @Test
    void testLinkedListReadWithIndexGreaterThanSize() {
        int indexGreaterThanSize = 15;
        IndexOutOfBoundsException exception = assertThrows(
                IndexOutOfBoundsException.class,
                () -> linkedList.read(indexGreaterThanSize),
                "LinkedList index should not be greater than size."
        );
    }

    @Test
    void testLinkedListReadWithValidIndex() {
        int size = linkedList.getSize() - 1;
        for (int i = 0; i < size; i++) {
            Integer result = linkedList.read(i);
            assertEquals(i, result, String.format("Data at index %d should be %d.", i, result));
        }
    }

    // SEARCH
    @Test
    void testLinkedListSearchWhenEmpty() {
        Integer data = 5;
        linkedList = new LinkedList<>();
        NoSuchElementException exception = assertThrows(
                NoSuchElementException.class,
                () -> linkedList.search(data),
                "LinkedList head is null."
        );
    }

    @Test
    void testLinkedListSearchWithInvalidData() {
        Integer data = 5;
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> linkedList.search(data),
                "Data is not present in LinkedList."
        );
    }

    @Test
    void testLinkedListSearchWithValidData() {
        int size = linkedList.getSize() - 1;
        for (int data = 0; data < size; data++) {
            int result = linkedList.search(data);
            assertEquals(data, result, String.format("Data at LinkedList[%d] should return index %d.", data, data));
        }
    }

    // INSERT
    @Test
    void testLinkedListInsertAtStart() {
        Integer data = 5;
        linkedList.insertAtStart(data);
        int index = 0;
        Integer result = linkedList.read(index);
        assertEquals(data, result, String.format("Data at index %d should be %d.", index, data));
    }

    @Test
    void testLinkedListInsertAtEndWhenEmpty() {
        Integer data = 5;
        linkedList = new LinkedList<>();
        linkedList.insertAtEnd(data);
        int index = 0;
        Integer result = linkedList.read(index);
        assertEquals(data, result, String.format("Data at index %d should be %d.", index, data));
    }

    @Test
    void testLinkedListInsertAtEnd() {
        Integer data = 5;
        linkedList.insertAtEnd(data);
        int index = linkedList.getSize() - 1;
        Integer result = linkedList.read(index);
        assertEquals(data, result, String.format("Data at index %d should be %d.", index, data));
    }

    @Test
    void testLinkedListInsertAtIndexWithIndexLessThanZero() {
        int indexLessThanZero = -5;
        Integer data = 5;
        IndexOutOfBoundsException exception = assertThrows(
                IndexOutOfBoundsException.class,
                () -> linkedList.insertAtIndex(indexLessThanZero, data),
                "LinkedList index should not be less than zero."
        );
    }

    @Test
    void testLinkedListInsertAtIndexWithIndexGreaterThanSize() {
        int indexGreaterThanSize = 15;
        Integer data = 5;
        IndexOutOfBoundsException exception = assertThrows(
                IndexOutOfBoundsException.class,
                () -> linkedList.insertAtIndex(indexGreaterThanSize, data),
                "LinkedList index should not be greater than size."
        );
    }

    @Test
    void testLinkedListInsertAtIndexWithIndexZero() {
        int index = 0;
        Integer data = 5;
        linkedList.insertAtIndex(index, data);
        Integer result = linkedList.read(index);
        assertEquals(data, result, String.format("Data at index %d should be %d.", index, data));
    }

    @Test
    void testLinkedListInsertAtIndexWithValidIndex() {
        int index = 5;
        Integer data = 5;
        linkedList.insertAtIndex(index, data);
        Integer result = linkedList.read(index);
        assertEquals(data, result, String.format("Data at index %d should be %d.", index, data));
    }

    // DELETE
    @Test
    void testLinkedListDeleteFromStartWhenEmpty() {
        linkedList = new LinkedList<>();
        NoSuchElementException exception = assertThrows(
                NoSuchElementException.class,
                () -> linkedList.deleteFromStart(),
                "Cannot delete from an empty LinkedList."
        );
    }

    @Test
    void testLinkedListDeleteFromStart() {
        int index = 0;
        Integer data = linkedList.read(index);
        Integer result = linkedList.deleteFromStart();
        assertEquals(data, result, String.format("Data at index %d should be %d.", index, data));
    }

    @Test
    void testLinkedListDeleteFromEndWhenEmpty() {
        linkedList = new LinkedList<>();
        NoSuchElementException exception = assertThrows(
                NoSuchElementException.class,
                () -> linkedList.deleteFromEnd(),
                "Cannot delete from an empty LinkedList."
        );
    }

    @Test
    void testLinkedListDeleteFromEndWithSizeOne() {
        linkedList = new LinkedList<>();
        Integer data = 5;
        linkedList.insertAtStart(data);
        Integer result = linkedList.deleteFromEnd();
        assertEquals(data, result, String.format("Data %d should be equal to result %d.", data, result));
    }

    @Test
    void testLinkedListDeleteFromEnd() {
        int index = linkedList.getSize() - 1;
        Integer data = linkedList.read(index);
        Integer result = linkedList.deleteFromEnd();
        assertEquals(data, result, String.format("Data %d should be equal to result %d.", data, result));
    }

    @Test
    void testLinkedListDeleteFromIndexWhenEmpty() {
        linkedList = new LinkedList<>();
        int index = 0;
        NoSuchElementException exception = assertThrows(
                NoSuchElementException.class,
                () -> linkedList.deleteFromIndex(index),
                "Cannot delete from an empty LinkedList."
        );
    }

    @Test
    void testLinkedListDeleteFromIndexWithIndexLessThanZero() {
        int indexLessThanZero = -5;
        IndexOutOfBoundsException exception = assertThrows(
                IndexOutOfBoundsException.class,
                () -> linkedList.deleteFromIndex(indexLessThanZero),
                "LinkedList index should not be less than zero."
        );
    }

    @Test
    void testLinkedListDeleteFromIndexWithIndexGreaterThanSize() {
        int indexGreaterThanSize = 15;
        IndexOutOfBoundsException exception = assertThrows(
                IndexOutOfBoundsException.class,
                () -> linkedList.deleteFromIndex(indexGreaterThanSize),
                "LinkedList index should not be greater than size."
        );
    }

    @Test
    void testLinkedListDeleteFromIndexWithIndexZero() {
        int index = 0;
        Integer data = linkedList.read(index);
        Integer result = linkedList.deleteFromIndex(index);
        assertEquals(data, result, String.format("Data %d should be equal to result %d.", data, result));
    }

    @Test
    void testLinkedListDeleteFromIndex() {
        int index = 1;
        Integer data = linkedList.read(index);
        Integer result = linkedList.deleteFromIndex(index);
        assertEquals(data, result, String.format("Data %d should be equal to result %d.", data, result));
    }
}
