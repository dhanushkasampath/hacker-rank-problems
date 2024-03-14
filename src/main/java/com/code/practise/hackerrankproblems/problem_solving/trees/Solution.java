package com.code.practise.hackerrankproblems.problem_solving.trees;

import java.util.Scanner;

class Node {
    Node left;
    Node right;
    int data;

    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}

class Solution {

    /*
    class Node 
        int data;
        Node left;
        Node right;
    */
    public static int height(Node root) {
        // Write your code here.
        if (root == null || root.left == null && root.right == null) {
            return 0;
        } else {
            int leftHeight = 0;
            int rightHeight = 0;

            if (root.left != null) {//has a left child
                leftHeight = height(root.left);// recursive call
            }

            if (root.right != null) {//has a right child
                rightHeight = height(root.right); // recursive call
            }

            //Compare height of left subtree and right subtree  
            //and store maximum of two in variable max  
            int max = Math.max(leftHeight, rightHeight);

            // Calculate the total height of tree by adding height of root
            return max + 1;
        }
    }


    public static Node insert(Node root, int data) {
        if(root == null) {
            return new Node(data);
        } else {
            Node cur;
            if(data <= root.data) {
                cur = insert(root.left, data);
                root.left = cur;
            } else {
                cur = insert(root.right, data);
                root.right = cur;
            }
            return root;
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        Node root = null;
        while(t-- > 0) {
            int data = scan.nextInt();
            root = insert(root, data);
        }
        scan.close();
        int height = height(root);
        System.out.println(height);
    }
}