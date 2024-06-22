package rajat.slidingwindow;
//https://leetcode.com/problems/count-number-of-nice-subarrays/

public class CountNiceSubArrays {
    // Function to calculate the count of subarrays with at most k odd numbers
    private static int atMostK(int[] nums, int k) {
        int count = 0; // Initialize count of subarrays
        int oddCount = 0; // Initialize count of odd numbers in the current window
        int i = 0, j = 0; // Initialize the left pointer of the sliding window

        // Loop through the array using the sliding window technique
        for (; j < nums.length; j++) {
            // If the current element is odd, increment the count of odd numbers
            if (nums[j] % 2 == 1) {
                oddCount++;
            }

            // Shrink the window until the count of odd numbers is less than or equal to k
            while (oddCount > k) {
                // If the left element of the window is odd, decrement the count of odd numbers
                if (nums[i] % 2 == 1) {
                    oddCount--;
                }
                // Move the left pointer to the j
                i++;
            }

            // At this point, all subarrays from left to j have at most k odd numbers
            // So, add the count of subarrays to the total count
            count += j - i + 1;
        }

        // Return the total count of subarrays with at most k odd numbers
        return count;
    }

    public static int countSubarrays(int[] nums, int k) {
        // Calculate the count of nice subarrays with exactly k odd numbers
        return atMostK(nums, k) - atMostK(nums, k - 1);
    }

    public static void main(String[] args) {
        int nums[] = {1, 1, 2, 1, 1};
        int k = 3;
        System.out.println(countSubarrays(nums, k));
    }
}
