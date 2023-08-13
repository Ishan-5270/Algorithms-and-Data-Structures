package Leetcode;

// O(m + n) -> TC, O(1) -> SC 
public class MergeStringsAlternatively {
    public String mergeAlternately(String word1, String word2){ 
        int m = word1.length();
        int n = word2.length();

        int i = 0, j = 0; 

        StringBuilder result = new StringBuilder();
        /*
         * We are using Stringbuilder instead of String because the String class in Java is immutable 
         */

         while (i<m || j<n){
            if (i<m){
                result.append(word1.charAt(i++));
            }
            if (j<m){
                result.append(word2.charAt(j++));
            }
         }
         return result.toString();

        //  for (int k = 0; k < Math.max(m, n); k++) {
        //     if (k < m){
        //         result.append(word1.charAt(k));
        //     }
        //     if (k < n){
        //         result.append(word2.charAt(k));
        //     }
        //  }
        //  return result.toString();
    }



    /*
     * Could also be done using a for loop using a one pointer approach 
     */

     
}
