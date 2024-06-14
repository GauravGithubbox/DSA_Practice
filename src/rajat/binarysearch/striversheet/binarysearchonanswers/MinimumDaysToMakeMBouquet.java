package rajat.binarysearch.striversheet.binarysearchonanswers;
// https://leetcode.com/problems/minimum-number-of-days-to-make-m-bouquets/description/
public class MinimumDaysToMakeMBouquet {
    /**
     * Checks if it's possible to make m bouquets from the bloomDay array
     * within the given number of days.
     *
     * @param bloomDay Array of integers representing the bloom day of each flower.
     * @param day The day to check if m bouquets can be made.
     * @param m Number of bouquets needed.
     * @param k Number of consecutive flowers needed to make one bouquet.
     * @return True if m bouquets can be made within 'day' days, otherwise false.
     *
     * Time Complexity: O(n) where n is the length of bloomDay array.
     * Space Complexity: O(1)
     */
    private static boolean possible(int[] bloomDay, int day, int m, int k) {
        int count = 0;
        int numberOfBouquet = 0;

        for(int i = 0; i < bloomDay.length; i++) {
            if(bloomDay[i] <= day) {
                count++;
            }
            else{
                numberOfBouquet += (count / k);
                count = 0;
            }
        }
        numberOfBouquet += (count / k);
        return numberOfBouquet >= m;
    }
    /**
     * Brute force approach to find the minimum days required to make m bouquets.
     *
     * @param bloomDay Array of integers representing the bloom day of each flower.
     * @param m Number of bouquets needed.
     * @param k Number of consecutive flowers needed to make one bouquet.
     * @return The minimum days required or -1 if it's not possible.
     *
     * Time Complexity: O((max - min) * n) where max and min are the maximum and minimum
     * values in bloomDay and n is the length of bloomDay array.
     * Space Complexity: O(1)
     */
    public static int minDaysBruteForce(int[] bloomDay, int m, int k) {
        int minDay = Integer.MAX_VALUE, maxDay = Integer.MIN_VALUE;

        if(bloomDay.length < m * k) {
            return -1;
        }

        for(int ele : bloomDay) {
            minDay = Math.min(minDay, ele);
            maxDay = Math.max(maxDay, ele);
        }

        // Check each day from minDay to maxDay
        for (int day = minDay; day <= maxDay; day++) {
            if (possible(bloomDay, day, m, k)) {
                return day;
            }
        }
        return -1;
    }

    /**
     * Optimized approach using binary search to find the minimum days required
     * to make m bouquets.
     *
     * @param bloomDay Array of integers representing the bloom day of each flower.
     * @param m Number of bouquets needed.
     * @param k Number of consecutive flowers needed to make one bouquet.
     * @return The minimum days required or -1 if it's not possible.
     *
     * Time Complexity: O(n * log(max - min)) where max and min are the maximum and minimum
     * values in bloomDay and n is the length of bloomDay array.
     * Space Complexity: O(1)
     */
    public static int minDays(int[] bloomDay, int m, int k) {
        int minDay = Integer.MAX_VALUE, maxDay = Integer.MIN_VALUE;
        int ans = -1;
        if(bloomDay.length < m * k) {
            return -1;
        }

        for(int ele : bloomDay) {
            minDay = Math.min(minDay, ele);
            maxDay = Math.max(maxDay, ele);
        }

        int low = minDay, high = maxDay;
        while(low <= high) {
            int mid = low + (high - low) / 2;
            if(possible(bloomDay, mid, m, k)) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }


    public static void main(String[] args) {
        int[] bloomDay = {1, 10, 3, 10, 2};
        int m = 3, k = 1;

        // Test the brute force approach
        System.out.println("Brute Force: " + minDaysBruteForce(bloomDay, m, k));

        // Test the optimized binary search approach
        System.out.println("Binary Search: " + minDays(bloomDay, m, k));
    }
}
