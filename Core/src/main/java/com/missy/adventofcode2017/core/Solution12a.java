package com.missy.adventofcode2017.core;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * A solution to day 12 part 2's puzzle.
 */
class Solution12a extends Solution12 implements PartOne {
    @Override
    public String solve() throws IOException {
        final List<Integer> group = findGroup(0, new ArrayList<>(), readInput());

        // return the no. of programs in the same group as zero
        return ((Integer) group.size()).toString();
    }
}
