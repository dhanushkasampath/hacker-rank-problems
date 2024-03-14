package com.code.practise.hackerrankproblems.problem_solving.trees.top_view;

import java.util.*;

/**
 * UNDERSTAND THIS
 */
class NodeClass {
    NodeClass left;
    NodeClass right;
    int data;

    NodeClass(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}

class CorrectSolution {

    /*

    class Node
        int data;
        Node left;
        Node right;
    */
    public static void topView(NodeClass root) {
        //In the top view of a binary tree, you start from the root and move horizontally to the left and right
        Map<Integer, TreeMap<Integer, Integer>> map = topViewRec(new TreeMap<>(), root, 0, 0);
        map.forEach((level, innerMap) -> {
            System.out.print(innerMap
                    .firstEntry()
                    .getValue() + " ");
        });
    }

    private static Map<Integer, TreeMap<Integer, Integer>> topViewRec(Map<Integer, TreeMap<Integer, Integer>> map, NodeClass root, int level, int depth) {

        if (map.get(level) == null) {
            TreeMap<Integer, Integer> innerMap = new TreeMap<>();
            innerMap.put(depth, root.data);
            map.put(level, innerMap);
        } else {
            map
                    .get(level)
                    .putIfAbsent(depth, root.data);
        }

        if (root.left != null || root.right != null) {
            depth++;
        }

        if (root.left != null) {
            topViewRec(map, root.left, level - 1, depth);
            if (root.left.right != null) {
                topViewRec(map, root.left.right, level, depth + 1);
            }
            if (root.left.left != null) {
                topViewRec(map, root.left.left, level - 2, depth + 1);
            }
        }

        if (root.right != null) {
            topViewRec(map, root.right, level + 1, depth);
            if (root.right.left != null) {
                topViewRec(map, root.right.left, level, depth + 1);
            }
            if (root.right.right != null) {
                topViewRec(map, root.right.right, level + 2, depth + 1);
            }
        }
        return map;
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
//        NodeClass root = null;
//        while(t-- > 0) {
//            int data = scan.nextInt();
//            root = insert(root, data);
//        }
//        scan.close();
//        topView(root);
        int[] arr = {1, 14, 3, 7, 4, 5, 15, 6, 13, 10, 11, 2, 12, 8, 9};
        NodeClass root = null;
        for(int i : arr) {
            root = insert(root, i);
        }
        topView(root);
    }
}