package Leetcode;

public class StringCompression {
    public int compress(char[] chars) {
        int count = 0; 
        int index = 0; 
        for (int i = 0; i < chars.length; i++) {
            count = 1;
            // checking if the next character is going to be the same 
            // even though we are iterating in the while loop we still need a way to iterate in the for loop 
            // for which we will be needing the for loop
            while(i<chars.length - 1 && chars[i] == chars[i+1]){
                count++;
                i++; 
            }
            chars[index] = chars[i];
            index++; 

            if (count > 1){
                for(char c: Integer.toString(count).toCharArray()){
                    chars[index] = c;
                    index++; 
                }
            }
        }
        return index;
    }
}
