package org.example.collections.my_array;

import org.example.collections.MyArray;
import org.example.interfaces.BinaryOperator;
import org.example.interfaces.Consumer;
import org.example.interfaces.Predicate;
import org.example.interfaces.UnaryOperator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MyArrayIteratorTest {

    private static final int DEFAULT_CAPACITY = 10;
    public final int[] array = new int[]{3, 17, 75, 80, 202};

    @Test
    void testMyArrayForEachIterator() {
        MyArray myArrayForInsertion = new MyArray();
        MyArray myArrayForTraversal = new MyArray(array);
        myArrayForTraversal.forEach(new Consumer() {
            @Override
            public void accept(T element) {
                myArrayForInsertion.insertAtEnd(element);
            }
        });
        assertArrayEquals(myArrayForTraversal.toArray(), myArrayForInsertion.toArray(), "MyArrayForInsertion should be equal to MyArrayForTraversal.");
    }

    @Test
    void testMyArrayForEachIteratorLambda() {
        MyArray myArrayForInsertion = new MyArray();
        MyArray myArrayForTraversal = new MyArray(array);
        myArrayForTraversal.forEach(element -> myArrayForInsertion.insertAtEnd(element));
        assertArrayEquals(myArrayForTraversal.toArray(), myArrayForInsertion.toArray());
    }

    @Test
    void testMyArrayFilterIterator() {
        MyArray myArray = new MyArray(array);
        MyArray result = myArray.filter(new Predicate() {
            @Override
            public boolean test(int element) {
                return element % 2 == 0;
            }
        });
        int[] arrayWithEvenElements = new int[]{80, 202};
        assertArrayEquals(arrayWithEvenElements, result.toArray(), "MyArray result should be equal to arrayWithEvenElements.");
    }

    @Test
    void testMyArrayFilterIteratorLambda() {
        MyArray myArray = new MyArray(array);
        MyArray result = myArray.filter(element -> element % 2 == 0);
        int[] arrayWithEvenElements = new int[]{80, 202};
        assertArrayEquals(arrayWithEvenElements, result.toArray());
    }

    @Test
    void testMyArrayMapIterator() {
        MyArray myArray = new MyArray(array);
        MyArray result = myArray.map(new UnaryOperator() {
            @Override
            public int apply(int element) {
                return element * 2;
            }
        });
        int[] arrayWithDoubledElements = new int[]{6, 34, 150, 160, 404};
        assertArrayEquals(arrayWithDoubledElements, result.toArray(), "MyArray result should be equal to arrayWithDoubledElements.");
    }

    @Test
    void testMyArrayMapIteratorLambda() {
        MyArray myArray = new MyArray(array);
        MyArray result = myArray.map(element -> element * 2);
        int[] arrayWithDoubledElements = new int[]{6, 34, 150, 160, 404};
        assertArrayEquals(arrayWithDoubledElements, result.toArray(), "MyArray result should be equal to arrayWithDoubledElements.");
    }

    @Test
    void testMyArrayReduceIterator() {
        MyArray myArray = new MyArray(array);
        int result = myArray.reduce(new BinaryOperator() {
            @Override
            public int apply(int left, int right) {
                return left + right;
            }
        }, 0);
        int sumOfArrayElements = 377;
        assertEquals(sumOfArrayElements, result, "MyArray result should be equal to sumOfArrayElements.");
    }

    @Test
    void testMyArrayReduceIteratorLambda() {
        MyArray myArray = new MyArray(array);
        int result = myArray.reduce((accumulator, element) -> accumulator + element, 0);
        int sumOfArrayElements = 377;
        assertEquals(sumOfArrayElements, result, "MyArray result should be equal to sumOfArrayElements.");
    }

    @Test
    void testMyArraySomeIterator() {
        MyArray myArray = new MyArray(array);
        boolean result = myArray.some(new Predicate() {
            @Override
            public boolean test(int element) {
                return element % 2 != 0;
            }
        });
        assertTrue(result, "MyArray should contain one or more odd numbers.");
    }

    @Test
    void testMyArraySomeIteratorLambda() {
        MyArray myArray = new MyArray(array);
        boolean result = myArray.some(element -> element % 2 != 0);
        assertTrue(result, "MyArray should contain one or more odd numbers.");
    }

    @Test
    void testMyArrayEveryIterator() {
        MyArray myArray = new MyArray(array);
        boolean result = myArray.every(new Predicate() {
            @Override
            public boolean test(int element) {
                return element >= 0;
            }
        });
        assertTrue(result, "MyArray should contain all non-negative numbers.");
    }

    @Test
    void testMyArrayEveryIteratorLambda() {
        MyArray myArray = new MyArray(array);
        boolean result = myArray.every(element -> element >= 0);
        assertTrue(result, "MyArray should contain all non-negative numbers.");
    }
}
