package org.example;

import java.util.Arrays;

public abstract class ManualCollection {

    protected static final int DEFAULT_CAPACITY = 10;

    protected int capacity;
    protected int size;
    protected int[] data;

    public ManualCollection() {
        this.capacity = DEFAULT_CAPACITY;
        this.size = 0;
        this.data = new int[capacity];
    }

    public ManualCollection(int initialCapacity) {
        if (initialCapacity < 0) throw new IllegalArgumentException("Collection initial capacity cannot be less than zero.");
        this.capacity = DEFAULT_CAPACITY;
        this.size = 0;
        this.data = new int[capacity];
        setCapacity(initialCapacity);
    }

    protected void manageCapacity() {
        if (size == capacity) {
            int newCapacity = (size < DEFAULT_CAPACITY) ? DEFAULT_CAPACITY : capacity * 2;
            int[] newCollection = new int[newCapacity];
            for (int i = 0; i < size; i++) {
                newCollection[i] = data[i];
            }
            setData(newCollection);
        }

        if (size > DEFAULT_CAPACITY && size <= capacity / 4) {
            int newCapacity = (size / 2 < DEFAULT_CAPACITY) ? DEFAULT_CAPACITY : capacity / 2;
            int[] newCollection = new int[newCapacity];
            for (int i = 0; i < size; i++) {
                newCollection[i] = data[i];
            }
            setData(newCollection);
        }
    }

    protected void setCapacity(int initialCapacity) {
        int newCapacity = DEFAULT_CAPACITY;
        while (newCapacity < initialCapacity) {
            newCapacity = newCapacity * 2;
        }
        this.capacity = newCapacity;
    }

    public int getSize() { return size; }

    protected void incrementSize() { this.size++; }

    protected void decrementSize() { this.size--; }

    public int[] getData() { return data; }

    protected void setData(int[] data) { this.data = data; }

    public int[] toArray() {
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = data[i];
        }
        return array;
    }

    // READ
    public int read(int index) {
        // Time complexity: O(1)
        if (index < 0 || index >= size) throw new IndexOutOfBoundsException("Index out of bounds: " + index);
        return data[index];
    }

    // SEARCH
    public int search(int element) {
        // Time complexity: O(N)
        for (int i = 0; i < size; i++) {
            if (data[i] == element) {
                return i;
            }
        }
        throw new IllegalArgumentException("Element not present in collection: " + element);
    }

    // INSERT
    public ManualCollection insertAtStart(int element) {
        // Time complexity: O(N)
        manageCapacity();
        for (int i = size; i > 0; i--) { // Iterates from the end to the start.
            data[i] = data[i - 1]; // Shifts elements -->
        }
        data[0] = element; // Inserts element at the start.
        incrementSize();
        return this;
    }

    public ManualCollection insertAtEnd(int element) {
        // Time complexity: O(1)
        manageCapacity();
        data[size] = element; // Inserts element at the end.
        incrementSize();
        return this;
    }

    public ManualCollection insertAtIndex(int index, int element) {
        // Time complexity: O(N)
        if (index < 0 || index > size) throw new IndexOutOfBoundsException("Index out of bounds: " + index);
        manageCapacity();
        for (int i = size; i > index; i--) { // Iterates from the end to the index.
            data[i] = data[i - 1]; // Shifts elements -->
        }
        data[index] = element; // Inserts element at index.
        incrementSize();
        return this;
    }

    // DELETE
    public ManualCollection deleteFromStart() {
        // Time complexity: O(N)
        if (size == 0) throw new IllegalStateException("Cannot delete from an empty collection.");
        manageCapacity();
        for (int i = 0; i < size - 1; i++) { // Iterates from the start to the penultimate element.
            data[i] = data[i + 1]; // Shifts elements <--
        }
        data[size - 1] = 0; // Clears the last element which has already been shifted.
        decrementSize();
        return this;
    }

    public ManualCollection deleteFromEnd() {
        // Time complexity: O(1)
        if (size == 0) throw new IllegalStateException("Cannot delete from an empty collection.");
        manageCapacity();
        data[size - 1] = 0; // Deletes element at the end.
        decrementSize();
        return this;
    }

    public ManualCollection deleteFromIndex(int index) {
        // Time complexity: O(N)
        if (size == 0) throw new IllegalStateException("Cannot delete from an empty collection.");
        if (index < 0 || index >= size) throw new IndexOutOfBoundsException("Index out of bounds: " + index);
        manageCapacity();
        for (int i = index; i < size - 1; i++) { // Iterates from index to the penultimate element.
            data[i] = data[i + 1]; // Shifts elements <--
        }
        data[size - 1] = 0; // Clears the last element which has already been shifted.
        decrementSize();
        return this;
    }

    @Override
    public String toString() {
        return "ManualCollection{" +
                "data=" + Arrays.toString(Arrays.copyOf(data, size)) +
                '}';
    }
}
