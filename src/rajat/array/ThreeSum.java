package rajat.array;

import java.util.*;

//https://leetcode.com/problems/3sum/
public class ThreeSum {

    /**
     * Finds all unique triplets in the array that sum up to zero using a brute-force approach.
     *
     * @param nums Input array of integers.
     * @return List of unique triplets that sum up to zero.
     * Time Complexity: O(n^3) | Space Complexity: O(n)
     */
    public static List<List<Integer>> threeSumBruteForce(int[] nums) {
        List<List<Integer>> output = new ArrayList<>();
        HashSet<List<Integer>> uniqueTriplets = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    if (nums[i] + nums[j] + nums[k] == 0) {
                        List<Integer> temp = Arrays.asList(nums[i], nums[j], nums[k]);
                        Collections.sort(temp);
                        uniqueTriplets.add(temp);
                    }
                }
            }
        }

        output.addAll(uniqueTriplets);
        return output;
    }

    /**
     * Finds all unique triplets in the array that sum up to zero using a hash set to avoid duplicates.
     *
     * @param nums Input array of integers.
     * @return List of unique triplets that sum up to zero.
     * Time Complexity: O(n^2)
     * Space Complexity:  O(n)HashSet + 2*O(M), where M is no of unique triplets and 2 is because
     *  one is for The List<List<Integer>> and one is for the HashSet to avoid duplicacy.
     */
    public static List<List<Integer>> threeSumWithHashSet(int[] nums) {
        int n = nums.length;
        HashSet<List<Integer>> uniqueTriplets = new HashSet<>();
        List<List<Integer>> output = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            HashSet<Integer> set = new HashSet<>();
            for (int j = i + 1; j < n; j++) {
                int complement = -1 * (nums[i] + nums[j]);
                if (set.contains(complement)) {
                    List<Integer> smallOutput = Arrays.asList(nums[i], nums[j], complement);
                    Collections.sort(smallOutput);
                    uniqueTriplets.add(smallOutput);
                }
                set.add(nums[j]);
            }
        }

        output.addAll(uniqueTriplets);
        return output;
    }

    /**
     * Finds all unique triplets in the array that sum up to zero using the two-pointer technique.
     *
     * @param nums Input array of integers.
     * @return List of unique triplets that sum up to zero.
     * Time Complexity: O(n^2) | Space Complexity: O(n)
     */
    public static List<List<Integer>> threeSumWithTwoPointer(int[] nums) {
        List<List<Integer>> output = new ArrayList<>();
        int n = nums.length;
        Arrays.sort(nums); // Sort the array to make it easier to handle duplicates and use the two-pointer technique

        for (int i = 0; i < n; i++) {
            // Skip duplicate elements for i
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int low = i + 1, high = n - 1;

            while (low < high) {
                int sum = nums[i] + nums[low] + nums[high];
                if (sum == 0) {
                    List<Integer> smallOutput = Arrays.asList(nums[i], nums[low], nums[high]);
                    output.add(smallOutput);

                    // Skip duplicate elements for low
                    while (low < high && nums[low] == nums[low + 1]) {
                        low++;
                    }

                    // Skip duplicate elements for high
                    while (low < high && nums[high] == nums[high - 1]) {
                        high--;
                    }
                    low++;
                    high--;
                } else if (sum < 0) {
                    low++;
                } else {
                    high--;
                }
            }
        }

        return output;
    }

    public static void main(String[] args) {
        int[] nums = {-1, 0, 1, 2, -1, -4};

        System.out.println("***********Three Sum Using Brute Force ************");
        List<List<Integer>> output1 = threeSumBruteForce(nums);
        System.out.println(output1);

        System.out.println("***********Three Sum Using Hash Set ************");
        List<List<Integer>> output2 = threeSumWithHashSet(nums);
        System.out.println(output2);

        System.out.println("***********Three Sum Using Two Pointer ************");
        List<List<Integer>> output3 = threeSumWithTwoPointer(nums);
        System.out.println(output3);
    }
}
