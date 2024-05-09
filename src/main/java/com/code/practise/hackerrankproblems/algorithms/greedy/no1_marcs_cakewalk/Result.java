package com.code.practise.hackerrankproblems.algorithms.greedy.no1_marcs_cakewalk;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class Result {

    /*
     * Complete the 'marcsCakewalk' function below.
     *
     * The function is expected to return a LONG_INTEGER.
     * The function accepts INTEGER_ARRAY calorie as parameter.
     */

    public static long marcsCakewalk(List<Integer> calorie) {
        // Write your code here
        Collections.sort(calorie);
        Collections.reverse(calorie);
        long minimumMilesNecessary = 0;
        for(int i=0; i< calorie.size(); i++){
            minimumMilesNecessary += (long) (Math.pow(2, i) * calorie.get(i));
        }
        return minimumMilesNecessary;
    }

    public static void main(String[] args){
        System.out.println(marcsCakewalk(Arrays.asList(5, 10, 7)));
    }

}
