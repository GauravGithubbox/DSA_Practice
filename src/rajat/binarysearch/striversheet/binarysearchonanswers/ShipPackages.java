package rajat.binarysearch.striversheet.binarysearchonanswers;

//https://leetcode.com/problems/capacity-to-ship-packages-within-d-days/
public class ShipPackages {
    private static boolean canShipWithinDays(int[] weights, int days, int capacity) {
        int requiredDays = 1; // Start with the first day
        int currentLoad = 0;  // Current load of the ship for the day

        for (int weight : weights) {
            // Check if adding the current weight exceeds the ship's capacity
            if (currentLoad + weight > capacity) {
                requiredDays++; // Increment the day count
                currentLoad = weight; // Start the next day with the current weight
            } else {
                currentLoad += weight; // Add the weight to the current day's load
            }
        }
        // Return true if the number of required days is within the given days
        return requiredDays <= days;
    }

    // Time Complexity: O((sum(weights) - max(weights) + 1) * N)
    // Space Complexity: O(1)
    public static int shipWithinDaysBruteForce(int[] weights, int days) {
        // Initialize the minimum and maximum capacity required
        int minCapacity = Integer.MAX_VALUE;
        int maxCapacity = 0;

        // Calculate the minimum and maximum possible ship capacity
        for (int weight : weights) {
            minCapacity = Math.min(minCapacity, weight);
            maxCapacity += weight;
        }

        // Iterate over all possible capacities from minimum to maximum
        for (int capacity = minCapacity; capacity <= maxCapacity; capacity++) {
            // Check if the current capacity can ship all packages within the given days
            if (canShipWithinDays(weights, days, capacity)) {
                return capacity; // Return the first viable capacity
            }
        }
        return -1; // If no viable capacity found, return -1
    }

    // Time Complexity: O(log(sum(weights) - max(weights) + 1) * N)
    // Space Complexity: O(1)
    public static int shipWithinDays(int[] weights, int days) {
        // Initialize the minimum and maximum capacity required
        int minCapacity = Integer.MAX_VALUE;
        int maxCapacity = 0;

        // Calculate the minimum and maximum possible ship capacity
        for (int weight : weights) {
            minCapacity = Math.min(minCapacity, weight);
            maxCapacity += weight;
        }

        // Set the initial search range for the binary search
        int low = minCapacity, high = maxCapacity;

        // // Check if the current midCapacity can ship all packages within the given days
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if(canShipWithinDays(weights, days, mid)){
                high = mid - 1; // Try for a smaller capacity
            }
            else{
                low = mid + 1; // // Increase capacity
            }
        }
        return low; //  // The minimum capacity that can ship all packages within days
    }

    public static void main(String[] args) {
        int[] weights = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int days = 5;

        // Output for the brute force approach
        System.out.println("Brute Force Result: " + shipWithinDaysBruteForce(weights, days));

        // Output for the binary search optimal approach
        System.out.println("Optimal Binary Search Result: " + shipWithinDays(weights, days));
    }
}
