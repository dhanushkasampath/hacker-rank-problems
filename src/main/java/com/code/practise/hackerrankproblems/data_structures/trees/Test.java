package com.code.practise.hackerrankproblems.data_structures.trees;

/**
 * When we debug above code we can clearly understand how binary tree behaves.
 * The binary-tree.png file show the visual view of the above tree. The places where the nodes are placed is
 * totally depend on the time that it gets added to the tree
 */
public class Test {

    public static void main(String[] args) {
        // Assume we need to add this data to binary search tree.
        int[] arr = {38, 76, 33, 56, 90, 33, 71, 41, 48, 68};

        // Also we need to start by identifying the root node.
        // let's assume 40 as the root node.
        Node binaryTree = new Node(40);
        for(int i : arr) {
            binaryTree.insert(i);// use the insert method we defined
        }
        System.out.println("Data inserted to binary tree successfully");
    }
}