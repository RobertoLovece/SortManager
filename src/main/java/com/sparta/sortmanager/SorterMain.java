package com.sparta.sortmanager;

import com.sparta.sortmanager.controller.SortManager;
import com.sparta.sortmanager.model.BubbleSort;
import com.sparta.sortmanager.model.MergeSort;
import com.sparta.sortmanager.model.SortingAlgorithm;
import com.sparta.sortmanager.view.DisplayManager;

import java.util.Arrays;
import java.util.Random;

public class SorterMain {

    public static void main(String[] args) {

        DisplayManager displayManager = new DisplayManager();
        String desiredAlgorithm = displayManager.getDesiredAlgorithm();

        SortManager sortManager = new SortManager();

        String sortedArrayString = sortManager.initiateSorting(desiredAlgorithm);
        String unsortedArrayString = sortManager.getUnsortedArrayString();

        displayManager.displayOriginalArray(unsortedArrayString);
        displayManager.displaySortedArray(sortedArrayString);

    }

}
