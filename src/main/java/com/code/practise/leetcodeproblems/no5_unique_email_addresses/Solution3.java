package com.code.practise.leetcodeproblems.no5_unique_email_addresses;

import java.util.HashSet;
import java.util.Set;

public class Solution3 {
    public static int numUniqueEmails(String[] emails) {
        // we can use a hashset instead of two lists. cz has set store unique values
        Set<String> list = new HashSet<>();
        for(String email : emails) {
            String[] emailArray = email.split("@");
            emailArray[0] = emailArray[0].replace(".", "");
            if(emailArray[0].contains("+")){
                int end = emailArray[0].indexOf("+");
                emailArray[0] = emailArray[0].substring(0, end);
            }
            email = emailArray[0] + "@" + emailArray[1];
            list.add(email);
        }
        return list.size();
    }


    public static void main(String[] args) {
//        int num = numUniqueEmails(new String[]{"test.email+alex@leetcode.com","test.e.mail+bob.cathy@leetcode.com","testemail+david@lee.tcode.com"});
        int num = numUniqueEmails(new String[]{"linqmafia@leet+code.com","linqmafia@code.com"});
        System.out.println(num);
    }
}
