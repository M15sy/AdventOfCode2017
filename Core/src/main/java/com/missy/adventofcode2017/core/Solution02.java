package com.missy.adventofcode2017.core;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * A solution to day 2's puzzle.
 */
abstract class Solution02 extends SolutionImpl {

    /**
     * Calculates a value for a row.
     * @param row the row to be calculated.
     * @return the calculated value.
     */
    abstract Integer calculateRow(List<Integer> row);

    @Override
    public String getQuestionName() {
        return "Day 2: Corruption Checksum";
    }

    @Override
    String getInputFileName() {
        return "Day02.txt";
    }

    @Override
    public String solve() throws IOException {
        Integer results = 0;
        // for each row
        try (BufferedReader br = new BufferedReader(new InputStreamReader(getInputAsStream()))) {
            String line;
            while ((line = br.readLine()) != null) {
                final List<Integer> row = Arrays.stream(line.split(WHITESPACE_SEPARATOR))
                        .mapToInt(Integer::parseInt)
                        .boxed()
                        .collect(Collectors.toList());
                // calculate the value and add to results
                results += calculateRow(row);
            }
        }

        return results.toString();
    }
}
