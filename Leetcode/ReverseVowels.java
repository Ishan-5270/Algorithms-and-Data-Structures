package Leetcode;


// TC - O(N) - traversing through the array once 
// SC - need to convery the string into a character to swap hence the SC is O(N)
public class ReverseVowels {
    public String reverseVowels(String s) {
        /*
         * from what i understand we need to reverse the vowels in the middle occurance of the string
         * how to we track all the vowels 
         */

         int start = 0; 
         int end = s.length() - 1; 
         char charstr[] = s.toCharArray();

         while (start < end){
            // Find the leftmost vowel 
            while (start < s.length() && !isVowel(charstr[start])){
                start++;
            }

            // Find the rightmost vowel 
            while (end >= 0 && !(isVowel(charstr[end]))){
                end--; 
            }

            if (start < end){
                swap(charstr, start++, end--);
            }
         }
         return new String(charstr);
    }

    private void swap(char[] charstr, int start, int end) {
        char temp = charstr[start];
        charstr[start] = charstr[end];
        charstr[end] = temp; 
    }

    public static boolean isVowel(char ch){
        return ch == 'A' || ch == 'E' || ch == 'I' || ch == 'O' || ch == 'U' 
        || ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u';
    }
}
