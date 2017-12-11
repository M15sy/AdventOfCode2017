package com.missy.adventofcode2017.core;

/**
 * A solution to day 8 part 2's puzzle.
 */
class Solution08b extends Solution08 implements PartTwo {
    @Override
    Integer getResult() {
        // return the highest value to have been in any register
        return getMaxValue();
    }
}
