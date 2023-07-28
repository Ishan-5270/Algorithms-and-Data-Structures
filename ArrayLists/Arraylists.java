package ArrayLists;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections; 

public class Arraylists {

    // Collection framework has datastructures already implemented from the start 

    // Arrays are fixed size whereas the size of arraylists can be modified 

    // Inside arrays we can store primitives & objects -> Inside arraylists we can only store objects (everything is stored inside the heap) & can only store objects 

    // basic functions - Add, Get, Modify, Delete, Iterate(other operations)

    public static void main(String[] args) {
        // if we need to store int then we will have to use the Integer class -> basically all starting with upper letters 
        ArrayList<Integer> list = new ArrayList<>(); // or ArrayList<Integer> list = new ArrayList<Integer>()

        // add elements 
        list.add(0);
        list.add(2);    
        list.add(3);
        System.out.println(list);

        // get 
        int element = list.get(0);
        System.out.println(element);

        // all element in between 
        // using .add adds all the elements towards the end -> we pass in the index first 
        list.add(1,1);
        System.out.println(list);

        // set element 
        list.set(0, 5);
        System.out.println(list);

        // delete element
        list.remove(3);
        System.out.println(list);

        //count all the number of elements in the array list 
        int size = list.size();
        System.out.println(size);

        //loops in an arraylist 
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i)+  " ");
        }

        // sorting elements in an arraylist 
        Collections.sort(list);
        // part of the collections class and we can use its pre-build sort function to sort all the data structures that are part of the collections framework
        System.out.println(list);

    }



    
}
