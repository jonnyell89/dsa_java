package org.example;

public class ManualArray<T> {

    private Object[] array;

    public ManualArray(int length) {

        this.array = new Object[length];
    }

    public ManualArray(T[] array) {

        this.array = new Object[array.length];

        for (int i = 0; i < array.length; i++) {

            this.array[i] = array[i];
        }
    }

    private Object[] getArray() { return array; }

    private void setArray(Object[] array) { this.array = array; }

    // READ
    @SuppressWarnings("unchecked")
    public T read(int index) {

        // Time complexity: 1 step
        // Big O Notation: O(1)

        if (index < 0 || index > array.length - 1) {

            throw new ArrayIndexOutOfBoundsException("Index out of bounds: " + index);
        }

        return (T) array[index];
    }

    // SEARCH
    public int search(T element) {

        // Time complexity: N steps
        // Big O Notation: O(N)

        for (int i = 0; i < array.length; i++) {

            if (array[i] == element) {

                return i;
            }
        }

        throw new IllegalArgumentException("Illegal argument: " + element);
    }

    // INSERT
    public ManualArray<T> insertAtStart(T element) {

        // Time complexity: N + 3 steps
        // Big O Notation: O(N)

        Object[] newArray = new Object[array.length + 1];

        newArray[0] = element;

        for (int i = 0; i < array.length; i++) {

            newArray[i + 1] = array[i];
        }

        setArray(newArray);

        return this;
    }

    public ManualArray<T> insertAtEnd(T element) {

        // Time complexity: N + 3 steps
        // Big O Notation: O(N)

        Object[] newArray = new Object[array.length + 1];

        for (int i = 0; i < array.length; i++) {

            newArray[i] = array[i];
        }

        newArray[newArray.length - 1] = element;

        setArray(newArray);

        return this;
    }

    public ManualArray<T> insertAtIndex(T element, int index) {

        // Time complexity: N + 3 steps
        // Big O Notation: O(2N)

        if (index < 0 || index > array.length) {

            throw new ArrayIndexOutOfBoundsException("Index out of bounds: " + index);
        }

        Object[] newArray = new Object[array.length + 1];

        for (int i = 0; i < index; i++) { // Transfer up to index.

            newArray[i] = array[i];
        }

        newArray[index] = element; // Add at index.

        for (int i = index + 1; i < newArray.length; i++) { // Transfer beyond index.

            newArray[i] = array[i - 1];
        }

        setArray(newArray);

        return this;
    }

    // DELETE
    public ManualArray<T> deleteFromStart() {

        // Time complexity: N + 2 steps
        // Big O Notation: O(N)

        if (array.length == 0) {

            throw new IllegalStateException("Illegal state, array length: " + array.length);
        }

        Object[] newArray = new Object[array.length - 1];

        for (int i = 1; i < array.length; i++) {

            newArray[i - 1] = array[i];
        }

        setArray(newArray);

        return this;
    }

    public ManualArray<T> deleteFromEnd() {

        // Time complexity: N + 2 steps
        // Big O Notation: O(N)

        if (array.length == 0) {

            throw new IllegalStateException("Illegal state, array length: " + array.length);
        }

        Object[] newArray = new Object[array.length - 1];

        for (int i = 0; i < newArray.length; i++) {

            newArray[i] = array[i];
        }

        setArray(newArray);

        return this;
    }

    public ManualArray<T> deleteFromIndex(int index) {

        // Time complexity: N + 3 steps
        // Big O Notation: O(N)

        if (array.length == 0) {

            throw new IllegalStateException("Illegal state, array length: " + array.length);
        }

        if (index < 0 || index > array.length - 1) {

            throw new ArrayIndexOutOfBoundsException("Index out of bounds: " + index);
        }

        Object[] newArray = new Object[array.length - 1];

        for (int i = 0; i < index; i++) {

            newArray[i] = array[i];
        }

        for (int i = index + 1; i < array.length; i++) {

            newArray[i - 1] = array[i];
        }

        setArray(newArray);

        return this;
    }
}
