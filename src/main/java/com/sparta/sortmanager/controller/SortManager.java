package com.sparta.sortmanager.controller;

import com.sparta.sortmanager.model.BubbleSort;
import com.sparta.sortmanager.model.MergeSort;
import com.sparta.sortmanager.model.SortingAlgorithm;

import java.util.Arrays;
import java.util.Random;

public class SortManager {

    private int[] unsortedArray;
    private int[] sortedArray;

    public String initialiseRandomArray(int size, int bound, int seed) {

        unsortedArray = getRandomIntArray(size, bound, seed);
        return Arrays.toString(unsortedArray);

    }

    public String initiateSorting(String desiredAlgorithm) {

        SortingAlgorithm sortingAlgorithm = getSortingAlgorithm(desiredAlgorithm);
        sortedArray = unsortedArray.clone();
        sortingAlgorithm.sort(sortedArray);

        String sortedString = Arrays.toString(sortedArray);

        return sortedString;

    }

    public SortingAlgorithm getSortingAlgorithm(String algorithmType) {

        SortingAlgorithm sa = switch (algorithmType) {
            case "Bubble" -> new BubbleSort();
            case "Merge" -> new MergeSort();
            default -> null;
        };

        return sa;
    }

    // If seed is 0 then don't use a seed
    private int[] getRandomIntArray(int size, int bound, int seed) {

        Random random = new Random(seed);
        if (seed == 0) random = new Random();

        int[] result = new int[size];

        for (int i = 0; i < size; i++) {
            result[i] = random.nextInt(bound);
        }

        return result;
    }

    public int[] getUnsortedArray() {
        return unsortedArray;
    }

    public void setUnsortedArray(int[] unsortedArray) {
        this.unsortedArray = unsortedArray;
    }

    public int[] getSortedArray() {
        return sortedArray;
    }

    public void setSortedArray(int[] sortedArray) {
        this.sortedArray = sortedArray;
    }
}
