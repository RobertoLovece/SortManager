package com.sparta.sortmanager;

import com.sparta.sortmanager.controller.SortManager;
import com.sparta.sortmanager.view.DisplayManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class SorterMain {

    public static Logger logger = LogManager.getLogger("Sort-Logger");

    public static void main(String[] args) {

        DisplayManager displayManager = new DisplayManager();
        logger.debug("Successfully created DisplayManager view");

        SortManager sortManager = new SortManager();
        logger.debug("Successfully created SortManager controller");

        String desiredAlgorithm = displayManager.getDesiredAlgorithm();
        boolean validAlgorithm = sortManager.checkSortingAlgorithm(desiredAlgorithm);

        while (!validAlgorithm) {
            logger.warn("Invalid desired algorithm entered, retrying input");

            displayManager.displayRepeatMessage();
            desiredAlgorithm = displayManager.getDesiredAlgorithm();
            validAlgorithm = sortManager.checkSortingAlgorithm(desiredAlgorithm);
        }

        String unsortedArrayString = sortManager.initialiseRandomArray(11, 100, 0);
        String sortedArrayString = sortManager.initiateSorting(desiredAlgorithm);
        double sortingTime = sortManager.getSortingTimeSeconds();

        logger.debug("Successfully executed sorting algorithm outputting results with DisplayManager");
        displayManager.displayOriginalArray(unsortedArrayString);
        displayManager.displaySortedArray(sortedArrayString);
        displayManager.displaySortingTime(sortingTime);

    }

}
