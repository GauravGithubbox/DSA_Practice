package rajat.array;

import java.util.HashMap;
import java.util.Map;
//https://leetcode.com/problems/subarray-sum-equals-k/
public class CountSubArrayWithSumK {
    public static int countSubArrayWithSumKBruteForce(int[] arr, int k) {
        int count = 0;

        // Iterate through each starting point of the subarray
        for (int i = 0; i < arr.length; i++) {
            int sum = 0;

            // Calculate the sum of subarray starting at i and ending at j
            for (int j = i; j < arr.length; j++) {
                sum += arr[j];

                // If the sum equals k, increment the count
                if (sum == k) {
                    count++;
                }
            }
        }

        return count;
    }
    public static int countSubArrayWithSumK(int[] arr, int k) {
        int count = 0;
        Map<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        map.put(0, 1);
        for(int ele : arr) {
            sum += ele;
            if(map.containsKey(sum - k)) {
                count += map.get(sum - k);
            }
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }

      return count;
    }
    public static void main(String[] args) {
        int[] arr = {1, 1, 1};
        int k = 2;

        System.out.println(countSubArrayWithSumK(arr, k));
    }
}
