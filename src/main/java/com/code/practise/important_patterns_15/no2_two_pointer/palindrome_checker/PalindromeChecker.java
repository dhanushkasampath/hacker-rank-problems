package com.code.practise.important_patterns_15.no2_two_pointer.palindrome_checker;

public class PalindromeChecker {
    public static boolean isPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return true; // Empty or null string is considered a palindrome
        }

        // Convert the string to lowercase and remove non-alphanumeric characters
        s = s.toLowerCase().replaceAll("[^a-z0-9]", "");

        // Initialize two pointers. Actually these are index values
        int left = 0;
        int right = s.length() - 1; //due to 0 base index

        while (left < right) {
            // Check if characters at the two pointers are equal
            if (s.charAt(left) != s.charAt(right)) {
                return false; // Not a palindrome
            }
            left++;  // Move the left pointer forward
            right--; // Move the right pointer backward
        }

        return true; // The string is a palindrome
    }

    public static void main(String[] args) {
        String input = "A man, a plan, a canal: Panama"; // Example input
        System.out.println("Is the string a palindrome? " + isPalindrome(input));
    }
}
