package com.lab.strings;

public class PermutationChecker {

    private static final int ASCII_CHARACTER_LIMIT = 128;

    public boolean isPermutation(String first, String second) {
        // null check
        if (first == null || second == null) {
            throw new IllegalArgumentException("Input strings cannot be null");
        }
        // strings that do not have the same length cannot be permutations of each other
        if (first.length() != second.length()) {
            return false;
        }
        // Array to keep track of character counts
        int [] characterFrequencies = new int[ASCII_CHARACTER_LIMIT];

        // add up all the characters in first string
        for (int i = 0; i < first.length(); i++) {
            char character = first.charAt(i);
            characterFrequencies[character]++;
        }

        // decrement count and verify against second string
        for (int i = 0; i < second.length(); i++) {
            char character = second.charAt(i);
            characterFrequencies[character]--;

            // count below 0 means not Permutation
            if (characterFrequencies[character] < 0) {
                return false;
            }
        }
        return true;
    }
}