package com.sparta.sortmanagertests;

import com.sparta.sortmanager.controller.SortManager;
import org.junit.jupiter.api.*;

public class SortManagerTests {

    private static SortManager sortManager;

    @BeforeAll
    static void setUp() {
        sortManager = new SortManager();
    }

    // Test the random array size is as expected
    @DisplayName("Given a random array of set size 7 generated initialiseRandomArray the length of the array should be 7")
    @Test
    public void checkInitialiseRandomArrayLength() {

        sortManager.initialiseRandomArray(7, 100, 0);
        int arrayLength = sortManager.getUnsortedArray().length;

        Assertions.assertEquals(7, arrayLength);

    }

}
