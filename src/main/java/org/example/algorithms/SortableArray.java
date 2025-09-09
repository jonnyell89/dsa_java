package org.example.algorithms;

import org.example.collections.ManualArray;

public class SortableArray {

    // Chapter 13: Recursive Algorithms for Speed.

    protected ManualArray manualArray;

    public SortableArray(ManualArray manualArray) {
        this.manualArray = manualArray;
    }

    public int partition(int leftPointer, int rightPointer) {
        int pivotIndex = rightPointer;
        int pivot = manualArray.read(pivotIndex);
        rightPointer -= 1;
        while (true) {
            while (manualArray.read(leftPointer) < pivot) {
                leftPointer += 1;
            }
            while (manualArray.read(rightPointer) > pivot) {
                rightPointer -= 1;
            }
            // If the pointers have met, exit the loop to swap the left pointer and the pivot values by index.
            if (leftPointer >= rightPointer) break;
            // If the pointers have not met, swap the left pointer and right pointer values by index.
            else {
                manualArray.swapByIndex(leftPointer, rightPointer);
                leftPointer += 1;
            }
        }
        manualArray.swapByIndex(leftPointer, pivotIndex);
        return leftPointer;
    }

    public void quicksort(int leftIndex, int rightIndex) {
        if (rightIndex - leftIndex <= 0) return; // Base case.
        int pivotIndex = partition(leftIndex, rightIndex);
        quicksort(leftIndex, pivotIndex - 1);
        quicksort(pivotIndex + 1, rightIndex);
    }

    public int quickselect(int kthLowestValue, int leftIndex, int rightIndex) {
        if (rightIndex - leftIndex <= 0) return manualArray.read(leftIndex);
        int pivotIndex = partition(leftIndex, rightIndex);
        if (kthLowestValue < pivotIndex) {
            return quickselect(kthLowestValue, leftIndex, pivotIndex - 1);
        } else if (kthLowestValue > pivotIndex) {
            return quickselect(kthLowestValue, pivotIndex + 1, rightIndex);
        } else {
            return manualArray.read(pivotIndex);
        }
    }

    public void merge(int leftIndex, int midIndex, int rightIndex) {
        int leftSize = midIndex - leftIndex + 1;
        int rightSize = rightIndex - midIndex;
        int[] leftArray = new int[leftSize];
        int[] rightArray = new int[rightSize];
        for (int i = 0; i < leftSize; i++) {
            leftArray[i] = manualArray.read(leftIndex + i);
        }
        for (int j = 0; j < rightSize; j++) {
            rightArray[j] = manualArray.read(midIndex + 1 + j);
        }
        int i = 0, j = 0; // Initial indices of leftArray and rightArray.
        int k = leftIndex; // Initial index of merged subarray.
        while (i < leftSize && j < rightSize) {
            if (leftArray[i] <= rightArray[j]) {
                manualArray.setByIndex(k, leftArray[i]);
                i++;
            } else {
                manualArray.setByIndex(k, rightArray[j]);
                j++;
            }
            k++;
        }
        while (i < leftSize) {
            manualArray.setByIndex(k, leftArray[i]);
            i++;
            k++;
        }
        while (j < rightSize) {
            manualArray.setByIndex(k, rightArray[j]);
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
        quicksort(0, manualArray.getSize() - 1);
        int size = manualArray.getSize();
        for (int i = 0; i < size - 1; i++) {
            if (manualArray.read(i) == manualArray.read(i + 1)) return true;
        }
        return false;
    }

    //Exercise 1:
    public int greatestProduct() {
        int lastIndex = manualArray.getSize() - 1;
        quicksort(0, lastIndex);
        return manualArray.read(lastIndex) * manualArray.read(lastIndex - 1) * manualArray.read(lastIndex - 2);
    }

    // Exercise 2:
    public int findMissingNumber() {
        int size = manualArray.getSize();
        quicksort(0, size - 1);
        for (int i = 0; i < size; i++) {
            if (manualArray.read(i) != i) return i;
        }
        return -1;
    }

    //Exercise 3:
    public int greatestNumberSlow() {
        // Time complexity: O(N^2)
        int size = manualArray.getSize();
        for (int i = 0; i < size; i++) {
            boolean isGreatestNumber = true;
            for (int j = 0; j < size; j++) {
                if (manualArray.read(j) > manualArray.read(i)) {
                    isGreatestNumber = false;
                }
            }
            if (isGreatestNumber) return manualArray.read(i);
        }
        throw new IllegalStateException("Array is either empty, or all values are the same.");
    }

    public int greatestNumberMedium() {
        // Time complexity: O(N log N)
        int lastIndex = manualArray.getSize() - 1;
        quicksort(0, lastIndex);
        return manualArray.read(lastIndex);
    }

    public int greatestNumberFast() {
        // Time complexity: O(N)
        int size = manualArray.getSize();
        int greatestNumber = manualArray.read(0);
        for (int i = 1; i < size; i++) {
            if (manualArray.read(i) > greatestNumber) {
                greatestNumber = manualArray.read(i);
            }
        }
        return greatestNumber;
    }
}
