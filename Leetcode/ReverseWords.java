package Leetcode;


// Inefficient 
/*
 * TC - O(N)
 * SC - O(N)
 */
public class ReverseWords {
    public static String reverseWords(String s) {
        /*
         * The string s lets get rid of leading and trailing spaces if any 
         */

         String answer = ""; 
         String results[];
         s = s.trim();
         // now we want to split the string into multiple characters 
         results = s.split("\\s+");

         // now we want to print to backwards 
         for (int i = results.length - 1; i > 0; i--) {
            answer += results[i] + " "; 
         }
         answer += results[0];
         return answer; 
    }

    public static void main(String[] args) {
        String s = "       the     sky is blue    ";
        System.out.println(reverseWords(s));
    }
}
