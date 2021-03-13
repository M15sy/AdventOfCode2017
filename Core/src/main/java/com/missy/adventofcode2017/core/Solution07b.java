package com.missy.adventofcode2017.core;

import java.io.IOException;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * A solution to day 7 part 2's puzzle.
 */
public class Solution07b extends Solution07 implements PartTwo {
    private Integer newNodeWeight;

    @Override
    public String solve() throws IOException {
        readInputToNodes();
        recurseSubTreeWeight(findRoot());
        return newNodeWeight.toString();
    }

    private Integer recurseSubTreeWeight(final Node thisNode) {
        Integer weight = thisNode.getWeight();

        if (newNodeWeight == null) {
            final List<Integer> weights = new ArrayList<>();
            for (String name : thisNode.getChildren()) {
                final Integer subtreeWeight = recurseSubTreeWeight(findNode(name));
                weights.add(subtreeWeight);
                weight += subtreeWeight;
            }

            checkImbalance(thisNode, weights);
        }

        return weight;
    }

    private void checkImbalance(final Node thisNode, final List<Integer> weights) {
        if (!weights.isEmpty()) {
            final Map<Integer, Long> frequencyMap = weights.stream()
                    .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
            final Integer modeWeight = weights.stream().max(Comparator.comparing(frequencyMap::get)).orElseThrow();

            for (int i = 0; i < weights.size(); i++) {
                final Integer nodeWeight = weights.get(i);
                if (!nodeWeight.equals(modeWeight)) {
                    final String nodeToChange = thisNode.getChildren().get(i);
                    final int weightDiff = nodeWeight - modeWeight;
                    newNodeWeight = findNode(nodeToChange).getWeight() - weightDiff;
                }
            }
        }
    }
}
