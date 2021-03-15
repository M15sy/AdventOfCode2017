package com.missy.adventofcode2017.core;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

/**
 * A solution to day 13's puzzle.
 */
abstract class Solution13 extends SolutionImpl {
    @Override
    public String getQuestionName() {
        return "Day 13: Packet Scanners";
    }

    @Override
    String getInputFileName() {
        return "Day13.txt";
    }

    /**
     * Populates firewall and returns it.
     * @return the populated firewall
     * @throws IOException if an IO error occurs
     */
    protected int[] populateFirewall() throws IOException {
        final List<String> input = getInputAsListOfString(LINE_SEPARATOR);
        final int lastLayerNo = Integer.parseInt(input.get(input.size() - 1).split(": ")[0]);
        final Iterator<String> iterator = input.iterator();
        final int[] firewall = new int[lastLayerNo + 1];

        while (iterator.hasNext()) {
            final String[] bits = iterator.next().split(": ");
            firewall[Integer.parseInt(bits[0])] = Integer.parseInt(bits[1]);
        }

        return firewall;
    }

    protected boolean isCaught(final int depth, final int pico) {
        return depth != 0 && pico % ((2 * depth) - 2) == 0;
    }
}
