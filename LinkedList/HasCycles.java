package LinkedList;

public class HasCycles {
     // Floyds algoritm of detecting loops 

     class Listnode{
        String data;
        Listnode next; 

        Listnode(String data){
            this.data = data; 
            this.next = null; 
        }

        public boolean hascycles(Listnode head){
            if (head == null){
                return false; 
            }
            Listnode fast = head; // fast 
            Listnode slow = head; // slow

            while(fast != null || fast.next != null){
                fast = fast.next.next; 
                slow = slow.next; 

                if (fast == slow){
                   return true;  
                }
            }
            return false; 
        }

     }
    public static void main(String[] args) {
        
    }
}
