public class Permutations {

    public static void printPerm(String str, String permutations){
        if(str.length() == 0){
            System.out.println(permutations);
            return; 
        }
        // we are not using the index to track which is why we do not need an index 

        for (int i = 0; i < str.length(); i++) {
            char currchr = str.charAt(i); 
            String newStr = str.substring(0, i) + str.substring(i+1);
            printPerm(newStr, permutations+currchr);
            
        }   
    }
    
    
    public static void main(String[] args) {
        String str = "abc"; 
        printPerm(str, "");
    } 
}
