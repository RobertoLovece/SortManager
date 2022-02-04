package com.sparta.sortmanager;

import com.sparta.sortmanager.controller.SortManager;
import com.sparta.sortmanager.view.DisplayManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

// TODO Does an array with negative values gets sorted?
// TODO Empty array outcome?
// TODO What if the array is null?
// TODO split down tests into separate classes to remove coupling DONE

public class SorterMain {

    public static Logger logger = LogManager.getLogger("Sort-Logger");

    public static void main(String[] args) {

        DisplayManager displayManager = new DisplayManager();
        logger.debug("Successfully created DisplayManager view");

        String desiredAlgorithm = displayManager.getDesiredAlgorithm();
        // maybe refactor to check desired algorithm with while loop

        SortManager sortManager = new SortManager();
        logger.debug("Successfully created SortManager controller");

        String unsortedArrayString = sortManager.initialiseRandomArray(11, 100, 0);
        String sortedArrayString = sortManager.initiateSorting(desiredAlgorithm);
        double sortingTime = sortManager.getSortingTimeSeconds();

        logger.debug("Successfully executed sorting algorithm outputting results with DisplayManager");
        displayManager.displayOriginalArray(unsortedArrayString);
        displayManager.displaySortedArray(sortedArrayString);
        displayManager.displaySortingTime(sortingTime);

    }

}
