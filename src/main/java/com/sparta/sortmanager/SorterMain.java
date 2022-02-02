package com.sparta.sortmanager;

import com.sparta.sortmanager.controller.SortManager;
import com.sparta.sortmanager.view.DisplayManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class SorterMain {

    private static Logger logger = LogManager.getLogger("Sort-Logger");

    public static void main(String[] args) {

        logger.error("Test");

        DisplayManager displayManager = new DisplayManager();
        String desiredAlgorithm = displayManager.getDesiredAlgorithm();
        // maybe refactor to check desired algorithm with while loop

        SortManager sortManager = new SortManager();

        String unsortedArrayString = sortManager.initialiseRandomArray(11, 100, 0);
        String sortedArrayString = sortManager.initiateSorting(desiredAlgorithm);

        displayManager.displayOriginalArray(unsortedArrayString);
        displayManager.displaySortedArray(sortedArrayString);

    }

}
