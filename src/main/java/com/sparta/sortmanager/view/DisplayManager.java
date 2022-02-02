package com.sparta.sortmanager.view;

import com.sparta.sortmanager.SorterMain;

import java.util.Scanner;

public class DisplayManager {

    public String getDesiredAlgorithm() {
        System.out.print("Please enter your desired algorithm type: ");

        Scanner scanner = new Scanner(System.in);
        String desiredAlgorithmType = scanner.next();

        SorterMain.logger.info("Desired algorithm type input was: '" + desiredAlgorithmType + "'");

        return desiredAlgorithmType;
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

}
