package Trees;

import javax.swing.tree.TreeNode;

public class isSubTree {

    static class TreeNode{
        int val; 
        TreeNode left; 
        TreeNode right; 

        TreeNode(int val){
            this.val = val; 
            this.left = null; 
            this.right = null; 
        }
    }

    // root and subroot will be provided

    public boolean isIdentical(TreeNode root, TreeNode subroot){
        if (root == null && subroot == null){
            return true; 
        }

        if (root == null || subroot == null){
            return false;
        }

        if (root.val == subroot.val){
            return isIdentical(root.left, subroot.left) && isIdentical(root.right, subroot.right);
        }

        return false; 
    }


    public boolean issubtree(TreeNode root, TreeNode subroot){
        if (subroot == null){
            return true; 
        }
        
        if (root == null){
            return false;
        }

        if (root.val == subroot.val){
            // now we want to check the values of the left and right subtree 
            if (isIdentical(root, subroot)){
                return true; 
            }
        }

        return issubtree(root.left, subroot) || issubtree(root.right, subroot);
    }
    public static void main(String[] args) {
        
    }
}
