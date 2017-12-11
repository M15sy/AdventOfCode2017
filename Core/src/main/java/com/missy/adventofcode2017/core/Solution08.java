package com.missy.adventofcode2017.core;

import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

/**
 * A solution to day 8's puzzle.
 */
abstract class Solution08 extends SolutionImpl {

    private Map<String, Integer> registers = new HashMap<>();
    private Integer maxValue = Integer.MIN_VALUE;

    /**
     * @return the registers.
     */
    protected Map<String, Integer> getRegisters() {
        return registers;
    }

    /**
     * @return the maximum value to have been in any register
     */
    protected Integer getMaxValue() {
        return maxValue;
    }

    /**
     * @return the final result.
     */
    abstract Integer getResult();

    @Override
    public String getQuestionName() {
        return "Day 8: I Heard You Like Registers";
    }

    @Override
    String getInputFileName() {
        return "Day08.txt";
    }

    @Override
    public String solve() throws IOException {
        // for each instruction
        final List<Instruction> instructions = createInputAsListOfInstructions();
        for (Instruction instruction : instructions) {
            // put the registers in the map if they're not there already
            putInMapIfNotThereAlready(instruction.getRegister());
            putInMapIfNotThereAlready(instruction.getCondition().getRegister());

            // if the condition is true
            if (checkCondition(instruction.getCondition())) {
                // amend the registers value
                final Integer newValue = registers.get(instruction.getRegister()) + instruction.getChangeAmount();
                registers.put(instruction.getRegister(), newValue);
                if (newValue > maxValue) {
                    maxValue = newValue;
                }
            }
        }
        return getResult().toString();
    }

    @SuppressWarnings("ReturnCount")
    private boolean checkCondition(final Condition condition) {
        final int registerValue = registers.get(condition.getRegister());
        final String operator = condition.getOperator();
        final int value = condition.getValue();

        switch (operator) {
            case ">":
                return registerValue > value;
            case ">=":
                return registerValue >= value;
            case "<":
                return registerValue < value;
            case "<=":
                return registerValue <= value;
            case "!=":
                return registerValue != value;
            case "==":
            default:
                return registerValue == value;
        }
    }

    private List<Instruction> createInputAsListOfInstructions() throws IOException {
        return getInputAsListOfString(LINE_SEPARATOR).stream()
                .map(it -> {
                    final List<String> bits = Arrays.asList(it.split(WHITESPACE_SEPARATOR));
                    return new Instruction(
                            bits.get(0),
                            (bits.get(1).equalsIgnoreCase("inc") ? 1 : -1) * Integer.parseInt(bits.get(2)),
                            new Condition(bits.get(4), bits.get(5), Integer.parseInt(bits.get(6))));
                })
                .collect(Collectors.toList());
    }

    private void putInMapIfNotThereAlready(final String register) {
        if (!registers.containsKey(register)) {
            registers.put(register, 0);
        }
    }

    protected class Instruction {
        private final String register;
        private final int changeAmount;
        private final Condition condition;

        Instruction(final String register, final int change, final Condition condition) {
            this.register = register;
            this.changeAmount = change;
            this.condition = condition;
        }

        public String getRegister() {
            return register;
        }

        public int getChangeAmount() {
            return changeAmount;
        }

        public Condition getCondition() {
            return condition;
        }
    }

    protected class Condition {
        private final String register;
        private final String operator;
        private final int value;

        Condition(final String register, final String operator, final int value) {
            this.register = register;
            this.operator = operator;
            this.value = value;
        }

        public String getRegister() {
            return register;
        }

        public String getOperator() {
            return operator;
        }

        public int getValue() {
            return value;
        }
    }
}
