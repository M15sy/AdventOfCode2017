package com.missy.adventofcode2017.core;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * A solution to day 12's puzzle.
 */
abstract class Solution12 extends SolutionImpl {

    @Override
    public String getQuestionName() {
        return "Day 12: Digital Plumber";
    }

    @Override
    String getInputFileName() {
        return "Day12.txt";
    }

    /**
     * Reads input as a {@link Map} of program and it's connected programs.
     * @return the input as a {@link Map}.
     * @throws IOException if an IO error occurs.
     */
    protected Map<Integer, List<Integer>> readInput() throws IOException {
        return getInputAsListOfString("\\r\\n").stream()
                .collect(Collectors.toMap(
                        s -> Integer.parseInt(s.split(" <-> ")[0]),
                        s -> Arrays.stream(s.split(" <-> ")[1].split(", "))
                                .mapToInt(Integer::parseInt)
                                .boxed()
                                .collect(Collectors.toList())));
    }

    /**
     * Finds the group of a given program.
     * @param program the program.
     * @param group the group.
     * @param input the input.
     * @return the group.
     */
    protected List<Integer> findGroup(final Integer program, final List<Integer> group, final Map<Integer, List<Integer>> input) {
        if (!group.contains(program)) {
            final List<Integer> connectedPrograms = input.get(program);
            input.remove(program);
            group.add(program);
            for (Integer p : connectedPrograms) {
                findGroup(p, group, input);
            }
        }
        return group;
    }
}
