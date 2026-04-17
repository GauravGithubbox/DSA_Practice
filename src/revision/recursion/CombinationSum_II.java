package revision.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum_II {
    public static void main(String[] args) {
        int [] condidates = {10,1,2,7,6,1,5};
        int target = 8;
        List<List<Integer>> result = combinationSum2(condidates,target);
        System.out.println("combinationSum2 "+result);
    }

    public static void calculateSum(int index, int[] nums, int target, List<List<Integer>> result, List<Integer> ds) {
        if (target == 0) {
            result.add(new ArrayList<>(ds));
            return;
        }
        // pick
        for (int i = index; i < nums.length; i++) {
            if (i > index && nums[i] == nums[i - 1]) {
                continue;
            }
            if (nums[i] > target)
                break;
            ds.add(nums[i]);
            calculateSum(i + 1, nums, target - nums[i], result, ds);
            ds.remove(ds.size() - 1);
        }

    }

    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates);
        calculateSum(0, candidates, target, result, new ArrayList());
        return result;
    }
}
