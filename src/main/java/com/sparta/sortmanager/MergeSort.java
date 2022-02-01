package com.sparta.sortmanager;

public class MergeSort implements SortingAlgorithm {

    @Override
    public int[] sort(int[] array) {

        int middle = ((array.length - 1))/2;

        System.out.println(middle);
        System.out.println(array[middle]);

        return new int[0];
    }

}
