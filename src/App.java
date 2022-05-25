import engine.logic.Dijkstra;
import engine.graph.Graph;
import engine.node.Node;

public class App {

    static Node firstNode = new Node("NodeA");
    static Node second = new Node("NodeB");
    static Node third = new Node("NodeC");
    static Node forth = new Node("NodeD");
    static Node fifth = new Node("NodeE");
    static Node sixth = new Node("NodeF");
    static Node seventh = new Node("NodeG");
    static Node eighth = new Node("NodeH");

    public static void main(String[] args) {
        firstNode.addDestination(second, 20);
        firstNode.addDestination(third, 5);

        Graph graph = new Graph();
        graph.addNode(firstNode);
        graph.addNode(second);

        graph = Dijkstra.calculateShortestPath(graph, firstNode);

        System.out.println(graph);
    }

}
