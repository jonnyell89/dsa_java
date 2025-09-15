package org.example.collections.linked_list;

import org.example.collections.LinkedList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

public class LinkedListSearchTest {

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
            assertEquals(data, result, String.format("Data at LinkedList[%d] should return index %d.", data, result));
        }
    }
}
