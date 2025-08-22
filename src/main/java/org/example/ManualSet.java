package org.example;

import java.util.Arrays;

import static org.example.Config.MIN_CAPACITY;

public class ManualSet {

    protected int[] set;
    protected int size;

    public ManualSet() {

        this.set = new int[MIN_CAPACITY];
        this.size = 0;
    }

    public ManualSet(int length) {

        if (length < 0) {
            throw new IllegalArgumentException("Set length cannot be negative.");
        }

        this.set = new int[getCapacity(length)];
        this.size = 0;
    }

    public int[] getSet() { return set; }

    protected void setSet(int[] set) { this.set = set; }

    public int getSize() { return size; }

    protected void setSize(int size) { this.size = size; }

    protected void incrementSize() { this.size++; }

    protected void decrementSize() { this.size--; }

    protected boolean isDuplicate(int element) {

        for (int i = 0; i < size; i++) {

            if (element == set[i]) {

                return true;
            }
        }

        return false;
    }

    protected int getCapacity(int length) {

        int capacity = MIN_CAPACITY;

        while (capacity < length) {

            capacity = capacity * 2;
        }

        return capacity;
    }

    protected void manageCapacity() {

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

        manageCapacity();

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
