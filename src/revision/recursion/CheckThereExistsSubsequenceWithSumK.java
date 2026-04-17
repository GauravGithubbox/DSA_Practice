package revision.recursion;

public class CheckThereExistsSubsequenceWithSumK {
    public static void main(String[] args) {
        CheckThereExistsSubsequenceWithSumK sol = new CheckThereExistsSubsequenceWithSumK();
        int[] nums = {1, 10, 4, 5};
        int target = 16;
        System.out.println(sol.checkSubsequenceSum(nums, target)); // Expected output: true
    }


    private boolean solve(int i, int n, int[] arr, int k) {

        // Found valid subsequence
        if (k == 0) return true;

        // Out of bounds OR sum exceeded
        if (i == n || k < 0) return false;

        // Optimization: if current element > k, skip "take"
        if (arr[i] > k) {
            return solve(i + 1, n, arr, k);
        }

        // Try including OR excluding
        return solve(i + 1, n, arr, k - arr[i])
                || solve(i + 1, n, arr, k);
    }

    private boolean checkSubsequenceSum(int[] nums, int target) {
        return solve(0, nums.length, nums, target);
    }
}
