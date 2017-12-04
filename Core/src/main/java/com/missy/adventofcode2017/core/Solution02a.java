package com.missy.adventofcode2017.core;

import java.util.List;

/**
 * A solution to day 2 part 1's puzzle.
 */
class Solution02a extends Solution02 {

    @Override
    public String getQuestionName() {
        return "Day 2: Corruption Checksum --- Part One ---";
    }

    @Override
    Integer calculateRow(final List<Integer> row) {
        Integer min = Integer.MAX_VALUE;
        Integer max = Integer.MIN_VALUE;
        for (int i = 0; i < row.size(); i++) {
            final int it = row.get(i);
            if (it > max) {
                max = it;
            }
            if (it < min) {
                min = it;
            }
        }
        // return the range of the row
        return max - min;
    }
}
