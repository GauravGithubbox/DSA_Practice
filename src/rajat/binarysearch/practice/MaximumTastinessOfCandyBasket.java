package rajat.binarysearch.practice;

import java.util.Arrays;

public class MaximumTastinessOfCandyBasket {

    public static int maximumTastiness(int[] price, int k) {
        Arrays.sort(price); // Sort the prices to simplify the selection of candies

        int low = 1; // Minimum possible difference
        int high = price[price.length - 1] - price[0]; // Maximum possible difference

        int maxTastiness = 0;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (canSelectKWithDifference(price, k, mid)) {
                maxTastiness = mid; // Update the maximum tastiness
                low = mid + 1; // Try for a larger minimum difference
            } else {
                high = mid - 1; // Reduce the range to find the possible maximum difference
            }
        }

        return maxTastiness;
    }

    // Helper function to determine if it's possible to select k candies with at least 'diff' difference
    private static boolean canSelectKWithDifference(int[] price, int k, int diff) {
        int count = 1; // Start with the first candy
        int lastSelectedPrice = price[0];

        for (int i = 1; i < price.length; i++) {
            if (price[i] - lastSelectedPrice >= diff) {
                count++;
                lastSelectedPrice = price[i];
                if (count == k) {
                    return true; // Found k candies satisfying the condition
                }
            }
        }

        return false; // Not possible to select k candies with the given difference
    }

    public static void main(String[] args) {
        // Example Test Case 1
        int[] price1 = {13, 5, 1, 8, 21, 2};
        int k1 = 3;
        System.out.println("Maximum tastiness for Test Case 1: " + maximumTastiness(price1, k1));
        // Expected output: 8

        // Example Test Case 2
        int[] price2 = {10, 15, 3, 7, 19};
        int k2 = 3;
        System.out.println("Maximum tastiness for Test Case 2: " + maximumTastiness(price2, k2));
        // Expected output: 7

        // Example Test Case 3
        int[] price3 = {1, 5, 9, 13};
        int k3 = 2;
        System.out.println("Maximum tastiness for Test Case 3: " + maximumTastiness(price3, k3));
        // Expected output: 12

        // Example Test Case 4
        int[] price4 = {1, 6, 11, 16, 21};
        int k4 = 4;
        System.out.println("Maximum tastiness for Test Case 4: " + maximumTastiness(price4, k4));
        // Expected output: 5
    }
}
