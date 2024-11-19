package com.code.practise.hackerrankproblems.data_structures.disjoint_set.hacker_rank_question_components_in_a_graph.using_2D_array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Forest {
    private List<TreeNode> forestRoots;

    public Forest() {
        forestRoots = new ArrayList<>();
    }

    public List<TreeNode> buildForest(int[][] edges) {
        Map<Integer, TreeNode> nodeMap = new HashMap<>(); // Map to store TreeNode by value
        Map<Integer, Integer> parentMap = new HashMap<>();       // Track all nodes that are children

        // Initialize nodes and Union-Find parent pointers
        for (int[] edge : edges) {
            for (int node : edge) {
                nodeMap.putIfAbsent(node, new TreeNode(node));
                parentMap.putIfAbsent(node, node); // Each node is its own parent initially
            }
        }

        // Union-Find: Connect components based on edges
        for (int[] edge : edges) {
            int parent1 = findParent(edge[0], parentMap);
            int parent2 = findParent(edge[1], parentMap);

            if (parent1 != parent2) {
                // Union the two components
                parentMap.put(parent1, parent2);
            }
        }

        // Group nodes by their connected components
        Map<Integer, TreeNode> rootMap = new HashMap<>();
        for (int node : nodeMap.keySet()) {
            int root = findParent(node, parentMap);
            rootMap.putIfAbsent(root, nodeMap.get(root));
            if (root != node) {
                rootMap.get(root).children.add(nodeMap.get(node));
            }
        }

        // Collect all unique roots
        forestRoots = new ArrayList<>(rootMap.values());
        return forestRoots;

    }

    private int findParent(int node, Map<Integer, Integer> parentMap) {
        if (parentMap.get(node) != node) {
            parentMap.put(node, findParent(parentMap.get(node), parentMap)); // Path compression
        }
        return parentMap.get(node);
    }

    public void printForest(List<TreeNode> roots) {
        for (TreeNode root : roots) {
            printTree(root, 0);
        }
    }

    private void printTree(TreeNode node, int level) {
        if (node == null) return;
        System.out.println("  ".repeat(level) + node.val);
        for (TreeNode child : node.children) {
            printTree(child, level + 1);
        }
    }

    private static List<Integer> generateResponse(List<TreeNode> roots) {
        List<Integer> response = new ArrayList<>();

        int minNodes = Integer.MAX_VALUE;
        int maxNodes = Integer.MIN_VALUE;
        for (TreeNode treeNode : roots){
            List<TreeNode> children = treeNode.children;
            if(children != null){
                int noOfChildren = children.size();
                if(minNodes > noOfChildren){
                    minNodes = noOfChildren;
                }

                if(maxNodes < noOfChildren){
                    maxNodes = noOfChildren;
                }
            }
        }

        response.add(minNodes+1);
        response.add(maxNodes+1);
        return response;
    }

    public static void main(String[] args) {
        Forest forest = new Forest();

        // Example: Define edges
        int[][] edges = {
                {1, 6}, {2, 7}, {3, 8}, {4, 9}, {2, 6}
        };

        // Build the forest
        List<TreeNode> roots = forest.buildForest(edges);

        // Print the forest
        System.out.println("Forest Structure:");
        forest.printForest(roots);

        List<Integer> response = generateResponse(roots);

        System.out.println(response);
    }
}