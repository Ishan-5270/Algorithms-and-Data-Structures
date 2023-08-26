package Leetcode;

public class BuyAndSellStock {
    /*
     * This question can also be solved using one of the DP techniques 
     */

     // O(N)  - TC and SC 
     // Instead of arrays could also use two variables to make it constant space for later
     public int maxProfit(int[] prices, int fee) {
        int n = prices.length;
        int free[] = new int[n];
        int hold[] = new int[n];

        // first day we gotta buy that shit
        hold[0] = -prices[0];
        for (int i = 1; i < n; i++) {
            // we are checking if we should keep it or sell it
            free[i] = Math.max(free[i-1], hold[i-1] + prices[i] - fee);
            hold[i] = Math.max(hold[i-1], free[i-1] - prices[i]);
        }
        return free[n-1];
     }
}
