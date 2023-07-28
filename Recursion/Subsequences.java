public class Subsequences {
    public static void sunsequences(String str, int idx, String newString){

        if (idx == str.length()){
            System.out.println(newString);
            return; 
        }
        char currchr = str.charAt(idx); 
        // to be 
        sunsequences(str, idx+1, newString+currchr);

        // not to be 
        sunsequences(str, idx+1, newString);
    }
    public static void main(String[] args) {
        String str = "abc";
        sunsequences(str, 0, "");
    }
}
