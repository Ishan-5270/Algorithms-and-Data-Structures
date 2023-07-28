package Hashing.Hashset;
import java.util.HashSet;
import java.util.Iterator;

public class hashsetimp {
    /**
     * Time Complexity
     * Insert - O(1)
     * Search - O(1)
     * Delete - O(1)
     */

     public static void main(String[] args) {

        // Creating 
        HashSet<Integer> set = new HashSet<>();


        // Insert
        set.add(1);
        set.add(2);
        set.add(3);
        set.add(1);
        // 1 will only be stored once because only unique elements are stored 


        // Search
        if (set.contains(1)){
            // returns boolean true if present
            System.out.println("contains");
        }

        if (!set.contains(1)){
            System.out.println("Does not contain");
        }

        // Size 
        //System.out.println(set.size());

        // Print all elements 
        //System.out.println(set);

        // Delete 
        set.remove(1);

        // Iterator 
        // Set has a seperate iterator because it does not have indexes 
        Iterator it = set.iterator();
        // hasNext, Next function 2 important functions 
        // .next to return the next element 
        // .hasNext returns true if there is an element in the next step

        while(it.hasNext()){
            System.out.println(it.next());
        }

        
     }
}
