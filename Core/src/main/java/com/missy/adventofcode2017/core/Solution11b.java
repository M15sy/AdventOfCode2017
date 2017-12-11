package com.missy.adventofcode2017.core;

/**
 * A solution to day 11 part 2's puzzle.
 */
class Solution11b extends Solution11 implements PartTwo {
    @Override
    protected Integer getResult() {
        // return the furthest no. of steps he got
        return getMax();
    }
}
