package com.code.practise.hackerrankproblems.data_structures.trie;

public class TrieNode {

    static int ALPHABET_SIZE = 26;
    // Java Makes sure that all 26 are null
    TrieNode[] children = new TrieNode[ALPHABET_SIZE];

    // for end of word
    boolean isEndOfWord = false;
}
