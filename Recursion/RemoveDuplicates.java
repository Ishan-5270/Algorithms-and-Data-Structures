public class RemoveDuplicates {
    public static boolean[] map = new boolean[26];

    // because map is declared static we do not need to call it and we can use it directly 
    public static void removeDuplicates(String str, int idx, String newString) {

        if(idx == str.length()){
            System.out.println(newString);
            return; 
        }
        
        char currchr = str.charAt(idx);
        if(map[currchr - 'a'] == true){ // we can also remove the == true because if we do not write anything than == true is implied 
            removeDuplicates(str, idx+1, newString);
        } else {
            newString += currchr; 
            map[currchr - 'a'] = true;
            removeDuplicates(str, idx+1, newString);
        }
    }
    public static void main(String[] args) {
        String str = "aabbcgysahvad";
        removeDuplicates(str, 0, "");
    }
}
