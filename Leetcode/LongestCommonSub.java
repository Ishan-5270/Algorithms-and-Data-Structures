package Leetcode;

public class LongestCommonSub {
    // O(M*N) - TC and SC 
    public int longestCommonSubsequence(String text1, String text2) {
        /*
         * Problem can be solved using Hashmaps but tabulation is a more efficient way to solve the problem 
         */

         int m = text1.length();
         int n = text2.length();
         int dp[][] = new int[m+1][n+1];

         for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (text1.charAt(i) == text2.charAt(j)){
                    // update dp
                    dp[i][j] = dp[i-1][j-1] + 1;
                }
                else {
                    // get the max of the last value 
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
         }
         return dp[m][n];
    }
}
