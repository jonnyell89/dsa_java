package org.example.collections;

import org.example.interfaces.BinaryOperator;
import org.example.interfaces.Consumer;
import org.example.interfaces.Predicate;
import org.example.interfaces.UnaryOperator;

import java.util.Arrays;
import java.util.Collection;

public class MyArray<T> {

    private static final int DEFAULT_CAPACITY = 10;

    private int capacity;
    private int size;
    private T[] data;

    @SuppressWarnings("unchecked")
    public MyArray() {
        this.capacity = DEFAULT_CAPACITY;
        this.size = 0;
        this.data = (T[]) new Object[capacity];
    }

    @SuppressWarnings("unchecked")
    public MyArray(int initialCapacity) {
        if (initialCapacity < 0) throw new IllegalArgumentException("MyArray initial capacity cannot be less than zero.");

        this.capacity = DEFAULT_CAPACITY;
        ensureCapacity(initialCapacity);
        this.size = 0;
        this.data = (T[]) new Object[capacity];
    }

    @SuppressWarnings("unchecked")
    public MyArray(Collection<? extends T> collection) {
        if (collection == null) throw new NullPointerException("MyArray cannot be null.");

        this.capacity = DEFAULT_CAPACITY;
        ensureCapacity(collection.size());
        this.size = 0;
        this.data = (T[]) new Object[this.capacity];

        for (T element : collection) {
            this.data[size++] = element;
        }

//        for (int i = 0; i < collection.size(); i++) {
//            this.data[i] = collection[i];
//            size++;
//        }
    }

    @SuppressWarnings("unchecked")
    private void ensureCapacity() {
        if (size == capacity) {
            int newCapacity = (size < DEFAULT_CAPACITY) ? DEFAULT_CAPACITY : capacity * 2;
            T[] newData = (T[]) new Object[newCapacity];

            for (int i = 0; i < size; i++) {
                newData[i] = data[i];
            }

            this.capacity = newCapacity;
            this.data = newData;
        }

        if (size > DEFAULT_CAPACITY && size <= capacity / 4) {
            int newCapacity = (size / 2 < DEFAULT_CAPACITY) ? DEFAULT_CAPACITY : capacity / 2;
            T[] newData = (T[]) new Object[newCapacity];

            for (int i = 0; i < size; i++) {
                newData[i] = data[i];
            }

            this.capacity = newCapacity;
            this.data = newData;
        }
    }

    private void ensureCapacity(int initialCapacity) {
        int capacity = DEFAULT_CAPACITY;

        while (capacity < initialCapacity) {
            capacity = capacity * 2;
        }

        this.capacity = capacity;
    }

    public int size() { return size; }

    public boolean isEmpty() { return size == 0; }

    @SuppressWarnings("unchecked")
    public T[] toArray() {
        T[] array = (T[]) new Object[size];

        for (int i = 0; i < size; i++) {
            array[i] = data[i];
        }
        return array;
    }

    // GUARDS
    private void checkElementIndex(int index) {
        if (index < 0 || index >= size) throw new ArrayIndexOutOfBoundsException("Index out of bounds: " + index);
    }

    private void checkPositionIndex(int index) {
        if (index < 0 || index > size) throw new ArrayIndexOutOfBoundsException("Index out of bounds: " + index);
    }

    private void checkIfEmpty() {
        if (isEmpty()) throw new IllegalStateException("Cannot delete from empty MyArray.");
    }

    // READ
    public T read(int index) {
        // Time complexity: O(1)
        checkElementIndex(index);

        return data[index];
    }

    // SEARCH
    public int search(T element) {
        // Time complexity: O(N)
        for (int i = 0; i < size; i++) {
            if (element == null ? data[i] == null : element.equals(data[i])) {
                return i;
            }
        }
        return -1;
    }

    // INSERT
    public void insertAtStart(T element) {
        // Time complexity: O(N)
        ensureCapacity();

        for (int i = size; i > 0; i--) { // Iterates from the end to the start.
            data[i] = data[i - 1]; // Shifts elements -->
        }
        data[0] = element; // Inserts element at the start.
        size++;
    }

    public void insertAtEnd(T element) {
        // Time complexity: O(1)
        ensureCapacity();

        data[size] = element; // Inserts element at the end.
        size++;
    }

    public void insertAtIndex(int index, T element) {
        // Time complexity: O(N)
        checkPositionIndex(index);
        ensureCapacity();

        for (int i = size; i > index; i--) { // Iterates from the end to the index.
            data[i] = data[i - 1]; // Shifts elements -->
        }
        data[index] = element; // Inserts element at index.
        size++;
    }

    // DELETE
    public T deleteFromStart() {
        // Time complexity: O(N)
        checkIfEmpty();
        ensureCapacity();

        T element = data[0];

        for (int i = 0; i < size - 1; i++) { // Iterates from the start to the penultimate element.
            data[i] = data[i + 1]; // Shifts elements <--
        }
        data[size - 1] = null; // Clears the last element which has already been shifted.
        size--;
        return element;
    }

    public T deleteFromEnd() {
        // Time complexity: O(1)
        checkIfEmpty();
        ensureCapacity();

        T element = data[size - 1];

        data[size - 1] = null; // Deletes element at the end.
        size--;
        return element;
    }

    public T deleteFromIndex(int index) {
        // Time complexity: O(N)
        checkIfEmpty();
        checkElementIndex(index);
        ensureCapacity();

        T element = data[index];

        for (int i = index; i < size - 1; i++) { // Iterates from index to the penultimate element.
            data[i] = data[i + 1]; // Shifts elements <--
        }
        data[size - 1] = null; // Clears the last element which has already been shifted.
        size--;
        return element;
    }

    // TRANSFORM
    public void swapByIndex(int i, int j) {
        checkElementIndex(i);
        checkElementIndex(j);

        T temp = data[i];
        data[i] = data[j];
        data[j] = temp;
    }

    public void replaceByIndex(int i, int j) {
        checkElementIndex(i);
        checkElementIndex(j);

        data[i] = data[j];
    }

    public void setByIndex(int index, T element) {
        checkElementIndex(index);

        data[index] = element;
    }

    // ITERATORS
    public void forEach(Consumer<T> consumer) {
        for (int i = 0; i < size; i++) {
            consumer.accept(data[i]);
        }
    }

    public MyArray<T> filter(Predicate<T> predicate) {
        MyArray<T> x = new MyArray<>();

        for (int i = 0; i < size; i++) {
            T element = data[i];
            if (predicate.test(element)) {
                x.insertAtEnd(element);
            }
        }
        return x;
    }

    public MyArray<T> map(UnaryOperator<T> unaryOperator) {
        MyArray<T> x = new MyArray<>();

        for (int i = 0; i < size; i++) {
            T element = data[i];
            x.insertAtEnd(unaryOperator.apply(element));
        }
        return x;
    }

    public T reduce(BinaryOperator<T> binaryOperator, T initialValue) {
        T accumulator = initialValue;

        for (int i = 0; i < size; i++) {
            T element = data[i];
            accumulator = binaryOperator.apply(accumulator, element);
        }
        return accumulator;
    }

    public boolean some(Predicate<T> predicate) {
        for (int i = 0; i < size; i++) {
            T element = data[i];
            if (predicate.test(element)) {
                return true;
            }
        }
        return false;
    }

    public boolean every(Predicate<T> predicate) {
        for (int i = 0; i < size; i++) {
            T element = data[i];
            if (!predicate.test(element)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public String toString() {
        return "MyArray{" +
                "data=" + Arrays.toString(Arrays.copyOf(data, size)) +
                '}';
    }
}
