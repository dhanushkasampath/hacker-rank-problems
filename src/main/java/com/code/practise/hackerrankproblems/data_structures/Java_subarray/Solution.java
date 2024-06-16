package com.code.practise.hackerrankproblems.data_structures.Java_subarray;

import java.util.Scanner;

/**
 * This solution is accepted
 */
public class Solution {

    public static void printSubArrayCount(int[] elementArr){
        int subArrayCount = 0;
        for(int arr : elementArr){
            if(arr < 0){
                subArrayCount++;
            }
        }

        for(int i = 0; i < elementArr.length; i++){
            for(int j = i+1; j < elementArr.length; j++){
                int sum = getArraySumByStartAndEndElements(elementArr, i, j);
                if(sum < 0){
                    subArrayCount++;
                }
            }
        }

        System.out.println(subArrayCount);
    }

    public static int getArraySumByStartAndEndElements(int[] arr, int start, int end){
        int sum = 0;
        for(int i = start; i < end+1; i++){
            sum = sum + arr[i];
        }
        return sum;
    }

    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int noOfElements = sc.nextInt();
//        int[] elementArr = new int[noOfElements];
//        for(int i=0; i< noOfElements; i++){
//            elementArr[i] = sc.nextInt();
//        }

        int[] elementArr = {1, -2, 4, -5, 1};
        printSubArrayCount(elementArr);
    }
}

