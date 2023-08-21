package Leetcode;

import javax.swing.tree.TreeNode;

// O(N) in the worst case traversing through all the nodes in the binary tree
// O(1) no extra space occupied 
public class SearchBST {
    public TreeNode searchBST(TreeNode root, int val) {
        /*
         * Search in a binary search tree and return the node 
         */

         if (root == null){
            return null; 
         }

         if (root.val == val){
            return root;
         } else if (root.val > val){
            return searchBST(root.left, val);
         } else if (root.val < val){
            searchBST(root.right, val);
         }

    }
}
