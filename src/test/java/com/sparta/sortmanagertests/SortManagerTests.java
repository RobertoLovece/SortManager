package com.sparta.sortmanagertests;

import com.sparta.sortmanager.controller.SortManager;
import org.junit.jupiter.api.*;

import java.util.Arrays;

public class SortManagerTests {

    private static SortManager sortManager;
    private static final String DESIRED_ALGORITHM = "Merge";

    @BeforeAll
    static void setUp() {
        sortManager = new SortManager();
    }

    @AfterEach
    void cleanUp() {
        sortManager.setUnsortedArray(null);
        sortManager.setSortedArray(null);
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

    // TODO Test size of random array is as expected
    // TODO Does an array with negative values gets sorted
    // TODO Empty array outcome?

}
