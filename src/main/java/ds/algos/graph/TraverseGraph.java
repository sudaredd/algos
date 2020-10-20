package ds.algos.graph;

import java.util.*;

public class TraverseGraph {

    public static void main(String[] args) {

        Graph graph = Graph.createGraph();
        Set<String> dfs = depthFirstTraversal(graph, "Bob");
        System.out.println(dfs);
        Set<String> bfs = breadthFirstTraversal(graph, "Bob");
        System.out.println(bfs);

    }

    static Set<String> breadthFirstTraversal(Graph graph, String root) {

        Set<String> bfsSet = new LinkedHashSet<>();

        Queue<Vertex> queue = new LinkedList<>();

        queue.offer(new Vertex(root));

        while (!queue.isEmpty()) {

            Vertex v = queue.poll();
            bfsSet.add(v.getLabel());
            List<Vertex> edges = graph.getEdges(v);
            for(Vertex vertex : edges) {
                if(!bfsSet.contains(vertex.getLabel())) {
                    queue.offer(vertex);
                }
            }
        }
        return bfsSet;

    }


        static Set<String> depthFirstTraversal(Graph graph, String root) {

        Set<String> dfsSet = new LinkedHashSet<>();

        Stack<Vertex> stack = new Stack<>();
        stack.push(new Vertex(root));

        while (!stack.isEmpty()) {
            Vertex vertex = stack.pop();
            dfsSet.add(vertex.getLabel());
            List<Vertex> edges = graph.getEdges(vertex);
            for(Vertex v: edges) {
                if(!dfsSet.contains(v.getLabel())) {
                    stack.push(v);
                }
            }
        }

        return dfsSet;
    }

}
