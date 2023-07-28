package BinaryTrees;

import java.util.ArrayList;

public class BinaryTrees {
    // Search Time Complexity - O(H) -> O(log(N))(When the tree is perfectly balanced) -> Used for fast lookup
    
    static class Node{
        int data; 
        Node left;
        Node right; 
        Node(int data){
            this.data = data; 
        }
    }


    // O(H)
    public static Node insert(Node root, int val){
        if (root == null){
            root = new Node(val);
            return root; 
        }

        if (root.data > val){
            // left subtree
            root.left = insert(root.left, val);
        }

        else {
            // right subtree 
            root.right = insert(root.right, val);

        }
        return root; 
    }


    public static void inorder(Node root){
        if (root == null){
            return; 
        }
        inorder(root.left);
        System.out.print(root.data + " ");

        inorder(root.right);
    }


    // O(H)
    public static boolean search(Node root, int key){
        if (root == null){
            return false; 
        }
        if (root.data > key){ // left 
            return search(root.left, key);
        }

        else if(root.data == key){
            return true; 
        }

        else {
            return search(root.right, key);
        }
    }


    /**
     * 3 cases 
     * No cases -> Leaf Node 
     * One Child -> Replace Node with a single child
     * Two Children -> Replace with inorder successor 
     * @param root
     * @param key
     * @return
     */
    public static Node delete(Node root, int key){
        if (root.data > key){
            root.left = delete(root.left, key);
        } 
        else if (root.data < key){
            root.right =  delete(root.right, key);
        } else {

            // case 1 
            if (root.left == null && root.right == null){
                return null;
            }

            // case 2 
            if (root.left == null){
                return root.right;
            }
          
            else if (root.right == null){
                return root.left;
            }

            // case 3 
            Node IS = inordersuccessor(root.right);
            root.data = IS.data;
            root.right = delete(root.right, IS.data);
        }

        return root; 
    }


    private static Node inordersuccessor(Node root) {
        while (root.left != null){
            root = root.left; 
        }

        return root;
    }


    public static void printInRange(Node root, int x, int y){
        if (root == null){
            return; 
        }
        // Case 1 
        if (root.data >= x && root.data <= y){
            printInRange(root.left, x, y);
            System.out.print(root.data + " ");
            printInRange(root.right, x, y);
        }

        // Case 2 
        else if (root.data >= y){
            printInRange(root.left, x, y);
        }

        // Case 3 
        else {
            printInRange(root.right, x, y);
        }

    }

    public static void printRoottoLeaf(Node root, ArrayList<Integer> path){
        if (root == null){
            return; 
        }

        path.add(root.data);
        // lead node 
        if (root.left == null && root.right == null){
            printPath(path);
        } else { // non lead nodes 
            printRoottoLeaf(root.left, path);
            printRoottoLeaf(root.right, path);
        }
        path.remove(path.size() - 1);
    }

    private static void printPath(ArrayList<Integer> path) {
        for (int i = 0; i < path.size(); i++) {
            System.out.print(" -> " + path.get(i));
        }
        System.out.println();
    }


    public static void main(String[] args) {
        int values[] = {5, 1, 3, 4, 2, 7};
        Node root = null; 

        for (int i = 0; i < values.length; i++) {
            root = insert(root, values[i]);
        }

        inorder(root);
        System.out.println();
        printRoottoLeaf(root, new ArrayList<>());
    }
}
