package com.sparta.sortmanagertests;

import com.sparta.sortmanager.BubbleSort;
import com.sparta.sortmanager.SortingAlgorithm;
import org.junit.jupiter.api.BeforeAll;

public class SortManagerTests {

    private static SortingAlgorithm sorter;

    @BeforeAll
    static void setUp() {
        sorter = new BubbleSort();
    }

}
