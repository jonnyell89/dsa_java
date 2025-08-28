package org.example.collections;

import java.util.Arrays;

public class ManualSet extends ManualCollection {

    public ManualSet() {
        super();
    }

    public ManualSet(int initialCapacity) {
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

    @Override
    public String toString() {
        return "ManualSet{" +
                "data=" + Arrays.toString(Arrays.copyOf(data, size)) +
                '}';
    }
}
