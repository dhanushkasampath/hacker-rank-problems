package com.code.practise.hackerrankproblems.common.java.strings.regex.valid_ips;

import java.util.Scanner;

public class Solution {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        while(in.hasNext()){
            String ipAddress = in.next();
            System.out.println(ipAddress.matches(MyRegex.pattern));
        }
    }
}
