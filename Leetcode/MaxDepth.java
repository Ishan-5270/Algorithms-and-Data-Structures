package Leetcode;

import javax.swing.tree.TreeNode;

/*
 * TC - O(logN)  
 * SC - O(logN) both of these are true only when the tree is perfectly balanced 
 */
public class MaxDepth {
    public int maxDepth(TreeNode root) {
        int depth = 0; 

        /*
         * We need to keep going down until there are no root nodes 
         */
        if (root == null){
            return 0; 
        }

        int ls = maxDepth(root.left);
        int rs = maxDepth(root.right);

        return Math.max(ls, rs) + 1;
    }
}
