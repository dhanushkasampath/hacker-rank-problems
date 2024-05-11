package com.code.practise.hackerrankproblems.algorithms.dynamic_programming.divide_chocos_equally;

import java.util.Collections;
import java.util.List;

/**
 * In detailed description can be found here
 * https://rohangupta-3817.medium.com/hackerrank-dp-equal-5adc78771571
 */
public class Solution {

    public static int equal(List<Integer> arr) {
        int ans = Integer.MAX_VALUE;
        int minElem = Collections.min(arr);

        for (int base = 0; base < 3; base++) {
            int temp = 0;
            for (int i = 0; i < arr.size(); i++) {
                int dist = arr.get(i) - (minElem - base);
                int steps = dist / 5 + (dist % 5) / 2 + (dist % 5) % 2;
                temp += steps;
            }
            ans = Math.min(ans, temp);
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
//        List<Integer> arr = List.of(1, 2, 3, 7, 8, 9);
        List<Integer> arr = List.of(10, 7, 12);
        System.out.println(solution.equal(arr));
    }
}
