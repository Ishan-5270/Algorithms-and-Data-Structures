public class KeyboardCombinations {

    public static String[] keypad = {".", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tu", "vwx", "yz"}; 

    public static void Combinations(String str, int idx, String combination){

        if (idx == str.length()){
            System.out.println(combination);
            return; 
        }
        char currchr = str.charAt(idx);
        String mapping = keypad[currchr - '0'];

        for (int i = 0; i < mapping.length() ; i++) {
            Combinations(str, idx+1, combination + mapping.charAt(i));            
        }
    }

    public static void main(String[] args) {
        String str = "4367";
        Combinations(str, 0, ""); 

    }
    
}
