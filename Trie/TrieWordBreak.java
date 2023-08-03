package Trie;

public class TrieWordBreak {

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


    public static boolean wordbreak(String key){
        if (key.length() == 0){
            return true;
        }

        if (search(key)){
            return true; 
        }

        for (int i = 1; i < key.length(); i++) {
            String firstPart = key.substring(0, i);
            String secondPart = key.substring(i);

            if (search(firstPart) && wordbreak(secondPart)){
                return true;
            }
        }
        return false; 
    }


    
    public static void main(String[] args) {
        // String words[] = {"the", "a", "there", "their", "any"};
        // for (int i = 0; i < words.length; i++) {
        //     insert(words[i]);
        // }

        String words[] = {"i", "like", "sam", "samsung", "mobile"};
        String key = "i";

        for (int i = 0; i < words.length; i++) {
            insert(words[i]);
        }

        System.out.println(wordbreak(key));
    }
}

