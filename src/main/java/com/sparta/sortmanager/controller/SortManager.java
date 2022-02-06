package com.sparta.sortmanager.controller;

import com.sparta.sortmanager.SorterMain;
import com.sparta.sortmanager.model.BinarySearchTreeAdapter;
import com.sparta.sortmanager.model.BubbleSort;
import com.sparta.sortmanager.model.MergeSort;
import com.sparta.sortmanager.model.SortingAlgorithm;

import java.util.Arrays;
import java.util.Random;

public class SortManager {

    private int[] unsortedArray;
    private int[] sortedArray;

    private long sortingTime;

    public String initialiseRandomArray(int size, int bound, int seed) {

        unsortedArray = getRandomIntArray(size, bound, seed);
        String unsortedString = Arrays.toString(unsortedArray);

        SorterMain.logger.info("unsortedArray created (size: "+ size +
                ", bound: " +bound + ", seed: " + seed + "): " + unsortedString);

        return unsortedString;

    }

    public String initiateSorting(String desiredAlgorithm) {

        SortingAlgorithm sortingAlgorithm = getSortingAlgorithm(desiredAlgorithm);
        sortedArray = unsortedArray.clone();

        final long startTime = System.nanoTime();
        sortingAlgorithm.sort(sortedArray);
        final long endTime = System.nanoTime();

        sortingTime = (endTime - startTime);
        String sortedString = Arrays.toString(sortedArray);

        SorterMain.logger.info("sortedArray created from sorting unsortedArray: " + sortedString);
        SorterMain.logger.info("Total sorting time was " + sortingTime + " nano-seconds (10^-9)");

        return sortedString;

    }

    public boolean checkSortingAlgorithm(String algorithmType) {
        return "1".equals(algorithmType) || "2".equals(algorithmType) || "3".equals(algorithmType);
    }

    private SortingAlgorithm getSortingAlgorithm(String algorithmType) {

        SortingAlgorithm sa = switch (algorithmType) {
            case "1" -> new BubbleSort();
            case "2" -> new MergeSort();
            case "3" -> new BinarySearchTreeAdapter();
            default -> null;
        };

        SorterMain.logger.debug("Created instance of: " + sa.getClass().getSimpleName());

        return sa;
    }

    public boolean getCompareChoice(String choice) {
        return "1".equals(choice);
    }

    public boolean checkCompareChoice(String choice) {
        return "1".equals(choice) || "2".equals(choice);
    }

    public boolean checkCompareAlgorithm(String choice, String previous) {

        if (previous.equals(choice)) {
            return false;
        }
        else {
            return "1".equals(choice) || "2".equals(choice) || "3".equals(choice);
        }

    }

    public String getSortingAlgorithmTypeString(String algorithmType) {

        String algorithmString = switch (algorithmType) {
            case "1" -> "Bubble Sort";
            case "2" -> "Merge Sort";
            case "3" -> "Binary Search Tree";
            default -> "";
        };

        return algorithmString;

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

    public String getUnsortedArrayString() {
        return Arrays.toString(unsortedArray);
    }

    public void setUnsortedArray(int[] unsortedArray) {
        this.unsortedArray = unsortedArray;
    }

    public double getSortingTimeSeconds() {
        return (double) sortingTime / 1_000_000_000;
    }
}
