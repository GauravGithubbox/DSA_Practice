package revision.recursion;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {
    public static void main(String[] args) {
        int[] nums = {2, 3, 5, 4};
        int target = 7;
        List<List<Integer>> result = combinationSum(nums,target);
        System.out.println("Combination Sum "+result);
    }

    private static void solve(int index, int[] candidates, int target,
                       List<Integer> current, List<List<Integer>> result) {

        if (target == 0) {
            result.add(new ArrayList<>(current));
            return;
        }

        if (index == candidates.length)
            return;

        if (candidates[index] <= target) {
            current.add(candidates[index]);
            solve(index, candidates, target - candidates[index], current, result);
            current.remove(current.size() - 1); // backtrack
        }

        solve(index + 1, candidates, target, current, result);
    }
    private static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> current = new ArrayList<>();

        solve(0, candidates, target, current, result);
        return result;
    }
}
