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

        String compareAlgorithmChoice = displayManager.getCompareAlgorithmChoice();
        boolean validCompareChoice = sortManager.checkCompareChoice(compareAlgorithmChoice);

        while (!validCompareChoice) {
            logger.warn("Invalid compare algorithm choice entered, retrying input");

            displayManager.displayRepeatMessage();
            compareAlgorithmChoice = displayManager.getCompareAlgorithmChoice();
            validCompareChoice = sortManager.checkCompareChoice(compareAlgorithmChoice);
        }

        if (sortManager.getCompareChoice(compareAlgorithmChoice)) {

            String compareAlgorithm = displayManager.getDesiredAlgorithm();

            boolean validCompareAlgorithm =
                    sortManager.checkCompareAlgorithm(compareAlgorithm, desiredAlgorithm);

            while (!validCompareAlgorithm) {
                logger.warn("Invalid compare algorithm type entered, retrying input");

                displayManager.displayRepeatCompareMessage();
                compareAlgorithm = displayManager.getDesiredAlgorithm();
                validCompareAlgorithm = sortManager.checkCompareAlgorithm(compareAlgorithm, desiredAlgorithm);

            }

            sortManager.initiateSorting(compareAlgorithm);
            double compareSortingTime = sortManager.getSortingTimeSeconds();

            displayManager.displayOriginalArray(unsortedArrayString);
            displayManager.displaySortedArray(sortedArrayString);
            displayManager.displayCompareSortingTime(sortingTime, compareSortingTime);

        }

        logger.info("Exiting application");

    }

    private void sortFirstAlgorithm() {



    }

}
