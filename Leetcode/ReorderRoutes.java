package Leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

// O(N) - TC 
// O(N) - SC 
public class ReorderRoutes {
    int count = 0;
    public int minReorder(int n, int[][] connections) {
        
        HashMap<Integer, List<List<Integer>>> map = new HashMap<>();
        // now we create an adjacency list using the hashmap 
        for(int[] connection: connections){
            // we want to get notified for 0th
            map.computeIfAbsent(connection[0], k -> new ArrayList<List<Integer>>()).add(
                    Arrays.asList(connection[1], 1));
            map.computeIfAbsent(connection[1], k -> new ArrayList<List<Integer>>()).add(
                    Arrays.asList(connection[0], 0)); 
        }
        dfs(0, -1, map);
        return count;
    }

    private void dfs(int i, int j, HashMap<Integer, List<List<Integer>>> map) {
        if (!map.containsKey(i)){
            return;
        }

        // we do not need to traverse through it because we will be calling it recursively anyways
        for (List<Integer> neighbor : map.get(i)){
            int child = neighbor.get(0);
            int sign = neighbor.get(1);

            if (child != j){
                count += sign;
                dfs(child, i, map);
            }

        }
    }
}
