package com.code.practise.hackerrankproblems.interview_preparation_kit.string_manipulation.making_anagrams;

public class Solution {

    public static int makeAnagram(String a, String b) {
        // Write your code here
        char[] charArrayOfA = a.toCharArray();
        char[] charArrayOfB = b.toCharArray();

        for(int i =0; i< charArrayOfA.length; i++){
            for(int j=0; j< charArrayOfB.length; j++){
                if(charArrayOfA[i]==charArrayOfB[j]){
                    charArrayOfA[i]=' ';
                    charArrayOfB[j]=' ';
                    break;
                }
            }
        }

        String finalStr = String.valueOf(charArrayOfA)+String.valueOf(charArrayOfB);
        finalStr = finalStr.replaceAll("\\s+", "");

        return finalStr.length();

    }

    public static void main(String[] args) {
        String s1 = "bacdc";
        String s2 = "dcbad";
        System.out.println(makeAnagram(s1, s2));
    }
}
