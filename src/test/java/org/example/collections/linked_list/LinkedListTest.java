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
        for (int i = 0; i < size; i++) {
            int result = linkedList.search(i);
            assertEquals(i, result, String.format("Data at LinkedList[%d] should return index %d.", i, i));
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
        int result = linkedList.read(index);
        assertEquals(data, result, String.format("Data at index %d should be %d.", index, data));
    }
}
