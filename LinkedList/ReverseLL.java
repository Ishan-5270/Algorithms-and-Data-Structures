package LinkedList;

public class ReverseLL {
    /*
     * ArrayList(is implemented using a dynamic array) vs LinkedList 
    Arraylist - Insert O(N), Search O(1)
    In LinkedList st the memory is non contiguous -> 1->2->3->null
    LinkedList - Insert O(1) - thats why we use a linked list when we need to insert something, Search O(N) - because we need to traverse all the elements 
    Linked List - variable size 
    all indiividual elements of a linked list is called a node - a data and a link to the next node
    we only track the first node 
    1) Singular(Can only go ahead) 2) Double(Go either ways) 3) Circular(Connected to the first node)
     */

     Node head; 
     private int size; 

     ReverseLL(){
        this.size = 0; 
     }

     class Node {
        String data; 
        Node next; 

        Node(String data){
            this.data = data; 
            this.next = null; 
            size++; 
        }
     }

     // add - first, last 
     public void addfirst(String data){
        Node newNode = new Node(data);
        if (head == null){
            head = newNode;
            return; 
        }

        newNode.next = head;
        head = newNode; 
     }

     public void addlast(String data){
        Node newNode = new Node(data);
         if (head == null){
            head = newNode;
            return; 
        }

        // if we manipulated with the head instead of currNode we would lose access to the linkedlist 
        Node curNode = head; 
        while(curNode.next != null){
            curNode = curNode.next; 
        }
        curNode.next = newNode; 
     }

     public void printList(){
        if (head == null){
            System.out.println("List is empty ");
            return; 
        }
        Node curNode = head; 
        while(curNode != null){
            System.out.print(curNode.data + " -> ");
            curNode = curNode.next; 
        }
        System.out.println("NULL");
     }

     //delete first 
     public void deletefirst(){
        if (head == null){
            System.out.println("The list is empty");
            return; 
        }
        size--; 
        head = head.next; 
     }

     //delete last 
     public void deletelast(){
        if (head == null){
            System.out.println("The list is empty");
            return; 
        }

        if (head.next == null){
            head = null;
            return; 
        }

        size--;

        Node secondLast = head;
        Node lastNode = head.next;
        while (lastNode.next != null){
            lastNode = lastNode.next;
            secondLast = secondLast.next; 
        }
        secondLast.next = null; 
     }

     public int getsize(){
        return size;
     }

     public void reverseIterate(){
        if (head == null || head.next == null){
            return; 
        }

        Node prevnode = head; 
        Node currnode = head.next; 
        while(currnode != null){
            Node nextNode = currnode.next; 
            // declared inside the loop because we are not using it anywhere outside  
            currnode.next = prevnode; 

            //update
            prevnode = currnode; 
            currnode = nextNode; 
        }
        head.next = null; 
        head = prevnode; 
     }

     public Node reverseRecursive(Node head){
        if (head == null || head.next == null){
            return head; 
        }
        Node newhead = reverseRecursive(head.next);
        head.next.next = head; 
        head.next = null; 

        return newhead; 
     }

     public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.addfirst("a");
        list.addfirst("is");
        list.addlast("list");
        list.addfirst("this");
        list.deletefirst();
        list.deletelast();
        list.head = list.reverseRecursive(list.head);
        list.printList();
        System.out.println(list.getsize());
     }
}