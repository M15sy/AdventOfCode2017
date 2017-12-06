package com.missy.adventofcode2017.core;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * A solution to day 6's puzzle.
 */
abstract class Solution06 extends SolutionImpl {

    /**
     * Returns the desired calculation from the snapshots.
     * @param snapshots the snapshots.
     * @param input the input.
     * @return the result as an {@link Integer}.
     */
    abstract Integer calcResult(List<String> snapshots, String input);

    @Override
    public String getQuestionName() {
        return "Day 6: Memory Reallocation";
    }

    @Override
    String getInputFileName() {
        return "Day06.txt";
    }

    @Override
    public String solve() throws IOException {
        final List<Integer> input = getInputAsListOfInteger();
        final List<String> snapshots = new ArrayList<>();

        while (!snapshots.contains(input.toString())) {
            snapshots.add(input.toString());
            final int max = Collections.max(input);
            final int indexOfMax = input.indexOf(max);
            int currentIndex = indexOfMax;

            for (int i = 0; i < max; i++) {
                currentIndex = currentIndex + 1 < input.size() ? currentIndex + 1 : 0;
                input.set(indexOfMax, input.get(indexOfMax) - 1);
                input.set(currentIndex, input.get(currentIndex) + 1);
            }
        }

        return calcResult(snapshots, input.toString()).toString();
    }
}
