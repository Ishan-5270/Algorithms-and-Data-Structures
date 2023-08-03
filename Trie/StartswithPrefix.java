package Trie;

public class StartswithPrefix {

    static class Node {
        Node[] children; 
        boolean eow; 

        public Node(){
            this.children = new Node[26]; // a-z 
            for (int i = 0; i < 16; i++) {
                children[i] = null;
            }
            this.eow = false; 
        }
    }

 
    static Node root  = new Node();

    public static void insert(String word){ // O(L)  -> Length of a key 
        Node curr = root; 
        for (int i = 0; i < word.length(); i++) {
            int idx = word.charAt(i) - 'a';

            if (curr.children[idx] == null){
                curr.children[idx] = new Node();
            }

            if (i == word.length() - 1){
                curr.children[idx].eow = true;
            }

            curr = curr.children[idx]; 
        }
    }

    public static boolean search(String word){ // O(L) -> Length of a key
        Node curr = root; 
        for (int i = 0; i < word.length(); i++) {
            int idx = word.charAt(i) - 'a';

            if (curr.children[idx] == null){
                return false;
            }
            if (i == word.length() - 1 &&  curr.children[idx].eow == false){
                return false; 
            }
            curr = curr.children[idx]; 
        }
        return true;
    }

    public static boolean startswith(String key){
       Node curr = root; 
        for (int i = 0; i < key.length(); i++) {
            int idx = key.charAt(i) - 'a';

            if (curr.children[idx] == null){
                return false;
            }

            curr = curr.children[idx]; 
        }
        return true;
    } 
    
    public static void main(String[] args) {
        String words[] = {"the", "a", "there", "their", "any", "apple", "app"};
        for (int i = 0; i < words.length; i++) {
            insert(words[i]);
        }

        System.out.println(startswith("app"));
    }
}
