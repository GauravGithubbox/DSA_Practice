package array;

import java.util.*;

public class MajorityElement_II {
    public static void main(String[] args) {
        int[] nums = {3, 2, 3};
        List<Integer> result = majorityElementSecond(nums);
    }

    private static List<Integer> majorityElementSecond(int[] nums) {
        List<Integer> result = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        int length = nums.length;
        Arrays.sort(nums);
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() > length / 3) {
                result.add(entry.getKey());
            }
        }
        return result;
    }
}
