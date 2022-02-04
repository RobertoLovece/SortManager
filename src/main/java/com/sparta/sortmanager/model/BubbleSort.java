package com.sparta.sortmanager.model;

public class BubbleSort implements SortingAlgorithm {

    @Override
    public void  sort(int[] inputArray) {

        if(inputArray == null) return;

        int inputLength = inputArray.length;
        int temp;

        for (int i = 0; i < (inputLength - 1) ; i++) {

            for (int j = 0; j < (inputLength - i - 1) ; j++) {

                if (inputArray[j] > inputArray[j + 1]) {

                    // swap arr[j+1] and arr[j]
                    temp = inputArray[j];

                    inputArray[j] = inputArray[j + 1];
                    inputArray[j + 1] = temp;

                }
            }
        }

    }

}
