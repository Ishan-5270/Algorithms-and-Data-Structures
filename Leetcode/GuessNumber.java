package Leetcode;

public class GuessNumber {
    /** 
 * Forward declaration of guess API.
 * @param  num   your guess
 * @return 	     -1 if num is higher than the picked number
 *			      1 if num is lower than the picked number
 *               otherwise return 0
 * int guess(int num);
 */

public class Solution extends GuessGame {
    public int guessNumber(int n) {
        /*
         * We will be using binary search in this question
         */

         int start = 0; 
         int end = n;

         while (start <= end){
            int mid = start + (end - start)/2;
            int res = guess(mid);
            if (res == 0){
                return res;
            }

            else if (res < 0){
                start = mid + 1;
            }

            else {
                end = mid - 1;
            }
         }
         return -1;
    }
}


}
