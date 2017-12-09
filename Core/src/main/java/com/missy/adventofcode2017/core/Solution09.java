package com.missy.adventofcode2017.core;

import java.io.IOException;

/**
 * A solution to day 9's puzzle.
 */
abstract class Solution09 extends SolutionImpl {

    private Integer score = 0;
    private Integer garbageCount = 0;

    /**
     * Returns the final result.
     * @return the final result.
     */
    protected abstract Integer getResult();

    /**
     * Returns the current score.
     * @return the current score.
     */
    protected Integer getScore() {
        return score;
    }

    /**
     * Returns the garbage count.
     * @return the garbage count.
     */
    protected Integer getGarbageCount() {
        return garbageCount;
    }

    @Override
    public String getQuestionName() {
        return "Day 9: Stream Processing";
    }

    @Override
    protected String getInputFileName() {
        return "Day09.txt";
    }

    @Override
    @SuppressWarnings({"ModifiedControlVariable"})
    public String solve() throws IOException {
        final char[] input = getInputAsString().toCharArray();
        int currentGroupScore = 0;
        boolean garbage = false;

        // for each char
        for (int i = 0; i < input.length; i++) {
         final   char ch = input[i];
            if (ch == '!') {
                // if it's a '!' ignore the next char
                i++;
            } else if (ch == '>') {
                // if it's a '>' close garbage
                garbage = false;
            } else {
                if (garbage) {
                    // if it's garbage count it
                    garbageCount++;
                } else {
                    // if it's not garbage
                    switch (ch) {
                        case '{':   // and it's a '{' open group and increment score
                            currentGroupScore++;
                            score += currentGroupScore;
                            break;
                        case '}':   // and it's a '}' close group
                            currentGroupScore--;
                            break;
                        case '<':   // if it's a '<' open garbage
                            garbage = true;
                            break;
                        default:    // do nothing
                            break;
                    }
                }
            }
        }

        return getResult().toString();
    }
}
