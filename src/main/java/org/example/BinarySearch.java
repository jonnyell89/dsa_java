package org.example;

public class BinarySearch {

    public static int binarySearch(int[] iterable, int size, int element) {

        int startIndex = 0;
        int endIndex = size - 1;

        while (startIndex <= endIndex) {

            int midpoint = startIndex + (endIndex - startIndex) / 2;

            int midpointElement = iterable[midpoint];

            if (element == midpointElement) {
                return midpoint;
            }
            else if (element < midpointElement) {
                endIndex = midpoint - 1;
            }
            else {
                startIndex = midpoint + 1;
            }
        }

        return -1;
    }
}
