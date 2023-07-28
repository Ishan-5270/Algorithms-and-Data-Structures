package Queue;

public class Queue {
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

        Queuee(int size){
            arr = new int[size];
            this.size = size; 
        } 

        public static boolean isEmpty(){
            return rear == -1; 
        }


        //enqueue - O(1)
        public static void add(int data){  
            if (rear == size - 1){
                System.out.println("Full Quene");
                return; 
            }

            rear ++; 
            arr[rear] = data; 
        }

        // dequeue - O(N)
        // for circular queue - O(1)
        public static int remove() {
            if (isEmpty()){
                System.out.println("empty queue");
                return -1; 
            }

            int front = arr[0];
            for(int i = 0; i<rear; i++){
                arr[i] = arr[i+1];
            }
            rear--;
            return front; 
        }

        // Peek - O(N )
        public static int peek(){
            if (isEmpty()){
                System.out.println("empty queue");
                return -1; 
            }

            return arr[0];
        }
    }

    public static void main(String[] args) {
        Queuee q = new Queuee(10);
        q.add(1);
        q.add(2);
        q.add(3);


        // 1 2 3 ... 1 2 3 
        while(!q.isEmpty()){
            System.out.println(q.peek());
            q.remove();
        }
    }
}

