package com.code.practise.hackerrankproblems.data_structures.trie;

import java.util.Arrays;
import java.util.List;

import static com.code.practise.hackerrankproblems.data_structures.trie.TrieNode.ALPHABET_SIZE;

public class Implementation {

    // Method to insert a key into the Trie
    static void insertKey(TrieNode root, String key) {

        // Initialize the curr pointer with the root node
        TrieNode curr = root;

        // Iterate across the length of the string
        for (char c : key.toCharArray()) {

            // Check if the node exists for the current character in the Trie
            if (curr.children[c - 'a'] == null) {

                // If node for current character does not exist then make a new node
                TrieNode newNode = new TrieNode();

                // Keep the reference for the newly created node. This means assigning a value to the particular index of the array
                curr.children[c - 'a'] = newNode;
            }

            // Move the curr pointer to the newly created node
            curr = curr.children[c - 'a'];
        }

        // Mark the end of the word
        curr.isEndOfWord = true;
    }

    // Method to search a key in the Trie
    static boolean searchKey(TrieNode root, String key) {

        // Initialize the curr pointer with the root node
        TrieNode curr = root;

        // Iterate across the length of the string
        for (char c : key.toCharArray()) {
            /**
             * Check if the node exists for the current character in the Trie
             * here the difference is an int between 0 and 26. The size of the array that we have created is also 26
             */
            if (curr.children[c - 'a'] == null)
                return false;

            // Move the curr pointer to the already existing node for the current character
            curr = curr.children[c - 'a'];
        }

        // Return true if the word exists and is marked as ending
        return curr.isEndOfWord;
    }

    // Returns true if root has no children, else false
    static boolean isEmpty(TrieNode root)
    {
        for (int i = 0; i < ALPHABET_SIZE; i++)
            if (root.children[i] != null)
                return false;
        return true;
    }

    // Recursive function to delete a key from given Trie
    static TrieNode remove(TrieNode root, String key, int depth)
    {
        // If tree is empty
        if (root == null)
            return null;

        // If last character of key is being processed
        if (depth == key.length()) {

            // This node is no more end of word after
            // removal of given key
            if (root.isEndOfWord)
                root.isEndOfWord = false;

            // If given is not prefix of any other word
            if (isEmpty(root)) {
                root = null;
            }

            return root;
        }

        // If not last character, recur for the child
        // obtained using ASCII value
        int index = key.charAt(depth) - 'a';
        root.children[index] =
                remove(root.children[index], key, depth + 1);

        // If root does not have any child (its only child got
        // deleted), and it is not end of another word.
        if (isEmpty(root) && root.isEndOfWord == false){
            root = null;
        }

        return root;
    }

    public static void main(String[] args) {

        // Create an example Trie
        TrieNode root = new TrieNode();
        List<String> arr = Arrays.asList(
                "and", "ant", "do", "geek", "dad", "ball");
        for (String s : arr) {
            insertKey(root, s);
        }

        // One by one search strings
        List<String> searchKeys =
                Arrays.asList("do", "gee", "bat");
        for (String s : searchKeys) {
            System.out.println("Key : " + s);
            if (searchKey(root, s))
                System.out.println("Present");
            else
                System.out.println("Not Present");
        }

        System.out.println("Does 'geek' present: " + searchKey(root, "geek"));
        remove(root, "geek", 0);
        System.out.println("Does 'geek' present: " + searchKey(root, "geek"));
    }

}
