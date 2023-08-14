package Leetcode;

public class IncreasingTripletSubsequence {
    public boolean increasingTriplet(int[] nums) {
        /*
         * bruteforce method 
         */
        
        //  for (int i = 0; i < nums.length; i++) {
        //     for (int j = 0; j < i; j++) {
        //         for (int j2 = 0; j2 < j; j2++) {
        //             if (nums[j2] < nums[j] && nums[j] < nums[i]){
        //                 return true; 
        //             }
        //         }
        //     }
        //  }
        //  return false; 

        /*
         * We want a way by which we can track those 2 bigger numbers of iterating multiple times
         */

         int a = Integer.MAX_VALUE;
         int b = Integer.MAX_VALUE;

         for (int i = 0; i < nums.length; i++) {
            if (nums[i]  <= a){
                a = nums[i];
            }
            else if (nums[i] <= b){
                b = nums[i];
            }
            else {
                return true; 
            }
         }
         return false; 
    }
}
