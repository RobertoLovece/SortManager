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

        boolean valid = switch (algorithmType) {
            case "1", "2", "3" -> true;
            default -> false;
        };

        return valid;
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
        boolean valid = switch (choice) {
            case "1" -> true;
            default -> false;
        };

        return valid;
    }


    public boolean checkCompareChoice(String choice) {
        boolean valid = switch (choice) {
            case "1", "2" -> true;
            default -> false;
        };

        return valid;
    }

    public boolean checkCompareAlgorithm(String choice, String previous) {

        if (previous.equals(choice)) {
            return false;
        }

        boolean valid = switch (choice) {
            case "1", "2", "3" -> true;
            default -> false;
        };

        return valid;

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

    public double getSortingTimeSeconds() {
        return (double) sortingTime / 1_000_000_000;
    }
}
