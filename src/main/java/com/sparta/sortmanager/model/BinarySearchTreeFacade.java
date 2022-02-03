package com.sparta.sortmanager.model;

import java.util.ArrayList;

public class BinarySearchTreeFacade implements SortingAlgorithm {

    @Override
    public void sort(int[] inputArray) {

        BinarySearchTree binarySearchTree = new BinarySearchTree();

        // convert array to bst
        for (int value : inputArray) {
            binarySearchTree.addNode(value);
        }

        binarySearchTree.createTransverseOrder(binarySearchTree.getRoot());
        ArrayList<Integer> traverseOrder = binarySearchTree.getTraverseOrder();

        for (int i = 0; i < inputArray.length; i++) {
            inputArray[i] = traverseOrder.get(i);
        }

    }

}
