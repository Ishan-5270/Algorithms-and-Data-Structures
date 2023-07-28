package Queue;

public class QueueLinkedList {
    // Enque - Add 
    // Dequeue - Remove
    // Front - Peek 

    // Implementing using an array -> We need to check if the queue is already full
    // Front and Rear both start with -1 position 

    static class Node {
        int data; 
        Node next; 

        Node(int data){
            this.data = data; 
            this.next = null; 
        }
    }

    static class Queuee{
        static Node head = null; 
        static Node tail = null; 

        public static boolean isEmpty(){
            return head == null && tail == null; 
        }

        //enqueue - O(1)
        public static void add(int data){  
            Node newNode = new Node(data);
            if (tail == null){
                tail = head = newNode; 
                return;
            }
            tail.next = newNode; 
            tail = newNode; 
        }

        // dequeue - O(N)
        // for circular queue - O(1)
        public static int remove() {
            if (isEmpty()){
                System.out.println("empty queue");
                return -1; 
            }

            int front = head.data; 
            if (head == tail){
                tail = null; 
            }
            head = head.next; 
            return front; 
        }

        // Peek - O(N )
        public static int peek(){
            if (isEmpty()){
                System.out.println("empty queue");
                return -1; 
            }

            return head.data;
        }
    }

    public static void main(String[] args) {
        Queuee q = new Queuee();
        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);
        q.add(5);
       

        // 1 2 3 ... 1 2 3 
        while(!q.isEmpty()){
            System.out.println(q.peek());
            q.remove();
        }
    }
}

