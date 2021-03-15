package com.missy.adventofcode2017.core;

import java.io.IOException;

/**
 * A solution to day 13 part 1's puzzle.
 */
class Solution13a extends Solution13 implements PartOne {
    @Override
    public String solve() throws IOException {
        final int[] firewall = populateFirewall();
        int severity = 0;

        for (int i = 0; i < firewall.length; i++) {
            final int depth = firewall[i];
            if (isCaught(depth, i)) {
                severity += depth * i;
            }
        }

        return String.valueOf(severity);
    }
}
