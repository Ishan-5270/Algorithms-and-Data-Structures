package Leetcode;

// O(n) TC Iterating over the array once 
// O(1) SC constant extra space is used 
public class CanPlaceFlowers {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        // the array flowerbed determines if it empty or not 
        // n determines the new flowers that need to be planted 
        int emptyspace = 0; 

        for (int i = 0; i < flowerbed.length; i++){

            if (flowerbed[i] == 0){
                // now we want to figure out where if there is space to insert n new flowers 
            // now we figure out how many 3 consecutive empty spaces there are 
            boolean leftempty = (i == 0 || flowerbed[i-1]  == 0);
            boolean rightempty = (i == flowerbed.length - 1 || flowerbed[i+1] == 0);

            if (leftempty && rightempty){
                flowerbed[i] = 1; 
                // we need to make the position we are inserting in one
                emptyspace++; 
            }
            }  
        }
        return emptyspace >= n; 
    }
}
