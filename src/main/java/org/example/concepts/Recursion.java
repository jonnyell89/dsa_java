package org.example.concepts;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Recursion {

    // Chapter 10: Recursively Recurse with Recursion.

    // Exercise 4:
    public static void printAllItems(Object[] array) {
        for (Object element : array) {
            if (element instanceof Object[]) {
                printAllItems((Object[]) element); // Recursive step.
            } else {
                System.out.println(element); // Base case.
            }
        }
    }

    // Chapter 11: Learning to Write in Recursive.

    // Recursive Category: Repeatedly Execute.
    public static void countdown(int number) {
        System.out.println(number);
        if (number == 0) return; // Base case.
        countdown(number - 1); // Recursive step.
    }

    // Recursive Trick: Passing Extra Parameters.
    public static void doubleArray(int[] array, int index) {
        if (index >= array.length) return; // Base case.
        array[index] = array[index] * 2;
        doubleArray(array, index + 1); // Recursive step.
    }

    // Recursive Category: Calculations.
    public static int factorial(int number) {
        // 6 * 5 * 4 * 3 * 2 * 1 == 6 * factorial(5) -> Sub-problem.
        if (number == 1) return number; // Base case.
        return number * factorial(number - 1); // Recursive step.
    }

    // Top-down Recursion: A New Way of Thinking.
    public static int sum(int[] array) {
        // 1 + 2 + 3 + 4 + 5 == 1 + sum({2, 3, 4, 5}) -> Sub-problem.
        if (array.length == 1) return array[0]; // Base case.
        int[] subarray = Arrays.copyOfRange(array, 1, array.length);
        return array[0] + sum(subarray); // Recursive step.
    }

    // Top-down Recursion: A New Way of Thinking.
    public static String reverse(String string) {
        // "abcde" == "a" + reverse("bcde") -> Sub-problem.
        if (string.length() == 1) return string; // Base case.
        return reverse(string.substring(1)) + string.charAt(0); // Recursive step.
    }

    // Top-down Recursion: A New Way of Thinking.
    public static int countX(String string) {
        if (string.isEmpty()) return 0; // Base case.
        char firstChar = string.charAt(0);
        if (firstChar == 'x') {
            return 1 + countX(string.substring(1)); // Recursive step.
        } else {
            return countX(string.substring(1)); // Recursive step.
        }
    }

    // The Staircase Problem.
    public static int numberOfPaths(int steps) {
        if (steps <= 0) return 0; // Base case.
        if (steps == 1) return 1; // Accounts for numberOfPaths(1) -> numberOfPaths(0) + numberOfPaths(-1) + numberOfPaths(-2) == 1;
        if (steps == 2) return 2; // Accounts for numberOfPaths(2) -> numberOfPaths(1) + numberOfPaths(0) + numberOfPaths(-1) == 2;
        if (steps == 3) return 4; // Accounts for numberOfPaths(3) -> numberOfPaths(2) + numberOfPaths(1) + numberOfPaths(0) == 4;
        return numberOfPaths(steps - 1) + numberOfPaths(steps - 2) + numberOfPaths(steps - 3); // Recursive step.
    }

    // Anagram Generation.
    public static List<String> anagramsOf(String string) {
        if (string.length() == 1) { // Base case.
            List<String> base = new ArrayList<>();
            base.add(string);
            return base;
        }
        List<String> collection = new ArrayList<>();
        List<String> substringAnagrams = anagramsOf(string.substring(1)); // Recursive step.
        char firstChar = string.charAt(0);
        for (String substringAnagram : substringAnagrams) {
            for (int i = 0; i <= substringAnagram.length(); i++) {
                StringBuilder stringBuilder = new StringBuilder(substringAnagram);
                stringBuilder.insert(i, firstChar);
                collection.add(stringBuilder.toString());
            }
        }
        return collection;
    }

    // Exercise 1:
    public static int numberOfCharacters(List<String> array) {
        if (array.isEmpty()) return 0; // Base case.
        return array.get(0).length() + numberOfCharacters(array.subList(1, array.size())); // Recursive step.
    }

    // Exercise 2:
    public static List<Integer> selectEven(int[] numbers) {
        if (numbers.length == 0) return new ArrayList<>();
        List<Integer> result = new ArrayList<>();
        int number = numbers[0];
        if (number % 2 == 0) result.add(number);
        int[] subarray = Arrays.copyOfRange(numbers, 1, numbers.length);
        result.addAll(selectEven(subarray));
        return result;
    }

    // Exercise 3:
    public static int triangle(int number) {
        if (number == 0) return 0;
        return number + triangle(number - 1);
    }

    // Exercise 4:
    public static int indexOfX(String string) {
        if (string.charAt(0) == 'x') return 0;
        return indexOfX(string.substring(1)) + 1;
    }

    // Exercise 5:
    public static int uniquePaths(int rows, int columns) {
        if (rows == 1 || columns == 1) return 1;
        return uniquePaths(rows - 1, columns) + uniquePaths(rows, columns - 1);
    }

    // Chapter 12: Dynamic Programming.


}
