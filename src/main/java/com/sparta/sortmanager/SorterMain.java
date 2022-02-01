package com.sparta.sortmanager;

import com.sparta.sortmanager.controller.SortManager;
import com.sparta.sortmanager.view.DisplayManager;


public class SorterMain {

    public static void main(String[] args) {

        DisplayManager displayManager = new DisplayManager();
        String desiredAlgorithm = displayManager.getDesiredAlgorithm();

        SortManager sortManager = new SortManager();

        String unsortedArrayString = sortManager.initialiseRandomArray(11, 100, 0);
        String sortedArrayString = sortManager.initiateSorting(desiredAlgorithm);

        displayManager.displayOriginalArray(unsortedArrayString);
        displayManager.displaySortedArray(sortedArrayString);

    }

}
