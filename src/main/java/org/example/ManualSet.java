package org.example;

import java.util.Arrays;

public class ManualSet {

    private int[] set;
    private int size;
    private static final int MIN_CAPACITY = 10;

    public ManualSet() {

        this.set = new int[MIN_CAPACITY];
        this.size = 0;
    }

    public ManualSet(int capacity) {

        if (capacity < 0) {
            throw new IllegalArgumentException("Set capacity cannot be negative.");
        }

        int forceCapacity = capacity < MIN_CAPACITY ? MIN_CAPACITY : capacity;

        this.set = new int[forceCapacity];
        this.size = 0;
    }

    public int[] getSet() { return set; }

    private void setSet(int[] set) { this.set = set; }

    public int getSize() { return size; }

    private void setSize(int size) { this.size = size; }

    private void incrementSize() { this.size++; }

    private void decrementSize() { this.size--; }

    private boolean isDuplicate(int element) {

        for (int i = 0; i < size; i++) {

            if (element == set[i]) {

                return true;
            }
        }

        return false;
    }

    private void manageCapacity() {

        if (size == set.length) { // Expand

            int newCapacity = (set.length < MIN_CAPACITY) ? MIN_CAPACITY : set.length * 2;

            int[] newSet = new int[newCapacity];

            for (int i = 0; i < size; i++) {

                newSet[i] = set[i];
            }

            setSet(newSet);
        }

        if (set.length > MIN_CAPACITY && size <= set.length / 4) { // Contract

            int newCapacity = (set.length / 2 < MIN_CAPACITY) ? MIN_CAPACITY : set.length / 2;

            int[] newSet = new int[newCapacity];

            for (int i = 0; i < size; i++) {

                newSet[i] = set[i];
            }

            setSet(newSet);
        }
    }

    public boolean contains(int element) {

        return isDuplicate(element);
    }

    // READ
    public int read(int index) {

        // Time complexity: O(1)

        if (index < 0 || index >= size) {
            throw new ArrayIndexOutOfBoundsException("Index out of bounds: " + index);
        }

        return set[index];
    }

    // SEARCH
    public int search(int element) {

        // Time complexity: O(N)

        for (int i = 0; i < size; i++) {

            if (element == set[i]) {

                return i;
            }
        }

        throw new IllegalArgumentException("Element not present in set: " + element);
    }

    // INSERT
    public ManualSet insertAtStart(int element) {

        // Time complexity: O(N)

        if (isDuplicate(element)) {
            throw new IllegalArgumentException("Element already present in set: " + element);
        }

        manageCapacity();

        for (int i = size; i > 0; i--) { // Starts at the end, shifts elements ->

            set[i] = set[i - 1];
        }

        set[0] = element; // Inserts element at the start.

        incrementSize();

        return this;
    }

    public ManualSet insertAtEnd(int element) {

        // Time complexity: O(1)

        if (isDuplicate(element)) {
            throw new IllegalArgumentException("Element already present in set: " + element);
        }

        manageCapacity();

        set[size] = element; // Inserts element at the end.

        incrementSize();

        return this;
    }

    public ManualSet insertAtIndex(int element, int index) {

        // Time complexity: O(N)

        if (isDuplicate(element)) {
            throw new IllegalArgumentException("Element already present in set: " + element);
        }

        if (index < 0 || index > size) {
            throw new ArrayIndexOutOfBoundsException("Index out of bounds: " + index);
        }

        manageCapacity();

        for (int i = size; i > index; i--) { // Starts at the end, shifts elements ->

            set[i] = set[i - 1];
        }

        set[index] = element; // Inserts element at index.

        incrementSize();

        return this;
    }

    // DELETE
    public ManualSet deleteFromStart() {

        // Time complexity: O(N)

        if (size == 0) {
            throw new IllegalStateException("Cannot delete from an empty set.");
        }

        manageCapacity();

        for (int i = 0; i < size - 1; i++) { // Starts at the start, shifts elements <-

            set[i] = set[i + 1];
        }

        decrementSize();

        return this;
    }

    public ManualSet deleteFromEnd() {

        // Time complexity: O(N)

        if (size == 0) {
            throw new IllegalStateException("Cannot delete from an empty set.");
        }

        manageCapacity();

        set[size - 1] = 0; // Deletes element at the end.

        decrementSize();

        return this;
    }

    public ManualSet deleteFromIndex(int index) {

        // Time complexity: O(N)

        if (size == 0) {
            throw new IllegalStateException("Cannot delete from an empty set.");
        }

        if (index < 0 || index >= size) {
            throw new ArrayIndexOutOfBoundsException("Index out of bounds: " + index);
        }

        manageCapacity();

        for (int i = index; i < size - 1; i++) { // Starts at the index, shifts elements <-

            set[i] = set[i + 1];
        }

        decrementSize();

        return this;
    }

    @Override
    public String toString() {
        return "ManualSet{" +
                "set=" + Arrays.toString(Arrays.copyOf(set, size)) +
                '}';
    }
}
