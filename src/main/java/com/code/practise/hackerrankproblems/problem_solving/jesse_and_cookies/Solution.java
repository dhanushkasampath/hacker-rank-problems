package com.code.practise.hackerrankproblems.problem_solving.jesse_and_cookies;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Solution {
    public static int cookies(int k, List<Integer> A) {
        // Write your code here
        int noOfOperations = 0;
        Collections.sort(A);//sort the numbers in ascending order
        List<Integer> cookieList = new ArrayList<>(A);
        while (!cookieList.isEmpty()) {
            if(isListElementsAreGreaterThanGivenValue(cookieList, k)){
                return noOfOperations;
            }
            if (cookieList.size() <= 2) {
                return -1;
            }
            Collections.sort(cookieList);
            int sweetness = getSweetness(cookieList.get(0), cookieList.get(1));// get the least small numbers
            cookieList.set(1, sweetness);//replace the 2nd element with new value
            cookieList.remove(0);//remove the first element
            noOfOperations++;
        }
        return -1;
    }

    private static int getSweetness(int firstLeastSweetCookie,
                                    int secondLeastSweetCookie ){
        return firstLeastSweetCookie + 2*secondLeastSweetCookie;
    }

    //this function checks whether all the elements in the list are greater than or equal to given value.
    // returns true or false
    private static boolean isListElementsAreGreaterThanGivenValue(
            List<Integer> list, int val){

        List<Integer> elementsLessThanGivenValue =
                list.stream()
                        .filter(element -> element < val)
                        .toList();

        return elementsLessThanGivenValue.isEmpty();

    }

    public static void main(String[] args) throws IOException {
        int operationCount = cookies(7, Arrays.asList(1, 2, 3, 9, 10, 12));
//        int operationCount = cookies(10, Arrays.asList(1, 1, 1));
//        int operationCount = cookies(200, Arrays.asList(5, 6, 7));
//        int operationCount = cookies(8467293, Arrays.asList(13, 47, 74, 12, 89, 74, 18, 38));
        System.out.println(operationCount);
    }

}
