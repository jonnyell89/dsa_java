package org.example;

import java.util.Arrays;

public class ManualSet {

    private int[] set;
    private int size;

    public ManualSet() {

        this.set = new int[10];
        this.size = 0;
    }

    public ManualSet(int length) {

        if (length < 0) {
            throw new IllegalArgumentException("Set length cannot be negative.");
        }

        this.set = new int[length];
        this.size = 0;
    }

    private int[] getSet() { return set; }

    private void setSet(int[] set) { this.set = set; }

    private int getSize() { return size; }

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

    private void ensureCapacity() {

        if (size > set.length) { // Expand

            int newCapacity = set.length == 0 ? 1 : set.length * 2;

            int[] newSet = new int[newCapacity];

            for (int i = 0; i < size; i++) {

                newSet[i] = set[i];
            }

            setSet(newSet);
        }

        if (size > 0 && size <= set.length / 4) { // Contract

            int newCapacity = size * 2;

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

        ensureCapacity();

        for (int i = size; i > 0; i--) {

            set[i] = set[i - 1];
        }

        set[0] = element;

        incrementSize();

        return this;
    }

    public ManualSet insertAtEnd(int element) {

        // Time complexity: O(N)

        if (isDuplicate(element)) {
            throw new IllegalArgumentException("Element already present in set: " + element);
        }

        ensureCapacity();

        set[size] = element;

        incrementSize();

        return this;
    }

    public ManualSet insertAtIndex(int element, int index) {

        // Time complexity: O(N)

        if (isDuplicate(element)) {
            throw new IllegalArgumentException("Element already present in set: " + element);
        }

        if (index < 0 || index >= size) {
            throw new ArrayIndexOutOfBoundsException("Index out of bounds: " + index);
        }

        ensureCapacity();

        for (int i = size; i > index; i--) {

            set[i] = set[i - 1];
        }

        set[index] = element;

        incrementSize();

        return this;
    }

    // DELETE
    public ManualSet deleteFromStart() {

        // Time complexity: O(N)

        if (size == 0) {
            throw new IllegalStateException("Cannot delete from an empty set.");
        }

        ensureCapacity();

        for (int i = 0; i < size - 1; i++) {

            int nextElement = i + 1 == size ? 0 : i + 1;

            set[i] = set[nextElement];
        }

        decrementSize();

        return this;
    }

    public ManualSet deleteFromEnd() {

        // Time complexity: O(N)

        if (size == 0) {
            throw new IllegalStateException("Cannot delete from an empty set.");
        }

        ensureCapacity();

        set[size - 1] = 0;

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

        ensureCapacity();

        for (int i = index; i < size - 1; i++) {

            int nextElement = i + 1 == size ? 0 : i + 1;

            set[i] = set[nextElement];
        }

        decrementSize();

        return this;
    }

    @Override
    public String toString() {
        return "ManualSet{" +
                "set=" + Arrays.toString(set) +
                '}';
    }
}
