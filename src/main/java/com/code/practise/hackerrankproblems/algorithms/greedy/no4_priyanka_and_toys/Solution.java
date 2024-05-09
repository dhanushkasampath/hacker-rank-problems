package com.code.practise.hackerrankproblems.algorithms.greedy.no4_priyanka_and_toys;

import java.util.*;

class Solution {

    /**
     * This is a solution which uses Greedy Method.
     *
     * @param w weight of objects
     * @return
     */
    public static int toys(List<Integer> w) {
        // Write your code here

        int weightGap = 4;
        int noOfContainersNeeded = 0;

        //sort the weights in ascending order
        Collections.sort(w);

        int weightOfFirstItemAddedToAContainer = 0;
        for(int weight : w){
            if (weight == 0) {
                continue;
            }
            if(weightOfFirstItemAddedToAContainer == 0){
                noOfContainersNeeded++;
                weightOfFirstItemAddedToAContainer = weight;
            } else {
                if(weight - weightOfFirstItemAddedToAContainer > weightGap){
                    noOfContainersNeeded++; // need a new container
                    weightOfFirstItemAddedToAContainer = weight;
                }
            }
        }
        return noOfContainersNeeded;
    }

    public static void main(String[] args){
//        System.out.println(toys(Arrays.asList(1, 2, 3, 21, 7, 12, 14, 21)));
//        System.out.println(toys(Arrays.asList(7, 8, 12, 15, 19, 24)));
//        System.out.println(toys(Arrays.asList(16, 18, 10, 13, 2, 9, 17, 17, 0, 19)));
        System.out.println(toys(Arrays.asList(724, 103, 403, 792, 195, 445, 676, 337,
                142, 731, 274, 530, 478, 719, 966, 680, 202, 692, 142, 260, 333, 555, 905, 517, 679, 432, 620, 477, 841,
                340, 960, 566, 443, 715, 710, 639, 160, 386, 328, 655, 469, 955, 537, 299, 674, 855, 980, 228, 548, 122,
                489, 881, 30, 746, 750, 709, 531, 370, 539, 372, 710, 499, 938, 505, 215, 0, 144, 727, 738, 825, 734, 207,
                780, 271, 507, 806, 127, 839, 387, 675, 313, 228, 908, 343, 974, 658, 53, 857, 380, 592, 230, 442, 443,
                520, 947, 10, 521, 444, 738, 259))); // expected it 66 but i get 65. i'm confused

    }

}
