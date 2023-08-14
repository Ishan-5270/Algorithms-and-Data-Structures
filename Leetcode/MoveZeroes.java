package Leetcode;

public class MoveZeroes {
    public void moveZeroes(int[] nums) {
        /*
         * bruteforce approach
         */

         /*
          * Single pointer 
          */
         int i = 0;  
         for (int num: nums) {
            if (num != 0){
                nums[i] = num; 
                // by doing this we can essentially update all the values before the 0 
                i++; 
            }
         }

         while (i<nums.length){
            nums[i] = 0; 
            i++; 
         }

         /*
          * Two Pointer 
          */
         int s = 0, e = 1;
         while (e < nums.length){
            if (nums[s] == 0 && nums[e] != 0){
            // reverse 
            int temp = nums[s]; 
            nums[s] = nums[e];
            nums[e] = temp;
            s++; e++;
         }

         else if (nums[s] == 0 && nums[e] == 0){
            e++;
         } else {
            s++; e++; 
         }
         }
    }
}
