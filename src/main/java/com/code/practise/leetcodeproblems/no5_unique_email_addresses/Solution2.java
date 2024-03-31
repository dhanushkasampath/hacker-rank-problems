package com.code.practise.leetcodeproblems.no5_unique_email_addresses;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Solution2 {
    public static int numUniqueEmails(String[] emails) {
        List<String> list = new ArrayList<>();
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
        // get the unique strings from a string list
        List<String> uniqueList =  list.stream().distinct().toList();

        return uniqueList.size();
    }


    public static void main(String[] args) {
//        int num = numUniqueEmails(new String[]{"test.email+alex@leetcode.com","test.e.mail+bob.cathy@leetcode.com","testemail+david@lee.tcode.com"});
        int num = numUniqueEmails(new String[]{"linqmafia@leet+code.com","linqmafia@code.com"});
        System.out.println(num);
    }
}
