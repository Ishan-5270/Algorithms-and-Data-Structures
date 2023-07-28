package Hashing.Hashset;
import java.util.*;

public class hashtable {
    // implemented using an array of LL


    // put function 1) K-V pair exists then update the value rather than inserting a new K-V pair 
    // 2) Insert the K-V pair 
    // how to figure out where to store the data -> where to store the data
    // famous hashing algorithms - SH1 etc to encrypt passwords

    // Java has inbuilt function called hashcode that does the desired job for us
    // hashfunction is such that it returns the same bucket every single time -> it makes the overall code a lot more efficient
    // Time to search or put will now be the size of the LL -> evenly spread out hashfunction n/N -> lambda  lambda <= K(constant value)
    // if it crosses the threshhold then we increase the size of the buckets 

    // when the size of the array changes then the bucket index is also going to be different 

    static class HashMap<K,V> { // generics -> the key value pair is undefined 
        private class Node {
            K key; 
            V value; 

            public Node(K key, V value){
                this.key = key; 
                this.value = value;
            }
        }

        private int n; // nodes 
        private int N; // buckets 
        private LinkedList<Node> buckets[]; // N -> buckets.length

        public HashMap(){
            this.N = 4; 
            this.buckets = new LinkedList[4];
            for (int i = 0; i < 4; i++) {
                this.buckets[i] = new LinkedList<>();                
            }
        }

        public void put(K key, V value){
           int bi = hashfunction(key); 
           int di = searchinLL(key, bi); // data index 
           if (di == -1){
            // Node does not exist 
            buckets[bi].add(new Node(key, value));
            n++;
           } else {
            Node node = buckets[bi].get(di);
            node.value = value;
           }

           double lambda = (double)n/N;
           if (lambda > 2.0){
            rehash();
           }
        }

        private void rehash() {
        }

        private int searchinLL(K key, int bi) {
            LinkedList<Node> ll = 

        }

        private int hashfunction(K key) {
            int bi = key.hashCode();
            return Math.abs(bi) % N;
            // can return any value 
        }

    }






}
