package org.example.collections.linked_list;

import org.example.collections.MyLinkedList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MyLinkedListInsertTest {

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
    // INSERT
    @Test
    void testMyLinkedListInsertAtStart() {
        Integer data = 5;
        myLinkedList.insertAtStart(data);
        int index = 0;
        Integer result = myLinkedList.read(index);
        assertEquals(data, result, String.format("Data %d should be equal to result %d.", data, result));
    }

    @Test
    void testMyLinkedListInsertAtEndWhenEmpty() {
        Integer data = 5;
        myLinkedList = new MyLinkedList<>();
        myLinkedList.insertAtEnd(data);
        int index = 0;
        Integer result = myLinkedList.read(index);
        assertEquals(data, result, String.format("Data %d should be equal to result %d.", data, result));
    }

    @Test
    void testMyLinkedListInsertAtEnd() {
        Integer data = 5;
        myLinkedList.insertAtEnd(data);
        int index = myLinkedList.getSize() - 1;
        Integer result = myLinkedList.read(index);
        assertEquals(data, result, String.format("Data %d should be equal to result %d.", data, result));
    }

    @Test
    void testMyLinkedListInsertAtIndexWithIndexLessThanZero() {
        int indexLessThanZero = -5;
        Integer data = 5;
        IndexOutOfBoundsException exception = assertThrows(
                IndexOutOfBoundsException.class,
                () -> myLinkedList.insertAtIndex(indexLessThanZero, data),
                "MyLinkedList index should not be less than zero."
        );
    }

    @Test
    void testMyLinkedListInsertAtIndexWithIndexGreaterThanSize() {
        int indexGreaterThanSize = 15;
        Integer data = 5;
        IndexOutOfBoundsException exception = assertThrows(
                IndexOutOfBoundsException.class,
                () -> myLinkedList.insertAtIndex(indexGreaterThanSize, data),
                "MyLinkedList index should not be greater than size."
        );
    }

    @Test
    void testMyLinkedListInsertAtIndexWithIndexZero() {
        int index = 0;
        Integer data = 5;
        myLinkedList.insertAtIndex(index, data);
        Integer result = myLinkedList.read(index);
        assertEquals(data, result, String.format("Data %d should be equal to result %d.", data, result));
    }

    @Test
    void testMyLinkedListInsertAtIndexWithValidIndex() {
        int index = 5;
        Integer data = 5;
        myLinkedList.insertAtIndex(index, data);
        Integer result = myLinkedList.read(index);
        assertEquals(data, result, String.format("Data %d should be equal to result %d.", data, result));
    }
}
