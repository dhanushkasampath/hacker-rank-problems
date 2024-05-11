package com.code.practise.hackerrankproblems.algorithms.dynamic_programming.construct_the_array;

public class Solution {
    public static final long MODULUS = 1000000007;

    public static long countArray(int n, int k, int x) {

        long a = 0;
        long b = 1;

        for (int i = 3; i <= n; i++) {
            long a2 = (k - 1) * b;
            a2 %= MODULUS;
            long b2 = (k - 2) * b;
            b2 %= MODULUS;
            b2 += a;
            b2 %= MODULUS;
            a = a2;
            b = b2;
        }

        if (x == 1) {
            return a;
        } else {
            return b;
        }
    }

    public static void main(String[] args) {
        System.out.println(countArray(4, 3, 2));
    }
}
