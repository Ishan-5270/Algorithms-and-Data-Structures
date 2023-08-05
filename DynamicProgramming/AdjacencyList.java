package DynamicProgramming;

import java.util.ArrayList;

public class AdjacencyList{

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

    /*
     * A lot of graph computations involve finding the neighbor
     * This can be done by looping through the arraylist stored at the index 
     * for which for neighbor needs to be found
     * This makes the TC of the operation O(X) --> where X is the number of neighbors that a certain vertex has 
     * This makes adjacency list one of the most efficient ways to implement a graph DS 
     */


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

    public static void main(String[] args) {
        int V = 4;

        ArrayList<Edge> graph[] = new ArrayList[V];
        // print 2's neighbors 

        createGraph(graph);

        for (int i = 0; i < graph[2].size(); i++) {
            Edge e = graph[2].get(i);
            System.out.print(e.dest  + " " + e.weight);
            System.out.println();
        }
    }
}

