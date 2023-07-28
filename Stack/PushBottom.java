package Stack;
import java.util.*;

public class PushBottom {
    public static void pushatbottom(int data, Stack<Integer> s){
        if (s.isEmpty()){
            s.push(data);
            return; 
        }
        int top = s.pop();
        pushatbottom(data, s);
        s.push(top);
    }
    public static void main(String[] args) {
        Stack<Integer> s = new Stack<>(); 
        s.push(1);
        s.push(2);
        s.push(3);

        int data = 4; 
        pushatbottom(data, s);

        while(!s.isEmpty()){
            System.out.println(s.peek());
            s.pop();
        }
    }
}
