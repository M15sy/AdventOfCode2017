package com.missy.adventofcode2017.core;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * A solution to day 10 part 2's puzzle.
 */
class Solution10b extends Solution10 implements PartTwo {

    @Override
    public String solve() throws IOException {
        final List<Integer> input = getInput();

        final List<Integer> sparseHash = knotHash(input);

        final byte[] denseHash = condense(sparseHash);

        return hex(denseHash);
    }

    private List<Integer> getInput() throws IOException {
        final List<Integer> input = getInputAsString().chars().boxed().collect(Collectors.toList());
        input.addAll(Arrays.asList(17, 31, 73, 47, 23));
        // x64 as we want to run a total of 64 rounds
        final List<Integer> totalInput = new ArrayList<>();
        for (int i = 0; i < 64; i++) {
            totalInput.addAll(input);
        }
        return totalInput;
    }

    private byte[] condense(final List<Integer> sparseHash) {
        final byte[] dense = new byte[16];
        for (int i = 0; i < 16; i++) {
            for (int j = i * 16; j < i * 16 + 16; j++) {
                dense[i] ^= sparseHash.get(j);
            }
        }
        return dense;
    }

    private String hex(final byte[] denseHash) {
        final StringBuilder sb = new StringBuilder();
        // for each byte
        for (byte hash : denseHash) {
            // try get it's hex
            String hex = Integer.toHexString(hash);
            // if it's too short prepend with zeros
            while (hex.length() < 2) {
                hex = "0" + hex;
            }
            // if it's too long take the last two digits
            if (hex.length() > 2) {
                hex = hex.substring(hex.length() - 2);
            }
            sb.append(hex);
        }
        return sb.toString();
    }
}
