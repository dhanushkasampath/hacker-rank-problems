package com.code.practise.hackerrankproblems.common.java.lambda_expressions;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Test {

    public static void main(String[] args) throws IOException {
        MyMath myMath = new MyMath();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int noOfTestCases = Integer.parseInt(br.readLine());
        PerformOperation performOperation;
        boolean ret = false;
        String ans = null;

        while (noOfTestCases--> 0) {
            String s = br.readLine().trim();
            StringTokenizer st = new StringTokenizer(s);
            int conditionToCheck = Integer.parseInt(st.nextToken());
            int num = Integer.parseInt(st.nextToken());
            if (conditionToCheck == 1) {
                performOperation = myMath.isOdd();
                ret = myMath.checker(performOperation, num);
                ans = (ret) ? "ODD" : "EVEN";
            } else if (conditionToCheck == 2) {
                performOperation = myMath.isPrime();
                ret = myMath.checker(performOperation, num);
                ans = (ret) ? "PRIME" : "COMPOSITE";
            } else if (conditionToCheck == 3) {
                performOperation = myMath.isPalindrome();
                ret = myMath.checker(performOperation, num);
                ans = (ret) ? "PALINDROME" : "NOT PALINDROME";

            }
            System.out.println(ans);
        }
    }
}

//5
//1 4
//2 5
//3 898
//1 3
//2 12


//result

//EVEN
//PRIME
//PALINDROME
//ODD
//COMPOSITE