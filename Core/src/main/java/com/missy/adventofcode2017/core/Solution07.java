package com.missy.adventofcode2017.core;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * A solution to day 7's puzzle.
 */
abstract class Solution07 extends SolutionImpl {
    private List<Node> nodes;

    @Override
    public String getQuestionName() {
        return "Day 7: Recursive Circus";
    }

    @Override
    String getInputFileName() {
        return "Day07.txt";
    }

    /**
     * Reads puzzle input.
     * @throws IOException if an IO error occurs.
     */
    protected void readInputToNodes() throws IOException {
        nodes = getInputAsListOfString(LINE_SEPARATOR).stream()
                .map(it -> {
                    final String[] bits = it.split(" -> ");
                    final String[] bobs = bits[0].split(" ");

                    final String name = bobs[0];
                    final int weight = Integer.parseInt(
                            bobs[1].replace("(", "").replace(")", ""));
                    final List<String> children = bits.length > 1
                            ? Arrays.asList(bits[1].split(", "))
                            : new ArrayList<>();

                    return new Node(name, weight, children);
                })
                .collect(Collectors.toList());
    }

    /**
     * Find node by name.
     * @param name the name of the node
     * @return the node
     */
    protected Node findNode(final String name) {
        return nodes.stream()
                .filter(it -> it.getName().equals(name))
                .findFirst()
                .orElseThrow();
    }

    /**
     * Find parent node of node.
     * @param name the name of the node
     * @return the parent node or null
     */
    protected Node findParent(final String name) {
        return nodes.stream()
                .filter(it -> it.getChildren().stream().anyMatch(name::equals))
                .findFirst()
                .orElse(null);
    }

    /**
     * Find the root node.
     * @return the root node
     */
    protected Node findRoot() {
        Node currentNode = nodes.get(0);
        Node parent = findParent(currentNode.getName());

        while (parent != null) {
            currentNode = parent;
            parent = findParent(currentNode.getName());
        }

        return currentNode;
    }

    protected class Node {
        private final String name;
        private final int weight;
        private final List<String> children;

        Node(final String name, final int weight, final List<String> children) {
            this.name = name;
            this.weight = weight;
            this.children = children;
        }

        String getName() {
            return name;
        }

        int getWeight() {
            return weight;
        }

        List<String> getChildren() {
            return children;
        }
    }
}
