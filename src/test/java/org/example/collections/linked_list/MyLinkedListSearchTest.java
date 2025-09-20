package org.example.collections.linked_list;

import org.example.collections.MyLinkedList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

public class MyLinkedListSearchTest {

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

    // SEARCH
    @Test
    void testMyLinkedListSearchWhenEmpty() {
        Integer data = 5;
        myLinkedList = new MyLinkedList<>();
        NoSuchElementException exception = assertThrows(
                NoSuchElementException.class,
                () -> myLinkedList.search(data),
                "MyLinkedList head is null."
        );
    }

    @Test
    void testMyLinkedListSearchWithInvalidData() {
        Integer data = 5;
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> myLinkedList.search(data),
                "Data is not present in MyLinkedList."
        );
    }

    @Test
    void testMyLinkedListSearchWithValidData() {
        int size = myLinkedList.getSize() - 1;
        for (int data = 0; data < size; data++) {
            int result = myLinkedList.search(data);
            assertEquals(data, result, String.format("Data at MyLinkedList[%d] should return index %d.", data, result));
        }
    }
}
