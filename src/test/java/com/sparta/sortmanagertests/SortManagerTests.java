package com.sparta.sortmanagertests;

import com.sparta.sortmanager.controller.SortManager;
import org.junit.jupiter.api.*;

import java.util.Arrays;

public class SortManagerTests {

    private static SortManager sortManager;
    private static final String DESIRED_ALGORITHM = "Bubble";

    @BeforeAll
    static void setUp() {
        sortManager = new SortManager();
    }

    @AfterEach
    void cleanUp() {
        sortManager.resetSorting();
    }

    @DisplayName("Given an array of length 11 with random values between 0 and 100 as well as" +
            " a random seed of 1. The sorted array should match the Arrays.sort method")
    @Test
    public void givenAnArrayOf11Values0To100_SortedArray_MatchesArraysSort() {

        sortManager.initialiseRandomArray(11, 100, 1);
        sortManager.initiateSorting(DESIRED_ALGORITHM);

        int[] sortedArray = sortManager.getSortedArray();

        int[] expectedArray = sortManager.getUnsortedArray();
        Arrays.sort(expectedArray);

        int actual = Arrays.compare(sortedArray, expectedArray);
        Assertions.assertEquals(0, actual);

    }

    // Test the random array size is as expected
    @DisplayName("Given a random array of set size 7 the length of the array should be 7")
    @Test
    public void checkGetRandomArrayLength() {

        sortManager.initialiseRandomArray(7, 100, 1);
        int arrayLength = sortManager.getUnsortedArray().length;

        Assertions.assertEquals(7, arrayLength);

    }

    // TODO Does an array with negative values gets sorted?
    // TODO Empty array outcome?
    // TODO What if the array is null?

}
