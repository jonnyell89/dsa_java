package org.example;

import java.util.Arrays;

public class ManualSet {

    private static final int DEFAULT_CAPACITY = 10;

    protected int capacity;
    protected int[] set;
    protected int size;

    public ManualSet() {

        this.capacity = DEFAULT_CAPACITY;
        this.set = new int[capacity];
        this.size = 0;
    }

    public ManualSet(int initialCapacity) {

        if (initialCapacity < 0) {
            throw new IllegalArgumentException("Set initial capacity cannot be less than zero.");
        }

        this.capacity = Utils.getCapacity(initialCapacity, DEFAULT_CAPACITY);
        this.set = new int[capacity];
        this.size = 0;
    }

    public int[] getSet() { return set; }

    protected void setSet(int[] set) { this.set = set; }

    public int getSize() { return size; }

    protected void incrementSize() { this.size++; }

    protected void decrementSize() { this.size--; }

    public int[] toSet() {

        int[] toSet = new int[size];

        for (int i = 0; i < size; i++) {

            toSet[i] = set[i];
        }

        return toSet;
    }

    protected boolean isDuplicate(int element) {

        // Time complexity: O(N)

        for (int i = 0; i < size; i++) {

            if (element == set[i]) {

                return true;
            }
        }

        return false;
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

        setSet(Utils.manageCapacity(set, size, DEFAULT_CAPACITY));

        for (int i = size; i > 0; i--) { // Iterates from the end to the start.

            set[i] = set[i - 1]; // Shifts elements -->
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

        setSet(Utils.manageCapacity(set, size, DEFAULT_CAPACITY));

        set[size] = element; // Inserts element at the end.

        incrementSize();

        return this;
    }

    public ManualSet insertAtIndex(int index, int element) {

        // Time complexity: O(N)

        if (isDuplicate(element)) {
            throw new IllegalArgumentException("Element already present in set: " + element);
        }

        if (index < 0 || index > size) {
            throw new ArrayIndexOutOfBoundsException("Index out of bounds: " + index);
        }

        setSet(Utils.manageCapacity(set, size, DEFAULT_CAPACITY));

        for (int i = size; i > index; i--) { // Iterates from the end to the index.

            set[i] = set[i - 1]; // Shifts elements -->
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

        setSet(Utils.manageCapacity(set, size, DEFAULT_CAPACITY));

        for (int i = 0; i < size - 1; i++) { // Iterates from the start to the penultimate element.

            set[i] = set[i + 1]; // Shifts elements <--
        }

        set[size - 1] = 0; // Clears the last element which has already been shifted.

        decrementSize();

        return this;
    }

    public ManualSet deleteFromEnd() {

        // Time complexity: O(1)

        if (size == 0) {
            throw new IllegalStateException("Cannot delete from an empty set.");
        }

        setSet(Utils.manageCapacity(set, size, DEFAULT_CAPACITY));

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

        setSet(Utils.manageCapacity(set, size, DEFAULT_CAPACITY));

        for (int i = index; i < size - 1; i++) { // Iterates from index to the penultimate element.

            set[i] = set[i + 1]; // Shifts elements <--
        }

        set[size - 1] = 0; // Clears the last element which has already been shifted.

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
