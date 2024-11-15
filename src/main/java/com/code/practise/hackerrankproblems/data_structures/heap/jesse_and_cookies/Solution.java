package com.code.practise.hackerrankproblems.data_structures.heap.jesse_and_cookies;

import java.util.ArrayList;
import java.util.List;

/**
 * We are going to solve this problem using a min heap. Firstly, we add all the elements in the list to a min heap.
 * This has time complexity of O(nlog(n))
 * Then after that we are going to iterate through our heap. If the root’s value is less than
 * , we pop() it and the one after it, mix them together using the formula above, and insert the new cookie back into the min heap then increment count. We keep doing this until the root has a value greater or equal to
 *  or there’s one item left in the heap. If there’s one item left and it’s less than
 *  we return
 * . Here is the code:
 */
public class Solution {

    private static List<Integer> itemList;

    public int noOfIterationsRequired(int k, List<Integer> cookieList){
        itemList = new ArrayList<>();
        int count = 0;
        for(Integer cookie : cookieList){
            insertIntoHeap(cookie);
        }

        while(peek() < k && itemList.size() > 1){
            insertIntoHeap(pop() + 2 * pop());
            count++;
        }

        if (peek() < k){
            count = -1;
        }

        return count;
    }

    private static void insertIntoHeap(Integer cookie) {
        itemList.add(cookie);
        bubbleUp();
    }

    /**
     * This method check and make sure the parent value of each node is less than its value
     * in each nodes
     */
    private static void bubbleUp() {
        int i = itemList.size() - 1;
        while(i > 0){
            int parentIndex = getParentIndex(i);
            if(itemList.get(i) < itemList.get(parentIndex)){
                swap(i, parentIndex);
                i = parentIndex;
            }else{
                break;
            }
        }
    }

    /**
     *
     */
    private static void bubbleDown(){
       int i = 0;
       while(true){
           int leftChildIndex = getLeftChildIndex(i);
           int rightChildIndex = getRightChildIndex(i);
           int min = i;

           if (leftChildIndex < itemList.size() && itemList.get(min) > itemList.get(leftChildIndex)){
               min = leftChildIndex;
           }

           if (rightChildIndex < itemList.size() && itemList.get(min) > itemList.get(rightChildIndex)){
               min = rightChildIndex;
           }

           if(min == i){
               break;
           }

           swap(i, min);
           i=min;
       }
    }

    private static int pop(){
        int val = itemList.get(0);
        int i = itemList.size() - 1;
        itemList.set(0, itemList.get(i)); //replace the oth index of the list with value in i'th index
        itemList.remove(i);// remove the value at i'th index
        bubbleDown();
        return val;
    }

    /**
     *
     * @param i - the index of a particular node
     * @return - parent index of the given node
     */
    private static int getParentIndex(int i){
        return ( i - 1 ) / 2;
    }

    /**
     *
     * @param i - the index of a particular node
     * @return - Index of the left-child of the given node
     */
    private static int getLeftChildIndex(int i){
        return ( 2 * i ) + 1;
    }

    /**
     *
     * @param i - the index of a particular node
     * @return - Index of the right-child of the given node
     */
    private static int getRightChildIndex(int i){
        return ( 2 * i ) + 2;
    }

    /**
     * This method is to swap the values of index-x and index-y
     * @param x this is an index of the arrayList
     * @param y this is an index of the arrayList
     */
    private static void swap(int x, int y){
        Integer temp = itemList.get(x);
        itemList.set(x, itemList.get(y));
        itemList.set(y, temp);
    }

    /**
     * This method will return the 1st element of the array
     * @return
     */
    private static int peek(){
        return itemList.get(0);
    }
}
