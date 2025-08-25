package org.example;

public class BubbleSort {

    public static void bubbleSort(int[] iterable, int size) {

        int unsortedEndIndex = size - 1;
        boolean sorted = false;

        while (!sorted) {

            sorted = true;

            for (int i = 0; i < unsortedEndIndex; i++) {

                if (iterable[i] > iterable[i + 1]) {

                    int temp = iterable[i];
                    iterable[i] = iterable[i + 1];
                    iterable[i + 1] = temp;

                    sorted = false;
                }
            }

            unsortedEndIndex--;
        }
    }
}
