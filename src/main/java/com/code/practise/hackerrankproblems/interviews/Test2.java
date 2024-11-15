package com.code.practise.hackerrankproblems.interviews;

import java.util.*;
import java.util.Arrays;

public class Test2 {
    public static void main(String[] args) {
//        int[] nums = { 1, 1, 1 };
        int k = 0;


        List<Integer> arr = Arrays.asList(1, 1, 1);
//        int maxLength = findMaxLength(nums, k);
        int maxLength = maxSubsequenceLength(k, arr);
        System.out.println(maxLength);

    }



    public static int findMaxLength(int[] nums, int k) {
        int n = nums.length;
        if (n == 0) {
            return 0;
        }

        // Map to store the length of the longest valid subsequence ending with each number
        Map<Integer, Integer> maxLengthEndingWith = new HashMap<>();
        int maxLen = 0;

        for (int num : nums) {
            // Check if there exists a number whose XOR with 'num' is equal to 'k'
            if (maxLengthEndingWith.containsKey(num ^ k)) {
                int length = maxLengthEndingWith.get(num ^ k) + 1;
                maxLengthEndingWith.put(num, length);
                maxLen = Math.max(maxLen, length);
            } else {
                maxLengthEndingWith.put(num, 1); // At minimum, each element is a valid subsequence of length 1
            }
        }

        return maxLen;
    }







    public static int maxSubsequenceLength(int k, List<Integer> arr) {
        int lengthOfList = arr.size();

        if (lengthOfList == 0) {
            return 0;
        }

        int[] longestValidSequence = new int[lengthOfList]; // to store the length of the longest valid subsequence ending at index i
        Arrays.fill(longestValidSequence, 1); // since a single element is a valid subsequence

        int maxLength = 1; // set the maxLength of a subsequence to 1 at the beginning

        // Iterate via each element to calculate longestValidSequence[i]
        for (int i = 1; i < lengthOfList; i++) {
            for (int j = 0; j < i; j++) {
                if ((arr.get(i) ^ arr.get(j)) == k) {
                    longestValidSequence[i] = Math.max(longestValidSequence[i], longestValidSequence[j] + 1);
                }
            }
            maxLength = Math.max(maxLength, longestValidSequence[i]);
        }

        return maxLength;
    }

    public static int findMaxLength1(int[] nums, int k) {
        int n = nums.length;
        if (n == 0) {
            return 0;
        }

        // dp[i] will store the length of the longest valid subsequence ending at index i
        int[] dp = new int[n];
        Arrays.fill(dp, 1); // At minimum, each element itself is a valid subsequence

        int maxLength = 1; // Initialize with at least the length of one element

        // Iterate through each element to calculate dp[i]
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if ((nums[i] ^ nums[j]) == k) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            maxLength = Math.max(maxLength, dp[i]);
        }

        return maxLength;
    }
}
