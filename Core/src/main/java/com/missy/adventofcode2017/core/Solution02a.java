package com.missy.adventofcode2017.core;

import java.util.Collections;
import java.util.List;

/**
 * A solution to day 2 part 1's puzzle.
 */
class Solution02a extends Solution02 implements PartOne {
    @Override
    Integer calculateRow(final List<Integer> row) {
        return Collections.max(row) - Collections.min(row);
    }
}
