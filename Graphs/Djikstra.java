package Graphs;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class Djikstra {

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

    public static class Pair implements Comparable<Pair> {
        int node;
        int dest;

        public Pair(int n, int d){
            this.node = n;
            this.dest = d;
        }

        @Override
        public int compareTo(Pair p2){
            return this.dest - p2.dest;
        }
    }


    // O(E + E logV) -> Edges + NlogN(Time complexity for sorting)
    public static void Djikstras(ArrayList<Edge> graph[], int src, int V){
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        // a question to consider is how do we know which item the priority queue is going to give priority to ->  we do this using comparable 

        int dis[] = new int[V];
        // initalize distance to infinity 
        for (int i = 0; i < V; i++) {
            if (i != src){
                dis[i] = Integer.MAX_VALUE;
            }
        }
        boolean vis[] = new boolean[V];
        pq.add(new Pair(0, 0));

        while(!pq.isEmpty()){
            Pair curr = pq.remove();
            if (!vis[curr.node]){
                vis[curr.node] = true;
            

                for (int i = 0; i < graph[curr.node].size(); i++) {
                    Edge e = graph[curr.node].get(i);
                    // now we perform relaxation after finding the neighbors 

                    int u = e.src;
                    int v = e.dest;

                    if (dis[u] + e.wt < dis[v]){
                        dis[v] = dis[u] + e.wt;
                        pq.add(new Pair(v, dis[v]));
                }
            }
        }
    }

    for (int i = 0; i < V; i++) {
        System.out.print(dis[i]+ " ");
    }
}

    public static void main(String[] args) {
        int V = 4;

        ArrayList<Edge> graph[] = new ArrayList[V];
        createGraph(graph);
        /*
         * Djikstras only works with positive edge weights 
         */
        Djikstras(graph, 0, V);
    }
}
