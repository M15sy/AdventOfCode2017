package com.missy.adventofcode2017.core;

import java.util.List;

/**
 * A solution manager.
 */
public final class SolutionManager {

    private static List<Solution> solutions = List.of(
            new Solution01a(),
            new Solution01b(),
            new Solution02a(),
            new Solution02b(),
            new Solution03a(),
            new Solution03b(),
            new Solution04a(),
            new Solution04b(),
            new Solution05a(),
            new Solution05b(),
            new Solution06a(),
            new Solution06b(),
//            new Solution07a(),
//            new Solution07b(),
            new Solution08a(),
            new Solution08b(),
            new Solution09a(),
            new Solution09b(),
            new Solution10a(),
            new Solution10b(),
            new Solution11a(),
            new Solution11b()
    );

    /**
     * Private ctor - class should not be instantiated.
     */
    private SolutionManager() {
    }

    /**
     * Returns a {@link List} of all the {@link Solution}s.
     * @return a {@link List} of all the {@link Solution}s.
     */
    public static List<Solution> getAllSolutions() {
        return solutions;
    }
}
