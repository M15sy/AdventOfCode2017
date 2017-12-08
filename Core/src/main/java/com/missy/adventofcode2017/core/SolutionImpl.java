package com.missy.adventofcode2017.core;

import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * A solution to an <a href="http://adventofcode.com/2017">Advent Of Code 2017</a> puzzle.
 */
abstract class SolutionImpl implements Solution {

    static final String WHITESPACE_SEPARATOR = "\\s+";
    static final String LINE_SEPARATOR = "\\n+";

    /**
     * Returns the puzzle input file's name as a {@link String}.
     * @return the puzzle input file's name as a {@link String}.
     */
    abstract String getInputFileName();

    /**
     * Returns the puzzle input as an {@link InputStream}.
     * @return the puzzle input as an {@link InputStream}.
     */
    InputStream getInputAsStream() {
        return getClass().getClassLoader().getResourceAsStream(getInputFileName());
    }

    /**
     * Returns the puzzle input as a {@link String}.
     * @return the puzzle input as a {@link String}.
     * @throws IOException if an IO error occurs.
     */
    String getInputAsString() throws IOException {
        try {
            return IOUtils.toString(getInputAsStream(), Charset.defaultCharset());
        } catch (final IOException e) {
            throw new IOException("Failed to read file: " + getInputFileName(), e);
        }
    }

    /**
     * Returns the puzzle input as a {@link List} of {@link Integer}.
     * @param separator the separator to use.
     * @return the puzzle input as a {@link List} of {@link Integer}.
     * @throws IOException if an IO error occurs.
     */
    List<String> getInputAsListOfString(final String separator) throws IOException {
        return Arrays.asList(getInputAsString().split(separator));
    }

    /**
     * Returns the puzzle input as a {@link List} of {@link Integer}.
     * @param separator the separator to use.
     * @return the puzzle input as a {@link List} of {@link Integer}.
     * @throws IOException if an IO error occurs.
     */
    List<Integer> getInputAsListOfInteger(final String separator) throws IOException {
        return Arrays.stream(getInputAsString().split(separator))
                .mapToInt(Integer::parseInt)
                .boxed()
                .collect(Collectors.toList());
    }
}