package Leetcode;

public class ReverseLL {
    public ListNode reverseList(ListNode head) {
        /*
         * We can do both recursive and iterative approaches to this question 
         */

         // I am gonna try the recursive approach because it is returning the ListNode 

        //  if (head == null){
        //     return null;
        //  }

        //  if (head.next == null){
        //     return head; 
        //  }


        //  ListNode newHead = reverseList(head.next);
        // we are passing in the next value for the LL into the recursive stack 
        //  head.next.next = head;
        //  head.next = null;

        //  return newHead; 

        /*
         * Now let us try the iterative approach
         * We need 3 different pointers - prevNode, currNode, nextNode
         */

         NodeType prevNode = null;
         NodeType currNode = head; 
         NodeType nextNode = null;
         
         while (currNode != null){
            nextNode = currNode.next; 
            currNode.next = prevNode;
            prevNode = currNode;
            currNode = nextNode;
         }
         head = prevNode;
         return head;
    }
}
