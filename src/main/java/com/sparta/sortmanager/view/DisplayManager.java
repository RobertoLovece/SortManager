package com.sparta.sortmanager.view;

import java.util.Scanner;

public class DisplayManager {

    public String getDesiredAlgorithm() {
        System.out.print("Please enter your desired algorithm type: ");

        Scanner scanner = new Scanner(System.in);
        String desiredAlgorithmType = scanner.next();

        return desiredAlgorithmType;
    }

    public void displayOriginalArray(String array) {
        System.out.println("Unsorted Array: " + array);
    }

    public void displaySortedArray(String array) {
        System.out.println("Sorted Array: " + array);
    }

}
