package org.example;

public class SelectionSort {

    public static int[] selectionSort(int[] iterable, int size) {
        // Time complexity: O(N^2)
        for (int i = 0; i < size - 1; i++) {
            int lowestElementIndex = i;
            for (int j = i + 1; j < size; j++) {
                if (iterable[j] < iterable[lowestElementIndex]) {
                    lowestElementIndex = j;
                }
            }
            if (lowestElementIndex != i) {
                int temp = iterable[i];
                iterable[i] = iterable[lowestElementIndex];
                iterable[lowestElementIndex] = temp;
            }
        }
        return iterable;
    }
}
