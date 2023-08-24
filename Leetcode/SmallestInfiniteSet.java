package Leetcode;

import java.util.HashSet;
import java.util.PriorityQueue;

public class SmallestInfiniteSet {
    /*
     * First thing we need to do is initialize the constructor
     */

    public HashSet<Integer> ispresent;
    PriorityQueue<Integer> heap;
    int currno;

    public SmallestInfiniteSet() {
        ispresent = new HashSet<>();
        heap = new PriorityQueue<>();
        currno = 1;
    }
    
    public int popSmallest() {
        // pop the smallest element and at the same time store the item in the hashset 
        int smallest = 0; 
        if (!heap.isEmpty()){
            // store it first in the hashset
            smallest = heap.poll();
            ispresent.remove(smallest);
        } else {
            // if it is not there in the heap then 
            smallest = currno;
            currno++;
        }
        return smallest;
    }
    
    public void addBack(int num) {
        // if it is not in the hashset and smaller than the curr no. then we can add the number
        if (!ispresent.contains(num) || num < currno){
            heap.add(num);
            ispresent.add(num);
        }
    }
}
