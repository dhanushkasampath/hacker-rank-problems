package com.code.practise.hackerrankproblems.data_structures.trees;

public class Node {

    private Node left;
    private Node right;
    private int data;

    public Node(int data){
        this.data = data;
    }

    public void insert(int value) {
        if (value <= data) {
            if (left == null) {
                left = new Node(value);//stops by creating a new node in left
            } else {
                left.insert(value);
            }

        } else {
            if (right == null) {
                right = new Node(value);//stops by creating a new node in right
            } else {
                right.insert(value);
            }
        }
    }

    public boolean contains(int value) {
        if (value == data) {
            return true; // stops by returning true for this Node object
        } else if (value < data) {
            if (left == null) {
                return false; //no node in the left
            } else {
                return  left.contains(value);
            }
        } else {
            if (right == null) {
                return false; //no node in the right
            } else {
                return  right.contains(value);
            }
        }
    }

    public void printInOrder() {
        if (left != null) {
            left.printInOrder();
        }
        System.out.println(data);
        if (right != null) {
            left.printInOrder();
        }
    }

    public void printPreOrder() {
        System.out.println(data);
        if (left != null) {
            left.printPreOrder();
        }
        if (right != null) {
            left.printPreOrder();
        }
    }

    public void printPostOrder() {
        if (left != null) {
            left.printPostOrder();
        }
        if (right != null) {
            left.printPostOrder();
        }
        System.out.println(data);
    }
}
