package revision.recursion;

public class CountAllSubsequencesWithSumK {
    public static void main(String[] args) {
        int[] nums = {4, 9, 2, 5, 1};
        int target = 10;
        int result = countSubsequenceWithTargetSum(nums, target);
        System.out.println("countSubsequenceWithTargetSum " + result);
    }
    private static int helperCount(int i, int[] nums, int n, int target) {

        if (target == 0) {
            return 1;
        }
        if (i == n) {
            return 0;
        }

        // ✅ Take the element
        int take = 0;
        if (nums[i] <= target) {
            take = helperCount(i + 1, nums, n, target - nums[i]);
        }

        // ❌ Not take
        int notTake = helperCount(i + 1, nums, n, target);

        // ✅ Total ways
        return take + notTake;
    }

    private static int countSubsequenceWithTargetSum(int[] nums, int target) {
        return helperCount(0, nums, nums.length, target);
    }


}
