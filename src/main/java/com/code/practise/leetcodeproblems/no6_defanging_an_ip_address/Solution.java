package com.code.practise.leetcodeproblems.no6_defanging_an_ip_address;

public class Solution {
    public static String defangIpAddr(String address) {
        return address.replace(".", "[.]");
    }

    public static void main(String[] args) {
        System.out.println(defangIpAddr("1.1.1.1"));
        System.out.println(defangIpAddr("255.100.50.0"));
    }
}
