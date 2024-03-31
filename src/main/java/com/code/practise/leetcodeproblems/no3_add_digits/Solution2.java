package com.code.practise.leetcodeproblems.no3_add_digits;

public class Solution2 {
    public static int addDigits(int num) {
        while (num >= 10) {
            int total = 0;
            while (num > 0) {
                total += num % 10;
                num /= 10;
            }
            num = total;
        }
        return num;
    }

    public static void main(String[] args) {
        System.out.println(addDigits(12345));
    }
}
