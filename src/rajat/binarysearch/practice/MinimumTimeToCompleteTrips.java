package rajat.binarysearch.practice;

//https://leetcode.com/problems/minimum-time-to-complete-trips/description/
public class MinimumTimeToCompleteTrips {
    // Helper function to determine if it's possible to complete the given number of trips in 'time' minutes
    public static boolean canCompleteTrips(int[] time, long timeLimit, int totalTrips) {
        long trips = 0;
        for (int t : time) {
            trips += timeLimit / t;
        }
        return trips >= totalTrips;
    }

    // Main function to find the minimum time to complete the totalTrips
    public static long minimumTime(int[] time, int totalTrips) {
        long low = 1; // Minimum possible time
        long high = (long) 1e14; // A large upper bound for the maximum time (arbitrarily chosen for practical constraints)
        long ans = high;

        while (low <= high) {
            long mid = low + (high - low) / 2;

            if (canCompleteTrips(time, mid, totalTrips)) {
                ans = mid; // If it's possible to complete the trips in 'mid' time, update answer and search for a smaller time
                high = mid - 1;
            } else {
                low = mid + 1; // Otherwise, search in the larger half
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        // Test case 1
        int[] time1 = {1, 2, 3};
        int totalTrips1 = 5;
        System.out.println("Minimum time for test case 1: " + minimumTime(time1, totalTrips1));
        // Expected output: 3
        // Explanation: At speed 3, buses can make [3, 1, 1] trips respectively, total 5 trips.

        // Test case 2
        int[] time2 = {2, 3, 5};
        int totalTrips2 = 7;
        System.out.println("Minimum time for test case 2: " + minimumTime(time2, totalTrips2));
        // Expected output: 10
        // Explanation: At speed 10, buses can make [5, 3, 2] trips respectively, total 10 trips.

        // Test case 3
        int[] time3 = {5, 10, 10};
        int totalTrips3 = 9;
        System.out.println("Minimum time for test case 3: " + minimumTime(time3, totalTrips3));
        // Expected output: 50
    }
}
