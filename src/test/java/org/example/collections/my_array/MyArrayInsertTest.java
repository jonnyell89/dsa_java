package org.example.collections.my_array;

import org.example.collections.MyArray;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class MyArrayInsertTest {

    private final List<Integer> inputList = Arrays.asList(3, 17, 75, 80, 202);

    // INSERT
    @Test
    void testMyArrayInsertAtStart() {
        int elementToInsert = 10;
        MyArray<Integer> myArray = new MyArray<>(inputList);
        myArray.insertAtStart(elementToInsert);
        Integer[] arrayWithElementInserted = new Integer[]{10, 3, 17, 75, 80, 202};
        assertArrayEquals(arrayWithElementInserted, myArray.toArray(), "MyArray should be equal to arrayWithElementInserted.");
    }

    @Test
    void testMyArrayInsertAtEnd() {
        int elementToInsert = 10;
        MyArray<Integer> myArray = new MyArray<>(inputList);
        myArray.insertAtEnd(elementToInsert);
        Integer[] arrayWithElementInserted = new Integer[]{3, 17, 75, 80, 202, 10};
        assertArrayEquals(arrayWithElementInserted, myArray.toArray(), "MyArray should be equal to arrayWithElementInserted.");
    }

    @Test
    void testMyArrayInsertAtIndexWithIndexLessThanZero() {
        int indexLessThanZero = -5;
        int elementToInsert = 10;
        MyArray<Integer> myArray = new MyArray<>(inputList);
        ArrayIndexOutOfBoundsException exception = assertThrows(
                ArrayIndexOutOfBoundsException.class,
                () -> myArray.insertAtIndex(indexLessThanZero, elementToInsert),
                "MyArray index should not be less than zero."
        );
    }

    @Test
    void testMyArrayInsertAtIndexWithIndexGreaterThanSize() {
        int indexGreaterThanZero = 15;
        int elementToInsert = 10;
        MyArray<Integer> myArray = new MyArray<>(inputList);
        ArrayIndexOutOfBoundsException exception = assertThrows(
                ArrayIndexOutOfBoundsException.class,
                () -> myArray.insertAtIndex(indexGreaterThanZero, elementToInsert),
                "MyArray index should not be greater than size."
        );
    }

    @Test
    void testMyArrayInsertAtIndex() {
        int index = inputList.size() / 2;
        int elementToInsert = 10;
        MyArray<Integer> myArray = new MyArray<>(inputList);
        myArray.insertAtIndex(index, elementToInsert);
        Integer[] arrayWithElementInserted = new Integer[]{3, 17, 10, 75, 80, 202};
        assertArrayEquals(arrayWithElementInserted, myArray.toArray(), "MyArray should be equal to arrayWithElementInserted.");
    }
}
