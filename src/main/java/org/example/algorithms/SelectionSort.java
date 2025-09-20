package org.example.algorithms;

import org.example.collections.MyArray;

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

    public static MyArray selectionSort(MyArray myArray) {
        // Time complexity: O(N^2)
        int size = myArray.getSize();
        for (int i = 0; i < size - 1; i++) {
            int lowestElementIndex = i;
            for (int j = i + 1; j < size; j++) {
                if (myArray.read(j) < myArray.read(lowestElementIndex)) {
                    lowestElementIndex = j;
                }
            }
            if (lowestElementIndex != i) {
                myArray.swapByIndex(i, lowestElementIndex);
            }
        }
        return myArray;
    }
}
