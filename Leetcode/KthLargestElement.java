package Leetcode;

import java.util.PriorityQueue;

/*
 * Our heap is limited to the size of k because we are popping the elements after k
 * O(n.logk) - improvement on the previous approach
 * O(k) - SC 
 */
// Not the most efficient way to solve this problem
public class KthLargestElement {
    public int findKthLargest(int[] nums, int k) {
        /*
         * We can use a PQ data structure here and comparable
         */

         PriorityQueue<Integer> pq = new PriorityQueue<>();
         // now we store shit in the priority queue
         for (int i = 0; i < nums.length; i++) {
            pq.add(nums[i]);
         }

         // we want the second largent elment not the smallest 
         for (int i = 0; i < pq.size() - k; i++) {
            pq.poll();
         }
         return pq.poll();
    }
}
