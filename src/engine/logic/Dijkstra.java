package engine.logic;

import engine.graph.Graph;
import engine.node.Node;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import static engine.node.Node.calculateMinimumDistance;

public class Dijkstra {

    public static Graph calculateShortestPath(Graph graph, Node sourceNode) {
        sourceNode.setDistance(0);

        Set<Node> checkedNodes = new HashSet<>();
        Set<Node> uncheckedNodes = new HashSet<>();

        uncheckedNodes.add(sourceNode);

        while (uncheckedNodes.size() != 0) {
            Node currentNode = Node.getLowestDistanceNode(uncheckedNodes);
            uncheckedNodes.remove(currentNode);

            for (Map.Entry<Node, Integer> neighboringPair : currentNode.getNeighboringNodes().entrySet()) {
                Node neighboringNode = neighboringPair.getKey();
                Integer edgeLength = neighboringPair.getValue();

                if (!checkedNodes.contains(neighboringNode)) {
                    calculateMinimumDistance(neighboringNode, edgeLength, currentNode);
                    uncheckedNodes.add(neighboringNode);
                }

            }
            checkedNodes.add(currentNode);
        }
        return graph;
    }

}
