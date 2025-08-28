package org.example.collections;

import org.example.interfaces.IntBinaryOperator;
import org.example.interfaces.IntConsumer;
import org.example.interfaces.IntPredicate;
import org.example.interfaces.IntUnaryOperator;

import java.util.Arrays;

public class ManualArray extends ManualCollection {

//    protected static final int DEFAULT_CAPACITY = 10;

//    protected int capacity;
//    protected int size;
//    protected int[] data;

    public ManualArray() {
//        this.capacity = DEFAULT_CAPACITY;
//        this.size = 0;
//        this.data = new int[capacity];
        super();
    }

    public ManualArray(int initialCapacity) {
//        if (initialCapacity < 0) throw new IllegalArgumentException("Collection initial capacity cannot be less than zero.");
//        this.capacity = DEFAULT_CAPACITY;
//        this.size = 0;
//        this.data = new int[capacity];
//        setCapacity(initialCapacity);
        super(initialCapacity);
    }

    public ManualArray(int[] array) {
        if (array == null) throw new NullPointerException("Collection cannot be null.");
        this.capacity = DEFAULT_CAPACITY;
        setCapacity(array.length);
        this.size = array.length;
        this.data = new int[capacity];
        for (int i = 0; i < array.length; i++) {
            this.data[i] = array[i];
        }
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
    public ManualArray insertAtStart(int element) {
        // Time complexity: O(N)
        manageCapacity();
        for (int i = size; i > 0; i--) { // Iterates from the end to the start.
            data[i] = data[i - 1]; // Shifts elements -->
        }
        data[0] = element; // Inserts element at the start.
        incrementSize();
        return this;
    }

    @Override
    public ManualArray insertAtEnd(int element) {
        // Time complexity: O(1)
        manageCapacity();
        data[size] = element; // Inserts element at the end.
        incrementSize();
        return this;
    }

    @Override
    public ManualArray insertAtIndex(int index, int element) {
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
//    public ManualArray deleteFromStart() {
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

//    public ManualArray deleteFromEnd() {
//        // Time complexity: O(1)
//        if (size == 0) throw new IllegalStateException("Cannot delete from an empty collection.");
//        manageCapacity();
//        data[size - 1] = 0; // Deletes element at the end.
//        decrementSize();
//        return this;
//    }

//    public ManualArray deleteFromIndex(int index) {
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

    @Override
    public void forEach(IntConsumer consumer) {
        for (int i = 0; i < size; i++) {
            consumer.accept(data[i]);
        }
    }

    @Override
    public ManualArray filter(IntPredicate predicate) {
        ManualArray newManualArray = new ManualArray();
        for (int i = 0; i < size; i++) {
            int element = data[i];
            if (predicate.test(element)) {
                newManualArray.insertAtEnd(element);
            }
        }
        return newManualArray;
    }

    @Override
    public ManualArray map(IntUnaryOperator unaryOperator) {
        ManualArray newManualArray = new ManualArray();
        for (int i = 0; i < size; i++) {
            int element = data[i];
            newManualArray.insertAtEnd(unaryOperator.apply(element));
        }
        return newManualArray;
    }

    @Override
    public int reduce(IntBinaryOperator binaryOperator, int initialValue) {
        int accumulator = initialValue;
        for (int i = 0; i < size; i++) {
            int element = data[i];
            accumulator = binaryOperator.apply(accumulator, element);
        }
        return accumulator;
    }

    @Override
    public String toString() {
        return "ManualArray{" +
                "data=" + Arrays.toString(Arrays.copyOf(data, size)) +
                '}';
    }
}
