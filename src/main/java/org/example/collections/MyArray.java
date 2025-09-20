package org.example.collections;

import org.example.interfaces.IntBinaryOperator;
import org.example.interfaces.IntConsumer;
import org.example.interfaces.IntPredicate;
import org.example.interfaces.IntUnaryOperator;

import java.util.Arrays;

public class MyArray {

    protected static final int DEFAULT_CAPACITY = 10;

    protected int capacity;
    protected int size;
    protected int[] data;

    public MyArray() {
        this.capacity = DEFAULT_CAPACITY;
        this.size = 0;
        this.data = new int[capacity];
    }

    public MyArray(int initialCapacity) {
        if (initialCapacity < 0) throw new IllegalArgumentException("MyArray initial capacity cannot be less than zero.");

        this.capacity = DEFAULT_CAPACITY;
        ensureCapacity(initialCapacity);
        this.size = 0;
        this.data = new int[capacity];
    }

    public MyArray(int[] array) {
        if (array == null) throw new NullPointerException("MyArray cannot be null.");

        this.capacity = DEFAULT_CAPACITY;
        ensureCapacity(array.length);
        this.size = 0;
        this.data = new int[capacity];

        for (int i = 0; i < array.length; i++) {
            this.data[i] = array[i];
            size++;
        }
    }

    public int getCapacity() { return capacity; } // Only public for testing purposes.

    protected void setCapacity(int capacity) { this.capacity = capacity; }

    protected void ensureCapacity() {
        if (size == capacity) {
            int newCapacity = (size < DEFAULT_CAPACITY) ? DEFAULT_CAPACITY : capacity * 2;
            int[] newArray = new int[newCapacity];

            for (int i = 0; i < size; i++) {
                newArray[i] = data[i];
            }
            setCapacity(newCapacity);
            setData(newArray);
        }

        if (size > DEFAULT_CAPACITY && size <= capacity / 4) {
            int newCapacity = (size / 2 < DEFAULT_CAPACITY) ? DEFAULT_CAPACITY : capacity / 2;
            int[] newArray = new int[newCapacity];

            for (int i = 0; i < size; i++) {
                newArray[i] = data[i];
            }
            setCapacity(newCapacity);
            setData(newArray);
        }
    }

    protected void ensureCapacity(int initialCapacity) {
        int newCapacity = DEFAULT_CAPACITY;

        while (newCapacity < initialCapacity) {
            newCapacity = newCapacity * 2;
        }
        setCapacity(newCapacity);
    }

    public int getSize() { return size; }

    public int[] getData() { return data; } // Only public for testing purposes.

    protected void setData(int[] data) { this.data = data; }

    public boolean isEmpty() { return size == 0; }

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
        if (index < 0 || index >= size) throw new ArrayIndexOutOfBoundsException("Index out of bounds: " + index);

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
        return -1;
    }

    // INSERT
    public boolean insertAtStart(int element) {
        // Time complexity: O(N)
        ensureCapacity();

        for (int i = size; i > 0; i--) { // Iterates from the end to the start.
            data[i] = data[i - 1]; // Shifts elements -->
        }
        data[0] = element; // Inserts element at the start.
        size++;
        return true;
    }

    public boolean insertAtEnd(int element) {
        // Time complexity: O(1)
        ensureCapacity();

        data[size] = element; // Inserts element at the end.
        size++;
        return true;
    }

    public boolean insertAtIndex(int index, int element) {
        // Time complexity: O(N)
        if (index < 0 || index > size) throw new ArrayIndexOutOfBoundsException("Index out of bounds: " + index);
        ensureCapacity();

        for (int i = size; i > index; i--) { // Iterates from the end to the index.
            data[i] = data[i - 1]; // Shifts elements -->
        }
        data[index] = element; // Inserts element at index.
        size++;
        return true;
    }

    // DELETE
    public int deleteFromStart() {
        // Time complexity: O(N)
        if (size == 0) throw new IllegalStateException("Cannot delete from empty MyArray.");
        ensureCapacity();

        int element = data[0];

        for (int i = 0; i < size - 1; i++) { // Iterates from the start to the penultimate element.
            data[i] = data[i + 1]; // Shifts elements <--
        }
        data[size - 1] = 0; // Clears the last element which has already been shifted.
        size--;
        return element;
    }

    public int deleteFromEnd() {
        // Time complexity: O(1)
        if (size == 0) throw new IllegalStateException("Cannot delete from empty MyArray.");
        ensureCapacity();

        int element = data[size - 1];

        data[size - 1] = 0; // Deletes element at the end.
        size--;
        return element;
    }

    public int deleteFromIndex(int index) {
        // Time complexity: O(N)
        if (size == 0) throw new IllegalStateException("Cannot delete from empty MyArray.");
        if (index < 0 || index >= size) throw new ArrayIndexOutOfBoundsException("Index out of bounds: " + index);
        ensureCapacity();

        int element = data[index];

        for (int i = index; i < size - 1; i++) { // Iterates from index to the penultimate element.
            data[i] = data[i + 1]; // Shifts elements <--
        }
        data[size - 1] = 0; // Clears the last element which has already been shifted.
        size--;
        return element;
    }

    // TRANSFORM
    public void swapByIndex(int i, int j) {
        if (i < 0 || i >= size) throw new ArrayIndexOutOfBoundsException("Index out of bounds: " + i);
        if (j < 0 || j >= size) throw new ArrayIndexOutOfBoundsException("Index out of bounds: " + j);

        int temp = data[i];
        data[i] = data[j];
        data[j] = temp;
    }

    public void replaceByIndex(int i, int j) {
        if (i < 0 || i >= size) throw new ArrayIndexOutOfBoundsException("Index out of bounds: " + i);
        if (j < 0 || j >= size) throw new ArrayIndexOutOfBoundsException("Index out of bounds: " + j);

        data[i] = data[j];
    }

    public void setByIndex(int index, int element) {
        if (index < 0 || index >= size) throw new ArrayIndexOutOfBoundsException("Index out of bounds: " + index);

        data[index] = element;
    }

    // ITERATORS
    public void forEach(IntConsumer consumer) {
        for (int i = 0; i < size; i++) {
            consumer.accept(data[i]);
        }
    }

    public MyArray filter(IntPredicate predicate) {
        MyArray x = new MyArray();

        for (int i = 0; i < size; i++) {
            int element = data[i];
            if (predicate.test(element)) {
                x.insertAtEnd(element);
            }
        }
        return x;
    }

    public MyArray map(IntUnaryOperator unaryOperator) {
        MyArray x = new MyArray();

        for (int i = 0; i < size; i++) {
            int element = data[i];
            x.insertAtEnd(unaryOperator.apply(element));
        }
        return x;
    }

    public int reduce(IntBinaryOperator binaryOperator, int initialValue) {
        int accumulator = initialValue;

        for (int i = 0; i < size; i++) {
            int element = data[i];
            accumulator = binaryOperator.apply(accumulator, element);
        }
        return accumulator;
    }

    public boolean some(IntPredicate predicate) {
        for (int i = 0; i < size; i++) {
            int element = data[i];
            if (predicate.test(element)) {
                return true;
            }
        }
        return false;
    }

    public boolean every(IntPredicate predicate) {
        for (int i = 0; i < size; i++) {
            int element = data[i];
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
