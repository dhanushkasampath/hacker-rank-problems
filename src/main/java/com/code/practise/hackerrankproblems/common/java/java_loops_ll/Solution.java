package com.code.practise.hackerrankproblems.common.java.java_loops_ll;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * This answer got accepted
 */
public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int noOfQueries = sc.nextInt();

        List<List<Integer>> queryList = new ArrayList<>();

        for(int i=0; i< noOfQueries; i++){
            List<Integer> query = new ArrayList<>();
            for(int j = 0; j < 3; j++){
                query.add(sc.nextInt());
            }
            queryList.add(query);
        }
        printSeries(queryList);
    }

    private static void printSeries(List<List<Integer>> queryList){
        for (List<Integer> query : queryList) {
            int a = query.get(0);
            int b = query.get(1);
            int n = query.get(2);

            StringBuilder stringBuilder = new StringBuilder();
            int last = 0;
            for (int i=0; i<n;i++) {
                int val = (int) (Math.pow(2, i) * b);
                last = last + val;
                int finalVal = a + last;
                stringBuilder.append(finalVal);
                stringBuilder.append(" ");
            }
            System.out.println(stringBuilder);
        }
    }
}
