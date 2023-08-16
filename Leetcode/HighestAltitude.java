package Leetcode;

public class HighestAltitude {
    /*
     * question based on the concept of the prefix sum 
     */
    // O(N) - iterating over the array once TC 
    // O(1) - SC no auxilary space needed other than a few constants 
    public int largestAltitude(int[] gain) {
        int maxheight = 0; 
        int currentheight = 0;

        for (int elegan : gain) {
            currentheight += elegan;
            maxheight = Math.max(maxheight, currentheight);
        }
        return maxheight;
    }
}
