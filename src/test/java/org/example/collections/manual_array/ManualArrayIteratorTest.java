package org.example.collections.manual_array;

import org.example.collections.ManualArray;
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
        ManualArray manualArrayForInsertion = new ManualArray();
        ManualArray manualArrayForTraversal = new ManualArray(array);
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
        ManualArray manualArrayForInsertion = new ManualArray();
        ManualArray manualArrayForTraversal = new ManualArray(array);
        manualArrayForTraversal.forEach(element -> manualArrayForInsertion.insertAtEnd(element));
        assertArrayEquals(manualArrayForTraversal.toArray(), manualArrayForInsertion.toArray());
    }

    @Test
    void testManualArrayFilterIterator() {
        ManualArray manualArray = new ManualArray(array);
        ManualArray result = manualArray.filter(new IntPredicate() {
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
        ManualArray manualArray = new ManualArray(array);
        ManualArray result = manualArray.filter(element -> element % 2 == 0);
        int[] arrayWithEvenElements = new int[]{80, 202};
        assertArrayEquals(arrayWithEvenElements, result.toArray());
    }

    @Test
    void testManualArrayMapIterator() {
        ManualArray manualArray = new ManualArray(array);
        ManualArray result = manualArray.map(new IntUnaryOperator() {
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
        ManualArray manualArray = new ManualArray(array);
        ManualArray result = manualArray.map(element -> element * 2);
        int[] arrayWithDoubledElements = new int[]{6, 34, 150, 160, 404};
        assertArrayEquals(arrayWithDoubledElements, result.toArray(), "ManualArray result should be equal to arrayWithDoubledElements.");
    }

    @Test
    void testManualArrayReduceIterator() {
        ManualArray manualArray = new ManualArray(array);
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
        ManualArray manualArray = new ManualArray(array);
        int result = manualArray.reduce((accumulator, element) -> accumulator + element, 0);
        int sumOfArrayElements = 377;
        assertEquals(sumOfArrayElements, result, "ManualArray result should be equal to sumOfArrayElements.");
    }

    @Test
    void testManualArraySomeIterator() {
        ManualArray manualArray = new ManualArray(array);
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
        ManualArray manualArray = new ManualArray(array);
        boolean result = manualArray.some(element -> element % 2 != 0);
        assertTrue(result, "ManualArray should contain one or more odd numbers.");
    }

    @Test
    void testManualArrayEveryIterator() {
        ManualArray manualArray = new ManualArray(array);
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
        ManualArray manualArray = new ManualArray(array);
        boolean result = manualArray.every(element -> element >= 0);
        assertTrue(result, "ManualArray should contain all non-negative numbers.");
    }
}
