package Leetcode;

public class MinCostClimbingStairs {
    // O(N) - TC
    // O(1) - SC no extra auxilary space used 
    public int minCostClimbingStairs(int[] cost) {
        // /*
        //  * Use dp to figure out the lowest cost 
        //  * Can also use memoization which is the technique of storing recurisve calls in arrays 
        //  */

        //  // first the recursive way to solve the question 
        //  return Math.min(minCost(cost, n-1), minCost(cost, n-2));

        // Lets do the iterative approach now - so you were basically on the perfect track at the start of the problem 
        int first = cost[0];
        int second = cost[1];

        if (cost.length <= 2){
            return Math.min(first, second);
        }

        for (int i = 2; i < cost.length; i++) {
            int curr = cost[i] + Math.min(first, second);
            first = second;
            second = curr;
        }
        return Math.min(first, second);
    }

    // private int minCost(int[] cost, int n) {
    //     // now the recursive method 
    //     if (n < 0){
    //         return 0; 
    //     }

    //     if (n == 0 || n == 1){
    //         return cost[n];
    //     }

    //     if (dp[n] != 0){
    //         return dp[n];
    //     }

    //     // memoization 
    //     dp[n] = cost[n] + Math.min(minCost(cost, n-1), minCost(cost, n-2));
    //     return dp[n];
    //}
}
