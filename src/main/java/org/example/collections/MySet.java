package org.example.collections;

import java.util.Arrays;
import java.util.Collection;

public class MySet<T> {

    private MyArray<T> data;

    public MySet() {
        this.data = new MyArray<>();
    }

    public MySet(int initialCapacity) {
        if (initialCapacity < 0) throw new IllegalArgumentException("MySet initial capacity cannot be less than zero.");

        this.data = new MyArray<>(initialCapacity);
    }

    public MySet(Collection<? extends T> collection) {
        if (collection == null) throw new NullPointerException("MySet cannot be null.");

        this.data = new MyArray<>(collection.size());

        for (T element : collection) {
            if (!contains(element)) data.insertAtEnd(element);
        }
    }

    public int getCapacity() { return data.getCapacity(); } // Only public for testing purposes.

    public int getSize() { return data.getSize(); }

    public T[] getData() { return data.getData(); } // Only public for testing purposes.

    public boolean isEmpty() { return data.getSize() == 0; }

    public T[] toArray() { return data.toArray(); }

    public boolean contains(T element) {
        // Time complexity: O(N)
        int size = getSize();

        for (int i = 0; i < size; i++) {
            T current = data.read(i);
            if (element == null ? current == null : element.equals(current)) {
                return true;
            }
        }
        return false;
    }

    public boolean add(T element) {
        // Time complexity: O(N)
        if (!contains(element)) {
            data.insertAtEnd(element);
            return true;
        }
        return false;
    }

    public boolean addAll(Collection<? extends T> collection) {
        // Time complexity: O(N)
        boolean modified = false;

        for (T element : collection) {
            if (!contains(element)) {
                data.insertAtEnd(element);
                modified = true;
            }
        }
        return modified;
    }

    public boolean remove(T element) {
        // Time complexity: O(N)
        if (contains(element)) {
            int index = data.search(element);
            data.deleteFromIndex(index);
            return true;
        }
        return false;
    }

    public boolean removeAll(Collection<? extends T> collection) {
        // Time complexity: O(N)
        boolean modified = false;

        for (T element : collection) {
            if (contains(element)) {
                int index = data.search(element);
                data.deleteFromIndex(index);
                modified = true;
            }
        }
        return modified;
    }

    public void clear() {
        this.data = new MyArray<>();
    }

    @Override
    public String toString() {
        return "MySet{" +
                "data=" + Arrays.toString(Arrays.copyOf(data.toArray(), data.getSize())) +
                '}';
    }
}
