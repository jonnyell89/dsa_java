package org.example;

public class InsertionSort {

    public static int[] insertionSort(int[] iterable, int size) {
        for (int i = 1; i < size; i++) {
            int temp = iterable[i];
            int position = i - 1;
            while (position >= 0) {
                if (iterable[position] > temp) {
                    iterable[i] = iterable[position];
                }
                position--;
            }
        }
    }
}
