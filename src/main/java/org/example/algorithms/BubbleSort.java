package org.example.algorithms;

import org.example.collections.MyArray;

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

    public static MyArray<Integer> bubbleSort(MyArray<Integer> myArray) {
        // Time complexity: O(N^2)
        int unsortedEndIndex = myArray.getSize() - 1;
        boolean isSorted = false;
        while(!isSorted) {
            isSorted = true;
            for (int i = 0; i < unsortedEndIndex; i++) {
                if (myArray.read(i) > myArray.read(i + 1)) {
                    myArray.swapByIndex(i, i + 1);
                    isSorted = false;
                }
            }
            unsortedEndIndex--;
        }
        return myArray;
    }
}
