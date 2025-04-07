package graph;

import java.util.ArrayList;

public class BasicGraphImplementation {
    public static class Edge {
        int source;
        int destination;
        int weight;

        public Edge(int source, int destination, int weight) {
            this.source = source;
            this.destination = destination;
            this.weight = weight;
        }
    }

    public static void main(String[] args) {
        int vertices = 5;
        ArrayList<Edge>[] graph = new ArrayList[vertices]; // we define one list of array that is accepting the ArrayList as Edge
        for (int i = 0; i < vertices; i++) {
            graph[i] = new ArrayList<>(); // Now each element is a valid ArrayList
        }
        // For vertex 0
        graph[0].add(new Edge(0,1,5));
        // for vertex 1
        graph[1].add(new Edge(1,2,1));
        graph[1].add(new Edge(1,0,5));
        graph[1].add(new Edge(1,3,3));
        // for vertex 2
        graph[2].add(new Edge(2,1,1));
        graph[2].add(new Edge(2,3,1));
        graph[2].add(new Edge(2,4,2));

        // for vertex 3
        graph[3].add(new Edge(3,2,1));
        graph[3].add(new Edge(3,1,3));

        // for vertex 4
        graph[4].add(new Edge(4,2,2));

        for(int i =0;i<graph[2].size();i++){
            Edge e = graph[2].get(i);
            System.out.println("dest "+e.destination);
            System.out.println("source "+e.source);
            System.out.println("weight "+e.weight);
        }
    }
}
