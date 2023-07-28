package Stack;
import java.util.ArrayList;


public class StackClass2 {
    class Stack{
        static ArrayList<Integer> list = new ArrayList<>(); 
        public static boolean isEmpty(){
            return list.size() == 0;
        }

        // push
        public static void push(int data){
            list.add(data);
        }

        // pop
        public static int pop(){
            if (isEmpty()){
                return -1; 
            }
            int top = list.get(list.size() - 1); 
            list.remove(list.size() - 1);
            return top; 
        }

        public static int peek(){
            if (isEmpty()){
                return -1; 
            }
            return list.get(list.size() - 1); 
        }
    }
}
