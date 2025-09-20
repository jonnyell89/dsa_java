package org.example.collections.manual_array;

import org.example.collections.MyArray;
import org.example.interfaces.IntBinaryOperator;
import org.example.interfaces.IntConsumer;
import org.example.interfaces.IntPredicate;
import org.example.interfaces.IntUnaryOperator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ManualArrayIteratorTest {

    private static final int DEFAULT_CAPACITY = 10;
    public final int[] array = new int[]{3, 17, 75, 80, 202};

    @Test
    void testManualArrayForEachIterator() {
        MyArray manualArrayForInsertion = new MyArray();
        MyArray manualArrayForTraversal = new MyArray(array);
        manualArrayForTraversal.forEach(new IntConsumer() {
            @Override
            public void accept(int element) {
                manualArrayForInsertion.insertAtEnd(element);
            }
        });
        assertArrayEquals(manualArrayForTraversal.toArray(), manualArrayForInsertion.toArray(), "ManualArrayForInsertion should be equal to ManualArrayForTraversal.");
    }

    @Test
    void testManualArrayForEachIteratorLambda() {
        MyArray manualArrayForInsertion = new MyArray();
        MyArray manualArrayForTraversal = new MyArray(array);
        manualArrayForTraversal.forEach(element -> manualArrayForInsertion.insertAtEnd(element));
        assertArrayEquals(manualArrayForTraversal.toArray(), manualArrayForInsertion.toArray());
    }

    @Test
    void testManualArrayFilterIterator() {
        MyArray manualArray = new MyArray(array);
        MyArray result = manualArray.filter(new IntPredicate() {
            @Override
            public boolean test(int element) {
                return element % 2 == 0;
            }
        });
        int[] arrayWithEvenElements = new int[]{80, 202};
        assertArrayEquals(arrayWithEvenElements, result.toArray(), "ManualArray result should be equal to arrayWithEvenElements.");
    }

    @Test
    void testManualArrayFilterIteratorLambda() {
        MyArray manualArray = new MyArray(array);
        MyArray result = manualArray.filter(element -> element % 2 == 0);
        int[] arrayWithEvenElements = new int[]{80, 202};
        assertArrayEquals(arrayWithEvenElements, result.toArray());
    }

    @Test
    void testManualArrayMapIterator() {
        MyArray manualArray = new MyArray(array);
        MyArray result = manualArray.map(new IntUnaryOperator() {
            @Override
            public int apply(int element) {
                return element * 2;
            }
        });
        int[] arrayWithDoubledElements = new int[]{6, 34, 150, 160, 404};
        assertArrayEquals(arrayWithDoubledElements, result.toArray(), "ManualArray result should be equal to arrayWithDoubledElements.");
    }

    @Test
    void testManualArrayMapIteratorLambda() {
        MyArray manualArray = new MyArray(array);
        MyArray result = manualArray.map(element -> element * 2);
        int[] arrayWithDoubledElements = new int[]{6, 34, 150, 160, 404};
        assertArrayEquals(arrayWithDoubledElements, result.toArray(), "ManualArray result should be equal to arrayWithDoubledElements.");
    }

    @Test
    void testManualArrayReduceIterator() {
        MyArray manualArray = new MyArray(array);
        int result = manualArray.reduce(new IntBinaryOperator() {
            @Override
            public int apply(int left, int right) {
                return left + right;
            }
        }, 0);
        int sumOfArrayElements = 377;
        assertEquals(sumOfArrayElements, result, "ManualArray result should be equal to sumOfArrayElements.");
    }

    @Test
    void testManualArrayReduceIteratorLambda() {
        MyArray manualArray = new MyArray(array);
        int result = manualArray.reduce((accumulator, element) -> accumulator + element, 0);
        int sumOfArrayElements = 377;
        assertEquals(sumOfArrayElements, result, "ManualArray result should be equal to sumOfArrayElements.");
    }

    @Test
    void testManualArraySomeIterator() {
        MyArray manualArray = new MyArray(array);
        boolean result = manualArray.some(new IntPredicate() {
            @Override
            public boolean test(int element) {
                return element % 2 != 0;
            }
        });
        assertTrue(result, "ManualArray should contain one or more odd numbers.");
    }

    @Test
    void testManualArraySomeIteratorLambda() {
        MyArray manualArray = new MyArray(array);
        boolean result = manualArray.some(element -> element % 2 != 0);
        assertTrue(result, "ManualArray should contain one or more odd numbers.");
    }

    @Test
    void testManualArrayEveryIterator() {
        MyArray manualArray = new MyArray(array);
        boolean result = manualArray.every(new IntPredicate() {
            @Override
            public boolean test(int element) {
                return element >= 0;
            }
        });
        assertTrue(result, "ManualArray should contain all non-negative numbers.");
    }

    @Test
    void testManualArrayEveryIteratorLambda() {
        MyArray manualArray = new MyArray(array);
        boolean result = manualArray.every(element -> element >= 0);
        assertTrue(result, "ManualArray should contain all non-negative numbers.");
    }
}
