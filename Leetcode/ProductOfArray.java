package Leetcode;

import java.util.Arrays;

// TC - O(N)
// SC - O(1) - No auxilary space besides the results array
public class ProductOfArray {
    public int[] productExceptSelf(int[] nums) {
        // first we will make a results array 
        int results[] = new int[nums.length];
        Arrays.fill(results, 1);

        // now we want to iterate and store the values -> lets make use of temp 
        int temp = 1; 

        for (int i = 0; i < results.length; i++) {
            results[i] *= temp;
            temp *= nums[i];
        }

        temp = 1; 

        for (int i = nums.length - 1; i >= 0; i--) {
            results[i] *= temp;
            temp *= nums[i];
        }

        return results; 
    }
}
