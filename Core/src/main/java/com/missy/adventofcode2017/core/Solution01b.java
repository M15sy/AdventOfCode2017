package com.missy.adventofcode2017.core;

/**
 * A solution to day 1 part 2's puzzle.
 */
class Solution01b extends Solution01 implements PartTwo {
    @Override
    int getIncrement() {
        return getInputSize() / 2;
    }
}
