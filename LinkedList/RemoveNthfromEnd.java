package LinkedList;

public class RemoveNthfromEnd {

    class ListNode {
        String data; 
        ListNode next; 

        ListNode(String data){
            this.data = data; 
            this.next = null; 
        }
    }
    
    // listnode class defined 
    public ListNode removenthfromend(ListNode head, int n){
        if (head.next == null){
            return null; 
        }

        // calculate size 
        int size = 0; 
        ListNode curr = head; 
        while (curr != null){
            curr = curr.next;
            size++;
        }

        if (n == size){
            return head.next; 
        }

        // calculating the previous node (for the node to be deleted)
        int indextosearch = size - n; 
        ListNode prev = head; 
        int i = 1 ; 
        while (i < indextosearch){
            prev = prev.next; 
            i++; 
        }

        prev.next = prev.next.next; 
        return head; 
    }
    
    public static void main(String[] args) {
        
    }
}
 