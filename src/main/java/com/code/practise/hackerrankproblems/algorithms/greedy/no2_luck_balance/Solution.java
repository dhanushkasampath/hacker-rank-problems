package com.code.practise.hackerrankproblems.algorithms.greedy.no2_luck_balance;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class Solution {

    /**
     * This is a solution which uses Greedy Method.
     * leena has to participate all the contests
     *
     *
     * @param k -> maximum number of important contests that leena can loose
     * @param contests -> list of contests
     * @return
     */
    public static int luckBalance(int k, List<List<Integer>> contests) {

        List<Integer> luckBalanceOfImportantContests = new ArrayList<>();

        int luckBalance = 0;
        for(List<Integer> contest : contests){

            //if rating is 0, it's ok to get them loose. So their luckbalance can be summed together
            if(0 == contest.get(1)){
                luckBalance = luckBalance + contest.get(0);
            }

            //if rating is 1, that is an important contest. we add the luck balance of those contests to a separate list
            if(1 == contest.get(1)){
                luckBalanceOfImportantContests.add(contest.get(0));
            }
        }

        //here we sort the luck balances of important contests in descending order
        //This is a maximization problem
        luckBalanceOfImportantContests.sort(Collections.reverseOrder());

        //We define a separate list to store the luck balance of contests that leena needs to win. this list gets values in luckBalanceOfImportantContests list which are away from k.
        // we need to substract those values from main luckBalance
        List<Integer> reduceList = new ArrayList<>();

        for(int i=0; i < luckBalanceOfImportantContests.size(); i++){
            if (i < k) {
                luckBalance = luckBalance + luckBalanceOfImportantContests.get(i);
            } else {
                reduceList.add(luckBalanceOfImportantContests.get(i));
            }
        }

        for(int reduceValue : reduceList){
            luckBalance = luckBalance - reduceValue;
        }
        return luckBalance;
    }

    public static void main(String[] args){

        List<List<Integer>> contests = new ArrayList<>();
        contests.add(Arrays.asList(5, 1));
        contests.add(Arrays.asList(2, 1));
        contests.add(Arrays.asList(1, 1));
        contests.add(Arrays.asList(8, 1));
        contests.add(Arrays.asList(10, 0));
        contests.add(Arrays.asList(5, 0));
        int k = 3;
        int luckBalance = luckBalance(k, contests);
        System.out.println("luckBalance:"+luckBalance);

    }

}
