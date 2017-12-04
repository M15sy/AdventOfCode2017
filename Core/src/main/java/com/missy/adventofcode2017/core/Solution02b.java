package com.missy.adventofcode2017.core;

import java.util.List;

/**
 * A solution to day 2 part 2's puzzle.
 */
class Solution02b extends Solution02 {

    @Override
    public String getQuestionName() {
        return "Day 2: Corruption Checksum --- Part Two ---";
    }

    @Override
    Integer calculateRow(final List<Integer> row) {
        // for each number
        Integer result = 0;
        for (int i = 0; i < row.size(); i++) {
            final Integer it = row.get(i);
            // compare it to the other numbers
            for (int j = 0; j < row.size(); j++) {
                if (i != j) {
                    final Integer that = row.get(j);
                    if (it % that == 0) {
                        // if they are evenly divisible add it to result
                        result += it / that;
                        break;
                    }
                }
            }
        }
        return result;
    }
}
