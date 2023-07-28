import java.util.HashSet;

public class UniqueSubsequences {
    public static void sunsequences(String str, int idx, String newString, HashSet<String> set){

        if (idx == str.length()){
            if (set.contains(newString)){
                return; 
            }
            else {
                System.out.println(newString);
                set.add(newString); 
                return; 
            }
        }
        char currchr = str.charAt(idx); 
        // to be 
        sunsequences(str, idx+1, newString+currchr, set);

        // not to be 
        sunsequences(str, idx+1, newString, set);
    }
    public static void main(String[] args) {
        String str = "aaa";
        HashSet<String> set = new HashSet<>();
        sunsequences(str, 0, "", set);
    }
}
