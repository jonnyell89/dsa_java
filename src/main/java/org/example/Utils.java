package org.example;

public class Utils {

    public static int getCapacity(int length, int minCapacity) {

        int capacity = minCapacity;

        while (capacity < length) {

            capacity = capacity * 2;
        }

        return capacity;
    }

    public static int[] manageCapacity(int[] iterable, int size, int minCapacity) {

        if (iterable.length == size) {

            int newCapacity = (iterable.length < minCapacity) ? minCapacity : iterable.length * 2;

            int[] newIterable = new int[newCapacity];

            for (int i = 0; i < size; i++) {

                newIterable[i] = iterable[i];
            }

            return newIterable;
        }

        if (iterable.length > minCapacity && size <= iterable.length / 4) {

            int newCapacity = (iterable.length / 2 < minCapacity) ? minCapacity : iterable.length / 2;

            int[] newIterable = new int[newCapacity];

            for (int i = 0; i < size; i++) {

                newIterable[i] = iterable[i];
            }

            return newIterable;
        }

        return iterable;
    }
}
