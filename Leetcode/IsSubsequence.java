package Leetcode;

public class IsSubsequence {
    public boolean isSubsequence(String s, String t) {
        /*
         * bruteforce method -> we want to return true if all the values of t is over which means 
         * that we have checked for all characters in the t string but could not find a match 
         */
        int a = s.length();
        int b = t.length();
        int i = 0, j = 0;

        while (i < a && j < b){

            if (s.charAt(i) == t.charAt(j)){
                i++; 
            } 
                j++;
            }

            return i == a; 
    }
}
