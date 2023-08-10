package Graphs;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class MST {
    /*
     * All components are connected and the the total edge weight is the least 
     * Only possible for connected and undirected graph
     */

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
        graph[0].add(new Edge(0, 2, 10));

        graph[1].add(new Edge(1, 2, 10));
        graph[1].add(new Edge(1, 3, 10));

        graph[2].add(new Edge(2, 0, 2));
        graph[2].add(new Edge(2, 1, 10));
        graph[2].add(new Edge(2, 3, 10));

        graph[3].add(new Edge(3, 1, 18));
        graph[3].add(new Edge(3, 2, 15));
    }

    public static class Pair implements Comparable<Pair>{
        int node; 
        int cost;

        public Pair(int n, int c){
            this.node = n;
            this.cost = c;
        }

        @Override
        public int compareTo(Pair p2){
            return this.cost - p2.cost;
        }
    }


    public static void prims(ArrayList<Edge> graph[], int V){
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        boolean vis[] = new boolean[V];
        pq.add(new Pair(0, 0));

        int cost = 0;

        while(!pq.isEmpty()){
            Pair curr = pq.remove();

            if (!vis[curr.node]){
                vis[curr.node] = true;
                cost += curr.cost;

                for (int i = 0; i < graph[curr.node].size(); i++) {
                    Edge e = graph[curr.node].get(i);
                    if (!vis[e.dest]){
                        pq.add(new Pair(e.dest, e.wt));
                    }
                }
            }
        }

        System.out.println("Minimum cost of MST "+ cost);
    }

    public static void main(String[] args) {
        int V = 4;
        ArrayList<Edge> graph[] = new ArrayList[V];

        createGraph(graph);
        prims(graph, V);
    }

}
