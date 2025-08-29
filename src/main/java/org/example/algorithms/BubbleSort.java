package org.example.algorithms;

import org.example.collections.ManualArray;

public class BubbleSort {

    public static int[] bubbleSort(int[] iterable, int size) {
        // Time complexity: O(N^2)
        int unsortedEndIndex = size - 1;
        boolean isSorted = false;
        while (!isSorted) {
            isSorted = true;
            for (int i = 0; i < unsortedEndIndex; i++) {
                if (iterable[i] > iterable[i + 1]) {
                    int temp = iterable[i];
                    iterable[i] = iterable[i + 1];
                    iterable[i + 1] = temp;
                    isSorted = false;
                }
            }
            unsortedEndIndex--;
        }
        return iterable;
    }

    public static ManualArray bubbleSort(ManualArray manualArray) {
        // Time complexity: O(N^2)
        int unsortedEndIndex = manualArray.getSize() - 1;
        boolean isSorted = false;
        while(!isSorted) {
            isSorted = true;
            for (int i = 0; i < unsortedEndIndex; i++) {
                if (manualArray.read(i) > manualArray.read(i + 1)) {
                    manualArray.swapByIndex(i, i + 1);
                    isSorted = false;
                }
            }
            unsortedEndIndex--;
        }
        return manualArray;
    }
}
