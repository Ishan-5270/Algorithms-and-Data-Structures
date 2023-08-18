package Leetcode;

import java.util.Stack;

/*
 * O(N) - TC to reverse the strings, form the stringbuilder and store everything in the stack takes O(N) time 
 * O(N) - SC because the stack in the solution can grow to a max size if n we would need O(N) space in that case
 */
public class RemoveStars {
    public String removeStars(String s) {
        // /*
        //  * using the stack data structure 
        //  */

        //  // Step 1 iterate through the string 

        //  Stack<Integer> stack = new Stack<>();
        //  StringBuilder sb = new StringBuilder();
        //  for (int i = 0; i < s.length(); i++) {
        //     if (s.charAt(i) != '*'){
        //         stack.push(i);
        //     }
        //     else {
        //         stack.pop();
        //     }
        //  }

        //  // now we have the stack with the desired answer but in reverse order 
        //  // Now we iterate through the stack 
        //  // we are actually storing all the values in reverse order itself rn 
        //  while (!stack.isEmpty()){
        //     sb.append(stack.pop());
        //  }

        //  return sb.reverse().toString();

         // Alternative approach 

         StringBuilder result = new StringBuilder();
         for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != '*'){
                result.append(s.charAt(i));
            } else {
                result.deleteCharAt(result.length() - 1);
            }
         }

         return result.toString();

    }
}
