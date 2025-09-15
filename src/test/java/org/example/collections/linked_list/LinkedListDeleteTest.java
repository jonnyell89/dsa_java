package org.example.collections.linked_list;

import org.example.collections.LinkedList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

public class LinkedListDeleteTest {

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
