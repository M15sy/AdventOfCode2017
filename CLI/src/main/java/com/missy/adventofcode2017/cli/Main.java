package com.missy.adventofcode2017.cli;

import com.missy.adventofcode2017.core.Solution;
import com.missy.adventofcode2017.core.SolutionManager;
import org.apache.commons.lang3.time.StopWatch;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * A CLI interface to output the solutions of the <a href="http://adventofcode.com/2017">Advent Of Code 2017</a> puzzles.
 */
public final class Main {

    /**
     * Private ctor - class should not be instantiated.
     */
    private Main() {
    }

    /**
     * A CLI that will output the solutions of the <a href="http://adventofcode.com/2017">Advent Of Code 2017</a> puzzles.
     * @param args CLI arguments.
     * @throws IOException if an IO error occurs.
     */
    @SuppressWarnings("checkstyle:illegalCatch")
    public static void main(final String[] args) throws IOException {
        final StopWatch stopwatch = new StopWatch();
        final List<Solution> allSolutions = SolutionManager.getAllSolutions();
        for (int i = 0; i < allSolutions.size(); i++) {
            try {
                final Solution s = allSolutions.get(i);
                if (i % 2 == 0) {
                    System.out.println();
                    System.out.println(s.getQuestionName());
                }
                System.out.println(s.getPartName());
                stopwatch.start();
                System.out.println("Answer: " + s.solve());
                stopwatch.stop();
                System.out.println("Time taken: " + stopwatch.getTime(TimeUnit.MILLISECONDS) + " ms");
                stopwatch.reset();
            } catch (final Exception e) {
                e.printStackTrace();
            }
        }
    }
}
