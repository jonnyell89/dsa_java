package org.example.collections.linked_list;

import org.example.collections.LinkedList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class LinkedListInsertTest {

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
}
