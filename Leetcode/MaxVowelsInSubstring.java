package Leetcode;

import java.util.HashSet;

// TC - O(N)
// SC - O(1) no extra auxiary space needed 
public class MaxVowelsInSubstring {
    public int maxVowels(String s, int k) {
        HashSet<Character> set = new HashSet<>();
        set.add('a');
        set.add('e');
        set.add('i');
        set.add('o');
        set.add('u');

        int count = 0; 
        for (int i = 0; i < k; i++) {
            if (set.contains(s.charAt(i))){
                count++;
            }
        }
        int res = count; 

        for (int i = k; i < s.length(); i++) {
            if (set.contains(s.charAt(i))){
                count++;
            }
            if (set.contains(s.charAt(i-k))){
                count--; 
            }
            res = Math.max(res, count);
        }
        return res; 
    }

}
