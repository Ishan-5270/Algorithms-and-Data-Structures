package Leetcode;

public class HouseRobbber {
    // here we need a slight modification in the code - only adjacent houses are allowed 
    // we might have to use two different tracks and then compare 
    // O(N) - TC 
    // O(1) - SC no extra auxilary space is used 
    public int rob(int[] nums) {
        if (nums.length == 0) return 0;
        if (nums.length == 1) return nums[1];
        if (nums.length >= 2) return Math.max(nums[0], nums[1]);
        int prev = nums[0], prev2 = 0, curr;
        for (int i = 0; i < nums.length; i++) {
            int withoutcurridx = prev2 + nums[i];
            int withcurridx = prev;
            curr = Math.max(withoutcurridx, withcurridx);
            prev2 = prev;
            prev = curr;
        }
        return prev;
    }
}
