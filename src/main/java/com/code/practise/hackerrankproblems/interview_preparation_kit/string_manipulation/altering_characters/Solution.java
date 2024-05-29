package com.code.practise.hackerrankproblems.interview_preparation_kit.string_manipulation.altering_characters;

public class Solution {

    public static int alternatingCharacters(String s) {
        // Write your code here
        int noOfDeletionsNeeded = 0;

        char[] charArray = s.toCharArray();
        for(int i=0; i< charArray.length-1; i++){
            char current = charArray[i];
            char next = charArray[i+1];

            if(current == next){
                noOfDeletionsNeeded++;
            }
        }

        return noOfDeletionsNeeded;
    }

    public static void main(String[] args) {
        String s1 = "AAAA";
        String s2 = "BBBBB";
        String s3 = "ABABABAB";
        String s4 = "BABABA";
        String s5 = "AAABBB";
        System.out.println(alternatingCharacters(s1));
        System.out.println(alternatingCharacters(s2));
        System.out.println(alternatingCharacters(s3));
        System.out.println(alternatingCharacters(s4));
        System.out.println(alternatingCharacters(s5));
    }
}
