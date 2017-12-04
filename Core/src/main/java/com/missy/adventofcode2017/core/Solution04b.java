package com.missy.adventofcode2017.core;

import java.util.*;
import java.util.function.BiFunction;

/**
 * A solution to day 4 part 2's puzzle.
 */
class Solution04b extends Solution04 {

    @Override
    public String getQuestionName() {
        return "Day 4: High-Entropy Passphrases --- Part Two --- ";
    }

    @Override
    BiFunction<String, String, Boolean> getComparator() {
        return this::isAnagram;
    }

    private boolean isAnagram(final String word, final String otherWord) {
        final char[] word1 = word.toCharArray();
        final char[] word2 = otherWord.toCharArray();
        Map<Character, Integer> lettersInWord1 = new HashMap<>();

        // for each char in word1, add the count to the map
        for (char c : word1) {
            final int count = lettersInWord1.containsKey(c) ? lettersInWord1.get(c) + 1 : 1;
            lettersInWord1.put(c, count);
        }

        // for each char in word2, minus the count from the map
        for (char c : word2) {
            final int count = lettersInWord1.containsKey(c) ? lettersInWord1.get(c) - 1 : -1;
            lettersInWord1.put(c, count);
        }

        // for each char in the map, check the count is zero
        for (char c : lettersInWord1.keySet()) {
            if (lettersInWord1.get(c) != 0) {
                return false;
            }
        }

        return true;
    }
}
