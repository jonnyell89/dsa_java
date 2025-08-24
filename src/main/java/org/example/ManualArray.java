package org.example;

import java.util.Arrays;

import static org.example.Config.MIN_CAPACITY;

public class ManualArray {

    protected int[] array;
    protected int size;

    public ManualArray() {

        this.array = new int[MIN_CAPACITY];
        this.size = 0;
    }

    public ManualArray(int length) {

        if (length < 0) {
            throw new IllegalArgumentException("Array length cannot be less than zero.");
        }

        this.array = new int[Utils.getCapacity(length, MIN_CAPACITY)];
        this.size = 0;
    }

    public ManualArray(int[] array) {

        if (array == null) {
            throw new NullPointerException("Array cannot be null.");
        }

        this.array = new int[Utils.getCapacity(array.length, MIN_CAPACITY)];
        this.size = array.length;

        for (int i = 0; i < array.length; i++) {

            this.array[i] = array[i];
        }
    }

    public int[] getArray() { return array; }

    protected void setArray(int[] array) { this.array = array; }

    protected void resetArray() { this.array = new int[MIN_CAPACITY]; }

    public int getSize() { return size; }

    protected void resetSize() { this.size = 0; }

    protected void incrementSize() { this.size++; }

    protected void decrementSize() { this.size--; }

    public void clearArray() {

        resetArray();
        resetSize();
    }

    public int[] toArray() {

        int[] toArray = new int[size];

        for (int i = 0; i < size; i++) {

            toArray[i] = array[i];
        }

        return toArray;
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

        setArray(Utils.manageCapacity(array, size, MIN_CAPACITY));

        for (int i = size; i > 0; i--) { // Iterates from the end to the start.

            array[i] = array[i - 1]; // Shifts elements -->
        }

        array[0] = element; // Inserts element at the start.

        incrementSize();

        return this;
    }

    public ManualArray insertAtEnd(int element) {

        // Time complexity: O(1)

        setArray(Utils.manageCapacity(array, size, MIN_CAPACITY));

        array[size] = element; // Inserts element at the end.

        incrementSize();

        return this;
    }

    public ManualArray insertAtIndex(int index, int element) {

        // Time complexity: O(N)

        if (index < 0 || index > size) {
            throw new ArrayIndexOutOfBoundsException("Index out of bounds: " + index);
        }

        setArray(Utils.manageCapacity(array, size, MIN_CAPACITY));

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

        setArray(Utils.manageCapacity(array, size, MIN_CAPACITY));

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

        setArray(Utils.manageCapacity(array, size, MIN_CAPACITY));

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

        setArray(Utils.manageCapacity(array, size, MIN_CAPACITY));

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
