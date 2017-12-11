package com.missy.adventofcode2017.core;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * A solution to day 10's puzzle.
 */
abstract class Solution10 extends SolutionImpl {

    @Override
    public String getQuestionName() {
        return "Day 10: Knot Hash";
    }

    @Override
    String getInputFileName() {
        return "Day10.txt";
    }

    /**
     * Applies the knot hash algorithm to a given input.
     * @param input the input to be hashed.
     * @return the hashed result.
     */
    protected List<Integer> knotHash(final List<Integer> input) {
        // create the string to be tied into knots
        final Integer[] array = new Integer[256];
        Arrays.setAll(array, i -> i);
        final List<Integer> string = new ArrayList<>();
        Collections.addAll(string, array);

        // for each input
        int position = 0;
        for (int i = 0; i < input.size(); i++) {
            // get the loop
            final int length = input.get(i);
            final List<Integer> loop = new ArrayList<>();
            if (position + length < string.size()) {
                loop.addAll(string.subList(position, position + length));
            } else {
                loop.addAll(string.subList(position, string.size()));
                loop.addAll(string.subList(0, length + position - string.size()));
            }

            // reverse the loop
            Collections.reverse(loop);
            for (int j = 0; j < loop.size(); j++) {
                string.set(position + j < string.size() ? position + j : position + j - string.size(), loop.get(j));
            }

            // increase position
            position += length + i;
            while (string.size() <= position) {
                position -= string.size();
            }
        }

        return string;
    }
}
