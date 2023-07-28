public class FirstandLastOc {

    public static int first = -1;
    public static int second = -1; 

    public static void findOccurance(String str, int idx, char element){

        if (idx == str.length()){
            System.out.println(first);
            System.out.println(second);
            return; 
        }
        char currChar = str.charAt(idx);
        if(currChar == element){
            if(first == -1){
                first = idx; 
            } else {
                second = idx; 
            }
        }

        // common these in recursion -> call the recursive method 
        findOccurance(str, idx+1, element);

    }
    
    public static void main(String[] args) {
        String str = "abddegyedebbhaa";
        findOccurance(str, 0, 'a');
        
    }
}
