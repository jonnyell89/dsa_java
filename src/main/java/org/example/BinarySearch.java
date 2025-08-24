package org.example;

public class BinarySearch {

    public static boolean isSorted(int[] iterable, int size) {

        if (size < 2) return true;

        boolean isAscending = iterable[0] < iterable[1];

        for (int i = 0; i < size - 1; i++) {

            if (isAscending && iterable[i] > iterable[i + 1]) return false;
            if (!isAscending && iterable[i] < iterable[i + 1]) return false;
        }

        return true;

//        if (isAscending) {
//            for (int i = 0; i < size - 1; i++) {
//                if (iterable[i] > iterable[i + 1]) {
//                    return false;
//                }
//            }
//
//            return true;
//
//        } else {
//
//            for (int i = 0; i < size - 1; i++) {
//                if (iterable[i] < iterable[i + 1]) {
//                    return false;
//                }
//            }
//
//            return true;
//        }
    }

    public static int binarySearch(int[] iterable, int size, int element) {

        int start = 0;
        int end = size - 1;

        while (start <= end) {

            int midpoint = (start + end) / 2;

            int midpointElement = iterable[midpoint];

            if (element == midpointElement) {
                return midpoint;
            }
            else if (element < midpointElement) {
                end = midpoint - 1;
            }
            else {
                start = midpoint + 1;
            }
        }

        return -1;
    }
}
