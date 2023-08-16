package Leetcode;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

import CollectionsFramework.Collections;


public class CloseStrings {
    public static boolean closeStrings(String word1, String word2) {
        if ((word1.length() != word2.length())){
            return false; 
        }
       
        HashMap<Character, Integer> map1 = new HashMap<>();
        HashMap<Character, Integer> map2 = new HashMap<>();


        for (int i = 0; i < word1.length(); i++) {
            map1.put(word1.charAt(i), map1.getOrDefault(word1.charAt(i), 0) + 1);
            map2.put(word2.charAt(i), map2.getOrDefault(word2.charAt(i), 0)+ 1);
        }

        // now check if atleast all the keys are the same 

        for (int i = 0; i < word2.length(); i++) {
            if (!map1.containsKey(word2.charAt(i))){
                return false; 
            }
            if (!map2.containsKey(word1.charAt(i))){
                return false;
            }
        }

        ArrayList<Integer> list1 = new ArrayList<>();
        ArrayList<Integer> list2 = new ArrayList<>();


        for(Map.Entry<Character, Integer> e: map1.entrySet()){
            list1.add(e.getValue());
        }

        for(Map.Entry<Character, Integer> e: map2.entrySet()){
            list2.add(e.getValue());
        }

        // now check if the order of frequencies are the same for the elements 
        Collections.sort(list1);
        Collections.sort(list2);

        return list1 == list2;
    }

    public static void main(String[] args) {
        String s1 = "abbbzcf";
        String s2 = "babzzcz";

        System.out.println(closeStrings(s1, s2));
    }
}
