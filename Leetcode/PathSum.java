package Leetcode;

import javax.swing.tree.TreeNode;

public class PathSum {
    int count = 0; 
    int sum = 0; 
    public int pathSum(TreeNode root, int targetSum) {
        dfs(root, targetSum);
    }
    private void dfs(TreeNode root, int targetSum) {
        if (root != null){
            /*
             * We want to find all the paths where the sum is equal to target 
             */
            if (sum == targetSum){
                count++;
                sum = 0;
            }
            else {
                sum += root.val;
            }
            dfs(root.left, targetSum);
            dfs(root.right, targetSum);
        }
    }

    public static void main(String[] args) {
        
    }
}
