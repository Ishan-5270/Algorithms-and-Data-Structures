package Graphs;

import java.util.ArrayList;

public class BridgeinGraphs {
/*
 * Bridge is an edge whose deletion leads to an increase in the number of connected components
 * Tarjan's Algorithm 
 * mainly used in undirected graphs  
 * A bridge will only exist if dt[u] < the lowest dt[v]
 * Things to track - parent, dt, lowest dt
 */

 static class Edge{
        int src;
        int dest;
        int weight; 

        public Edge(int s, int d, int w){
            this.src = s;
            this.dest = d;
            this.weight = w; 
            // for weighted graphs 
        }
    }

    public static void createGraph(ArrayList<Edge> graph[]){
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<Edge>();
            // Creating an empty Arraylist at every index enables us to store the values for the graph
        }

        graph[0].add(new Edge(0, 2, 2));

        graph[1].add(new Edge(1, 2, 10));
        graph[1].add(new Edge(1, 3, 0));

        graph[2].add(new Edge(2, 0, 2));
        graph[2].add(new Edge(2, 1, 10));
        graph[2].add(new Edge(2, 3, -1));

        graph[3].add(new Edge(3, 1, 0));
        graph[3].add(new Edge(3, 2, -1));

        // All the graph elements are added to the graph
    }

    public static void getBridge(ArrayList<Edge> graph[], int V){
        int dt[] = new int[V];
        int low[] = new int[V];
        boolean vis[] = new boolean[V];

        int time = 0; 
        for (int i = 0; i < V; i++) {
            if (!vis[i]){
                dfs(graph, i, vis, dt, low, time, -1);
            }
        }
    }

    private static void dfs(ArrayList<Edge> graph[], int curr, boolean[] vis, int[] dt, int[] low, int time, int par) {
        vis[curr] = true;
        dt[curr] = low[curr] = ++time;

        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            if (e.dest == par){
                continue;
            }

            else if (!vis[e.dest]){
                dfs(graph, e.dest, vis, dt, low, time, curr);
                low[curr] = Math.min(low[curr], low[e.dest]);
                if (dt[curr] < low[e.dest]){
                    System.out.println("bridge is: "+ curr +"->" +e.dest);
                }
            } else {
                low[curr] = Math.min(low[curr], dt[e.dest]);

            }
        }
    }

public static void main(String[] args) {
    
 }
}
