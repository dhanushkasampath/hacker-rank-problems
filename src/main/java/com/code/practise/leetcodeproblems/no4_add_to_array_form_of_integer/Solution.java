package com.code.practise.leetcodeproblems.no4_add_to_array_form_of_integer;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution {
    public static List<Integer> addToArrayForm(int[] num, int k) {
        StringBuilder sb = new StringBuilder();
        for(int n : num){
            sb.append(n);
        }

        BigInteger value = new BigInteger(sb.toString());
        BigInteger sum = value.add(new BigInteger(String.valueOf(k)));
        return separateDigits(sum);

    }

    public static List<Integer> separateDigits(BigInteger number) {
        List<Integer> digits = new ArrayList<>();

        while (number.compareTo(BigInteger.ZERO) > 0) {
            BigInteger digit = number.remainder(new BigInteger("10")); // Extract the last digit
            digits.add(digit.intValue()); // Add the digit to the list
            number = number.divide(new BigInteger("10")); // Remove the last digit
        }

        // Reverse the list to get the digits in the correct order
        Collections.reverse(digits);

        return digits;
    }

    public static void main(String[] args) {
        List<Integer> list = addToArrayForm(new int[]{1, 2, 0, 0}, 34);
        System.out.println(list);
    }
}
