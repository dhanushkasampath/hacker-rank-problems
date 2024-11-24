package com.code.practise.important_patterns_15.no6_monotonic_stack;

import java.util.Arrays;
import java.util.Stack;

public class NextGreaterElement {

    public static void main(String[] args) {
        int[] nums = {4, 5, 2, 10, 8};
        int[] result = nextGreaterElement(nums);
        System.out.println(Arrays.toString(result));
    }

    private static int[] nextGreaterElement(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        Stack<Integer> stack = new Stack<>();

        // Traverse the array from right to left
        for (int i = n - 1; i >= 0; i--) {
            // Maintain monotonic decreasing order in the stack
            while (!stack.isEmpty() && nums[i] >= stack.peek()) {
                stack.pop();
            }
            // If the stack is not empty, the top of the stack is the NGE
            result[i] = stack.isEmpty() ? -1 : stack.peek();
            // Push the current element onto the stack
            stack.push(nums[i]);
        }
        return result;
    }
}
