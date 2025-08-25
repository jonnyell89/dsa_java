package org.example;

public class BinarySearch {

    public static int binarySearch(int[] iterable, int size, int element) {

        int start = 0;
        int end = size - 1;

        while (start <= end) { // Ensures start == end is also checked.

            int midpoint = start + (end - start) / 2; // Automatic floor division.

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
