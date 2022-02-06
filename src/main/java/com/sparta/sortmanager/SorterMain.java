package com.sparta.sortmanager;

import com.sparta.sortmanager.controller.SortManager;
import com.sparta.sortmanager.view.DisplayManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class SorterMain {

    public static Logger logger = LogManager.getLogger("Sort-Logger");

    // view and controller
    private static DisplayManager displayManager = new DisplayManager();
    private static SortManager sortManager = new SortManager();


    public static void main(String[] args) {

        System.out.println("Hello");

        // sorts the first algorithm
        String desiredAlgorithm = sortFirstAlgorithmMain();

        String compareAlgorithmChoice = checkIfComparingMain();

        if (sortManager.getCompareChoice(compareAlgorithmChoice)) {
            compareAlgorithmsMain(desiredAlgorithm);
        }

        logger.info("Exiting application");

    }

    private static String sortFirstAlgorithmMain() {

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

        String algorithmName = sortManager.getSortingAlgorithmTypeString(desiredAlgorithm);
        displayManager.displaySortingTime(algorithmName, sortingTime);

        return desiredAlgorithm;

    }

    private static String checkIfComparingMain() {

        String compareAlgorithmChoice = displayManager.getCompareAlgorithmChoice();
        boolean validCompareChoice = sortManager.checkCompareChoice(compareAlgorithmChoice);

        while (!validCompareChoice) {
            logger.warn("Invalid compare algorithm choice entered, retrying input");

            displayManager.displayRepeatMessage();
            compareAlgorithmChoice = displayManager.getCompareAlgorithmChoice();
            validCompareChoice = sortManager.checkCompareChoice(compareAlgorithmChoice);
        }

        return compareAlgorithmChoice;

    }

    private static void compareAlgorithmsMain(String desiredAlgorithm) {

        String compareAlgorithm = displayManager.getDesiredAlgorithm();

        boolean validCompareAlgorithm =
                sortManager.checkCompareAlgorithm(compareAlgorithm, desiredAlgorithm);

        while (!validCompareAlgorithm) {
            logger.warn("Invalid compare algorithm type entered, retrying input");

            displayManager.displayRepeatCompareMessage();
            compareAlgorithm = displayManager.getDesiredAlgorithm();
            validCompareAlgorithm = sortManager.checkCompareAlgorithm(compareAlgorithm, desiredAlgorithm);

        }

        double firstSortingTime = sortManager.getSortingTimeSeconds();

        String sortedArrayString = sortManager.initiateSorting(compareAlgorithm);
        double compareSortingTime = sortManager.getSortingTimeSeconds();

        displayManager.displayOriginalArray(sortManager.getUnsortedArrayString());
        displayManager.displaySortedArray(sortedArrayString);

        String firstAlgorithm = sortManager.getSortingAlgorithmTypeString(desiredAlgorithm);
        String secondAlgorithm = sortManager.getSortingAlgorithmTypeString(compareAlgorithm);

        displayManager.displayCompareSortingTime(firstAlgorithm, firstSortingTime, secondAlgorithm, compareSortingTime);

    }


}
