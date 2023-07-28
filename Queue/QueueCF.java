package Queue;
import java.util.Queue; 
import java.util.LinkedList; 
import java.util.*;


public class QueueCF {
    public static void main(String[] args) {
        // Queue is an interface not a class so it can not be used to create an object 
        Queue<Integer> q = new ArrayDeque<>();

        q.add(1);
        q.add(2);
        q.add(3);

        while(!q.isEmpty()){
            System.out.println(q.peek());
            q.remove();
        }
    }
}
