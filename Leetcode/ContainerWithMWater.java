package Leetcode;

public class ContainerWithMWater {
    public int maxArea(int[] height) {
        int lefth = 0;
        int righth = height.length - 1;
        int currArea = 0; 
        int maxArea = 0; 

        while (lefth < righth){
            currArea = Math.min(height[lefth], height[righth])* (righth - lefth);
            maxArea = Math.max(currArea, maxArea);

            // now we want to update the left and the right height 
            if (height[lefth] < height[righth]){
                lefth++;
            } else {
                righth--;// these things matter do not let it fuck you up 
            }
        }
        return maxArea;
    }
}
