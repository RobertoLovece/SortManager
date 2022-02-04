package com.sparta.sortmanager.model;

import java.util.List;

public class BinarySearchTreeAdapter implements SortingAlgorithm {

    @Override
    public void sort(int[] inputArray) {

        if (inputArray == null) return;

        BinarySearchTree binarySearchTree = new BinarySearchTree(inputArray.length);

        // convert array to BST
        for (int value : inputArray) {
            binarySearchTree.addNode(value);
        }

        binarySearchTree.createTransverseOrder(binarySearchTree.getRoot());
        List<Integer> traverseOrder = binarySearchTree.getTraverseOrder();

        // replace array values with BST traversal values
        for (int i = 0; i < inputArray.length; i++) {
            inputArray[i] = traverseOrder.get(i);
        }

    }

}
