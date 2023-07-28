package Hashing.Hashset;
import java.util.*;

public class hashmap {
    // stored key-value pairs 
    // key should always be unique but the values can be different

    public static void main(String[] args) {
        // store key, value
        HashMap<String, Integer> map = new HashMap<>();

        // Insertion 
        map.put("India", 120);
        map.put("China", 150);
        map.put("USA", 90);

        // the order does not have to be the same
        System.out.println(map);

        map.put("China", 180);
        // updates the alreeady existing value
        System.out.println(map);

        // Search - containskey -> returns boolean 
        if (map.containsKey("Indonesia")){
            System.out.println("Key is present in the map");
        } else {
            System.out.println("Not present");
        }

        // now to get the value associated with the key
        System.out.println(map.get("China"));
        System.out.println(map.get("Indonesia")); 
        // prints null because the value is not present

        for(Map.Entry<String, Integer> e :map.entrySet()){
            System.out.println(e.getKey() + " " + e.getValue());
            // getkey and getvalue used to get the keys and values 
        } 

        // alternnatively we can also make a set of keys 
        Set<String> keys = map.keySet();
        for(String key : keys){
            System.out.println(key + " " + map.get(key));
        }


        // how to remove 
        map.remove("China");
        System.out.println(map);

    }

}
