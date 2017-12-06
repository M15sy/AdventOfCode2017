package com.missy.adventofcode2017.core;

import java.util.function.BiFunction;

/**
 * A solution to day 4 part 1's puzzle.
 */
class Solution04a extends Solution04 implements PartOne {
    @Override
    BiFunction<String, String, Boolean> getComparator() {
        return String::equalsIgnoreCase;
    }
}
