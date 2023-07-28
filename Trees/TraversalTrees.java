package Trees;
import java.util.*;

public class TraversalTrees {

    static class Node{
        int data; 
        Node left; 
        Node right; 

        Node(int data){
            this.data = data; 
            this.left = null; 
            this.right = null; 
        }
    }

    static class BinaryTree{
        static int idx = -1; 
        public static Node buildTree(int nodes[]){
            idx++;
            if (nodes[idx] == -1){
                return null; 
            }

            Node newNode = new Node(nodes[idx]);
            newNode.left = buildTree(nodes);
            newNode.right = buildTree(nodes);

            return newNode;    
        }
    }

    public static void preorder(Node root){
        // Complexity - O(N) --> because we went to all the nodes one after the other
        if (root == null){
            return;
        }
        System.out.print(root.data + " ");
        preorder(root.left);
        preorder(root.right);
    }


    // O(N)
    public static void inorder(Node root){
        if (root == null){
            return;
        }
        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    } 


    // O(N)
    public static void postorder(Node root){
        if (root == null){
            return; 
        }
        postorder(root.left);
        postorder(root.right);
        System.out.print(root.data + " ");
    }

    
    // Time Complexity --> O(N)
    public static void levelorder(Node root){
        if (root == null){
            return; 
        }
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        q.add(null);

        while (!q.isEmpty()){
            Node currnode = q.remove();
            if (currnode == null){
                System.out.println();
                if (q.isEmpty()){
                    break;
                } else {
                    q.add(null);
                }
            } else {
                System.out.print(currnode.data + " ");
                if (currnode.left != null){
                    q.add(currnode.left);
                }
                if (currnode.right != null){
                    q.add(currnode.right);
                }
            }
        }
    }

    // O(N) --> time complexity
    public static int countOfNodes(Node root){
        if (root == null){
            return 0; 
        }

        int left = countOfNodes(root.left);
        int right = countOfNodes(root.right);

        return left + right; 
    }

    // O(N)
    public static int sumOfNodes(Node root){
         if (root == null){
            return 0; 
        }

        int leftsum = sumOfNodes(root.left);
        int rightsum = sumOfNodes(root.right);
        return leftsum + rightsum + root.data;
    }
    

    // O(N)
    public static int height(Node root){
        if (root == null){
            return 0;
        }
        int leftheight = height(root.left);
        int rightheight = height(root.right);

        int myheight = Math.max(leftheight, rightheight) + 1; 

        return myheight; 
    }

    // O(N^2)
    public static int diameter(Node root){
        if (root == null){
            return 0; 
        }
        int diam1 = diameter(root.left);
        int diam2 = diameter(root.right);
        int diam3 = height(root.left) + height(root.right) + 1; 

        return Math.max(diam1, Math.max(diam2, diam3));

    }

    static class TreeInfo
    {
        int ht; 
        int diam; 

        TreeInfo(int ht, int diam){
            this.ht = ht;
            this.diam = diam; 
        }
    }
    

    public static TreeInfo diameter2(Node root){
        if (root == null){
            return new TreeInfo(0, 0);
        }
        TreeInfo left = diameter2(root.left);
        TreeInfo right = diameter2(root.right);

        int myHeight = Math.max(left.ht, right.ht) + 1; 

        int diam1 = left.diam;
        int diam2 = right.diam;
        int diam3 = left.ht + right.ht + 1; 

        int mydiam = Math.max(Math.max(diam1, diam2), diam3);
        TreeInfo myInfo = new TreeInfo(myHeight, mydiam);

        return myInfo;
    }

    



 public static void main(String[] args) {
        int nodes[] = {1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1};
        BinaryTree tree = new BinaryTree();
        Node root = tree.buildTree(nodes);
        System.out.println(diameter2(root).diam);;
    }
}
