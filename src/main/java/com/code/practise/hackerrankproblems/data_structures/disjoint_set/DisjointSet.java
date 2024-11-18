package com.code.practise.hackerrankproblems.data_structures.disjoint_set;

public class DisjointSet {

    private int[] parent;

    /**
     *
     * @param size This is the constructor. it takes the size of the array needs to be created as the argument.
     */
    public DisjointSet(int size) {
        // Initialize the parent array with each element as its own representative
        parent = new int[size];
        for (int i = 0; i < size; i++) {
            parent[i] = i;
        }
    }

    /**
     * Find the representative (root) of the set that includes element i
     * @param i here i is the index of the node
     * @return root node
     */
    public int findRootNode(int i) {
        if (parent[i] == i) {
            return i;
        }

        parent[i] = findRootNode(parent[i]);
        return parent[i];
    }

    public void unionTwoSets(int i, int j) {
        int representativeOfSetContainingI = findRootNode(i);
        int representativeOfSetContainingJ = findRootNode(j);

        // Make the representative of i's set be the representative of j's set
        parent[representativeOfSetContainingI] = representativeOfSetContainingJ;
    }

    public static void main(String[] args) {
        int size = 5;
        DisjointSet disjointSet = new DisjointSet(size);

        // Perform union operations as needed
        disjointSet.unionTwoSets(1, 2);
        disjointSet.unionTwoSets(3, 4);

        // Check if elements are in the same set
        boolean inSameSet = disjointSet.findRootNode(1) == disjointSet.findRootNode(2);
        System.out.println("Are 1 and 2 in the same set? " + inSameSet);
    }
}
