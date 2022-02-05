package com.sparta.sortmanagertests;

import com.sparta.sortmanager.controller.SortManager;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;

public class SortManagerTests {

    private static SortManager sortManager;

    @BeforeAll
    static void setUp() {
        sortManager = new SortManager();
    }

    @DisplayName("Given a random array of set size 7 generated from initialiseRandomArray" +
            " the length of the random array should be 7")
    @Test
    public void checkInitialiseRandomArrayLength() {

        sortManager.initialiseRandomArray(7, 100, 0);
        int arrayLength = sortManager.getUnsortedArray().length;

        Assertions.assertEquals(7, arrayLength);

    }

    // "Bubble", "Merge", "BST"
    @ParameterizedTest
    @ValueSource(strings = {"1","2","3"})
    @DisplayName("Given a desired algorithm of 1, 2 or 3, initiateSorting" +
            " matches the Arrays.sort method")
    public void givenAnAlgorithm_InitiateSorting_MatchesArraysSort(String algorithm) {

        int[] actualArray = {10,73,87,91,24,5,41};
        int[] expectedArray = actualArray.clone();

        sortManager.setUnsortedArray(expectedArray);
        String actualExpected = sortManager.initiateSorting(algorithm);

        Arrays.sort(expectedArray);
        String expectedString = Arrays.toString(expectedArray);

        Assertions.assertEquals(actualExpected, expectedString);

    }

    @DisplayName("Given a desired algorithm of Fibonacci, using initiateSorting" +
            " should throw a NullPointerException")
    @Test
    public void givenAFibonacci_InitiateSorting_ThrowsNullPointerException() {

        Assertions.assertThrows(
                NullPointerException.class,
                () -> sortManager.initiateSorting("Fibonacci"),
                "No exception thrown"
        );
    }

    // "Bubble", "Merge", "BST"
    @ParameterizedTest
    @ValueSource(strings = {"1","2","3"})
    @DisplayName("Given a desired algorithm of 1, 2 or 3, checkSortingAlgorithm" +
            " returns true")
    public void givenAValidAlgorithm_CheckSortingAlgorithm_ReturnsTrue(String algorithm) {

        boolean actual = sortManager.checkSortingAlgorithm(algorithm);

        Assertions.assertEquals(actual, true);

    }

    // "Bubble", "Merge", "BST"
    @Test
    @DisplayName("Given a desired algorithm of 5, checkSortingAlgorithm" +
            " returns false")
    public void givenAInvalidAlgorithm_CheckSortingAlgorithm_ReturnsFalse() {

        boolean actual = sortManager.checkSortingAlgorithm("5");

        Assertions.assertEquals(actual, false);

    }

}
