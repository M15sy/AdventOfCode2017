package com.missy.adventofcode2017.core;

import java.io.IOException;

/**
 * A solution to day 7 part 1's puzzle.
 */
class Solution07a extends Solution07 implements PartOne {
    @Override
    public String solve() throws IOException {
        readInputToNodes();
        return findRoot().getName();
    }
}
