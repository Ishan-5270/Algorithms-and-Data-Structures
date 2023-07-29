package Hashing.Hashset;
import java.util.*;

import ArrayLists.Arraylists;

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
            LinkedList<Node> oldBucket[] =  buckets;
            buckets = new LinkedList[N*2];

            for (int i = 0; i < N*2; i++) {
                buckets[i] = new LinkedList<>();
            }

            for (int i = 0; i < oldBucket.length; i++) {
                LinkedList<Node> ll = oldBucket[i];
                for (int j = 0; j < ll.size(); j++) {
                    Node node = ll.get(j);
                    put(node.key, node.value);
                } 
            }
        }

        private int searchinLL(K key, int bi) {
            LinkedList<Node> ll = buckets[bi];
            for (int i = 0; i < ll.size(); i++) {
                if (ll.get(i).key == key){
                    return i;
                }   
            }
            return -1;
        }

        private int hashfunction(K key) {
            int bi = key.hashCode();
            return Math.abs(bi) % N;
            // can return any value 
        }

        private V get(K key){
           int bi = hashfunction(key); 
           int di = searchinLL(key, bi); // data index 
           if (di == -1){
            // Node does not exist 
            return null; 
           } else {
            Node node = buckets[bi].get(di);
            return node.value;
           }
        }

        public boolean containsKey(K key){
           int bi = hashfunction(key); 
           int di = searchinLL(key, bi); // data index 
           if (di == -1){
            // Node does not exist 
            return false; 
        } else {
            return true;
        }
        }

        public V remove(K key){
            int bi = hashfunction(key); 
            int di = searchinLL(key, bi); // data index 
            if (di == -1){
                // Node does not exist 
                return null; 
            } else {
                Node node = buckets[bi].remove(di);
                n--;
                return node.value;
            }
        }

        public boolean isEmpty(){
            return n== 0; 
        }

        public ArrayList<K> keySet(){
            ArrayList<K> keys = new ArrayList<>();

            for (int i = 0; i < buckets.length; i++) {
                LinkedList<Node> ll = buckets[i];
                for (int j = 0; j < ll.size(); j++) {
                    Node node = ll.get(j);
                    keys.add(node.key);
                }
            }
            return keys;
        }

    }

    public static void main(String[] args) {
        HashMap<String, Integer> map = new HashMap<>();
        map.put("India", 190);
        map.put("China", 200);
        map.put("USA", 50);

        ArrayList<String> keys = map.keySet();
        for (int i = 0; i < keys.size(); i++) {
            System.out.println(keys.get(i) + " " + map.get(keys.get(i)));            
        }
         
    }

}
