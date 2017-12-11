package com.missy.adventofcode2017.core;

import java.io.IOException;
import java.util.List;

/**
 * A solution to day 11's puzzle.
 */
abstract class Solution11 extends SolutionImpl {

    private static final double HALF = 0.5;
    private double x;
    private double y;
    private int max;

    /**
     * Return the final result as an {@link Integer}.
     * @return the final result.
     */
    protected abstract Integer getResult();

    @Override
    public String getQuestionName() {
        return "Day 11: Hex Ed";
    }

    @Override
    String getInputFileName() {
        return "Day11.txt";
    }

    /**
     * Gets his current x coordinate.
     * @return his current x coordinate.
     */
    protected double getX() {
        return x;
    }

    /**
     * Gets his current y coordinate.
     * @return his current y coordinate.
     */
    protected double getY() {
        return y;
    }

    /**
     * Gets the maximum number of steps away he has got.
     * @return the maximum number of steps away he has got.
     */
    protected int getMax() {
        return max;
    }

    @Override
    public String solve() throws IOException {
        final List<String> input = getInputAsListOfString(COMMA_SEPARATOR);

        for (String i : input) {
            move(i);
            final Integer steps = calcSteps(getX(), getY());
            if (steps > max) {
                max = steps;
            }
        }

        return getResult().toString();
    }

    /**
     * Calculates the number of steps away he currently is.
     * @param x the x coordinate.
     * @param y the y coordinate.
     * @return the number of steps away he is.
     */
    protected Integer calcSteps(final double x, final double y) {
        Integer count = 0;
        double currentX = x;
        double currentY = y;
        while (currentX != 0 || currentY != 0) {
            if (currentX < 0) {
                currentX++;
                if (currentY < 0) {
                    currentY += HALF;
                } else {
                    currentY -= HALF;
                }
            } else if (currentX > 0) {
                currentX--;
                if (currentY > 0) {
                    currentY -= HALF;
                } else {
                    currentY += HALF;
                }
            } else if (currentX == 0) {
                if (currentY < 0) {
                    currentY++;
                } else {
                    currentY--;
                }
            }
            count++;
        }

        return count;
    }

    private void move(final String direction) {
        switch (direction) {
            case "n":
                y++;
                break;
            case "ne":
                x++;
                y += HALF;
                break;
            case "se":
                x++;
                y -= HALF;
                break;
            case "s":
                y--;
                break;
            case "sw":
                x--;
                y -= HALF;
                break;
            case "nw":
                x--;
                y += HALF;
                break;
            default:
        }
    }
}
