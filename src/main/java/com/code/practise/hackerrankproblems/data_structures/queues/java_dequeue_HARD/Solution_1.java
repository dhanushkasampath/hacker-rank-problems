package com.code.practise.hackerrankproblems.data_structures.queues.java_dequeue_HARD;

import java.util.*;

/**
 * This solution passed all the test cases in the hacker rank including the constraint of completing the execution in 3 seconds
 */
public class Solution_1 {

    public static void main(String[] args) {
         System.out.println(maxUniqueNumbers(args));
     }

     @SuppressWarnings("resource")
     private static int maxUniqueNumbers(String[] args) {
         Scanner in = new Scanner(System.in);
         int n = in.nextInt(); // retrieve the number of entries in the array
         int m = in.nextInt(); // the size of the subarrays

         if (m>n || n > 100000 || m > 100000 ) throw new IllegalArgumentException("problem with input parameters");


         Deque<Integer> deque = new ArrayDeque<>();
         HashMap<Integer, Integer> countForEntries = new HashMap<>();

         int maxUniqueCount = 0;
         int currentUniqueCount = 0;

        //create initial deque consisting of the first m elements of the array
        //populate hashmap with the count of each element
        for (int i=0; i<m; i++) {
            int nextValue = in.nextInt();
            deque.add(nextValue);
            countForEntries.merge(nextValue, 1, Integer::sum);
        }

        maxUniqueCount = countForEntries.size();
        currentUniqueCount = countForEntries.size();

        //start to iterate through the rest of the array. remove the front value...
        //...and add the next value to the end of the deque

        for (int i=m; i<n; i++) {

            // remove the first element in the deque and reduce its count by 1
            int head = deque.pollFirst();
            countForEntries.merge(head, -1, Integer::sum);

            //add the next value of the array to the end of the deque and increase its count by 1
            //or set it to 1 if it doesn't exist already in the hashmap (see how the merge method of HashMap works)
            int nextValue = in.nextInt();
            deque.add(nextValue);
            countForEntries.merge(nextValue, 1, Integer::sum);

            //if the count has been reduced to 0 then its no longer part of the current set to remove it
            if (countForEntries.get(head) == 0) countForEntries.remove(head);

            // the number of unique numbers in the current set is given by the size of the hashmap
            // remember if we have the same number twice it still only has ONE key entry in the hashmap
            currentUniqueCount = countForEntries.size();
            // do we have a greater number of unique numbers in this set than any of the previous ones?
            maxUniqueCount = Math.max(currentUniqueCount, maxUniqueCount);

        }

        in.close();

        return maxUniqueCount;
     }
}

//input

//6 3
//5 3 5 2 3 2

//output
//3