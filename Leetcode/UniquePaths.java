package Leetcode;

public class UniquePaths {
    // O(M*N) - TC
    // O(M*N) - SC 
    public int uniquePaths(int m, int n) {
        /*
         * Brilliant solution - solve using dynamic programming ooptimation and recursion
         */

         int dp[][] = new int[m+1][n+1];
         int answer = dfs(dp, 0, 0, m, n);
         return answer;
    }

    private int dfs(int[][] dp, int i, int j, int m, int n) {
        if (i >= m || j >= n){
            // goes beyond the grid 
            return 0; 
        }

        if (i == m-1 && j == n-1){
            // we have reached a possible path
            return 1;
        }

        if (dp[i][j] != 0){
            // dp step 
            return dp[i][j];
        }

        int sum1 = dfs(dp, i+1, j, m, n);
        int sum2 = dfs(dp, i, j+1, m, n);

        return dp[i][j] = sum1 + sum2;
    }
}
