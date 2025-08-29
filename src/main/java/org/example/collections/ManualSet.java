package org.example.collections;

import java.util.Arrays;

public class ManualSet {

    protected final ManualArray data;

    public ManualSet() {
        this.data = new ManualArray();
    }

    public ManualSet(int initialCapacity) {
        if (initialCapacity < 0) throw new IllegalArgumentException("Set initial capacity cannot be less than zero.");
        this.data = new ManualArray(initialCapacity);
    }

    public ManualSet(int[] array) {
        if (array == null) throw new NullPointerException("Set cannot be null.");
        this.data = new ManualArray();
        for (int i = 0; i < array.length; i++) {
            if (!contains(array[i])) this.data.insertAtEnd(array[i]);
        }
    }

    public boolean contains(int element) {
        // Time complexity: O(N)
        for (int i = 0; i < data.getSize(); i++) {
            if (data.read(i) == element) {
                return true;
            }
        }
        return false;
    }

    // INSERT
//    public ManualSet insertAtStart(int element) {
//        // Time complexity: O(N)
//        if (contains(element)) throw new IllegalArgumentException("Element already present in collection: " + element);
//        manageCapacity();
//        for (int i = size; i > 0; i--) { // Iterates from the end to the start.
//            data[i] = data[i - 1]; // Shifts elements -->
//        }
//        data[0] = element; // Inserts element at the start.
//        incrementSize();
//        return this;
//    }
//
//    public ManualSet insertAtEnd(int element) {
//        // Time complexity: O(1)
//        if (contains(element)) throw new IllegalArgumentException("Element already present in collection: " + element);
//        manageCapacity();
//        data[size] = element; // Inserts element at the end.
//        incrementSize();
//        return this;
//    }
//
//    public ManualSet insertAtIndex(int index, int element) {
//        // Time complexity: O(N)
//        if (contains(element)) throw new IllegalArgumentException("Element already present in collection: " + element);
//        if (index < 0 || index > size) throw new IndexOutOfBoundsException("Index out of bounds: " + index);
//        manageCapacity();
//        for (int i = size; i > index; i--) { // Iterates from the end to the index.
//            data[i] = data[i - 1]; // Shifts elements -->
//        }
//        data[index] = element; // Inserts element at index.
//        incrementSize();
//        return this;
//    }

    @Override
    public String toString() {
        return "ManualSet{" +
                "data=" + Arrays.toString(Arrays.copyOf(data.toArray(), data.getSize())) +
                '}';
    }
}
