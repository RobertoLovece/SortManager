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

    @ParameterizedTest
    @ValueSource(strings = {"Bubble","Merge","BST"})
    @DisplayName("Given a desired algorithm of Bubble, Merge or BST, initiateSorting" +
            " matches the Arrays.sort method")
    public void givenAnAlgorithm_InitiateSorting_MatchesArraysSort() {

        int[] actualArray = {10,73,87,91,24,5,41};
        int[] expectedArray = actualArray.clone();

        sortManager.setUnsortedArray(expectedArray);
        String actualExpected = sortManager.initiateSorting("BST");

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

}
