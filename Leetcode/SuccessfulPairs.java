class Solution {

    // O((m + n).log m) - TC of sorting of length m is O(mlogm) and binary search for n elements is O(nlogm)
    // Arrays.sort TC is O(logm) - where m is the length of the array 
    // O(log m) or O(m)
     public int[] successfulPairs(int[] spells, int[] potions, long success) {
        /*
         * Lets do a bruteforce method first or we could sort first and then perform binary search
         * At the current state I do not think just binary search will work because the array is not sorted 
         */

         Arrays.sort(potions);
         int m = spells.length;
         int n = potions.length;
         int result[] = new int[m];
         int count = 0; 

         int maxportion = potions[n - 1];
         for (int i = 0; i < m; i++) {
            long minportion = (long) Math.ceil(1.0 * success/spells[i]);
            if (minportion > maxportion){
                result[i] = 0; 
            }
            // if not smaller we perform binary search 
            count = binarysearch((int)minportion, potions);
            result[i] = n - count; 
         }
         return result;
    }

    private int binarysearch(int minportion, int[] potions) {
        int start = 0;
        int end = potions.length;

        while (start < end){
            int mid = start + (end - start)/2;
            if (potions[mid] < minportion){
                start = mid + 1;
            } else {
                end = mid;
            }
        }
        return start; 
    }
}