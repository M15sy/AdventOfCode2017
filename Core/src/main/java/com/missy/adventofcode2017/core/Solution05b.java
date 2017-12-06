package com.missy.adventofcode2017.core;

/**
 * A solution to day 5 part 2's puzzle.
 */
class Solution05b extends Solution05 implements PartTwo {
    @Override
    int newOffset(final int offset) {
        return offset >= 3 ? offset - 1 : offset + 1;
    }
}
