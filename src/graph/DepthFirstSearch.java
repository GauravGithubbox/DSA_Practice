package graph;

import java.util.ArrayList;

public class DepthFirstSearch {
    public static class Edge {
        int source;
        int destination;
        int weight;

        Edge(int source, int destination, int weight) {
            this.source = source;
            this.destination = destination;
            this.weight = weight;
        }
    }

    public static void createGraph(ArrayList<Edge> graph[], int v) {
        for (int i = 0; i < v; i++) {
            graph[i] = new ArrayList<>();
        }
        // vertex 0
        graph[0].add(new Edge(0, 1, 1));
        graph[0].add(new Edge(0, 3, 1));
        // vertex 1
        graph[1].add(new Edge(1, 0, 1));
        graph[1].add(new Edge(1, 2, 1));
        graph[1].add(new Edge(1, 4, 1));
        graph[1].add(new Edge(1, 5, 1));
        //vertex 2
        graph[2].add(new Edge(2, 1, 1));
        // vertex 3
        graph[3].add(new Edge(3, 0, 1));
        graph[3].add(new Edge(3, 4, 1));
        // vertex 4
        graph[4].add(new Edge(4, 3, 1));
        graph[4].add(new Edge(4, 5, 1));
        // vertex 5
        graph[5].add(new Edge(5, 4, 1));
        graph[5].add(new Edge(5, 6, 1));
        graph[5].add(new Edge(5, 1, 1));
        // vertex 6
        graph[6].add(new Edge(6, 5, 1));

    }
    public static void dfs(ArrayList<Edge> graph[], boolean visited[],int curr){
        System.out.println(curr+" ");
        visited[curr] = true;

        for(int i =0;i<graph[curr].size();i++){
        Edge e = graph[curr].get(i);
        if(!visited[e.destination]){
            dfs(graph,visited, e.destination);
        }
        }
    }

    public static void main(String[] args) {
         /*
                0 ------- 1 ------- 2
                |         / |
                |       /   |
                |      /    |
                3 ---- 4    |
                       |     |
                       ------- 5 ------- 6

        */
        int v = 7;
        ArrayList<Edge> graph[] = new ArrayList[v];
        createGraph(graph, v);
        dfs(graph,new boolean[v],0);
    }
}
