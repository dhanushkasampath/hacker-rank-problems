package com.code.practise.hackerrankproblems.common.java.comparator;

import java.util.Comparator;

class Checker implements Comparator<Player> {

    @Override
    public int compare(Player p1, Player p2) {
        int n = Integer.compare(p2.score, p1.score);
        return n == 0 ? p1.name.compareTo(p2.name) : n;//String class has inbuilt compareTo method
    }
    // here n = 0 means scores of both are equal
}