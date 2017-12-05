package com.missy.adventofcode2017.core;

/**
 * A solution to day 5 part 2's puzzle.
 */
class Solution05b extends Solution05 {

    @Override
    public String getQuestionName() {
        return "Day 5: A Maze of Twisty Trampolines, All Alike --- Part Two ---";
    }

    @Override
    int newOffset(final int offset) {
        return offset >= 3 ? offset - 1 : offset + 1;
    }
}
