package com.code.practise.hackerrankproblems.interviews;

import java.util.*;

public class Test {
    public static void main(String[] args) {
//        String a = newPassword("1234", "567");
//        System.out.println(a);

        List<String> words = Arrays.asList("the", "bats", "tabs", "in", "cat", "act");
        List<String> sentences = Arrays.asList("cat the bats", "in the act", "act tabs in");
        List<Long> num = countSentences(words, sentences);
        System.out.println(num);
    }

    public static List<Long> countSentences(List<String> wordSet, List<String> sentences) {

        List<Long> sentenceCountList = new ArrayList<>();

        for(String sentence : sentences){
            long count = countValidSentences(sentence, new HashSet<>(wordSet));
            sentenceCountList.add(count);
        }
        return sentenceCountList;
    }


    private static int countValidSentences(String sentence, Set<String> words) {
        String[] sentenceWords = sentence.split(" ");
        List<List<String>> anagramsList = new ArrayList<>();

        // forming anagrams for each word in the sentence
        for (String word : sentenceWords) {
            List<String> anagrams = buildAnagrams(word, words);
            anagramsList.add(anagrams);
        }

        // forming all possible valid sentences from the anagrams
        Set<String> validSentences = new HashSet<>();
        formSentences(anagramsList, new ArrayList<>(), validSentences, 0);

        return validSentences.size();
    }

    private static void formSentences(List<List<String>> anagramsList, List<String> current, Set<String> validSentences, int index) {
        if (index == anagramsList.size()) {
            validSentences.add(String.join(" ", current));
            return;
        }

        for (String word : anagramsList.get(index)) {
            current.add(word);
            formSentences(anagramsList, current, validSentences, index + 1);
            current.remove(current.size() - 1);
        }
    }

    private static void swapCharacters(char[] array, int i, int j) {
        char tempCharacter = array[i];
        array[i] = array[j];
        array[j] = tempCharacter;
    }

    private static List<String> buildAnagrams(String word, Set<String> words) {
        List<String> anagrams = new ArrayList<>();
        anagramsBuilder(word.toCharArray(), 0, anagrams, words);
        return anagrams;
    }

    private static void anagramsBuilder(char[] charArray, int index, List<String> anagramsList, Set<String> words) {
        if (index == charArray.length) {
            String candidate = new String(charArray);
            if (words.contains(candidate)) {
                anagramsList.add(candidate);
            }
            return;
        }

        Set<Character> characterSet = new HashSet<>();
        for (int i = index; i < charArray.length; i++) {
            if (characterSet.add(charArray[i])) {
                swapCharacters(charArray, i, index);
                anagramsBuilder(charArray, index + 1, anagramsList, words);
                swapCharacters(charArray, i, index);
            }
        }
    }



















    public static String newPassword(String a, String b) {

        int lengthOfA = a.length();
        int lengthOfB = b.length();

        int maximumLength = Math.max(lengthOfA, lengthOfB);
        StringBuilder newPassword = new StringBuilder();

        for (int i=0; i < maximumLength; i++){
            if (i < lengthOfA) {
                newPassword.append(a.charAt(i));
            }

            if (i < lengthOfB) {
                newPassword.append(b.charAt(i));
            }
        }
        return newPassword.toString();
    }
}
