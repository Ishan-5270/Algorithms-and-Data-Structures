package Leetcode;

import java.util.List;

public class KeysAndRooms {
    /*
     * With a certain key you can go visit that room need to return boolean 
     * We can solve this question using dfs 
     */
    // TC - O(N+E) total number of rooms + keys
    // SC - O(N) - total number of keys 
     boolean result[];
     public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        result = new boolean[rooms.size()];
        result[0] = true;
        dfs(rooms, 0);
        for (boolean i: result) {
            if (!i){
                return false; 
            }
        }
        return true;

    }

    private void dfs(List<List<Integer>> rooms, int x) {
        // now we traverse through the rooms - iterate through the rooms inner array 
        for (int i : rooms.get(x)) {
            if(result[i] != true){
                // set it equal to true which means it is now visited 
                result[i] = true; 
                // this is what you would store in the queue so you pass it on in recursion 
                dfs(rooms, i);
            }
        }

    }
}
