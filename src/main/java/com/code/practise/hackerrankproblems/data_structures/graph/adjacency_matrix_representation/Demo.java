package com.code.practise.hackerrankproblems.data_structures.graph.adjacency_matrix_representation;

public class Demo {
    public static void addEdge(int[][] matrix, int i, int j){
        matrix[i][j] = 1;
        matrix[j][i] = 1; // when we add an edge from both sides it should be connected. That is why we use these two assignments to 1
    }

    public static void displayMatrix(int[][] matrix){
        for(int[] row: matrix){
            for(int val : row){
                System.out.print(val + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int noOfVertices = 4;

        int[][] matrix = new int[noOfVertices][noOfVertices]; // creating a 2D array

        //Now add edges one by one
        addEdge(matrix, 0, 1); // Since there is an edge between 0 and 1
        addEdge(matrix, 0, 2); // Since there is an edge between 0 and 2
        addEdge(matrix, 1, 2); // Since there is an edge between 1 and 2
        addEdge(matrix, 2, 3); // Since there is an edge between 2 and 3

        System.out.println("Adjacency Matrix Representation");
        displayMatrix(matrix);
    }
}
