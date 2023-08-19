package Leetcode;

public class DeleteMiddle {
    public ListNode deleteMiddle(ListNode head) {
        /*
         * The first and actually better approach to this question is the fast and slow  approach 
         * TC - O(N) iterating over the linked list once 
         * SC - O(1) we only need two pointers and hence we need constant time for thatt
         */

         if (head.next == null){
            return null;
         }

         ListNode n1 = head;
         ListNode n2 = head;
         int count = 0;

         while (n1 != null){
            n1 = n1.next;
            count++;
         }

         int mid = count/2;

         for (int i = 0; i < mid - 1; i++) {
            // stop at mid 
            n2 = n2.next;
         }

         n2.next = n2.next.next; 
         return head;
    }
}
