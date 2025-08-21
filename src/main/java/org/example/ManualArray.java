package org.example;

import java.util.Arrays;

public class ManualArray {

    private int[] array;
    private int size;
    private static final int MIN_CAPACITY = 10;

    public ManualArray() {

        this.array = new int[MIN_CAPACITY];
        this.size = 0;
    }

    public ManualArray(int length) {

        if (length < 0) {
            throw new IllegalArgumentException("Array length cannot be negative.");
        }

        this.array = new int[getCapacity(length)];
        this.size = 0;
    }

    public ManualArray(int[] array) {

        if (array == null) {
            throw new NullPointerException("Array cannot be null.");
        }

        this.array = new int[getCapacity(array.length)];
        this.size = array.length;

        for (int i = 0; i < array.length; i++) {

            this.array[i] = array[i];
        }
    }

    private int getCapacity(int length) {

        int capacity = MIN_CAPACITY;

        while (capacity < length) {

            capacity = capacity * 2;
        }

        return capacity;
    }

    public int[] getArray() { return array; }

    private void setArray(int[] array) { this.array = array; }

    public int getSize() { return size; }

    private void setSize(int size) { this.size = size; }

    private void incrementSize() { this.size++; }

    private void decrementSize() { this.size--; }

    private void manageCapacity() {

        if (size == array.length) { // Expand

            int newCapacity = (array.length < MIN_CAPACITY) ? MIN_CAPACITY : array.length * 2;

            int[] newArray = new int[newCapacity];

            for (int i = 0; i < size; i++) {

                newArray[i] = array[i];
            }

            setArray(newArray);
        }

        if (array.length > MIN_CAPACITY && size <= array.length / 4) { // Contract

            int newCapacity = (array.length / 2 < MIN_CAPACITY) ? MIN_CAPACITY : array.length / 2;

            int[] newArray = new int[newCapacity];

            for (int i = 0; i < size; i++) {

                newArray[i] = array[i];
            }

            setArray(newArray);
        }
    }

    // READ
    public int read(int index) {

        // Time complexity: O(1)

        if (index < 0 || index >= size) {
            throw new ArrayIndexOutOfBoundsException("Index out of bounds: " + index);
        }

        return array[index];
    }

    // SEARCH
    public int search(int element) {

        // Time complexity: O(N)

        for (int i = 0; i < size; i++) {

            if (element == array[i]) {

                return i;
            }
        }

        throw new IllegalArgumentException("Element not present in array: " + element);
    }

    // INSERT
    public ManualArray insertAtStart(int element) {

        // Time complexity: O(N)

        manageCapacity();

        for (int i = size; i > 0; i--) { // Iterates from the end to the start.

            array[i] = array[i - 1]; // Shifts elements -->
        }

        array[0] = element; // Inserts element at the start.

        incrementSize();

        return this;
    }

    public ManualArray insertAtEnd(int element) {

        // Time complexity: O(1)

        manageCapacity();

        array[size] = element; // Inserts element at the end.

        incrementSize();

        return this;
    }

    public ManualArray insertAtIndex(int element, int index) {

        // Time complexity: O(N)

        if (index < 0 || index > size) {
            throw new ArrayIndexOutOfBoundsException("Index out of bounds: " + index);
        }

        manageCapacity();

        for (int i = size; i > index; i--) { // Iterates from the end to the index.

            array[i] = array[i - 1]; // Shifts elements -->
        }

        array[index] = element; // Inserts element at index.

        incrementSize();

        return this;
    }

    // DELETE
    public ManualArray deleteFromStart() {

        // Time complexity: O(N)

        if (size == 0) {
            throw new IllegalStateException("Cannot delete from an empty array.");
        }

        manageCapacity();

        for (int i = 0; i < size - 1; i++) { // Iterates from the start to the penultimate element.

            array[i] = array[i + 1]; // Shifts elements <--
        }

        array[size - 1] = 0; // Clears the last element which has already been shifted.

        decrementSize();

        return this;
    }

    public ManualArray deleteFromEnd() {

        // Time complexity: O(1)

        if (size == 0) {
            throw new IllegalStateException("Cannot delete from an empty array.");
        }

        manageCapacity();

        array[size - 1] = 0; // Deletes element at the end.

        decrementSize();

        return this;
    }

    public ManualArray deleteFromIndex(int index) {

        // Time complexity: O(N)

        if (size == 0) {
            throw new IllegalStateException("Cannot delete from an empty array.");
        }

        if (index < 0 || index >= size) {
            throw new ArrayIndexOutOfBoundsException("Index out of bounds: " + index);
        }

        manageCapacity();

        for (int i = index; i < size - 1; i++) { // Iterates from index to the penultimate element.

            array[i] = array[i + 1]; // Shifts elements <--
        }

        array[size - 1] = 0; // Clears the last element which has already been shifted.

        decrementSize();

        return this;
    }

    @Override
    public String toString() {
        return "ManualArray{" +
                "array=" + Arrays.toString(Arrays.copyOf(array, size)) +
                '}';
    }
}
