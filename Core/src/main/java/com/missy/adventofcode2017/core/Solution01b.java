package com.missy.adventofcode2017.core;

/**
 * A solution to day 1 part 2's puzzle.
 */
class Solution01b extends Solution01 {

    @Override
    public String getQuestionName() {
        return "Day 1: Inverse Captcha --- Part Two ---";
    }

    @Override
    int getIncrement() {
        return getInputSize() / 2;
    }
}
