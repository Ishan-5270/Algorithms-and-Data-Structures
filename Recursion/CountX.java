public class CountX {

    public static void moveAllX(String str, int idx, int count, String newStr){
        if (idx == str.length()){
            for (int i = 0; i <count; i++) {
                newStr += 'x'; 
            }
            System.out.println(newStr);
            return; 
        }
        char currchr = str.charAt(idx);
        if (currchr == 'x'){
            count++;
            moveAllX(str, idx+1, count, newStr);
        } else {
            newStr += currchr; // this can be used to concatenate chatacters and strings 
            moveAllX(str, idx+1, count, newStr);
        }
    }
    public static void main(String[] args) {
        String str = "axbbcxxd";
        moveAllX(str, 0, 0, "");
    }
}
