package ds.algos.graph.dijkstra;

import java.util.*;

class Node {

    public int node;
    public int cost;

    public Node(int node, int cost) {
        this.node = node;
        this.cost = cost;
    }
}

public class GraphPriorityQ {

    int dist[];
    Set<Integer> visited;
    PriorityQueue<Node> pQueue;
    List<List<Node>> adjVertices;

    public GraphPriorityQ(int v) {
        this.dist = new int[v];
        this.visited = new HashSet<>();
        this.pQueue = new PriorityQueue<>((n1, n2) -> n1.cost > n2.cost ? 1 : n1.cost < n2.cost ? -1 : 0);
    }

    public static void main(String[] args) {

        int vertices = 6;
        int source = 0;

        List<List<Node>> adjList = new ArrayList<>();

        for (int i = 0; i < vertices; i++) {
            adjList.add(new ArrayList<>());
        }

        adjList.get(0).add(new Node(1, 5));
        adjList.get(0).add(new Node(2, 3));
        adjList.get(0).add(new Node(3, 2));
        adjList.get(0).add(new Node(4, 3));
        adjList.get(0).add(new Node(5, 3));
        adjList.get(2).add(new Node(1, 2));
        adjList.get(2).add(new Node(3, 3));
        // call Dijkstra's algo method  
        GraphPriorityQ dpq = new GraphPriorityQ(vertices);
        dpq.algo_dijkstra(adjList, source);

        // Print the shortest path from source node to all the nodes 
        System.out.println("The shorted path from source node to other nodes:");
        System.out.println("Source\t\t" + "Node#\t\t" + "Distance");
        for (int i = 0; i < dpq.dist.length; i++)
            System.out.println(source + " \t\t " + i + " \t\t " + dpq.dist[i]);
    }

    public void algo_dijkstra(List<List<Node>> adjList, int src_vertex) {

        this.adjVertices = adjList;

        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src_vertex] = 0;
        pQueue.add(new Node(src_vertex, 0));

        while (!pQueue.isEmpty()) {
            Node node = pQueue.poll();
            visited.add(node.node);
            graphAdjecents(node.node);
        }
    }

    private void graphAdjecents(int sourceNode) {
        List<Node> nodes = adjVertices.get(sourceNode);
        for (Node adjusent : nodes) {
            if (!visited.contains(adjusent.node)) {
                int cost = adjusent.cost;
                if (sourceNode + cost < dist[adjusent.node]) {
                    dist[adjusent.node] = dist[sourceNode] + cost;
                    adjusent.cost = dist[sourceNode] + cost;
                    pQueue.add(adjusent);

                }
            }
        }
    }

}
