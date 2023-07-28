public class CalltoParty {

    public static int calltoparty(int n){
        if (n<=1){
            return 1; 
        }
        // single 
        int way1 = calltoparty(n-1);

        //pairs 
        int way2 = (n-1)*calltoparty(n-2); 

        return way1 + way2; 
    }
    public static void main(String[] args) {
        int n = 4;
        System.out.println(calltoparty(n));
    }
}
