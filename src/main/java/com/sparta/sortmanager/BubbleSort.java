package com.sparta.sortmanager;

public class BubbleSort implements SortingAlgorithm {

    @Override
    public int[] sort(int[] array) {

        int n = array.length;
        int temp;

        for (int i = 0; i < n-1; i++) {

            for (int j = 0; j < n-i-1; j++) {

                if (array[j] > array[j+1]) {
                    // swap arr[j+1] and arr[j]
                    temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;

                }
            }
        }

        return array;
    }

}