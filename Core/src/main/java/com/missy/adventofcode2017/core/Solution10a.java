package com.missy.adventofcode2017.core;

import java.io.IOException;
import java.util.List;

/**
 * A solution to day 10 part 1's puzzle.
 */
class Solution10a extends Solution10 implements PartOne {
    @Override
    public String solve() throws IOException {
        final List<Integer> input = getInputAsListOfInteger(COMMA_SEPARATOR);

        final List<Integer> sparseHash = knotHash(input);

        final Integer result = sparseHash.get(0) * sparseHash.get(1);
        return result.toString();
    }
}
