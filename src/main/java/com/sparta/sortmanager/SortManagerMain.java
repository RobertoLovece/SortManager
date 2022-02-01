package com.sparta.sortmanager;

import java.util.Arrays;
import java.util.Random;

public class SortManagerMain {

    public static void main(String[] args) {

        int[] array = getRandomIntArray(11, 100);
        System.out.println("Start Array: " + Arrays.toString(array));

        BubbleSort bs = new BubbleSort();
        MergeSort ms = new MergeSort();

        System.out.println("Sorted Array: " +Arrays.toString(bs.sort(array)));

    }

    private static int[] getRandomIntArray(int size, int bound) {
        int[] result = new int[size];

        Random random = new Random();

        for (int i = 0; i < size; i++) {
             result[i] = random.nextInt(bound);
        }

        return result;
    }

}
