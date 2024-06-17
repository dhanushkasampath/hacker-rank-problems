package com.code.practise.hackerrankproblems.data_structures.stack;

import java.util.*;

class Solution{

    public static void main(String []argh)
    {
        Scanner sc = new Scanner(System.in);

        while (sc.hasNext()) {
            String input=sc.next();
            //Complete the code
            System.out.println(isBalanced(input));
        }

    }

    private static boolean isBalanced(String input){
        // Stack to hold opening brackets
        Stack<Character> stack = new Stack<>();

        // Iterate through each character in the string
        for (char ch : input.toCharArray()) {
            // If it's an opening bracket, push it onto the stack
            if (ch == '(' || ch == '{' || ch == '[') {
                stack.push(ch);
            }
            // If it's a closing bracket, check for balance
            else if (ch == ')' || ch == '}' || ch == ']') {
                // If stack is empty or top of stack doesn't match, it's unbalanced
                if (stack.isEmpty()) {
                    return false;
                }
                char top = stack.pop();
                if (!isMatchingPair(top, ch)) {
                    return false;
                }
            }
        }

        // If stack is empty at the end, all brackets were balanced
        return stack.isEmpty();
    }

    // Helper method to check if the pair of brackets match
    private static boolean isMatchingPair(char open, char close) {
        return (open == '(' && close == ')') ||
                (open == '{' && close == '}') ||
                (open == '[' && close == ']');
    }
}

//
//input
//
//{}()
//({()})
//{}(
//[]
//
//output
//
//true
//true
//false
//true

