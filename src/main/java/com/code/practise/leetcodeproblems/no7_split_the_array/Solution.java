package com.code.practise.leetcodeproblems.no7_split_the_array;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static boolean isPossibleToSplit(int[] nums) {

        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();

        for(int num : nums){
            if (!list1.contains(num)) {
                list1.add(num);
            } else {
                if(!list2.contains(num)){
                    list2.add(num);
                } else {
                    return false;
                }
            }
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(isPossibleToSplit(new int[]{0, 1, 2, 3}));
        System.out.println(isPossibleToSplit(new int[]{1, 1, 1, 1}));

    }
}
