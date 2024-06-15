package rajat.binarysearch.striversheet.binarysearchonanswers;

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



    public static int shipWithinDays(int[] weights, int days) {
        return -1;
    }

    public static void main(String[] args) {
        int[] weights = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int days = 5;

        System.out.println(shipWithinDaysBruteForce(weights, days));
    }
}
