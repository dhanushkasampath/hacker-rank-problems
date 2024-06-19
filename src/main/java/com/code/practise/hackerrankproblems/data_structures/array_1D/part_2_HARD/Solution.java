package com.code.practise.hackerrankproblems.data_structures.array_1D.part_2_HARD;

import java.util.*;

public class Solution {

    public static boolean canWin(int leap, int[] game, int i) {
        // Return true if you can win the game; otherwise, return false.
        if (i < 0 || game[i] == 1) {
            return false;
        }
        if (i + 1 >= game.length || i + leap >= game.length) {
            return true;
        }
        game[i] = 1;

        return canWin(leap, game, i + leap) ||
                canWin(leap, game, i + 1) ||
                canWin(leap, game, i - 1);
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int q = scan.nextInt();
        while (q-- > 0) {
            int n = scan.nextInt();
            int leap = scan.nextInt();

            int[] game = new int[n];
            for (int i = 0; i < n; i++) {
                game[i] = scan.nextInt();
            }

            System.out.println( (canWin(leap, game, 0)) ? "YES" : "NO" );
        }
        scan.close();
    }
}

/**
 *
 STDIN           Function
 -----           --------
 4               q = 4 (number of queries)
 5 3             game[] size n = 5, leap = 3 (first query)
 0 0 0 0 0       game = [0, 0, 0, 0, 0]
 6 5             game[] size n = 6, leap = 5 (second query)
 0 0 0 1 1 1     . . .
 6 3
 0 0 1 1 1 0
 3 1
 0 1 0

 STOUT
 YES
 YES
 NO
 NO
 *
 */