package com.missy.adventofcode2017.core;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * A solution to day 12 part 2's puzzle.
 */
class Solution12b extends Solution12 implements PartTwo {
    @Override
    public String solve() throws IOException {
        final Map<Integer, List<Integer>> input = readInput();

        Integer count = 0;
        while (input.size() != 0) {
            // get first key in input and find it's group
            final Integer key = Integer.parseInt(input.keySet().toArray()[0].toString());
            findGroup(key, new ArrayList<>(), input);
            count++;
        }

        // return the total no. of groups
        return count.toString();
    }
}
