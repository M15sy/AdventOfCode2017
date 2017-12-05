package com.missy.adventofcode2017.core;

/**
 * A solution to day 5 part 1's puzzle.
 */
class Solution05a extends Solution05 {

    @Override
    public String getQuestionName() {
        return "Day 5: A Maze of Twisty Trampolines, All Alike --- Part One ---";
    }

    @Override
    int newOffset(final int offset) {
        return offset + 1;
    }
}
