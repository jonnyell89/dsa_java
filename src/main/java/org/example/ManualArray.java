package org.example;

public class ManualArray {

    private int[] array;

    public ManualArray(int length) {

        this.array = new int[length];
    }

    public ManualArray(int[] array) {

        this.array = array;
    }

    public int[] getArray() { return array; }

    private void setArray(int[] array) { this.array = array; }

    // READ
    public int read(int index) {

        // Time complexity: O(1)

        if (index < 0 || index > array.length - 1) {

            throw new ArrayIndexOutOfBoundsException("Invalid index: " + index);
        }

        return array[index];
    }

    // SEARCH
    public int search(int element) {

        // Time complexity: O(N)

        for (int i = 0; i < array.length; i++) {

            if (array[i] == element) {

                return i;
            }
        }

        throw new IllegalArgumentException("Element not found: " + element);
    }

    // INSERT
    public ManualArray insertAtStart(int element) {

        // Time complexity: O(N)

        int[] newArray = new int[array.length + 1];

        newArray[0] = element;

        for (int i = 0; i < array.length; i++) {

            newArray[i + 1] = array[i];
        }

        setArray(newArray);

        return this;
    }

    public ManualArray insertAtEnd(int element) {

        // Time complexity: O(N)

        int[] newArray = new int[array.length + 1];

        for (int i = 0; i < array.length; i++) {

            newArray[i] = array[i];
        }

        newArray[newArray.length - 1] = element;

        setArray(newArray);

        return this;
    }

    public ManualArray insertAtIndex(int element, int index) {

        // Time complexity: O(2N)

        if (index < 0 || index > array.length) {

            throw new ArrayIndexOutOfBoundsException("Invalid index: " + index);
        }

        int[] newArray = new int[array.length + 1];

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
    public ManualArray deleteFromStart() {

        // Time complexity: O(N)

        if (array.length == 0) {

            throw new IllegalStateException("Cannot delete from an empty array.");
        }

        int[] newArray = new int[array.length - 1];

        for (int i = 1; i < array.length; i++) {

            newArray[i - 1] = array[i];
        }

        setArray(newArray);

        return this;
    }

    public ManualArray deleteFromEnd() {

        // Time complexity: O(N)

        if (array.length == 0) {

            throw new IllegalStateException("Cannot delete from an empty array.");
        }

        int[] newArray = new int[array.length - 1];

        for (int i = 0; i < newArray.length; i++) {

            newArray[i] = array[i];
        }

        setArray(newArray);

        return this;
    }

    public ManualArray deleteFromIndex(int index) {

        // Time complexity: O(N)

        if (array.length == 0) {

            throw new IllegalStateException("Cannot delete from an empty array.");
        }

        if (index < 0 || index > array.length - 1) {

            throw new ArrayIndexOutOfBoundsException("Invalid index: " + index);
        }

        int[] newArray = new int[array.length - 1];

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
