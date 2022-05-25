package engine.node;

import java.util.*;

public class Node {

    private String name;
    private Integer distance = Integer.MAX_VALUE; //Setting by default all unvisited nodes to the highest value to simulate infinity distance used in Dijkstra algorithm when init

    private List<Node> shortestPath = new LinkedList<>(); //Collection of nodes that presents the shortest path calculated from the starting node
    Map<Node, Integer> neighboringNodes = new HashMap<>(); //Nodes that are current neighbors to the chosen node

    public Node(String name) {
        this.name = name;
    }

    public static Node getLowestDistanceNode(Set<Node> uncheckedNodes) { //Lowest distance node from unchecked nodes
        Node lowestDistanceNode = null;
        int lowestDistance = Integer.MAX_VALUE;

        for (Node node : uncheckedNodes) {
            int nodeDistance = node.getDistance();

            if (nodeDistance < lowestDistance) {
                lowestDistance = nodeDistance;
                lowestDistanceNode = node;
            }
        }
        return lowestDistanceNode;
    }

    public static void calculateMinimumDistance(Node checkedNode, Integer edgeLength, Node sourceNode) { //Compares actual distance with newly calculated while following new path
        Integer sourceDistance = sourceNode.getDistance();
        int total = sourceDistance + edgeLength;
        if (total < checkedNode.getDistance()) {
            checkedNode.setDistance(total);
            LinkedList<Node> shortestPath = new LinkedList<>(sourceNode.getShortestPath());
            shortestPath.add(sourceNode);

            checkedNode.setShortestPath(shortestPath);
        }
    }

    public void addDestination(Node targetNode, int distance) {
        neighboringNodes.put(targetNode, distance);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getDistance() {
        return distance;
    }

    public void setDistance(Integer distance) {
        this.distance = distance;
    }

    public List<Node> getShortestPath() {
        return shortestPath;
    }

    public void setShortestPath(List<Node> shortestPath) {
        this.shortestPath = shortestPath;
    }

    public Map<Node, Integer> getNeighboringNodes() {
        return neighboringNodes;
    }

    public void setNeighboringNodes(Map<Node, Integer> neighboringNodes) {
        this.neighboringNodes = neighboringNodes;
    }
}
