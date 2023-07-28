public class PlaceTiles {

    public static int placetiles(int n, int m){

        if (n == m){
            return 2;
        }

        if (n < m){
            return 1; 
        }
        // vertical placements 
        int verticalplace = placetiles(n-m, m);

        //horizontal placements 
        int horizontalplace = placetiles(n-1, m); 

        return verticalplace + horizontalplace; 
    }
    public static void main(String[] args) {
        int n =4, m=2; 
        System.out.println(placetiles(n, m));
    }
    
}
