package Leetcode;

// O(N) TC -> traversing through the entire array once 
// O(1) -> Constant Space Complexity 
public class MaximumAvgSubarray1 {
    public double findMaxAverage(int[] nums, int k) {
        /*
         * We are going to use the sliding window algorithm here 
         */

         double sum = 0; 
         // first let us kind the sum till k
         for (int i = 0; i < k; i++) {
            sum += nums[i];
         }

         double res = sum; 

         for (int i = k; i < nums.length; i++) {
            // the idea behind this is that we want to find the biggest average and we are going to use another variable
            // to store the max value
            // we have already stored the sum of values until k in the above for loop and now we keep going one ahead 
            sum = nums[i] - nums[i-k];
            res = Math.max(res, sum);
         }

         return res/k;
    }
}
