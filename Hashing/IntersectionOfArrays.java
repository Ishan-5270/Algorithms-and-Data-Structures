package Hashing;
import java.util.*; 

public class IntersectionOfArrays {

    public static int intersection(int arr1[], int arr2[]){
        int count =  0;
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < arr1.length; i++) {
            set.add(arr1[i]);
        }

        for (int i = 0; i < arr2.length; i++) {
            if (set.contains(arr2[i])){
                count++;
                set.remove(arr2[i]);
            }
        }
        return count;
    }
    
    public static void main(String[] args) {
        int arr1[] = {7, 8, 9};
        int arr2[] = {5, 6, 7, 8};
        System.out.println(intersection(arr1, arr2));
    }
}
