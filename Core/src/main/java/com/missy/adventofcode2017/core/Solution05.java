package com.missy.adventofcode2017.core;

import java.io.IOException;
import java.util.List;

/**
 * A solution to day 5's puzzle.
 */
abstract class Solution05 extends SolutionImpl {

    /**
     * Returns new offset from a given offset.
     * @param offset the offset.
     * @return the new offset.
     */
    abstract int newOffset(int offset);

    @Override
    String getInputFileName() {
        return "Day05.txt";
    }

    @Override
    public String solve() throws IOException {
        final List<Integer> input = getInputAsListOfInteger();
        Integer steps = 0;
        for (int position = 0; position < input.size() && -1 < position;) {
            steps++;
            final int offset = input.get(position);
            input.set(position, newOffset(offset));
            position += offset;
        }
        return steps.toString();
    }
}

