package com.sparta.sortmanagertests;

import com.sparta.sortmanager.model.BinarySearchTreeFacade;
import com.sparta.sortmanager.model.BubbleSort;
import com.sparta.sortmanager.model.MergeSort;
import com.sparta.sortmanager.model.SortingAlgorithm;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.Random;

public class SortingAlgorithmTests {

    @ParameterizedTest
    @ValueSource(strings = {"Bubble","Merge","BST"})
    @DisplayName("Given an array of length 11 with random values between 0 and 100 as well as" +
            " a random-seed of 1, using bubble and merge sort the sorted array should match the Arrays.sort method")
    public void givenAnArrayOf11Values0To100_Sort_MatchesArraysSort(String type) {

        SortingAlgorithm sa = getSortingAlgorithm(type);
        System.out.println(sa.getClass().getSimpleName());
        int[] unsortedArray = getRandomIntArray(11, 100, 0,1);

        int[] actualArray = unsortedArray.clone();
        int[] expectedArray = unsortedArray.clone();

        sa.sort(actualArray);
        Arrays.sort(expectedArray);

        int actual = Arrays.compare(actualArray, expectedArray);
        Assertions.assertEquals(0, actual);

    }

    @ParameterizedTest
    @ValueSource(strings = {"Bubble","Merge","BST"})
    @DisplayName("test")
    public void mixed(String type) {

        SortingAlgorithm sa = getSortingAlgorithm(type);
        System.out.println(sa.getClass().getSimpleName());
        int[] unsortedArray = getRandomIntArray(100, 1000, -500, 1);

        int[] actualArray = unsortedArray.clone();
        int[] expectedArray = unsortedArray.clone();

        sa.sort(actualArray);
        Arrays.sort(expectedArray);

        // System.out.println(Arrays.toString(actualArray));
        // System.out.println(Arrays.toString(expectedArray));

        int actual = Arrays.compare(actualArray, expectedArray);
        Assertions.assertEquals(0, actual);

    }

    @ParameterizedTest
    @ValueSource(strings = {"Bubble","Merge","BST"})
    @DisplayName("test")
    public void negative(String type) {

        SortingAlgorithm sa = getSortingAlgorithm(type);
        System.out.println(sa.getClass().getSimpleName());
        int[] unsortedArray = getRandomIntArray(100, 1000, -1000, 1);

        int[] actualArray = unsortedArray.clone();
        int[] expectedArray = unsortedArray.clone();

        sa.sort(actualArray);
        Arrays.sort(expectedArray);

        int actual = Arrays.compare(actualArray, expectedArray);
        Assertions.assertEquals(0, actual);

    }

    @ParameterizedTest
    @ValueSource(strings = {"Bubble","Merge","BST"})
    @DisplayName("test")
    public void zero(String type) {

        SortingAlgorithm sa = getSortingAlgorithm(type);
        System.out.println(sa.getClass().getSimpleName());
        int[] unsortedArray = {0,0,0,0,0,0,0,0};

        int[] actualArray = unsortedArray.clone();
        int[] expectedArray = unsortedArray.clone();

        sa.sort(actualArray);
        Arrays.sort(expectedArray);

        int actual = Arrays.compare(actualArray, expectedArray);
        Assertions.assertEquals(0, actual);

    }

    @ParameterizedTest
    @ValueSource(strings = {"Bubble","Merge","BST"})
    @DisplayName("test")
    public void empty(String type) {

        SortingAlgorithm sa = getSortingAlgorithm(type);
        System.out.println(sa.getClass().getSimpleName());
        int[] unsortedArray = getRandomIntArray(0, 100, 0, 1);

        int[] actualArray = unsortedArray.clone();
        int[] expectedArray = unsortedArray.clone();

        sa.sort(actualArray);
        Arrays.sort(expectedArray);

        int actual = Arrays.compare(actualArray, expectedArray);
        Assertions.assertEquals(0, actual);

    }

    //TODO null array

    private SortingAlgorithm getSortingAlgorithm(String algorithmType) {

        SortingAlgorithm sa = switch (algorithmType) {
            case "Bubble" -> new BubbleSort();
            case "Merge" -> new MergeSort();
            case "BST" -> new BinarySearchTreeFacade();
            default -> null;
        };

        return sa;
    }

    // If seed is 0 then don't use a seed
    private int[] getRandomIntArray(int size, int bound, int offset, int seed) {

        Random random = new Random(seed);
        if (seed == 0) random = new Random();

        int[] result = new int[size];

        for (int i = 0; i < size; i++) {
            result[i] = random.nextInt(bound) + offset;
        }

        return result;
    }

}
