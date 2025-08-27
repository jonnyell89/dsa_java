package org.example;

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

    public static ManualCollection bubbleSort(ManualCollection manualCollection) {
        // Time complexity: O(N^2)
        int unsortedEndIndex = manualCollection.getSize() - 1;
        boolean isSorted = false;
        while(!isSorted) {
            isSorted = true;
            for (int i = 0; i < unsortedEndIndex; i++) {
                if (manualCollection.read(i) > manualCollection.read(i + 1)) {
                    manualCollection.swapByIndex(i, i + 1);
                    isSorted = false;
                }
            }
            unsortedEndIndex--;
        }
        return manualCollection;
    }
}
