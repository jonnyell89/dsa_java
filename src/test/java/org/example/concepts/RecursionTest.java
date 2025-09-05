package org.example.concepts;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class RecursionTest {

    @Test
    void recursionDoubleArray() {
        int[] array = new int[]{1, 2, 3, 4, 5};
        int index = 0;
        Recursion.doubleArray(array, index);
        int[] result = new int[]{2, 4, 6, 8, 10};
        assertArrayEquals(result, array, "Array should be equal to result.");
    }

    @Test
    void recursionFactorial() {
        int number = 10;
        int factorial = Recursion.factorial(10);
        int result = 3628800;
        assertEquals(result, factorial, "Factorial should be equal to result.");
    }

    @Test
    void recursionSum() {
        int[] array = new int[]{1, 2, 3, 4, 5};
        int sum = Recursion.sum(array);
        int result = 15;
        assertEquals(result, sum, "Sum should be equal to result.");
    }

    @Test
    void recursionReverse() {
        String string = "abcde";
        String reverse = Recursion.reverse(string);
        String result = "edcba";
        assertEquals(result, reverse, "Reverse should be equal to result.");
    }

    @Test
    void recursionCountX() {
        String string = "axbxcxd";
        int countX = Recursion.countX(string);
        int result = 3;
        assertEquals(result, countX, "CountX should be equal to result.");
    }

    @Test
    void recursionNumberOfPaths() {
        int steps = 4;
        int paths = Recursion.numberOfPaths(steps);
        int result = 7;
        assertEquals(result, paths, "Paths should be equal to result.");
    }

    @Test
    void recursionAnagramsOf() {
        String string = "abc";
        List<String> anagramsOf = Recursion.anagramsOf(string);
        String[] anagrams = {"abc", "bac", "bca", "acb", "cab", "cba"};
        List<String> result = Arrays.asList(anagrams);
        assertEquals(result, anagramsOf, "AnagramsOf should be equal to result.");
    }

    @Test
    void recursionNumberOfCharacters() {
        String[] strings = {"ab", "c", "def", "ghij"};
        List<String> array = Arrays.asList(strings);
        int characters = Recursion.numberOfCharacters(array);
        int result = 10;
        assertEquals(result, characters, "Characters should be equal to result.");
    }

    @Test
    void recursionSelectEven() {
        int[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        List<Integer> evenNumbers = Recursion.selectEven(numbers);
        List<Integer> result = new ArrayList<>(Arrays.asList(2, 4, 6, 8, 10));
        assertEquals(result, evenNumbers, "EvenNumbers should be equal to result.");
    }

    @Test
    void recursionTriangular() {
        int number = 7;
        int triangle = Recursion.triangle(number);
        int result = 28;
        assertEquals(result, triangle, "Triangle should be equal to result.");
    }

    @Test
    void recursionIndexOfX() {
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        int indexOfX = Recursion.indexOfX(alphabet);
        int result = 23;
        assertEquals(result, indexOfX, "IndexOfX should be equal to result.");
    }

    @Test
    void recursionUniquePaths() {
        int rows = 3;
        int columns = 3;
        int uniquePaths = Recursion.uniquePaths(rows, columns);
        int result = 6;
        assertEquals(result, uniquePaths, "UniquePaths should be equal to result.");
    }
}
