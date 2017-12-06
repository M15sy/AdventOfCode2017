package com.missy.adventofcode2017.core;

import java.util.List;

/**
 * A solution to day 6 part 1's puzzle.
 */
class Solution06b extends Solution06 implements PartTwo {
    @Override
    Integer calcResult(final List<String> snapshots, final String input) {
        return snapshots.size() - snapshots.indexOf(input);
    }
}
