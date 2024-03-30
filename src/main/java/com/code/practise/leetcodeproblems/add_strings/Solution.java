package com.code.practise.leetcodeproblems.add_strings;

import java.math.BigInteger;

public class Solution {

    public static String addStrings(String num1, String num2) {
        BigInteger sum = new BigInteger(num1).add(new BigInteger(num2));
        return sum.toString();
    }

    public static void main(String[] args) {
        System.out.println(addStrings("2","3"));
    }
}
