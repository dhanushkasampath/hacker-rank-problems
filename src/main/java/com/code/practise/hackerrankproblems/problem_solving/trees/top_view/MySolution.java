package com.code.practise.hackerrankproblems.problem_solving.trees.top_view;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * This solution is correct assuming only the nodes connected to root node are spread outwards.
 *
 * But this get fails when node nodes get spread outwards
 */
class Node {
    NodeClass left;
    NodeClass right;
    int data;

    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}

class Solution {

    private static final List<Integer> leftDataList = new ArrayList<>();
    private static final List<Integer> rightDataList = new ArrayList<>();

    /*

    class Node
        int data;
        Node left;
        Node right;
    */
    public static void topView(NodeClass root) {
        leftData(root);
        rightData(root);

        if (!leftDataList.isEmpty()) {
            leftDataList.remove(0);//remove the root since its already there is rightData list
        }

        if (!leftDataList.isEmpty()) {
            Collections.reverse(leftDataList);
        }

        StringBuilder sb = new StringBuilder();

        leftDataList.stream().forEach(data -> {
            sb.append(data);
            sb.append(" ");
        });
        rightDataList.stream().forEach(data -> {
            sb.append(data);
            sb.append(" ");
        });

        System.out.println(sb.toString());
    }

    public static void rightData(NodeClass root) {
        rightDataList.add(root.data);

        // System.out.print(root.data + " ");
        if(root.right != null) {
            rightData(root.right);
        }
    }

    private static void leftData(NodeClass root) {
        leftDataList.add(root.data);

        // System.out.print(root.data + " ");
        if(root.left != null) {
            leftData(root.left);
        }
    }

    public static NodeClass insert(NodeClass root, int data) {
        if(root == null) {
            return new NodeClass(data);
        } else {
            NodeClass cur;
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
//        Scanner scan = new Scanner(System.in);
//        int t = scan.nextInt();
//        Node root = null;
//        while(t-- > 0) {
//            int data = scan.nextInt();
//            root = insert(root, data);
//        }
//        scan.close();
//        topView(root);

//        int[] arr = {1, 2, 5, 3, 6, 4};
        int[] arr = {1, 14, 3, 7, 4, 5, 15, 6, 13, 10, 11, 2, 12, 8, 9};
        NodeClass root = null;
        for(int i : arr) {
            root = insert(root, i);
        }
        topView(root);
    }
}