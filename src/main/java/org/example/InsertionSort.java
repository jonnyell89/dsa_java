package org.example;

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

    public static ManualCollection insertionSort(ManualCollection manualCollection) {
        int size = manualCollection.getSize();
        for (int i = 1; i < size; i++) {
            int temp = manualCollection.read(i);
            int position = i - 1;
            while (position >= 0) {
                if (manualCollection.read(position) > temp) {
                    manualCollection.replaceByIndex(position + 1, position);
                    position--;
                } else break;
            }
            manualCollection.setByIndex(position + 1, temp);
        }
        return manualCollection;
    }
}
