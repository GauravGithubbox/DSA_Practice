package revision.recursion;

import java.util.ArrayList;
import java.util.List;

public class PowerSet {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        List<List<Integer>> result = powerSet(nums);
        System.out.println("power set " + result);
    }

    private static List<List<Integer>> powerSet(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        helperMethod(nums, 0, new ArrayList<>(), ans);
        return ans;
    }

    private static void helperMethod(int[] nums, int index, List<Integer> current, List<List<Integer>> ans) {
        // Base case: we reached the end
        if (index == nums.length) {
            ans.add(new ArrayList<>(current));
            return;
        }

        // 1️⃣ Include the current element
        current.add(nums[index]);
        helperMethod(nums, index + 1, current, ans);

        // Backtrack
        current.remove(current.size() - 1);

        // 2️⃣ Exclude the current element
        helperMethod(nums, index + 1, current, ans);
    }
}
