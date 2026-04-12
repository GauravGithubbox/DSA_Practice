package revision.hashing;

import java.util.HashMap;

public class CountSubarraysWithGivenSum {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        int target = 2;
        int result = subarraySum(nums,target);
        System.out.println("subarraySum "+result);
    }

    private static int subarraySum(int[] nums, int k) {
        int count = 0;
        int prefixSum = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        for (int num : nums) {
            prefixSum += num;

            if (map.containsKey(prefixSum - k)) {
                count += map.get(prefixSum - k);
            }
            map.put(prefixSum, map.getOrDefault(prefixSum, 0) + 1);
        }
        return count;
    }
}
