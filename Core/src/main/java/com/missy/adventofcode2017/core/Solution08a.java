package com.missy.adventofcode2017.core;

import java.util.Collections;
import java.util.Comparator;
import java.util.Map;

/**
 * A solution to day 8 part 1's puzzle.
 */
class Solution08a extends Solution08 implements PartOne {
    @Override
    Integer getResult() {
        // return the highest value in any register after completion
        return Collections.max(getRegisters().entrySet(), Comparator.comparingInt(Map.Entry::getValue)).getValue();
    }
}
