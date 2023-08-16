package Leetcode;

import java.util.HashMap;
import java.util.HashSet;

// TC -  O(N) Iterating through the array once 
// SC - O(N) Frequency count in the hashset and the values in the hashmap 

public class UniqueOccurances {
    public boolean uniqueOccurrences(int[] arr) {
        HashMap<Integer, Integer> map = new HashMap<>();
        /*
         * Store all the unique values in a set 
         * Then iterate through the array and see if a certain value is part of the hashmap and 
         * store the number of times it is ocuring 
         * Finally, we want to iterate through the hashmap and return true if the all the values are unique 
         */

         // step 1 
        for (int i : arr) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }

        // Store the frequencies in a hashset -> can only be added while initializing 
        HashSet<Integer> set = new HashSet<>(map.values());

        // now check for the size 
        if (set.size() == map.size()){
            return true;
        }
        return false; 
    }
}
