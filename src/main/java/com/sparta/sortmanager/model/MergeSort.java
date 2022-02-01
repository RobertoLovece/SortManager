package com.sparta.sortmanager.model;

public class MergeSort implements SortingAlgorithm {

    @Override
    public void sort(int[] inputArray) {

        int inputLength = inputArray.length;

        if (inputLength <= 1) {
            return;
        }

        int middle = inputLength/2;
        int[] leftHalf = new int[middle];
        int[] rightHalf = new int[inputLength - middle];

        // populate the left and right arrays based off the input array
        for (int i = 0; i < leftHalf.length; i++) {
            leftHalf[i] = inputArray[i];
        }
        for (int i = middle; i < inputLength; i++) {
            rightHalf[i - middle] = inputArray[i];
        }

        this.sort(leftHalf);
        this.sort(rightHalf);

        merge(inputArray, leftHalf, rightHalf);

    }

    private void merge(int[] inputArray, int[] leftHalf, int[] rightHalf) {

        int leftLength = leftHalf.length;
        int rightLength = rightHalf.length;

        int leftIndex = 0, rightIndex = 0, mergeIndex = 0;

        while (leftIndex < leftLength && rightIndex < rightLength) {

            if (leftHalf[leftIndex] <= rightHalf[rightIndex]) {
                inputArray[mergeIndex] = leftHalf[leftIndex];
                leftIndex++;
            }
            else {
                inputArray[mergeIndex] = rightHalf[rightIndex];
                rightIndex++;
            }

            mergeIndex++;

        }

        while (leftIndex < leftLength) {
            inputArray[mergeIndex] = leftHalf[leftIndex];
            leftIndex++;
            mergeIndex++;
        }

        while (rightIndex < rightLength) {
            inputArray[mergeIndex] = rightHalf[rightIndex];
            rightIndex++;
            mergeIndex++;
        }

    }

}
