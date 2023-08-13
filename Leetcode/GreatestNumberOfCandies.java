package Leetcode;

import java.util.ArrayList;
import java.util.List;

// TC - O(N)
// SC - O(1)

public class GreatestNumberOfCandies {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int max = 0; 
        List<Boolean> result = new ArrayList<>();
        for (int i = 0; i < candies.length; i++) {
            if (candies[i] > max){
                max = candies[i];
            }
            // we have found the max and now we want to see if others can atleast be equal to the max 
        }

        for (int i = 0; i < candies.length; i++) {
            if (candies[i] + extraCandies >= max){
                result.add(true);
            }
            else {
                result.add(false);
            }
        }
        return result;

        /*
         * Alternative way to write the code 
         * 
         * for (int candy: candies){
         * int max = 0;
         * max = Math.max(candy, max)
         * }
         * 
         * for (int candy: candies){
         * result.add(candy + extracandies >= maxcandies);
         * }
         * return result; 
         */
    }
}
