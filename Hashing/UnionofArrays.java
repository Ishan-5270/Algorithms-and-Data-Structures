package Hashing;
import java.util.*;

public class UnionofArrays {

    public static int union(int arr1[], int arr2[]){
        // TC - O(N)
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < arr1.length; i++) {
            set.add(arr1[i]);  
        }
        for (int i = 0; i < arr2.length; i++) {
            set.add(arr2[i]);
        }
        return set.size();
    }

    public static void main(String[] args) {
        int arr1[] = {5, 4, 7};
        int arr2[] = {5, 4, 7, 8, 9, 5};
        System.out.println(union(arr1, arr2));
    }
}
