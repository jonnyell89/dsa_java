package org.example;

public class Utils {

    public static int getCapacity(int length, int defaultCapacity) {

        int capacity = defaultCapacity;

        while (capacity < length) {

            capacity = capacity * 2;
        }

        return capacity;
    }

    public static int[] manageCapacity(int[] iterable, int size, int defaultCapacity) {

        if (iterable.length == size) {

            int newCapacity = (iterable.length < defaultCapacity) ? defaultCapacity : iterable.length * 2;

            int[] newIterable = new int[newCapacity];

            for (int i = 0; i < size; i++) {

                newIterable[i] = iterable[i];
            }

            return newIterable;
        }

        if (iterable.length > defaultCapacity && size <= iterable.length / 4) {

            int newCapacity = (iterable.length / 2 < defaultCapacity) ? defaultCapacity : iterable.length / 2;

            int[] newIterable = new int[newCapacity];

            for (int i = 0; i < size; i++) {

                newIterable[i] = iterable[i];
            }

            return newIterable;
        }

        return iterable;
    }

    public static boolean isSorted(int[] iterable, int size) {

        if (size < 2) return true;

        boolean isAscending = iterable[0] < iterable[1];

        for (int i = 0; i < size - 1; i++) {

            if (isAscending && iterable[i] > iterable[i + 1]) return false;
            if (!isAscending && iterable[i] < iterable[i + 1]) return false;
        }

        return true;
    }

    public static boolean isDuplicate(int[] iterable, int element) {

        // Time complexity: O(N)

        for (int i = 0; i < iterable.length; i++) {

            if (iterable[i] == element) {

                return true;
            }
        }

        return false;
    }

    public static boolean hasDuplicate(int[] iterable) {

        // Time complexity: O(N^2)

        for (int i = 0; i < iterable.length; i++) {

            for (int j = 0; j < iterable.length; j++) {

                if (i != j && iterable[i] == iterable[j]) {

                    return true;
                }
            }
        }

        return false;
    }

    public static boolean hasDuplicate(int[] iterable, int largestElement) {

        // Time complexity: O(N)

        int[] existingElements = new int[largestElement + 1];

        for (int i = 0; i < iterable.length; i++) {

            int iterableElement = iterable[i];

            if (existingElements[iterableElement] == 1) return true;

            else existingElements[iterableElement] = 1;
        }

        return false;
    }

    public static int getLargestElement(int[] iterable) {

        // Time complexity: O(N)

        int largestElement = iterable[0];

        for (int i = 0; i < iterable.length; i++) {

            if (iterable[i] > largestElement) {

                largestElement = iterable[i];
            }
        }

        return largestElement;
    }
}
