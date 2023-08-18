package Leetcode;

import java.util.Arrays;
import java.util.HashMap;

/*
 * TC - O(N^2) -> iterate over every row and column once operations like adding and checking in a hashmap take O(1) time 
 * SC - O(N^2) -> store all the rows in the hashmap and then in the worst case there are 6 rows to store so N^2
 */
public class EqualPairs {
    public int equalPairs(int[][] grid) {
        int count = 0; 
       HashMap<String, Integer> map = new HashMap<>();
       for(int[] row: grid){
        String rowString = Arrays.toString(row);
        map.put(rowString, 1 + map.getOrDefault(rowString, 0));
       }

       // Now we need to add up the frequencies of the column 
       for (int c = 0; c < grid.length; c++){
        int[] column = new int[grid.length];
        for (int r = 0; r < grid.length; r++) {
            column[r] = grid[r][c];
        }

        count += map.getOrDefault(Arrays.toString(column), 0);
       }

       return count;
    }
}
