package Queue; 

public class CircularQueue {
    // Enque - Add 
    // Dequeue - Remove
    // Front - Peek 

    // Implementing using an array -> We need to check if the queue is already full
    // Front and Rear both start with -1 position 

    static class Queuee{
        static int arr[];
        // we do not know the size of the array yet for which we need to first define the constructor 
        static int rear = -1; 
        static int size; 
        static int front = -1; 

        Queuee(int size){
            arr = new int[size];
            this.size = size; 
        } 

        public static boolean isEmpty(){
            return rear == -1 && front == -1; 
        }

        public static boolean isFull(){
            return (rear + 1)  % size == front; 
        }

        //enqueue - O(1)
        public static void add(int data){  
            if (isFull()){
                System.out.println("Full Quene");
                return; 
            }

            //1st element add 
            if (front == -1){
                front = 0; 
            }
            rear = (rear + 1) % size;
            arr[rear] = data; 
        }

        // dequeue - O(N)
        // for circular queue - O(1)
        public static int remove() {
            if (isEmpty()){
                System.out.println("empty queue");
                return -1; 
            }

            int result = arr[front];
            if (rear == front){
                rear = front = -1; 
            } else {
                front = (front + 1)% size; 
            }
            return result; 
        }

        // Peek - O(N )
        public static int peek(){
            if (isEmpty()){
                System.out.println("empty queue");
                return -1; 
            }

            return arr[front];
        }
    }

    public static void main(String[] args) {
        Queuee q = new Queuee(10);
        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);
        q.add(5);
        System.out.println(q.remove());
        q.add(6);
        System.out.println(q.remove());
        q.add(7);

        // 1 2 3 ... 1 2 3 
        while(!q.isEmpty()){
            System.out.println(q.peek());
            q.remove();
        }
    }
}

