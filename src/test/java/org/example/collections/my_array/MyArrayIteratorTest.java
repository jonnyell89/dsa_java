package org.example.collections.my_array;

import org.example.collections.MyArray;
import org.example.interfaces.BinaryOperator;
import org.example.interfaces.Consumer;
import org.example.interfaces.Predicate;
import org.example.interfaces.UnaryOperator;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MyArrayIteratorTest {

    private final List<Integer> inputList = Arrays.asList(3, 17, 75, 80, 202);

    @Test
    void testMyArrayForEachIterator() {
        MyArray<Integer> myArrayForInsertion = new MyArray<>();
        MyArray<Integer> myArrayForTraversal = new MyArray<>(inputList);
        myArrayForTraversal.forEach(new Consumer<Integer>() {
            @Override
            public void accept(Integer element) {
                myArrayForInsertion.insertAtEnd(element);
            }
        });
        assertArrayEquals(myArrayForTraversal.toArray(), myArrayForInsertion.toArray(), "MyArrayForInsertion should be equal to MyArrayForTraversal.");
    }

    @Test
    void testMyArrayForEachIteratorLambda() {
        MyArray<Integer> myArrayForInsertion = new MyArray<>();
        MyArray<Integer> myArrayForTraversal = new MyArray<>(inputList);
        myArrayForTraversal.forEach(element -> myArrayForInsertion.insertAtEnd(element));
        assertArrayEquals(myArrayForTraversal.toArray(), myArrayForInsertion.toArray());
    }

    @Test
    void testMyArrayFilterIterator() {
        MyArray<Integer> myArray = new MyArray<>(inputList);
        MyArray<Integer> result = myArray.filter(new Predicate<Integer>() {
            @Override
            public boolean test(Integer element) {
                return element % 2 == 0;
            }
        });
        Integer[] arrayWithEvenElements = new Integer[]{80, 202};
        assertArrayEquals(arrayWithEvenElements, result.toArray(), "MyArray result should be equal to arrayWithEvenElements.");
    }

    @Test
    void testMyArrayFilterIteratorLambda() {
        MyArray<Integer> myArray = new MyArray<>(inputList);
        MyArray<Integer> result = myArray.filter(element -> element % 2 == 0);
        Integer[] arrayWithEvenElements = new Integer[]{80, 202};
        assertArrayEquals(arrayWithEvenElements, result.toArray());
    }

    @Test
    void testMyArrayMapIterator() {
        MyArray<Integer> myArray = new MyArray<>(inputList);
        MyArray<Integer> result = myArray.map(new UnaryOperator<Integer>() {
            @Override
            public Integer apply(Integer element) {
                return element * 2;
            }
        });
        Integer[] arrayWithDoubledElements = new Integer[]{6, 34, 150, 160, 404};
        assertArrayEquals(arrayWithDoubledElements, result.toArray(), "MyArray result should be equal to arrayWithDoubledElements.");
    }

    @Test
    void testMyArrayMapIteratorLambda() {
        MyArray<Integer> myArray = new MyArray<>(inputList);
        MyArray<Integer> result = myArray.map(element -> element * 2);
        Integer[] arrayWithDoubledElements = new Integer[]{6, 34, 150, 160, 404};
        assertArrayEquals(arrayWithDoubledElements, result.toArray(), "MyArray result should be equal to arrayWithDoubledElements.");
    }

    @Test
    void testMyArrayReduceIterator() {
        MyArray<Integer> myArray = new MyArray<>(inputList);
        int result = myArray.reduce(new BinaryOperator<Integer>() {
            @Override
            public Integer apply(Integer left, Integer right) {
                return left + right;
            }
        }, 0);
        int sumOfArrayElements = 377;
        assertEquals(sumOfArrayElements, result, "MyArray result should be equal to sumOfArrayElements.");
    }

    @Test
    void testMyArrayReduceIteratorLambda() {
        MyArray<Integer> myArray = new MyArray<>(inputList);
        int result = myArray.reduce((accumulator, element) -> accumulator + element, 0);
        int sumOfArrayElements = 377;
        assertEquals(sumOfArrayElements, result, "MyArray result should be equal to sumOfArrayElements.");
    }

    @Test
    void testMyArraySomeIterator() {
        MyArray<Integer> myArray = new MyArray<>(inputList);
        boolean result = myArray.some(new Predicate<Integer>() {
            @Override
            public boolean test(Integer element) {
                return element % 2 != 0;
            }
        });
        assertTrue(result, "MyArray should contain one or more odd numbers.");
    }

    @Test
    void testMyArraySomeIteratorLambda() {
        MyArray<Integer> myArray = new MyArray<>(inputList);
        boolean result = myArray.some(element -> element % 2 != 0);
        assertTrue(result, "MyArray should contain one or more odd numbers.");
    }

    @Test
    void testMyArrayEveryIterator() {
        MyArray<Integer> myArray = new MyArray<>(inputList);
        boolean result = myArray.every(new Predicate<Integer>() {
            @Override
            public boolean test(Integer element) {
                return element >= 0;
            }
        });
        assertTrue(result, "MyArray should contain all non-negative numbers.");
    }

    @Test
    void testMyArrayEveryIteratorLambda() {
        MyArray<Integer> myArray = new MyArray<>(inputList);
        boolean result = myArray.every(element -> element >= 0);
        assertTrue(result, "MyArray should contain all non-negative numbers.");
    }
}
