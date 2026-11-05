package com.lab.strings;

public class UniqueStringChecker {

    public boolean hasAllUniqueCharacters(String text) {
        // Guardrail in case an empty or null string is passed
        if (text == null) {
            throw new IllegalArgumentException("Input text cannot be null");
        }

        // Strings with more characters than available ASCII characater exists will inevitably have at least one repeat
        if (text.length() > 128) {
            return false;
        }

        // Strings with exactly 1 character will always be unique
        if (text.length() <= 1) {
            return true;
        }

        // Make a boolean list to keep track of repeats
        boolean [] seenCharacters = new boolean[128];

        // Loop the string 
        // Update seenCharacters
        // If a character is in the boolean then a repeat was found and return false
        // Otherwise, return true
        for (int i = 0; i < text.length(); i++) {
            char currentChar = text.charAt(i);
            if (seenCharacters[currentChar]) {
                return false;
            }
            seenCharacters[currentChar] = true;
        }
        return true;
    }
}