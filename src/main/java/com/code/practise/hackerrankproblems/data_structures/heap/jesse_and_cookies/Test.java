package com.code.practise.hackerrankproblems.data_structures.heap.jesse_and_cookies;

import java.util.Arrays;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        List<Integer> cookieList = Arrays.asList(2,7,3,6,4,6);
        int expectedSweetNess = 9;
        Solution solution = new Solution();
        System.out.println("No. of iterations required to bring all sweets above the expected level: " +
                solution.noOfIterationsRequired(expectedSweetNess, cookieList));
    }
}
