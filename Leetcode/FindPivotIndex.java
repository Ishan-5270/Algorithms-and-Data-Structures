package Leetcode;

// O(N) - iterates over the array once 
// O(1) - no auxilary space used 
public class FindPivotIndex {
    public static int pivotIndex(int[] nums) {
        int sum = 0, leftsum = 0; 
        for (int n: nums) {
            sum += n;
        }

        for (int i = 0; i < nums.length; i++) {
            if (leftsum == sum - nums[i] - leftsum){
                return i; 
            }
            leftsum += nums[i];
        }
        return -1; 
    } 

    public static void main(String[] args) {
        int nums[] = {1,7,3,6,5,6};
        System.out.println(pivotIndex(nums));
    }
}
