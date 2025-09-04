package org.example.concepts;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class RecursionTest {

    @Test
    void recursionDoubleArray() {
        int[] array = new int[]{1, 2, 3, 4, 5};
        int index = 0;
        Recursion.doubleArray(array, index);
        int[] doubledArray = new int[]{2, 4, 6, 8, 10};
        assertArrayEquals(doubledArray, array, "Array should be equal to doubledArray.");
    }

    @Test
    void recursionFactorial() {
        int number = 10;
        int factorial = Recursion.factorial(10);
        int factorialOfNumber = 3628800;
        assertEquals(factorialOfNumber, factorial, "Factorial should be equal to factorialOfNumber.");
    }

    @Test
    void recursionSum() {
        int[] array = new int[]{1, 2, 3, 4, 5};
        int sum = Recursion.sum(array);
        int sumOfArray = 15;
        assertEquals(sumOfArray, sum, "Sum should be equal to sumOfArray.");
    }

    @Test
    void recursionReverse() {
        String string = "abcde";
        String reverse = Recursion.reverse(string);
        String reversedString = "edcba";
        assertEquals(reversedString, reverse, "Reverse should be equal to reversedString.");
    }

    @Test
    void recursionNumberOfPaths() {
        int n = 4;
        int paths = Recursion.numberOfPaths(n);
        int numberOfPaths = 7;
        assertEquals(numberOfPaths, paths, "Paths should be equal to numberOfPaths.");
    }
}
