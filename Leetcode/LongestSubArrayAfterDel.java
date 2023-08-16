package Leetcode;

public class LongestSubArrayAfterDel {
    
    public int longestSubarray(int[] nums) {
        int k = 1; 
        int zero = 0; 
        int ans = 0, left = 0; 
        for (int end = 0; end < nums.length; end++) {
            if (nums[end] == 0){
                zero++; 
            }

            // we are only allowed to delete one element so we need a way to keep track of that element
            if (zero > k){
                if (nums[left] == 0){
                    zero--; 
                }
                left++; 
            }
            ans = Math.max(ans, end - left);
        } 
        return ans; 
    }
}
