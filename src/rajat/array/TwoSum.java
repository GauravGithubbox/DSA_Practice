package rajat.array;

import java.util.HashMap;
import java.util.Map;

//https://leetcode.com/problems/two-sum/description/
// Time complexity : O(n)
// Space complexity: O(n)
public class TwoSum {
    public static int[] twoSum_BruteForce(int[] arr, int target) {
        int[] ans = new int[2];
        for (int i = 0; i < arr.length; i++) {
            int find = target - arr[i];
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] == find) {
                    ans[0] = i;
                    ans[1] = j;
                    return ans;
                }
            }
        }
        return ans;
    }

    public static int[] twoSum(int[] arr, int target) {
        int[] output = new int[2];
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < arr.length; i++) {
            int find = target - arr[i];

            if(map.containsKey(find)) {
                output[0] = i;
                output[1] = map.get(find);
                return output;
            }
            map.put(arr[i], i);
        }
        return output;
    }

    public static void main(String[] args) {
        int[] arr = {2, 7, 11, 15};
        int target = 9;

        int[] ans = twoSum(arr, target);
        System.out.println(ans[0] + " " + ans[1]);
    }
}
