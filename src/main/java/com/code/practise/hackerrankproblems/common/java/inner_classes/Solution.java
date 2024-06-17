package com.code.practise.hackerrankproblems.common.java.inner_classes;

public class Solution {

    static class Inner{
        private class Private{
            private String powerOf2(int num){
                return ((num&num-1)==0)?"a power of 2":"not a power of 2";
            }
        }
    }//end of Inner class

    public static void main(String[] args) throws Exception {

        int num = 4;
        Object o;// Must be used to hold the reference of the instance of the class Solution.Inner.Private

        //Write your code here
        Inner x = new Inner();
        o = x.new Private();
        Inner.Private y = (Inner.Private) o;
        System.out.println(num+" is "+ y.powerOf2(num));
        System.out.println("An instance of class: " + o.getClass().getCanonicalName() + " has been created");

    }//end of main
}
