package com.missy.adventofcode2017.core;

import java.io.IOException;

/**
 * A solution to day 13 part 2's puzzle.
 */
class Solution13b extends Solution13 implements PartTwo {
    @Override
    public String solve() throws IOException {
        final int[] firewall = populateFirewall();

        int delay = 0;
        boolean keepGoing = true;

        while (keepGoing) {
            boolean caught = false;
            for (int i = 0; i < firewall.length; i++) {
                final int depth = firewall[i];
                final int pico = i + delay;
                if (isCaught(depth, pico)) {
                    delay++;
                    caught = true;
                    break;
                }
            }
            keepGoing = caught;
        }

        return String.valueOf(delay);
    }
}
