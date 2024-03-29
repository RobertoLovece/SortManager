package com.sparta.sortmanager.model;

import java.util.ArrayList;
import java.util.List;

public class BinarySearchTree {

    private Node root;
    private List<Integer> traverseOrder;

    public BinarySearchTree(int traverseSize) {
        this.traverseOrder = new ArrayList<>(traverseSize);
    }

    public void addNode(int value) {

        Node newNode = new Node(value);

        if (root == null) {

            root = newNode;

        }
        else {

            Node focusNode = root;

            Node parent;

            while (true) {

                parent = focusNode;

                if (value < focusNode.value) {

                    focusNode = focusNode.leftChild;

                    if (focusNode == null) {

                        parent.leftChild = newNode;
                        return;

                    }

                } else {

                    focusNode = focusNode.rightChild;

                    if (focusNode == null) {

                        parent.rightChild = newNode;
                        return;

                    }
                }
            }
        }
    }

    public void createTransverseOrder(Node focusNode) {

        if (focusNode != null) {

            createTransverseOrder(focusNode.leftChild);

            traverseOrder.add(focusNode.value);

            createTransverseOrder(focusNode.rightChild);

        }

    }

    public List<Integer> getTraverseOrder() {
        return traverseOrder;
    }

    public Node getRoot() {
        return root;
    }

    private class Node {

        private int value;

        private Node leftChild;
        private Node rightChild;

        private Node(int value) {

            this.value = value;

        }

    }


}
