package com.sparta.sortmanager.controller;

import com.sparta.sortmanager.model.BubbleSort;
import com.sparta.sortmanager.model.MergeSort;
import com.sparta.sortmanager.model.SortingAlgorithm;

import java.util.Arrays;
import java.util.Random;

public class SortManager {

    private int[] unsortedArray;

    public String initiateSorting(String desiredAlgorithm) {

        unsortedArray = getRandomIntArray(11, 100);

        SortingAlgorithm sortingAlgorithm = getSortingAlgorithm(desiredAlgorithm);
        int[] sortedArray = sortingAlgorithm.sort(unsortedArray.clone());

        String sortedString = Arrays.toString(sortedArray);

        return sortedString;
    }

    public String getUnsortedArrayString() {
        return Arrays.toString(unsortedArray);
    }

    public SortingAlgorithm getSortingAlgorithm(String algorithmType) {

        SortingAlgorithm sa = switch (algorithmType) {
            case "Bubble" -> new BubbleSort();
            case "Merge" -> new MergeSort();
            default -> null;
        };

        return sa;
    }

    public int[] getRandomIntArray(int size, int bound) {

        int[] result = new int[size];

        Random random = new Random();

        for (int i = 0; i < size; i++) {
            result[i] = random.nextInt(bound);
        }

        return result;
    }


}
