package LinkedList;

public class IsPalindrome {
    // 1 2 1 
    // 1 2 2 1 
    public class Listnode{
        
        String data; 
        Listnode next; 
        Listnode(String data){
            this.data = data; 
            this.next = null; 
        }

        public boolean ispalindrome(Listnode head){
            if (head == null ||  head.next == null){
                return true; 
            }

            Listnode middle = findMiddle(head); //first half end
            Listnode secondhalfstart = reverse(middle.next);
        
            Listnode firsthalfstart = head; 
            while(secondhalfstart != null){
                if (firsthalfstart.data != secondhalfstart.data){
                    return false; 
                }
                firsthalfstart = firsthalfstart.next; 
                secondhalfstart = secondhalfstart.next; 
            }

            return true; 
        }

        private Listnode reverse(Listnode head) {     
            Listnode prev = null; 
            Listnode curr = head; 
            while(curr != null){
                Listnode next = curr.next; 
                curr.next = prev; 
                prev = curr; 
                curr = next;
            }
            return prev; 
        }

        private Listnode findMiddle(Listnode head) {
            Listnode hare = head; 
            Listnode turtle = head; 

            while (hare.next != null && hare.next.next != null){
                hare = hare.next.next;
                turtle = turtle.next;
            }
            return turtle; 
        }

    }
}
