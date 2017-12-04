package com.missy.adventofcode2017.core;

import java.io.IOException;

/**
 * A solution to an <a href="http://adventofcode.com/2017">Advent Of Code 2017</a> puzzle.
 */
public interface Solution {

    /**
     * Returns the name of the question as a {@link String}.
     * @return the question as a {@link String}.
     */
    String getQuestionName();

    /**
     * Solves the puzzle and returns the answer as a {@link String}
     * @throws IOException if an IO error occurs.
     * @return the answer as a {@link String}.
     */
    String solve() throws IOException;
}