package com.code.practise.important_patterns_15.no1_prefix_sum.q303_range_sum_query_immutable;

public class NumArray {

    private final int[] prefixSum;
    public NumArray(int[] nums) {
        prefixSum = new int[nums.length];
        prefixSum[0] = nums[0];
        for(int i=1; i< nums.length; i++){
            prefixSum[i] = prefixSum[i-1] + nums[i];
        }
    }

    public int sumRange(int left, int right) {

        if(left == 0){ // This means we request the sum from the beginning
            return prefixSum[right];
        } else {
            return prefixSum[right]- prefixSum[left-1];
        }
    }

    public static void main(String[] args) {
        NumArray numArray = new NumArray(new int[]{-2, 0, 3, -5, 2, -1});
        int sum1 = numArray.sumRange(0,2);
        System.out.println("Sum1: " + sum1);

    }
}
