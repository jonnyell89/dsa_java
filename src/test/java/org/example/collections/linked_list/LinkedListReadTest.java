package org.example.collections.linked_list;

import org.example.collections.LinkedList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

public class LinkedListReadTest {

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
}
