package com.sparta.sortmanagertests;

import com.sparta.sortmanager.model.BubbleSort;
import com.sparta.sortmanager.SorterMain;
import com.sparta.sortmanager.model.SortingAlgorithm;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class SorterMainTests {

    private static SorterMain sorterMain;
    private static SortingAlgorithm sorter;

    @BeforeAll
    static void setUp() {
        sorterMain = new SorterMain();
        sorter = new BubbleSort();
    }

    // @DisplayName("Given an array of length 11 with values between 0 and 100")
    // @Test
    // public void test() {
    //
    //     int[] testArray = sorterMain.getRandomIntArray(11, 100);
    //     int[] actualArray = testArray.clone();
    //
    //     sorter.sort(testArray);
    //     Arrays.sort(actualArray);
    //
    //     int actual = Arrays.compare(testArray, actualArray);
    //
    //     Assertions.assertEquals(0, actual);
    //
    // }


}
