package Leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

import javax.swing.tree.TreeNode;

/*
 * TC - O(N) visits all the nodes once 
 * SC - O(h) straight line 
 */
public class RightSideView {
    // public List<Integer> rightSideView(TreeNode root) {
    //     /*
    //      * You need to return the list of integers of all the nodes that are on the right side of the binary tree
    //      */

    //      ArrayList<Integer> list = new ArrayList<>();
    //      dfs(root, list, 0);
    //      return list; 
    // }

    // public static void dfs(TreeNode root, ArrayList<Integer> list, int depth){
    //     if (root == null){
    //         return;
    //     }

    //     if (list.size() == depth){
    //         list.add(root.val);
    //     }

    //     if (root.right != null){
    //         dfs(root.right, list, depth + 1);
    //     }

    //     if (root.left != null){
    //         dfs(root.left, list, depth + 1);
    //     }
    //}

    public List<Integer> rightSideView(TreeNode root){
        ArrayList<Integer> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        if (root == null){
            return result;
        }
        queue.add(root);
        while (!queue.isEmpty()){
            // we go through another layer of iteration now to figure out if the current level is empty or not 
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode curr = queue.poll();
                if (i == size - 1){
                    result.add(curr.val);
                }
                if (curr.left != null){
                    queue.add(curr.left);
                }
                if (curr.right != null){
                    queue.add(curr.right);
                }
            }
        }
        return result;
    }
}
