package Leetcode;

public class OddEvenList {
    public ListNode oddEvenList(ListNode head) {
        /*
         * 3 situations either just one node and that is odd so we just return that
         */
        if (head == null){
            return null; 
        }

        ListNode odd = head; ListNode even = head.next; ListNode evenHead = even; 

        while (even != null && even.next != null){
            odd.next = even.next; 
            odd = odd.next; 
            even.next = odd.next; 
            even = even.next; 
        }
        if (even.next != null){
            odd = even.next;
        }

        return head;
    }
}
