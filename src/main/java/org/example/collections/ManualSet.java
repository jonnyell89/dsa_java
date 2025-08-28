package org.example.collections;

import java.util.Arrays;

public class ManualSet extends ManualCollection {

//    private static final int DEFAULT_CAPACITY = 10;

//    protected int capacity;
//    protected int size;
//    protected int[] data;

    public ManualSet() {
//        this.capacity = DEFAULT_CAPACITY;
//        this.size = 0;
//        this.data = new int[capacity];
        super();
    }

    public ManualSet(int initialCapacity) {
//        if (initialCapacity < 0) throw new IllegalArgumentException("Collection initial capacity cannot be less than zero.");
//        this.capacity = DEFAULT_CAPACITY;
//        this.size = 0;
//        this.data = new int[capacity];
//        setCapacity(initialCapacity);
        super(initialCapacity);
    }

    public boolean contains(int element) {
        // Time complexity: O(N)
        for (int i = 0; i < size; i++) {
            if (data[i] == element) {
                return true;
            }
        }
        return false;
    }

    // READ
//    public int read(int index) {
//        // Time complexity: O(1)
//        if (index < 0 || index >= size) throw new IndexOutOfBoundsException("Index out of bounds: " + index);
//        return data[index];
//    }

    // SEARCH
//    public int search(int element) {
//        // Time complexity: O(N)
//        for (int i = 0; i < size; i++) {
//            if (data[i] == element) {
//                return i;
//            }
//        }
//        throw new IllegalArgumentException("Element not present in collection: " + element);
//    }

    // INSERT
    @Override
    public ManualSet insertAtStart(int element) {
        // Time complexity: O(N)
        if (contains(element)) throw new IllegalArgumentException("Element already present in collection: " + element);
        manageCapacity();
        for (int i = size; i > 0; i--) { // Iterates from the end to the start.
            data[i] = data[i - 1]; // Shifts elements -->
        }
        data[0] = element; // Inserts element at the start.
        incrementSize();
        return this;
    }

    @Override
    public ManualSet insertAtEnd(int element) {
        // Time complexity: O(1)
        if (contains(element)) throw new IllegalArgumentException("Element already present in collection: " + element);
        manageCapacity();
        data[size] = element; // Inserts element at the end.
        incrementSize();
        return this;
    }

    @Override
    public ManualSet insertAtIndex(int index, int element) {
        // Time complexity: O(N)
        if (contains(element)) throw new IllegalArgumentException("Element already present in collection: " + element);
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
//    public ManualSet deleteFromStart() {
//        // Time complexity: O(N)
//        if (size == 0) throw new IllegalStateException("Cannot delete from an empty collection.");
//        manageCapacity();
//        for (int i = 0; i < size - 1; i++) { // Iterates from the start to the penultimate element.
//            data[i] = data[i + 1]; // Shifts elements <--
//        }
//        data[size - 1] = 0; // Clears the last element which has already been shifted.
//        decrementSize();
//        return this;
//    }

//    public ManualSet deleteFromEnd() {
//        // Time complexity: O(1)
//        if (size == 0) throw new IllegalStateException("Cannot delete from an empty collection.");
//        manageCapacity();
//        data[size - 1] = 0; // Deletes element at the end.
//        decrementSize();
//        return this;
//    }

//    public ManualSet deleteFromIndex(int index) {
//        // Time complexity: O(N)
//        if (size == 0) throw new IllegalStateException("Cannot delete from an empty collection.");
//        if (index < 0 || index >= size) throw new IndexOutOfBoundsException("Index out of bounds: " + index);
//        manageCapacity();
//        for (int i = index; i < size - 1; i++) { // Iterates from index to the penultimate element.
//            data[i] = data[i + 1]; // Shifts elements <--
//        }
//        data[size - 1] = 0; // Clears the last element which has already been shifted.
//        decrementSize();
//        return this;
//    }

//    @Override
//    public ManualSet forEach() {
//        return;
//    }
//
//    @Override
//    public ManualSet filter() {
//        return;
//    }
//
//    @Override
//    public ManualSet map() {
//        return;
//    }
//
//    @Override
//    public ManualSet reduce() {
//        return;
//    }

    @Override
    public String toString() {
        return "ManualSet{" +
                "data=" + Arrays.toString(Arrays.copyOf(data, size)) +
                '}';
    }
}
