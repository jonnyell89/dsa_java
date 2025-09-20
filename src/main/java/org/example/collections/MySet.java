package org.example.collections;

import java.util.Arrays;

public class MySet {

    protected final MyArray data;

    public MySet() {
        this.data = new MyArray();
    }

    public MySet(int initialCapacity) {
        if (initialCapacity < 0) throw new IllegalArgumentException("MySet initial capacity cannot be less than zero.");
        this.data = new MyArray(initialCapacity);
    }

    public MySet(int[] array) {
        if (array == null) throw new NullPointerException("MySet cannot be null.");
        this.data = new MyArray();
        for (int i = 0; i < array.length; i++) {
            int element = array[i];
            if (!contains(element)) data.insertAtEnd(element);
        }
    }

    public  int getCapacity() { return data.getCapacity(); } // Only public for testing purposes.

    public int getSize() { return data.getSize(); }

    public int[] getData() { return data.getData(); } // Only public for testing purposes.

    public boolean isEmpty() { return data.getSize() == 0; }

    public int[] toArray() { return data.toArray(); }

    public boolean contains(int element) {
        // Time complexity: O(N)
        int size = getSize();
        for (int i = 0; i < size; i++) {
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
        boolean modified = false;
        for (int i = 0; i < array.length; i++) {
            int element = array[i];
            if (!contains(element)) {
                data.insertAtEnd(element);
                modified = true;
            }
        }
        return modified;
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
        boolean modified = false;
        for (int i = 0; i < array.length; i++) {
            int element = array[i];
            if (contains(element)) {
                int index = data.search(element);
                data.deleteFromIndex(index);
                modified = true;
            }
        }
        return modified;
    }

    public void clear() {
        int size = getSize();
        while (size > 0) {
            data.deleteFromEnd();
            size--;
        }
    }

    @Override
    public String toString() {
        return "MySet{" +
                "data=" + Arrays.toString(Arrays.copyOf(data.toArray(), data.getSize())) +
                '}';
    }
}
