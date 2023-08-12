package Graphs;

import java.util.ArrayList;

public class ArticulationPoint {
/*
 * A vertex in an undirected connected graph is an articulation point if removing it an all its edges diconnects the graph
 * Helps us in building more reliable networks
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
        graph[0].add(new Edge(0, 2, 2));

        graph[1].add(new Edge(1, 2, 10));
        graph[1].add(new Edge(1, 3, 0));

        graph[2].add(new Edge(2, 0, 2));
        graph[2].add(new Edge(2, 1, 10));
        graph[2].add(new Edge(2, 3, -1));

        graph[3].add(new Edge(3, 1, 0));
        graph[3].add(new Edge(3, 2, -1));
    }


    public static void dfs(ArrayList<Edge> graph[], int curr, int par, int dt[], int low[], boolean vis[], int time, boolean AP[]){
        vis[curr] = true;
        dt[curr] = low[curr] = ++time;
        int children = 0;

        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            int neigh = e.dest;

            if (par == neigh){
                continue;
            } else if (vis[neigh]){
                low[curr] = Math.min(low[curr], dt[neigh]);
            } else {
                dfs(graph, neigh, curr, dt, low, vis, time, AP);
                low[curr] = Math.min(low[curr], low[neigh]);

                if (dt[curr] <= low[neigh] && par != -1){
                   AP[curr] = true; 
                }
                children++;
            }
        }
        if (par == -1 && children > 1){
            AP[curr] = true;
        }
    }


    public static void articulationpoint(ArrayList<Edge> graph[], int V){
        int dt[] = new int[V];
        int low[] = new int[V];
        int time = 0;

        boolean vis[] = new boolean[V];
        boolean AP[] = new boolean[V];

        for (int i = 0; i < V; i++) {
            if (!vis[i]){
                dfs(graph, i, -1, dt, low, vis, time, AP);;
            }
        }

        for (int i = 0; i < V; i++) {
            if (AP[i] == true){
                System.out.print(i + " ");
            }
        }
    }

    public static void main(String[] args) {
        int V = 4; 

        ArrayList<Edge> graph[] = new ArrayList[V];

        createGraph(graph);
        articulationpoint(graph, V);

    }
}
