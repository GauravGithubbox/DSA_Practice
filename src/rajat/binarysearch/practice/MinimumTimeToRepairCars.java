package rajat.binarysearch.practice;

//https://leetcode.com/problems/minimum-time-to-repair-cars/description/
public class MinimumTimeToRepairCars {

    // Helper function to determine if it's possible to repair 'cars' number of cars in 'time' minutes
    public static boolean isPossibleToRepair(int[] ranks, int cars, long time) {
        int totalCarsRepaired = 0;

        for (int rank : ranks) {
            // Calculate the maximum number of cars this mechanic can repair within the given time
            long carsRepairedByThisMechanic = (long) Math.sqrt(time / rank);

            // Accumulate the total cars repaired
            totalCarsRepaired += carsRepairedByThisMechanic;

            // If the total cars repaired exceeds or meets the requirement, return true
            if (totalCarsRepaired >= cars) {
                return true;
            }
        }

        // If after all mechanics the total cars repaired is less than required, return false
        return totalCarsRepaired >= cars;
    }

    // Main function to find the minimum time to repair the given number of cars
    public static long minimumTime(int[] ranks, int cars) {
        long low = 1; // Minimum possible time
        long high = (long) 1e14; // A large upper bound for the maximum time
        long ans = high;

        while (low <= high) {
            long mid = low + (high - low) / 2; // Calculate the midpoint

            if (isPossibleToRepair(ranks, cars, mid)) {
                ans = mid; // If it's possible to repair the cars in 'mid' time, update the answer
                high = mid - 1; // Search in the smaller half
            } else {
                low = mid + 1; // Otherwise, search in the larger half
            }
        }

        return ans; // Return the minimum time found
    }

    public static void main(String[] args) {
        // Example Test Case 1
        int[] ranks1 = {4, 2, 3};
        int cars1 = 5;
        System.out.println("Minimum time to repair cars (Test Case 1): " + minimumTime(ranks1, cars1));
        // Expected output: the minimum time to repair 5 cars with given ranks

        // Example Test Case 2
        int[] ranks2 = {5, 10, 10};
        int cars2 = 9;
        System.out.println("Minimum time to repair cars (Test Case 2): " + minimumTime(ranks2, cars2));
        // Expected output: the minimum time to repair 9 cars with given ranks

        // Example Test Case 3
        int[] ranks3 = {1, 1, 1};
        int cars3 = 10;
        System.out.println("Minimum time to repair cars (Test Case 3): " + minimumTime(ranks3, cars3));
        // Expected output: the minimum time to repair 10 cars with given ranks
    }
}

