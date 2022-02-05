package com.sparta.sortmanager.view;

import com.sparta.sortmanager.SorterMain;

import java.util.Scanner;

public class DisplayManager {

    public String getDesiredAlgorithm() {
        displayValidAlgorithms();
        System.out.print("Please enter the number of your desired algorithm type: ");

        Scanner scanner = new Scanner(System.in);
        String desiredAlgorithmType = scanner.next();

        SorterMain.logger.info("Desired algorithm type input was: '" + desiredAlgorithmType + "'");

        return desiredAlgorithmType;
    }

    public String getCompareAlgorithmChoice() {

        System.out.print("Do you want to compare the timing against another algorithm? (1: Yes, 2: No): ");

        Scanner scanner = new Scanner(System.in);
        String compareAlgorithm = scanner.next();

        SorterMain.logger.info("Compare algorithm choice input was: '" + compareAlgorithm + "'");

        return compareAlgorithm;
    }

    private void displayValidAlgorithms() {
        System.out.println("1: Bubble Sort, 2: Merge Sort, 3: Binary Search Tree");
    }

    public void displayRepeatMessage() {
        System.out.println("Please input a valid option!");
    }

    public void displayRepeatCompareMessage() {
        System.out.println("Invalid algorithm selected. Please input a valid algorithm or a different choice " +
                "from your first algorithm!");
    }

    public void displayOriginalArray(String array) {
        System.out.println("Unsorted Array: " + array);
    }

    public void displaySortedArray(String array) {
        System.out.println("Sorted Array: " + array);
    }

    public void displaySortingTime(double time) {
        System.out.println("Total sorting time was " + time + " seconds");
    }

    public void displayCompareSortingTime(double sortingTime, double compareSortingTime) {
        System.out.println("The sorting time of option 1 was " + sortingTime + " seconds");
        System.out.println("Compared with the sorting time of option 2 which was " + compareSortingTime + " seconds");
    }
}
