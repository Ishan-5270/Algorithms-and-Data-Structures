package Hashing;

import java.util.HashMap;

public class NoOfSubArrays {

    public static void main(String[] args) {
        int arr[] = {10, -2, 2, -20, 10};
        HashMap<Integer, Integer> map = new HashMap<>(); // <Sum, Frequency>

        map.put(0, 1);
        int ans = 0;
        int sum = 0; 
        int K = -10; 

        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];

            if (map.containsKey(sum - K)){
                ans += map.get(sum-K);
            }

            if (map.containsKey(sum)){
                map.put(sum, map.get(sum) + 1);
            } else {
                map.put(sum, 1);
            }
        }
        System.out.println(ans);
    }
}
