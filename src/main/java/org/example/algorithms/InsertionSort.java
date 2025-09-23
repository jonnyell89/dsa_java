package org.example.algorithms;

import org.example.collections.MyArray;

public class InsertionSort {

    public static int[] insertionSort(int[] iterable, int size) {
        for (int i = 1; i < size; i++) {
            int temp = iterable[i];
            int position = i - 1;
            while (position >= 0) {
                if (iterable[position] > temp) {
                    iterable[position + 1] = iterable[position];
                    position--;
                } else break;
            }
            iterable[position + 1] = temp;
        }
        return iterable;
    }

    public static MyArray<Integer> insertionSort(MyArray<Integer> myArray) {
        int size = myArray.getSize();
        for (int i = 1; i < size; i++) {
            int temp = myArray.read(i);
            int position = i - 1;
            while (position >= 0) {
                if (myArray.read(position) > temp) {
                    myArray.replaceByIndex(position + 1, position);
                    position--;
                } else break;
            }
            myArray.setByIndex(position + 1, temp);
        }
        return myArray;
    }
}
