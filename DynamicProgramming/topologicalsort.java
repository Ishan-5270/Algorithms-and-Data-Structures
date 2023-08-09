package DynamicProgramming;

import java.util.*;

public class topologicalsort {
    /*
     * it is not the preferred method because we are even storing information that is not needed 
     * Space Complexity is too high
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
    
    public static void topSort(Arraylist<Edge> graph[], )

    public static void main(String[] args) {
        int V = 4;

        ArrayList<Edge> graph[] = new ArrayList[V];

        createGraph(graph);
        boolean vis[] = new boolean[V];

        
    }
}
