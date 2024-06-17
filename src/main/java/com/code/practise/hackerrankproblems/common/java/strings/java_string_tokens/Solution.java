package com.code.practise.hackerrankproblems.common.java.strings.java_string_tokens;

import java.util.Scanner;

/**
 * This answer got accepted
 */
public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String inputString = sc.nextLine();
        String[] arr = inputString.trim().split("[!,?._'@ ]+");

        if(arr.length == 1 && arr[0].isEmpty()){
            System.out.println(0);
        } else {
            System.out.println(arr.length);
        }
        for(String s : arr){
            System.out.println(s);
        }
    }
}
