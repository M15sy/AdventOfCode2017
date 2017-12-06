package com.missy.adventofcode2017.core;

import java.util.List;

/**
 * A solution to day 6 part 1's puzzle.
 */
class Solution06a extends Solution06 implements PartOne {
    @Override
    Integer calcResult(final List<String> snapshots, final String input) {
        return snapshots.size();
    }
}
