package com.missy.adventofcode2017.core;

import java.util.List;

/**
 * A solution to day 3 part 1's puzzle.
 */
class Solution03a extends Solution03 implements PartOne {

    @Override
    Integer calcResult(final MemorySlot slot) {
        return Math.abs(slot.getCoordinate().getX()) + Math.abs(slot.getCoordinate().getY());
    }

    @Override
    int calculateValue(final int slotIndex, final Coordinate2D position, final List<MemorySlot> layer, final List<List<MemorySlot>> layers) {
        return slotIndex;
    }
}
