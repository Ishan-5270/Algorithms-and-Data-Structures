package Leetcode;

import java.util.ArrayList;

import javax.swing.tree.TreeNode;

/*
 * O(T1 + T2)
 * O(T1 + T2)
 */
public class LeafSimilarTrees {
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        /*
         * Traverse through the end of the binary tree and store the values in two seperate arraylists 
         * and then compare them
         */

         ArrayList<Integer> list1 = new ArrayList<>();
         ArrayList<Integer> list2 = new ArrayList<>();

         // now we perform a depth first search 

         list1 = dfs(root1, list1);
         list2 = dfs(root2, list2);

         return list1.equals(list2);

    }

    public ArrayList<Integer> dfs(TreeNode node, ArrayList<Integer> list) {
        if (node != null){
            if (node.left == null && node.right == null){
                list.add(node.val);
            }
            dfs(node.left, list);
            dfs(node.right, list);
        }
        return list; 
    }
}
