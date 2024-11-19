package com.code.practise.important_patterns_15.no3_sliding_window.find_the_subarray_with_max_sum;

public class MaxSum {
    public static void main(String[] args) {
        int[] arr = new int[]{3, 2, 7, 5, 9, 6, 2};
        int k = 3;

        System.out.println("Max sum: " + findMaxSumBySlidingWindow(arr, k));
    }

    private static int findMaxSumBySlidingWindow(int[] arr, int k) {
        int initialSum =0;
        for(int i=0;i<k;i++){
            initialSum +=arr[i];
        }
        System.out.println("Initial sum "+initialSum);
        int finalMaxSum = initialSum ;

        for(int f=1, l=k; l<arr.length;f++,l++) {
            initialSum = initialSum - arr[f-1] + arr[l]; // This is the logic in sliding window
            if(initialSum>finalMaxSum ) {
                finalMaxSum =initialSum;
            }
        }
        return finalMaxSum;
    }
}

// f - first-Pointer
// l - last-Pointer