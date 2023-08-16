package Leetcode;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class DifferenceTwoArrays {
    
    // TC - O(M+N) - M is the size of nums1 and N is the size of nums2
    // SC - O(max(M+N)) - the output array is not considered part of the SC and hence the space complexity is O(max(M+N))

    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {

        return List.of(OnlyInFirst(nums2, nums1), OnlyInFirst(nums1, nums2));
    }

    public List<Integer> OnlyInFirst(int[] nums1, int[] nums2){
        HashSet<Integer> set1 = new HashSet<>();
        HashSet<Integer> set2 = new HashSet<>();

        for (Integer i : nums1) {
            set1.add(i);
        }

        // now we need to return the distict elements in nums1 that are not in nums2 
        for (Integer i : nums2) {
            if (!set1.contains(i)){
                set2.add(i);
            }
        }

        return new ArrayList<>(set2);
    }
    
}
