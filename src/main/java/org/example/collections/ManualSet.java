package org.example.collections;

import java.util.Arrays;

public class ManualSet {

    protected final ManualArray data;

    public ManualSet() {
        this.data = new ManualArray();
    }

    public ManualSet(int initialCapacity) {
        if (initialCapacity < 0) throw new IllegalArgumentException("ManualSet initial capacity cannot be less than zero.");
        this.data = new ManualArray(initialCapacity);
    }

    public ManualSet(int[] array) {
        if (array == null) throw new NullPointerException("ManualSet cannot be null.");
        this.data = new ManualArray();
        for (int i = 0; i < array.length; i++) {
            int element = array[i];
            if (!contains(element)) data.insertAtEnd(element);
        }
    }

    public boolean contains(int element) {
        // Time complexity: O(N)
        for (int i = 0; i < data.getSize(); i++) {
            if (data.read(i) == element) return true;
        }
        return false;
    }

    public boolean add(int element) {
        if (!contains(element)) {
            data.insertAtEnd(element);
            return true;
        }
        return false;
    }

    public boolean addAll(int[] array) {
        boolean added = true;
        for (int i = 0; i < array.length; i++) {
            int element = array[i];
            if (!contains(element)) {
                data.insertAtEnd(element);
            } else {
                added = false;
            }
        }
        return added;
    }

    public boolean remove(int element) {
        if (contains(element)) {
            int index = data.search(element);
            data.deleteFromIndex(index);
            return true;
        }
        return false;
    }

    public boolean removeAll(int[] array) {
        boolean removed = true;
        for (int i = 0; i < array.length; i++) {
            int element = array[i];
            if (contains(element)) {
                int index = data.search(element);
                data.deleteFromIndex(index);
            } else {
                removed = false;
            }
        }
        return removed;
    }

    public void clear() {
        int size = data.getSize();
        while (size > 0) {
            data.deleteFromEnd();
            size--;
        }
    }

    public int size() {
        return data.getSize();
    }

    public boolean isEmpty() {
        return data.getSize() == 0;
    }

    @Override
    public String toString() {
        return "ManualSet{" +
                "data=" + Arrays.toString(Arrays.copyOf(data.toArray(), data.getSize())) +
                '}';
    }
}
