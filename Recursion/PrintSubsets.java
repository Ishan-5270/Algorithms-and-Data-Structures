import java.util.ArrayList;

public class PrintSubsets {
    public static void findSubsets(int n, ArrayList<Integer> subset){

        if (n==0){
            printubsets(subset);
            return; 
        }

        // to be added 
        subset.add(n);
        findSubsets(n-1, subset);

        // not to be added 
        subset.remove(subset.size()-1);
        findSubsets(n-1, subset);
    }

    private static void printubsets(ArrayList<Integer> subset) {
        for (int i = 0; i < subset.size(); i++) {
            System.out.print(subset.get(i) + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int n = 3; 
        ArrayList<Integer> subset = new ArrayList<>(); 
        findSubsets(n, subset);
    }
}
