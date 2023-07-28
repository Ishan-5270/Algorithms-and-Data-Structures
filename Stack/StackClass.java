package Stack;

public class StackClass {
    // 3 main operations - Push O(1), Pop O(1), Peek O(1)
    // Is also called last in first out data structure - the thing that comes last is the first one to leave 
    // Push -> To the top of the stack 
    // Pop -> Remove the element from the top of the stack 
    // Peak -> Get the value of the top element in the stack 

    // Array -> fixed size which causes the problem -> either we stop the user, or we create a new array and copy all the elements 
     
    static class Node {
        int data; 
        Node next; 
        public Node(int data){
            this.data = data;
            this.next = null; 
        }
    }

    static class Stack {
       public static Node head;  
       public static boolean isEmpty(){
        return head == null; 
       }

       public static void push(int data){
        Node newnode = new Node(data);
        if (isEmpty()){
            head = newnode;
            return; 
        }
        newnode.next = head; 
        head = newnode; 
       }

       public static int pop(){
        if (isEmpty()){
            return -1; 
        }
        int top = head.data;
        head = head.next;
        return top; 
       }

       public static int peek(){
        if (isEmpty()){
            return -1; 
        }
        return head.data;
       }
    }


    public static void main(String[] args) {
        Stack s = new Stack();
        s.push(1);
        s.push(2);
        s.push(3);
        s.push(4);

        while (s.isEmpty())
        System.out.println(s.peek());
        s.pop();
    }
}
