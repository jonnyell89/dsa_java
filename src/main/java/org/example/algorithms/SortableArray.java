package org.example.algorithms;

import org.example.collections.MyArray;

public class SortableArray {

    // Chapter 13: Recursive Algorithms for Speed.

    protected MyArray<Integer> myArray;

    public SortableArray(MyArray<Integer> myArray) {
        this.myArray = myArray;
    }

    public int partition(int leftPointer, int rightPointer) {
        int pivotIndex = rightPointer;
        int pivot = myArray.read(pivotIndex);
        rightPointer -= 1;
        while (true) {
            while (myArray.read(leftPointer) < pivot) {
                leftPointer += 1;
            }
            while (myArray.read(rightPointer) > pivot) {
                rightPointer -= 1;
            }
            // If the pointers have met, exit the loop to swap the left pointer and the pivot values by index.
            if (leftPointer >= rightPointer) break;
            // If the pointers have not met, swap the left pointer and right pointer values by index.
            else {
                myArray.swapByIndex(leftPointer, rightPointer);
                leftPointer += 1;
            }
        }
        myArray.swapByIndex(leftPointer, pivotIndex);
        return leftPointer;
    }

    public void quicksort(int leftIndex, int rightIndex) {
        if (rightIndex - leftIndex <= 0) return; // Base case.
        int pivotIndex = partition(leftIndex, rightIndex);
        quicksort(leftIndex, pivotIndex - 1);
        quicksort(pivotIndex + 1, rightIndex);
    }

    public int quickselect(int kthLowestValue, int leftIndex, int rightIndex) {
        if (rightIndex - leftIndex <= 0) return myArray.read(leftIndex);
        int pivotIndex = partition(leftIndex, rightIndex);
        if (kthLowestValue < pivotIndex) {
            return quickselect(kthLowestValue, leftIndex, pivotIndex - 1);
        } else if (kthLowestValue > pivotIndex) {
            return quickselect(kthLowestValue, pivotIndex + 1, rightIndex);
        } else {
            return myArray.read(pivotIndex);
        }
    }

    public void merge(int leftIndex, int midIndex, int rightIndex) {
        // Create left subarray and right subarray.
        int leftSize = midIndex - leftIndex + 1;
        int rightSize = rightIndex - midIndex;
        int[] leftArray = new int[leftSize];
        int[] rightArray = new int[rightSize];
        // Insert data into left subarray and right subarray.
        for (int i = 0; i < leftSize; i++) {
            leftArray[i] = myArray.read(leftIndex + i);
        }
        for (int j = 0; j < rightSize; j++) {
            rightArray[j] = myArray.read(midIndex + 1 + j);
        }
        int i = 0, j = 0, k = leftIndex; // Initial indices of left subarray, right subarray and merged array.
        while (i < leftSize && j < rightSize) {
            if (leftArray[i] <= rightArray[j]) {
                myArray.setByIndex(k, leftArray[i]);
                i++;
            } else {
                myArray.setByIndex(k, rightArray[j]);
                j++;
            }
            k++; // Increment k with each insertion.
        }
        while (i < leftSize) {
            myArray.setByIndex(k, leftArray[i]);
            i++;
            k++;
        }
        while (j < rightSize) {
            myArray.setByIndex(k, rightArray[j]);
            j++;
            k++;
        }
    }

    public void mergeSort(int leftIndex, int rightIndex) {
        if (leftIndex < rightIndex) { // Base case is implicit in this condition.
            int midIndex = leftIndex + (rightIndex - leftIndex) / 2;
            mergeSort(leftIndex, midIndex); // Sort left half.
            mergeSort(midIndex + 1, rightIndex); // Sort right half.
            merge(leftIndex, midIndex, rightIndex); // Merge sorted halves.
        }
    }

    public boolean hasDuplicate() {
        // Time complexity: O(N log N)
        quicksort(0, myArray.getSize() - 1);
        int size = myArray.getSize();
        for (int i = 0; i < size - 1; i++) {
            if (myArray.read(i) == myArray.read(i + 1)) return true;
        }
        return false;
    }

    //Exercise 1:
    public int greatestProduct() {
        int lastIndex = myArray.getSize() - 1;
        quicksort(0, lastIndex);
        return myArray.read(lastIndex) * myArray.read(lastIndex - 1) * myArray.read(lastIndex - 2);
    }

    // Exercise 2:
    public int findMissingNumber() {
        int size = myArray.getSize();
        quicksort(0, size - 1);
        for (int i = 0; i < size; i++) {
            if (myArray.read(i) != i) return i;
        }
        return -1;
    }

    //Exercise 3:
    public int greatestNumberSlow() {
        // Time complexity: O(N^2)
        int size = myArray.getSize();
        for (int i = 0; i < size; i++) {
            boolean isGreatestNumber = true;
            for (int j = 0; j < size; j++) {
                if (myArray.read(j) > myArray.read(i)) {
                    isGreatestNumber = false;
                }
            }
            if (isGreatestNumber) return myArray.read(i);
        }
        throw new IllegalStateException("Array is either empty, or all values are the same.");
    }

    public int greatestNumberMedium() {
        // Time complexity: O(N log N)
        int lastIndex = myArray.getSize() - 1;
        quicksort(0, lastIndex);
        return myArray.read(lastIndex);
    }

    public int greatestNumberFast() {
        // Time complexity: O(N)
        int size = myArray.getSize();
        int greatestNumber = myArray.read(0);
        for (int i = 1; i < size; i++) {
            if (myArray.read(i) > greatestNumber) {
                greatestNumber = myArray.read(i);
            }
        }
        return greatestNumber;
    }
}
