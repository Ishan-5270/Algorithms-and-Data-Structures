package Leetcode;

import javax.swing.tree.TreeNode;

/*
 * TC - O(N)
 * SC - O(logN)
 */
public class GoodNodes {
    int count = 0; 
   public int goodNodes(TreeNode root) {
        /*
         * First we can traverse through all the nodes and then see increment the count
         */
         int max = root.val;
         dfs(root, max);
         return count;
    }

    public void dfs(TreeNode root, int max){
        if (root != null){
            if (root.val >= max){
                count++;
                max = root.val;
            }
            dfs(root.left, max);
            dfs(root.right, max);
        }
    }

}


