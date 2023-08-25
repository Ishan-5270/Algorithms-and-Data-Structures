package Leetcode;

import java.util.ArrayList;
import java.util.List;

// TC - O(nlogn)
// SC - O(N)
public class LetterCombination {
    String [] strMap = {"0","1","abc", "def","ghi","jkl","mno","pqrs","tuv","wxyz"};
    ArrayList<String> res = new ArrayList<>();
    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0){
            return res;
        }

        // if is it not we pass it to dfs 
        dfs(0, digits, new StringBuilder());
        return res;
    }

    private void dfs(int i, String digits, StringBuilder sb) {
        // base case 
        if (i == digits.length()){
            res.add(sb.toString());
            return;
        }

        // now the dfs 
        char ch = digits.charAt(i);
        // now we need to find the thing to add to the Stringbuilder 
        String str = strMap[ch - '0'];
        // iterate through the string 

        for (char c : str.toCharArray()) {
            sb.append(c);
            dfs(i+1, digits, sb);
            // now we need to delete the last character to backtrack
            sb.deleteCharAt(sb.length() - 1);
        }

    }

   
}
