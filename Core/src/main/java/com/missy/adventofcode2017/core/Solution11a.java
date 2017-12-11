package com.missy.adventofcode2017.core;

/**
 * A solution to day 11 part 1's puzzle.
 */
class Solution11a extends Solution11 implements PartOne {
    @Override
    protected Integer getResult() {
        // return how many steps away he is now
       return calcSteps(getX(), getY());
    }
}
