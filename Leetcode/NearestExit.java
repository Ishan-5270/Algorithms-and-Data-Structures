package Leetcode;

import java.util.LinkedList;
import java.util.Queue;

// O(m*n) - TC
// O(max(M, N)) - SC 
public class NearestExit {
    public int nearestExit(char[][] maze, int[] entrance) {
        /*
         * Now you know how this works 
         */

         int rows = maze.length;
         int col = maze[0].length;
         // lets create a 2-D array with the 
         int[][] dirs = {{1, 0}, {0, 1}, {0, -1}, {-1, 0}};
         int startrow = entrance[0]; int startcol = entrance[1];
         maze[startrow][startcol] = '+';

         Queue<int[]> queue = new LinkedList<>();
         // now we need to add the first item to the queue

         queue.add(new int[]{startrow, startcol, 0});
         // keep iterating till the queue is empty 
         while (!queue.isEmpty()){
            int[] curr = queue.poll();
            // now we need to check its all 4 sides 
            int currrow = curr[0]; int currcol = curr[1]; int currdist = curr[2];
            for(int[] dir: dirs){
                int nextrow = currrow + dir[0];
                int nextcol = currcol + dir[1];

                // while a column is still available we check 
                if (0 <= nextrow && nextrow <= rows && 0 <= nextcol && nextcol <= col 
                && maze[nextrow][nextcol] == '.'){
                    // we check if the row and col and actuall exits 
                    if (nextrow == 0 || nextrow == rows - 1 || nextcol == 0 || nextcol == col -1){
                        return currdist + 1;
                    }

                     // if not then we just add the things to the queue and mark it as visited
                    maze[nextrow][nextcol] = '+';
                    queue.add(new int[]{nextrow, nextcol, currdist + 1});
                }
            }
         }
         return -1;
    }
}
