package revision.arrays;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public static void main(String[] args) {
        int[] nums = {0,1,1,0};
        int target = 0;
        int[] result = optimizeTwoSum(nums, target);
        for (int re : result) {
            System.out.println(re);
        }
    }

    private static int[] bruteFourceTwoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }

            }
        }
        return new int[]{-1, -1};
    }

    private static int[] optimizeTwoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        int n = nums.length;
        for(int i =0;i<n;i++){
            int num = nums[i];
            int howMuchNeedMore = target - num;
            if(map.containsKey(howMuchNeedMore)){
                return new int[]{map.get(howMuchNeedMore),i};
            }
            map.put(nums[i],i);

        }
        return new int[]{-1,-1};
    }

}
