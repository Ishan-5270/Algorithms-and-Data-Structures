package Graphs;

import java.util.ArrayList;
import java.util.Stack;

public class SCC {
/*
 * Get nodes in stack (top sort) - O(V + E)
 * Transpose the graph - O(V + E)
 * Do DFS according to stack nodes on the transpose graph - O(V + E)
 */

 static class Edge{
        int src;
        int dest;
        int weight; 

        public Edge(int s, int d){
            this.src = s;
            this.dest = d;
        }
    }

    public static void createGraph(ArrayList<Edge> graph[]){
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<Edge>();
            // Creating an empty Arraylist at every index enables us to store the values for the graph
        }

        graph[0].add(new Edge(0, 2));

        graph[1].add(new Edge(1, 2));
        graph[1].add(new Edge(1, 3));

        graph[2].add(new Edge(2, 0));
        graph[2].add(new Edge(2, 1));
        graph[2].add(new Edge(2, 3));

        graph[3].add(new Edge(3, 1));
        graph[3].add(new Edge(3, 2));

    }

    public static void dfs(ArrayList<Edge> graph[], int curr, boolean vis[]){
        vis[curr] = true;
        System.out.print(curr + " ");

        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);

            if (!vis[e.dest]){
                dfs(graph, e.dest, vis);
            }
        }

    }

    public static void topSort(ArrayList<Edge> graph[], int curr, boolean vis[], Stack<Integer> s){
        vis[curr] = true;

        for (int i = 0; i < vis.length; i++) {
            Edge e = graph[curr].get(i);
            if (!vis[e.dest]){
                topSort(graph, e.dest, vis, s);
            }
        }

        s.push(curr);
    }


    public static void kosaraju(ArrayList<Edge> graph[], int V){
      // Step 1 - O(V + E)
      Stack<Integer> stack = new Stack<>();
      boolean vis[] = new boolean[V];
      for (int i = 0; i < vis.length; i++) {
        if (!vis[i]){
            topSort(graph, i, vis, stack);
        }
      } 
      
      // Step 2 Transpose graph - O(V + E)
      ArrayList<Edge> transpose[] = new ArrayList[V];
      for (int i = 0; i < graph.length; i++) {
        vis[i] = false;
        transpose[i] = new ArrayList<Edge>();
      }

      for (int i = 0; i < V; i++) {
        for (int j = 0; j < graph[i].size(); j++) {
            Edge e = graph[i].get(j);

            // each edge has e.src -> e.dest and we want to reverse it for the transpose graph
            transpose[e.dest].add(new Edge(e.dest, e.src));
        }
      }


      // Step 3 - O(V + E)
      while (!stack.isEmpty()){
        int curr = stack.pop();
        if (!vis[curr]){
            dfs(graph, curr, vis);
            System.out.println();

        }
      }
    }



    public static void main(String[] args) {
        int V = 4;

        ArrayList<Edge> graph[] = new ArrayList[V];
        createGraph(graph);

        kosaraju(graph, V);

    }
}
