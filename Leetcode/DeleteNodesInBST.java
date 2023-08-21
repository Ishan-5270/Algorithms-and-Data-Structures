package Leetcode;

import javax.swing.tree.TreeNode;

public class DeleteNodesInBST {
    /*
     * Three cases to consider 
     * It is the root node then simply delete it 
     * Single Child - replace it 
     * Else - repace with the left most node of the rigth subtree 
     */
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null){
           return null; 
        }
         if (root.val < key){
             root.right = deleteNode(root.right, key);
 
         } else if (root.val > key){
             root.left = deleteNode(root.left, key);
 
         } else {
             // case 1 - no children 
             if (root.left == null && root.right == null){
                 return null; 
             }
 
             // case 2 - single child 
             else if (root.left == null){
                 // there is a single left child\
                 return root.right; 
             }
 
             else if (root.right == null){
                 return root.left;
             }
 
             else {
                 // inorder successor 
                 root.val = InorderSuccesor(root.right);
                 root.right = deleteNode(root.right, root.val);
             }
 
         }
         return root; 
     }
 
     public static int InorderSuccesor(TreeNode root){
        int min = root.val;
        if (root == null){
           return min;
        }
         while(root.left != null){
            min = root.left.val;
             root = root.left;
         }
         return min; 
     }
