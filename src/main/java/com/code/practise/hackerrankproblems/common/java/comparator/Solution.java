package com.code.practise.hackerrankproblems.common.java.comparator;

import java.util.Arrays;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();

        Player[] player = new Player[n];
        Checker checker = new Checker();

        // create new players at the same time of getting user inputs
        for(int i = 0; i < n; i++){
            player[i] = new Player(scan.next(), scan.nextInt());
        }
        scan.close();

        //sort the player array by passing a comparator object
        Arrays.sort(player, checker);

        // just print the elements in the player array
        for(int i = 0; i < player.length; i++){
            System.out.printf("%s %s\n", player[i].name, player[i].score);
        }
    }
}

//input

//5
//amy 100
//david 100
//heraldo 50
//aakansha 75
//aleksa 150

//output
//aleksa 150
//amy 100
//david 100
//aakansha 75
//heraldo 50