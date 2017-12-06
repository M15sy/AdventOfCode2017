package com.missy.adventofcode2017.core;

import com.codepoetics.protonpack.Indexed;
import com.codepoetics.protonpack.StreamUtils;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

/**
 * A solution to day 1's puzzle.
 */
abstract class Solution01 extends SolutionImpl {

    private int inputSize;

    /**
     * Returns the increment.
     * @return the increment.
     */
    abstract int getIncrement();

    /**
     * Returns the size of the input.
     * @return the size of the input.
     */
    int getInputSize() {
        return inputSize;
    }

    @Override
    public String getQuestionName() {
        return "Day 1: Inverse Captcha";
    }

    @Override
    String getInputFileName() {
        return "Day01.txt";
    }

    @Override
    public String solve() throws IOException {
        final List<Integer> input = getInputAsString().chars()
                .mapToObj(i -> Integer.parseInt(String.valueOf((char) i)))
                .collect(Collectors.toList());

        inputSize = input.size();

        final Integer result = StreamUtils
                .zipWithIndex(input.stream())
                .filter(i -> {
                    final int proposedIndex = (int) i.getIndex() + getIncrement();
                    final int index = proposedIndex < input.size() ? proposedIndex : proposedIndex - input.size();
                    return i.getValue() == input.get(index);
                })
                .mapToInt(Indexed::getValue)
                .sum();

        return result.toString();
    }
}
