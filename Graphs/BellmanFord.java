package Graphs;

import java.util.ArrayList;

public class BellmanFord {
    // TC - Djikstra is less than Bellman Fords Algorithm
    // O(V*E) -> TC 

     static class Edge{
        int src;
        int dest;
        int wt;

        public Edge(int s, int d, int w){
            this.src = s;
            this.dest = d;
            this.wt = w;
        }
    }

    public static void createGraph(ArrayList<Edge> graph[]){
        for (int i = 0; i < graph.length ; i++) {
            graph[i] = new ArrayList<Edge>();
        } 
        graph[0].add(new Edge(0, 2, 2));

        graph[1].add(new Edge(1, 2, 10));
        graph[1].add(new Edge(1, 3, 0));

        graph[2].add(new Edge(2, 0, 2));
        graph[2].add(new Edge(2, 1, 10));
        graph[2].add(new Edge(2, 3, -1));

        graph[3].add(new Edge(3, 1, 0));
        graph[3].add(new Edge(3, 2, -1));
    }


    public static void bellmanford(ArrayList<Edge> graph[], int src, int V){
        int dist[] = new int[V];

        for (int i = 0; i < V; i++) {
            if (dist[i] != src){
                dist[i] = Integer.MAX_VALUE;
            }
        }

        for (int i = 0; i < dist.length; i++) {
             
        }
    }


}
