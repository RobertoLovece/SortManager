package com.sparta.sortmanager.model;

public class BubbleSort implements SortingAlgorithm {

    @Override
    public int[] sort(int[] inputArray) {

        int length = inputArray.length;
        int temp;

        for (int i = 0; i < (length-1) ; i++) {

            for (int j = 0; j < (length-i-1) ; j++) {

                if (inputArray[j] > inputArray[j+1]) {

                    // swap arr[j+1] and arr[j]
                    temp = inputArray[j];

                    inputArray[j] = inputArray[j+1];
                    inputArray[j+1] = temp;

                }
            }
        }

        return inputArray;
    }

}
