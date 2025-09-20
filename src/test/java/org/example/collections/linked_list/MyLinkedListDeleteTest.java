package org.example.collections.linked_list;

import org.example.collections.MyLinkedList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

public class MyLinkedListDeleteTest {

    private MyLinkedList<Integer> myLinkedList;

    @BeforeEach
    void testInit() {
        myLinkedList = new MyLinkedList<>();
        myLinkedList.insertAtStart(4);
        myLinkedList.insertAtStart(3);
        myLinkedList.insertAtStart(2);
        myLinkedList.insertAtStart(1);
        myLinkedList.insertAtStart(0);
    }

    // DELETE
    @Test
    void testMyLinkedListDeleteFromStartWhenEmpty() {
        myLinkedList = new MyLinkedList<>();
        NoSuchElementException exception = assertThrows(
                NoSuchElementException.class,
                () -> myLinkedList.deleteFromStart(),
                "Cannot delete from an empty MyLinkedList."
        );
    }

    @Test
    void testMyLinkedListDeleteFromStart() {
        int index = 0;
        Integer data = myLinkedList.read(index);
        Integer result = myLinkedList.deleteFromStart();
        assertEquals(data, result, String.format("Data %d should be equal to result %d.", data, result));
    }

    @Test
    void testMyLinkedListDeleteFromEndWhenEmpty() {
        myLinkedList = new MyLinkedList<>();
        NoSuchElementException exception = assertThrows(
                NoSuchElementException.class,
                () -> myLinkedList.deleteFromEnd(),
                "Cannot delete from an empty MyLinkedList."
        );
    }

    @Test
    void testMyLinkedListDeleteFromEndWithSizeOne() {
        myLinkedList = new MyLinkedList<>();
        Integer data = 5;
        myLinkedList.insertAtStart(data);
        Integer result = myLinkedList.deleteFromEnd();
        assertEquals(data, result, String.format("Data %d should be equal to result %d.", data, result));
    }

    @Test
    void testMyLinkedListDeleteFromEnd() {
        int index = myLinkedList.getSize() - 1;
        Integer data = myLinkedList.read(index);
        Integer result = myLinkedList.deleteFromEnd();
        assertEquals(data, result, String.format("Data %d should be equal to result %d.", data, result));
    }

    @Test
    void testMyLinkedListDeleteFromIndexWhenEmpty() {
        myLinkedList = new MyLinkedList<>();
        int index = 0;
        NoSuchElementException exception = assertThrows(
                NoSuchElementException.class,
                () -> myLinkedList.deleteFromIndex(index),
                "Cannot delete from an empty MyLinkedList."
        );
    }

    @Test
    void testMyLinkedListDeleteFromIndexWithIndexLessThanZero() {
        int indexLessThanZero = -5;
        IndexOutOfBoundsException exception = assertThrows(
                IndexOutOfBoundsException.class,
                () -> myLinkedList.deleteFromIndex(indexLessThanZero),
                "MyLinkedList index should not be less than zero."
        );
    }

    @Test
    void testMyLinkedListDeleteFromIndexWithIndexGreaterThanSize() {
        int indexGreaterThanSize = 15;
        IndexOutOfBoundsException exception = assertThrows(
                IndexOutOfBoundsException.class,
                () -> myLinkedList.deleteFromIndex(indexGreaterThanSize),
                "MyLinkedList index should not be greater than size."
        );
    }

    @Test
    void testMyLinkedListDeleteFromIndexWithIndexZero() {
        int index = 0;
        Integer data = myLinkedList.read(index);
        Integer result = myLinkedList.deleteFromIndex(index);
        assertEquals(data, result, String.format("Data %d should be equal to result %d.", data, result));
    }

    @Test
    void testMyLinkedListDeleteFromIndex() {
        int index = 1;
        Integer data = myLinkedList.read(index);
        Integer result = myLinkedList.deleteFromIndex(index);
        assertEquals(data, result, String.format("Data %d should be equal to result %d.", data, result));
    }
}
