package rajat.array;

import java.util.HashMap;
import java.util.Map;

public class LongestSubArrayWithZeroSum {
    private static int maxLen(int[] arr, int n) {
        Map<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        int maxLen = 0;
        map.put(0, -1);

        for(int i = 0; i < n; i++) {
            sum += arr[i];

            if(map.containsKey(sum)){
                maxLen = Math.max(maxLen, i - map.get(sum));
            }
            else{
                map.put(sum, i);
            }
        }
        return maxLen;
    }
    public static void main(String[] args) {
        int[] arr = {-1, 1, -1, 1};
        int n = arr.length;
        System.out.println("Length of the largest subarray with sum 0 is: " + maxLen(arr, n));
    }


}
