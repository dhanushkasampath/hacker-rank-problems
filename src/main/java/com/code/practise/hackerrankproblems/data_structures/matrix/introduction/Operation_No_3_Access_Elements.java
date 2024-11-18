package com.code.practise.hackerrankproblems.data_structures.matrix.introduction;

public class Operation_No_3_Access_Elements {
    public static void main(String[] args) {
        // Initializing a 2-D array with values
        int[][] arr
                = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };

        // Accessing elements of 2-D array
        System.out.println("First element of first row: "
                + arr[0][0]);
        System.out.println("Third element of second row: "
                + arr[1][2]);
        System.out.println("Second element of third row: "
                + arr[2][1]);
    }
}
