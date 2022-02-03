package com.sparta.sortmanager.model;

public class BinarySearchTree {

    private Node root;

    public static void main(String[] args) {

        BinarySearchTree theTree = new BinarySearchTree();

        theTree.addNode(50);
        theTree.addNode(25);
        theTree.addNode(15);
        theTree.addNode(30);
        theTree.addNode(75);
        theTree.addNode(85);

        theTree.inOrderTransverseTree(theTree.root);

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

    public void inOrderTransverseTree(Node focusNode) {

        if (focusNode != null) {

            inOrderTransverseTree(focusNode.leftChild);

            System.out.println(focusNode);

            inOrderTransverseTree(focusNode.rightChild);

        }

    }

    private class Node {

        private int value;

        private Node leftChild;
        private Node rightChild;

        private Node(int value) {

            this.value = value;

        }

        @Override
        public String toString() {
            return "value: " + value;
        }

    }


}
