package com.code.practise.hackerrankproblems.data_structures.queues.java_dequeue;

import java.util.*;
import java.util.stream.Collectors;

/**
 * This was my solution. It was not the best way. cz I have used lots of objects and streams.
 * This question is intended to use Dequeue
 */
public class MySolution {

     public static void main(String[] args) {
         Scanner in = new Scanner(System.in);
         Deque deque = new ArrayDeque<>();
         int n = in.nextInt();
         int m = in.nextInt();

         for (int i = 0; i < n; i++) {
             int num = in.nextInt();
             deque.addLast(num);
         }

         int noOfSubsets = n-m+1;

         List<List<Integer>> subArrayList = new ArrayList<>();

         while(noOfSubsets-- > 0){
             List<Integer> list = new ArrayList<>();
             list.add((Integer)deque.removeFirst());
             int temp = (Integer)deque.removeFirst();
             list.add(temp);
             list.add((Integer)deque.peekFirst());
             deque.addFirst(temp);
             subArrayList.add(list);
         }

         // System.out.println(subArrayList);

         List<Integer> uniqueNumberList = subArrayList.stream().map(list -> noOfUniqueNumbers(list)).collect(Collectors.toList());

         // System.out.println(uniqueNumberList);
         //now we have to get the maximum number out of above
         Optional<Integer> maxNumber = uniqueNumberList.stream().max(Comparator.naturalOrder());

         maxNumber.ifPresent(max -> System.out.println(max));
     }


    private static int noOfUniqueNumbers(List<Integer> list){
        // Use a HashSet to store unique elements
        Set<Integer> uniqueNumbers = new HashSet<>(list);
        // The size of the HashSet is the count of unique numbers
        return uniqueNumbers.size();
    }
}
//
//input
//
//6 3
//5 3 5 2 3 2
//
//output
//3
