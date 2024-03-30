package com.code.practise.leetcodeproblems.add_digits;

import java.util.Collections;
import java.util.List;
import java.util.ArrayList;

public class Solution1 {
    public static int getSumOfArrayList(List<Integer> numberList) {
        int sum = 0;
        for(int num : numberList){
            sum = sum + num;
        }
        return sum;
    }

    public static List<Integer> separateDigits(int number) {
        List<Integer> digits = new ArrayList<>();

        while (number > 0) {
            int digit = number % 10; // Extract the last digit
            digits.add(digit); // Add the digit to the list
            number /= 10; // Remove the last digit
        }

        // Reverse the list to get the digits in the correct order
        Collections.reverse(digits);

        return digits;
    }

    public static int addDigits(int num) {
        if (num == 0) {
            return 0;
        } else {
            List<Integer> numList = separateDigits(num);
            int sum = getSumOfArrayList(numList);
            if (Math.abs(sum) < 10) {
                return sum;
            } else {
                return addDigits(sum);
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(addDigits(12345));
    }
}
