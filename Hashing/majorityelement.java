package Hashing;
import java.util.*;

public class majorityelement {

    public static void majority_element(int nums[]){
        HashMap<Integer, Integer> map = new HashMap<>();
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if(map.containsKey(nums[i])){
                map.put(nums[i], map.get(nums[i] +1));
            } else {
                map.put(nums[i], 1);
            }
        }

        for (int keys : map.keySet()) {
            if (map.get(keys) > n/3){
                System.out.println(keys);
            }
        }
    }

    public static void main(String[] args) {
        int nums[] = {1, 1, 1, 2, 1, 1, 1, 3, 4};
        majority_element(nums);
    }
     
}
