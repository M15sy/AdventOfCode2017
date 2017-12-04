package com.missy.adventofcode2017.core;

import java.util.function.BiFunction;

/**
 * A solution to day 4 part 1's puzzle.
 */
class Solution04a extends Solution04 {

    @Override
    public String getQuestionName() {
        return "Day 4: High-Entropy Passphrases --- Part One --- ";
    }

    @Override
    BiFunction<String, String, Boolean> getComparator() {
        return String::equalsIgnoreCase;
    }
}
