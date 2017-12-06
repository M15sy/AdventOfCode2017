package com.missy.adventofcode2017.core;

import java.util.ArrayList;
import java.util.List;

/**
 * A solution to day 3 part 2's puzzle.
 */
class Solution03b extends Solution03 implements PartTwo {

    @Override
    Integer calcResult(final MemorySlot slot) {
        return slot.getContents();
    }

    @Override
    int calculateValue(final int slotIndex, final Coordinate2D position, final List<MemorySlot> layer, final List<List<MemorySlot>> layers) {
        final List<MemorySlot> poss = new ArrayList<>(layer);
        if (layers.size() > 0) {
            poss.addAll(layers.get(layers.size() - 1));
        }
        return poss.stream()
                .filter(it ->
                        it.getCoordinate().getX() >= position.getX() - 1
                                && it.getCoordinate().getX() <= position.getX() + 1
                                && it.getCoordinate().getY() >= position.getY() - 1
                                && it.getCoordinate().getY() <= position.getY() + 1
                )
                .mapToInt(MemorySlot::getContents)
                .sum();
    }
}
