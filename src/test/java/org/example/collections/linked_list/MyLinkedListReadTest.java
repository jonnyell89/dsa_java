package org.example.collections.linked_list;

import org.example.collections.MyLinkedList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

public class MyLinkedListReadTest {

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

    // READ
    @Test
    void testMyLinkedListReadWhenEmpty() {
        int index = 0;
        myLinkedList = new MyLinkedList<>();
        NoSuchElementException exception = assertThrows(
                NoSuchElementException.class,
                () -> myLinkedList.read(index),
                "MyLinkedList head is null."
        );
    }

    @Test
    void testMyLinkedListReadWithIndexLessThanZero() {
        int indexLessThanZero = -5;
        IndexOutOfBoundsException exception = assertThrows(
                IndexOutOfBoundsException.class,
                () -> myLinkedList.read(indexLessThanZero),
                "MyLinkedList index should not be less than zero."
        );
    }

    @Test
    void testMyLinkedListReadWithIndexGreaterThanSize() {
        int indexGreaterThanSize = 15;
        IndexOutOfBoundsException exception = assertThrows(
                IndexOutOfBoundsException.class,
                () -> myLinkedList.read(indexGreaterThanSize),
                "MyLinkedList index should not be greater than size."
        );
    }

    @Test
    void testMyLinkedListReadWithValidIndex() {
        int size = myLinkedList.getSize() - 1;
        for (int i = 0; i < size; i++) {
            Integer result = myLinkedList.read(i);
            assertEquals(i, result, String.format("Data at index %d should be %d.", i, result));
        }
    }
}
