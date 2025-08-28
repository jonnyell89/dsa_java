package org.example.algorithms;

import org.example.collections.ManualCollection;

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

    public static ManualCollection selectionSort(ManualCollection manualCollection) {
        // Time complexity: O(N^2)
        int size = manualCollection.getSize();
        for (int i = 0; i < size - 1; i++) {
            int lowestElementIndex = i;
            for (int j = i + 1; j < size; j++) {
                if (manualCollection.read(j) < manualCollection.read(lowestElementIndex)) {
                    lowestElementIndex = j;
                }
            }
            if (lowestElementIndex != i) {
                manualCollection.swapByIndex(i, lowestElementIndex);
            }
        }
        return manualCollection;
    }
}
