package Leetcode;

import java.util.Arrays;

// O(1) - SC no auxilary space used 
// O(NlogN) - NlogN for sorting and O(N) for the while loop 
public class MaxKSumPairs {
    public static int maxOperations(int[] nums, int target) {
        /*
         * bruteforce - we can track the numbers but how do we remove them 
         */
        
         Arrays.sort(nums); 
         // we do not want to store this value back anywhere 
         int num1 = 0;
         int num2 = nums.length - 1; 
         int count = 0; 

         while(num1 < num2){
            // we want it to be equal to another element which is why sorting is recommended 
            // since we cannot remove items from the array we can just iterate through them 
            if (nums[num1] + nums[num2] == target){
                num1++; num2--; count++; 
            }

            if (nums[num1] + nums[num2] < target){
                num1++; 
            }

            else if (nums[num1] + nums[num2] > target){
                num2--;
            }
         }
         return count;
    }

    public static void main(String[] args) {
        int nums[] = {1,2,3,4};
        System.out.println(maxOperations(nums, 5));
    }
}
