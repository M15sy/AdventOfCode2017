package com.missy.adventofcode2017.core;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.function.BiFunction;

/**
 * A solution to day 4's puzzle.
 */
abstract class Solution04 extends SolutionImpl {

    /**
     * Returns a function that takes two words as input parameters and returns true if
     * they are not to be used within the same password.
     * @return a function that compares two words and returns true if they are not to
     * be used within the same password.
     */
    abstract BiFunction<String, String, Boolean> getComparator();

    @Override
    public String getQuestionName() {
        return "Day 4: High-Entropy Passphrases";
    }

    @Override
    String getInputFileName() {
        return "Day04.txt";
    }

    @Override
    public String solve() throws IOException {
        Integer count = 0;
        try (BufferedReader br = new BufferedReader(new InputStreamReader(getInputAsStream()))) {
            // for each password
            String password;
            while ((password = br.readLine()) != null) {
                if (isValidPassword(password)) {
                    // if it's valid increment the counter
                    count++;
                }
            }
        }
        return count.toString();
    }

    /**
     * Returns a value that specifies whether a given password is valid.
     * @param password the password to validate.
     * @return a value that specifies whether a given password is valid.
     */
    private boolean isValidPassword(final String password) {
        // for each word in the password
        final List<String> words = List.of(password.split(WHITESPACE_SEPARATOR));
        for (int i = 0; i < words.size(); i++) {
            final String word = words.get(i);
            // compare it to the other words
            for (int j = i + 1; j < words.size(); j++) {
                final String otherWord = words.get(j);
                if (getComparator().apply(word, otherWord)) {
                    return false;
                }
            }
        }
        return true;
    }
}
