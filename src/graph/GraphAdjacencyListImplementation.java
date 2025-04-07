package graph;

import java.util.ArrayList;

public class GraphAdjacencyListImplementation {
    static class Edge{
        int src;
        int dest;
        int wt;
        public Edge(int s , int d, int w){
            this.src = s;
            this.dest = d;
            this.wt = w;
        }
    }

    public static void main(String[] args) {
        int v = 5;
        // int arr[] = new arr[v];
        ArrayList<Edge>[] graph = new ArrayList[v];
        for(int i =0;i<v;i++){
            graph[i] = new ArrayList<>(); // for every ith vertices we are creating new ArrayList<>(); so that we can store our edges in this
        }
        /*
        (5)       (1)
        0 ------ 1 ------- 2
                |       / |
                (3)|   (1)  |(2)
                | /       |
                3 ------- 4
                     (1)

         */
        // store for 0 vertices
        graph[0].add(new Edge(0,1,5)) ;

        // store for 1 - vertices
        graph[1].add(new Edge(1,0,5)) ;
        graph[1].add(new Edge(1,2,1)) ;
        graph[1].add(new Edge(1,3,3)) ;

        // store for 2 - vertices
        graph[2].add(new Edge(2,1,1)) ;
        graph[2].add(new Edge(2,3,1)) ;
        graph[2].add(new Edge(2,4,2)) ;
        // store for 3 - vertices
        graph[3].add(new Edge(3,2,1)) ;
        graph[3].add(new Edge(3,1,1)) ;
        // store for 4 - vertices
        graph[4].add(new Edge(4,2,2)) ;

        // now suppose question arise you need to store all the neighbor of 2-vertices
        for(int i =0;i<graph[2].size();i++){
            Edge e = graph[2].get(i);
            System.out.println(e.dest);
        }

    }
}
