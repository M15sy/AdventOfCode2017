package com.missy.adventofcode2017.core;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * A solution to day 3's puzzle.
 */
abstract class Solution03 extends SolutionImpl {

    /**
     * Calculate the value to go in a given {@link MemorySlot}.
     * @param slotIndex the memory slot index.
     * @param position the position of the memory slot.
     * @param layer the current spiral layer.
     * @param layers all spiral layers.
     * @return the value.
     */
    abstract int calculateValue(int slotIndex, Coordinate2D position, List<MemorySlot> layer, List<List<MemorySlot>> layers);

    /**
     * Returns the desired result from a given {@link MemorySlot}.
     * @param slot the memory slot.
     * @return the desired result from a given {@link MemorySlot}.
     */
    abstract Integer calcResult(MemorySlot slot);

    @Override
    public String getQuestionName() {
        return "Day 3: Spiral Memory";
    }

    @Override
    String getInputFileName() {
        return "Day03.txt";
    }

    @Override
    public String solve() throws IOException {
        final int targetValue = getInputAsListOfInteger(LINE_SEPARATOR).get(0);

        int width = 1;
        int currentValue = 1;
        int slotIndex = 1;
        int x = 0;
        int y = 0;

        final List<List<MemorySlot>> layers = new ArrayList<>();
        final List<MemorySlot> firstLayer = new ArrayList<>();
        firstLayer.add(new MemorySlot(currentValue, new Coordinate2D(x, y)));
        layers.add(firstLayer);

        // for each layer
        while (currentValue < targetValue) {
            width += 2;
            final int min = slotIndex + 1;
            final int max = slotIndex + 4 * (width - 1);
            final List<MemorySlot> layer = new ArrayList<>();
            // for each slot
            while (slotIndex < max) {
                slotIndex++;
                final int sideIndex = slotIndex == min ? 3 : layer.size() / (width - 1);
                switch (sideIndex) {
                    case 0:
                        y++;
                        break;
                    case 1:
                        x--;
                        break;
                    case 2:
                        y--;
                        break;
                    case 3:
                    default:
                        x++;
                }

                final Coordinate2D position = new Coordinate2D(x, y);
                currentValue = calculateValue(slotIndex, position, layer, layers);

                // last layer
                layer.add(new MemorySlot(currentValue, position));
            }
            // add the layer to the list of layers
            layers.add(layer);
        }

        // last layer
        final MemorySlot slot = layers.get(layers.size() - 1).stream()
                .filter(it -> it.getContents() >= targetValue)
                .findFirst()
                .get();

        return calcResult(slot).toString();
    }

    class MemorySlot {
        private final int contents;
        private final Coordinate2D location;

        MemorySlot(final int contents, final Coordinate2D location) {
            this.contents = contents;
            this.location = location;
        }

        public int getContents() {
            return contents;
        }

        public Coordinate2D getCoordinate() {
            return location;
        }
    }

    class Coordinate2D {
        private final int x;
        private final int y;

        Coordinate2D(final int x, final int y) {
            this.x = x;
            this.y = y;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }
    }
}
